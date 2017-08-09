package org.inventivetalent.chromaclient.effects.keypad;

import org.inventivetalent.chromaclient.effects.EffectType;

public class EffectKeypadCustom extends EffectKeypadAbstract {

	private int[][] param = new int[4][5];

	public EffectKeypadCustom(KeypadColorMatrix matrix) {
		super(EffectType.CHROMA_CUSTOM);
		this.param = matrix.getMatrix();
	}

}
