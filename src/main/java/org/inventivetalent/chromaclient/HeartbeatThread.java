package org.inventivetalent.chromaclient;

public class HeartbeatThread implements Runnable {

	private final ChromaClient client;

	public HeartbeatThread(ChromaClient client) {
		this.client = client;
	}

	public void run() {
		while (client.isInitialized()) {
			try {
				this.client.heartbeat();
				Thread.sleep(1000);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}
