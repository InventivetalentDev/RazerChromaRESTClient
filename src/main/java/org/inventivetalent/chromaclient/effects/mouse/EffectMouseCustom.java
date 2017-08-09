package org.inventivetalent.chromaclient.effects.mouse;

import org.inventivetalent.chromaclient.effects.EffectType;

public class EffectMouseCustom extends EffectMouseAbstract {

	private int[][] param = new int[9][7];

	public EffectMouseCustom(MouseColorMatrix matrix) {
		super(EffectType.CHROMA_CUSTOM2);
		this.param = matrix.getMatrix();
	}

}
