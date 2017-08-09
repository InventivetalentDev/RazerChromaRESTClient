package org.inventivetalent.chromaclient.effects;

public enum EffectTarget {

	KEYBOARD("/keyboard"),
	MOUSE("/mouse"),
	MOUSEPAD("/mousepad"),
	HEADSET("/headset"),
	KEYPAD("/keypad"),
	CHROMALINK("/chromalink");

	private final String route;

	EffectTarget(String route) {
		this.route = route;
	}

	public String getRoute() {
		return route;
	}
}
