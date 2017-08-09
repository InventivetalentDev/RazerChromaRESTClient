package org.inventivetalent.chromaclient.effects.mousepad;

import org.inventivetalent.chromaclient.effects.EffectType;

public class EffectMousepadCustom extends EffectMousepadAbstract {

	private int[] param = new int[15];

	public EffectMousepadCustom(MousepadColorArray array) {
		super(EffectType.CHROMA_CUSTOM);
		this.param = array.getArray();
	}

}
