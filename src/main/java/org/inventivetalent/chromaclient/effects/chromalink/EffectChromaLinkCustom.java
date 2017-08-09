package org.inventivetalent.chromaclient.effects.chromalink;

import org.inventivetalent.chromaclient.effects.EffectType;

public class EffectChromaLinkCustom extends EffectChromaLinkAbstract {

	private int[] param = new int[5];

	public EffectChromaLinkCustom(ChromaLinkColorArray array) {
		super(EffectType.CHROMA_CUSTOM);
		this.param = array.getArray();
	}

}
