package org.inventivetalent.chromaclient.effects.headset;

import com.google.gson.JsonObject;
import org.inventivetalent.chromaclient.Util;
import org.inventivetalent.chromaclient.effects.EffectType;

import java.awt.*;

public class EffectHeadsetStatic extends EffectHeadsetAbstract {

	private JsonObject param = new JsonObject();

	public EffectHeadsetStatic(Color color) {
		super(EffectType.CHROMA_STATIC);
		this.param.addProperty("color", Util.rgbToBgr(color.getRGB()));
	}

}
