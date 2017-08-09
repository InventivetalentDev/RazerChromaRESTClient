package org.inventivetalent.chromaclient.effects.mouse;

import org.inventivetalent.chromaclient.effects.EffectAbstract;
import org.inventivetalent.chromaclient.effects.EffectTarget;
import org.inventivetalent.chromaclient.effects.EffectType;

public class EffectMouseAbstract extends EffectAbstract {

	public EffectMouseAbstract( EffectType effect) {
		super(EffectTarget.MOUSE, effect);
	}

}
