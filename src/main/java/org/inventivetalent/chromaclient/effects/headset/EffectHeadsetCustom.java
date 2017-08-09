package org.inventivetalent.chromaclient.effects.headset;

import org.inventivetalent.chromaclient.effects.EffectType;

public class EffectHeadsetCustom extends EffectHeadsetAbstract {

	private int[] param = new int[5];

	public EffectHeadsetCustom(HeadsetColorArray array) {
		super(EffectType.CHROMA_CUSTOM);
		this.param = array.getArray();
	}

}
