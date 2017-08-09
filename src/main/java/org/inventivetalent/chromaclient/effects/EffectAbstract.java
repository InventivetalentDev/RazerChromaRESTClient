package org.inventivetalent.chromaclient.effects;

import lombok.Data;

@Data
public abstract class EffectAbstract {

	private transient final EffectTarget target;
	private final           EffectType   effect;

	public EffectAbstract(EffectTarget target, EffectType effect) {
		this.target = target;
		this.effect = effect;
	}

}
