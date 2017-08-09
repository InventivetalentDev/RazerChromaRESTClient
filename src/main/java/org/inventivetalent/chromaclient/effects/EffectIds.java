package org.inventivetalent.chromaclient.effects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EffectIds {

	private List<UUID> ids = new ArrayList<UUID>();

	public EffectIds add(UUID uuid) {
		this.ids.add(uuid);
		return this;
	}

}
