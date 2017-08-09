package org.inventivetalent.chromaclient.effects.keyboard;

import com.google.gson.JsonObject;
import org.inventivetalent.chromaclient.Util;
import org.inventivetalent.chromaclient.effects.EffectType;

import java.awt.*;

public class EffectKeyboardStatic extends EffectKeyboardAbstract {

	private final JsonObject param = new JsonObject();

	public EffectKeyboardStatic(Color color) {
		super(EffectType.CHROMA_STATIC);
		this.param.addProperty("color", Util.rgbToBgr(color.getRGB()));
	}

}
