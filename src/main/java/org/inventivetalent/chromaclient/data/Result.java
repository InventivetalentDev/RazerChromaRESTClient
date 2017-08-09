package org.inventivetalent.chromaclient.data;

// https://assets.razerzone.com/dev_portal/REST/html/_rz_errors_8h.html
public enum Result {

	INVALID(-1L),
	SUCCESS(0L),
	ACCESS_DENIED(5L),
	INVALID_HANDLE(6L),
	NOT_SUPPORTED(50L),
	INVALID_PARAMETER(87L),
	SERVICE_NOT_ACTIVE(1062L),
	SINGLE_INSTANCE_APP(1152L),
	DEVICE_NOT_CONNECTED(1167L),
	NOT_FOUND(1168L),
	REQUEST_ABORTED(1235L),
	ALREADY_INITIALIZED(1247L),
	RESOURCE_DISABLED(4309L),
	DEVICE_NOT_AVAILABLE(4319L),
	NOT_VALID_STATE(5023L),
	NO_MORE_ITEMS(259L),
	FAILED(2147500037L);

	private final long code;

	Result(long code) {
		this.code = code;
	}

	public long getCode() {
		return code;
	}

	public static Result forCode(long code) {
		for (Result result : values()) {
			if (result.code == code) {
				return result;
			}
		}
		return null;
	}

}
