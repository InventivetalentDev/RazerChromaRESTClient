package org.inventivetalent.chromaclient.effects.keypad;

import com.google.gson.JsonObject;
import org.inventivetalent.chromaclient.Util;
import org.inventivetalent.chromaclient.effects.EffectType;

import java.awt.*;

public class EffectKeypadStatic extends EffectKeypadAbstract {

	private JsonObject param = new JsonObject();

	public EffectKeypadStatic(Color color) {
		super(EffectType.CHROMA_STATIC);
		this.param.addProperty("color", Util.rgbToBgr(color.getRGB()));
	}

}
