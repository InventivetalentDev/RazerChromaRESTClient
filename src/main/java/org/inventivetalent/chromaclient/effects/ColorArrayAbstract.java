package org.inventivetalent.chromaclient.effects;

import org.inventivetalent.chromaclient.Util;

import java.awt.*;

public abstract class ColorArrayAbstract {

	private       int[] array;
	private final int   length;

	public ColorArrayAbstract(int[] array, int length) {
		this.length = length;

		if (array.length != length) {
			throw new IllegalArgumentException("array must have a length of " + length);
		}

		this.array = array;
	}

	public int[] getArray() {
		return array;
	}

	public int getLength() {
		return length;
	}

	public void setColor(int x, int bgr) {
		if (x < 0 || x > length) { throw new IllegalArgumentException("Invalid x position, must be 0 > x < " + length); }
		this.array[x] = bgr;
	}

	public void setColor(int x, Color color) {
		setColor(x, Util.rgbToBgr(color.getRGB()));
	}

	public void fill(int bgr) {
		for (int x = 0; x < length; x++) {
			this.array[x] = bgr;
		}
	}

	public void fill(Color color) {
		fill(Util.rgbToBgr(color.getRGB()));
	}

}
