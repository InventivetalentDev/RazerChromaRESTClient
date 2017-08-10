package org.inventivetalent.chromaclient.effects;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class Effects<E extends EffectAbstract> {

	private List<E> effects = new ArrayList<>();

	public Effects() {
	}

	public Effects(Collection<E> collection) {
		if (collection.isEmpty()) { return; }
		EffectAbstract first = null;
		for (EffectAbstract effect : collection) {
			if (first == null) {
				first = effect;
				continue;// continue, since we don't have anything to compare to yet
			}
			if (first.getTarget() != effect.getTarget()) {
				throw new IllegalArgumentException("Effect targets must all be of the same type");
			}
		}

		this.effects.addAll(collection);
	}

	public Effects add(E effectAbstract) {
		if (!this.effects.isEmpty()) {
			if (effectAbstract.getTarget() != this.effects.get(0).getTarget()) {
				throw new IllegalArgumentException("Effect type must match the existing effect types");
			}
		}

		this.effects.add(effectAbstract);
		return this;
	}

	public EffectTarget getTarget() {
		if(this.effects.isEmpty())return null;
		return this.effects.get(0).getTarget();
	}

}
