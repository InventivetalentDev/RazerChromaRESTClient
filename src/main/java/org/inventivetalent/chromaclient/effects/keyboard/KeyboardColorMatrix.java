package org.inventivetalent.chromaclient.effects.keyboard;

import org.inventivetalent.chromaclient.effects.ColorMatrixAbstract;

public class KeyboardColorMatrix extends ColorMatrixAbstract {

	public KeyboardColorMatrix() {
		super(new int[6][22], 6, 22);
	}

	public KeyboardColorMatrix(int[][] matrix) {
		super(matrix, 6, 22);
	}


}
