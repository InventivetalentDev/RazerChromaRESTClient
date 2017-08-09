package org.inventivetalent.chromaclient.effects.mousepad;

import com.google.gson.JsonObject;
import org.inventivetalent.chromaclient.Util;
import org.inventivetalent.chromaclient.effects.EffectType;

import java.awt.*;

public class EffectMousepadStatic  extends EffectMousepadAbstract{

	private final JsonObject param = new JsonObject();

	public EffectMousepadStatic(Color color) {
		super(EffectType.CHROMA_STATIC);
		this.param.addProperty("color", Util.rgbToBgr(color.getRGB()));
	}

}
