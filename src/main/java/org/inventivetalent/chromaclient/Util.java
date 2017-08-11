package org.inventivetalent.chromaclient;

public class Util {

	public static int rgbToBgr(int rgb) {
		int red = (rgb >> 16) & 0xFF;
		int green = (rgb >> 8) & 0xFF;
		int blue = (rgb >> 0) & 0xFF;
		return (blue << 16) | (green << 8) | (red << 0);
	}

	public static byte loByte(int i) {
		return (byte) (i & 0xff);
	}

	public static byte hiByte(int i) {
		return (byte) ((i >> 8) & 0xff);
	}

}
