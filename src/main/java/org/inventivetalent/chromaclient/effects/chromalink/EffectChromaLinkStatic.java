package org.inventivetalent.chromaclient.effects.chromalink;

import com.google.gson.JsonObject;
import org.inventivetalent.chromaclient.Util;
import org.inventivetalent.chromaclient.effects.EffectType;

import java.awt.*;

public class EffectChromaLinkStatic extends EffectChromaLinkAbstract {

	private JsonObject param = new JsonObject();

	public EffectChromaLinkStatic(Color color) {
		super(EffectType.CHROMA_STATIC);
		this.param.addProperty("color", Util.rgbToBgr(color.getRGB()));
	}

}
