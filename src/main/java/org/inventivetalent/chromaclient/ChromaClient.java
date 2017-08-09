package org.inventivetalent.chromaclient;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.NonNull;
import org.inventivetalent.chromaclient.data.Application;
import org.inventivetalent.chromaclient.data.Result;
import org.inventivetalent.chromaclient.effects.EffectAbstract;
import org.inventivetalent.chromaclient.effects.EffectId;
import org.inventivetalent.chromaclient.effects.EffectIds;
import org.inventivetalent.chromaclient.response.ResponseHeartbeat;
import org.inventivetalent.chromaclient.response.ResponseInit;
import org.inventivetalent.chromaclient.response.ResponseResult;

public class ChromaClient {

	static final String START_URL = "http://localhost:54235/razer/chromasdk";

	static final ObjectMapper GSON_MAPPER = new ObjectMapper() {

		private Gson gson = new Gson();

		public <T> T readValue(String s, Class<T> aClass) {
			try {
				return gson.fromJson(s, aClass);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		public String writeValue(Object o) {
			try {
				return gson.toJson(o);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	};

	private final Application application;

	// Used to store the session info, and the URI we need to make requests
	private ResponseInit session;

	private HeartbeatThread heartbeatThread;

	/**
	 * Creates a new ChromaClient for the specified {@link Application}
	 *
	 * @param application the {@link Application}, must not be null
	 */
	public ChromaClient(@NonNull Application application) {
		this.application = application;

		Unirest.setDefaultHeader("Content-Type", "application/json");
		Unirest.setObjectMapper(GSON_MAPPER);
	}

	/**
	 * Initializes the connection to start accepting requests. Must be called before any other methods
	 *
	 * @return {@link ResponseInit}
	 * @throws UnirestException
	 */
	public ResponseInit init() throws UnirestException {
		System.out.println("init");
		System.out.println(new Gson().toJson(this.application));
		HttpResponse<ResponseInit> response = Unirest
				.post(START_URL)
				.body(this.application)
				.asObject(ResponseInit.class);

		new Thread(this.heartbeatThread =
				new HeartbeatThread(this), "ChromaClient-Heartbeat-" + this.application.getTitle().replace(" ", "_"))
				.start();

		return this.session = response.getBody();
	}

	/**
	 * @return whether this client is initialized
	 */
	public boolean isInitialized() {
		return this.application != null && this.session != null;
	}

	void checkInitialized() {
		if (!isInitialized()) {
			throw new IllegalStateException("Not initialized");
		}
	}

	/**
	 * Un-initializes this client
	 *
	 * @return {@link Result}
	 * @throws UnirestException
	 */
	public Result unInit() throws UnirestException {
		checkInitialized();
		HttpResponse<ResponseResult> response = Unirest
				.delete(this.session.getUri())
				.asObject(ResponseResult.class);
		this.session = null;
		this.heartbeatThread = null;
		return Result.forCode(response.getBody().getResult());
	}

	/**
	 * Sends a heartbeat
	 *
	 * @return {@link ResponseHeartbeat}
	 * @throws UnirestException
	 */
	public ResponseHeartbeat heartbeat() throws UnirestException {
		System.out.println("heartbeat");
		checkInitialized();
		HttpResponse<ResponseHeartbeat> response = Unirest
				.put(this.session.getUri() + "/heartbeat")
				.asObject(ResponseHeartbeat.class);
		return response.getBody();
	}

	/**
	 * Creates an effect
	 *
	 * @param effect the {@link EffectAbstract}
	 * @return the {@link EffectId} to be used when setting the effect
	 * @throws UnirestException
	 */
	public EffectId createEffect( EffectAbstract effect) throws UnirestException {
		System.out.println("createEffect POST " + effect.getTarget().getRoute());
		System.out.println(new Gson().toJson(effect));
		HttpResponse<EffectId> response = Unirest
				.post(this.session.getUri() +  effect.getTarget().getRoute())
				.body(effect)
				.asObject(EffectId.class);
		return response.getBody();
	}

	/**
	 * Creates an effect and applies it to the device
	 *
	 * @param effect the {@link EffectAbstract}
	 * @return the result
	 * @throws UnirestException
	 */
	public ResponseResult createAndSetEffect( EffectAbstract effect) throws UnirestException {
		System.out.println("createAndSetEffect PUT " +  effect.getTarget().getRoute());
		System.out.println(new Gson().toJson(effect));
		System.out.println(effect.getTarget());
		HttpResponse<ResponseResult> response = Unirest
				.put(this
						.session
						.getUri() +
						effect
								.getTarget()
								.getRoute())
				.body(effect)
				.asObject(ResponseResult.class);
		return response.getBody();
	}

	//TODO: createEffects / createAndSetEffects

	/**
	 * Applies an effect to the device
	 *
	 * @param effectId the {@link EffectId}
	 * @return the result
	 * @throws UnirestException
	 */
	public ResponseResult setEffect(EffectId effectId) throws UnirestException {
		HttpResponse<ResponseResult> response = Unirest
				.put(this.session.getUri() + "/effect")
				.body(effectId)
				.asObject(ResponseResult.class);
		return response.getBody();
	}

	/**
	 * Deletes an effect & removes it from the device
	 *
	 * @param effectId the {@link EffectId}
	 * @return the result
	 * @throws UnirestException
	 */
	public ResponseResult deleteEffect(EffectId effectId) throws UnirestException {
		HttpResponse<ResponseResult> response = Unirest
				.put(this.session.getUri() + "/effect")
				.body(effectId)
				.asObject(ResponseResult.class);
		return response.getBody();
	}

	/**
	 * Applies multiple effects to the device
	 *
	 * @param effectIds the {@link EffectIds}
	 * @return the result
	 * @throws UnirestException
	 */
	public ResponseResult setEffects(EffectIds effectIds) throws UnirestException {
		HttpResponse<ResponseResult> response = Unirest
				.put(this.session.getUri() + "/effect")
				.body(effectIds)
				.asObject(ResponseResult.class);
		return response.getBody();
	}

	/**
	 * Deletes multiple effects and removes them from the device
	 *
	 * @param effectIds the {@link EffectIds}
	 * @return the result
	 * @throws UnirestException
	 */
	public ResponseResult deleteEffects(EffectIds effectIds) throws UnirestException {
		HttpResponse<ResponseResult> response = Unirest
				.put(this.session.getUri() + "/effect")
				.body(effectIds)
				.asObject(ResponseResult.class);
		return response.getBody();
	}

}
