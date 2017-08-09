package org.inventivetalent.chromaclient.effects.keypad;

import org.inventivetalent.chromaclient.effects.ColorMatrixAbstract;

public class KeypadColorMatrix extends ColorMatrixAbstract {

	public KeypadColorMatrix() {
		super(new int[4][5], 4, 5);
	}

	public KeypadColorMatrix(int[][] matrix) {
		super(matrix, 4, 5);
	}

}
