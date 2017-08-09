package org.inventivetalent.chromaclient.effects.mouse;

import com.google.gson.JsonObject;
import org.inventivetalent.chromaclient.Util;
import org.inventivetalent.chromaclient.effects.EffectType;

import java.awt.*;

public class EffectMouseStatic extends EffectMouseAbstract {

	private final JsonObject param = new JsonObject();

	public EffectMouseStatic(Color color) {
		super(EffectType.CHROMA_STATIC);
		this.param.addProperty("color", Util.rgbToBgr(color.getRGB()));
	}
}
