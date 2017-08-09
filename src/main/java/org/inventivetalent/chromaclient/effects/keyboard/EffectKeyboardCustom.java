package org.inventivetalent.chromaclient.effects.keyboard;

import org.inventivetalent.chromaclient.effects.EffectType;

public class EffectKeyboardCustom extends EffectKeyboardAbstract {

	private int[][] param = new int[6][22];

	public EffectKeyboardCustom(KeyboardColorMatrix matrix) {
		super(EffectType.CHROMA_CUSTOM);
		this.param = matrix.getMatrix();
	}

}
