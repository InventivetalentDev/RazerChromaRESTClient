package org.inventivetalent.chromaclient.effects.mouse;

import org.inventivetalent.chromaclient.effects.ColorMatrixAbstract;

public class MouseColorMatrix extends ColorMatrixAbstract {

	public MouseColorMatrix() {
		super(new int[9][7], 9, 7);
	}

	public MouseColorMatrix(int[][] matrix) {
		super(matrix, 9, 7);
	}

}
