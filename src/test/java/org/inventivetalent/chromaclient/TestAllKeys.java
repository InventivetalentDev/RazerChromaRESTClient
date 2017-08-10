package org.inventivetalent.chromaclient;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.inventivetalent.chromaclient.data.Application;
import org.inventivetalent.chromaclient.data.DeviceType;
import org.inventivetalent.chromaclient.effects.chromalink.ChromaLinkColorArray;
import org.inventivetalent.chromaclient.effects.chromalink.EffectChromaLinkCustom;
import org.inventivetalent.chromaclient.effects.chromalink.EffectChromaLinkNone;
import org.inventivetalent.chromaclient.effects.headset.EffectHeadsetCustom;
import org.inventivetalent.chromaclient.effects.headset.EffectHeadsetNone;
import org.inventivetalent.chromaclient.effects.headset.HeadsetColorArray;
import org.inventivetalent.chromaclient.effects.keyboard.EffectKeyboardCustom;
import org.inventivetalent.chromaclient.effects.keyboard.EffectKeyboardNone;
import org.inventivetalent.chromaclient.effects.keyboard.KeyboardColorMatrix;
import org.inventivetalent.chromaclient.effects.keypad.EffectKeypadCustom;
import org.inventivetalent.chromaclient.effects.keypad.EffectKeypadNone;
import org.inventivetalent.chromaclient.effects.keypad.KeypadColorMatrix;
import org.inventivetalent.chromaclient.effects.mouse.EffectMouseCustom;
import org.inventivetalent.chromaclient.effects.mouse.EffectMouseNone;
import org.inventivetalent.chromaclient.effects.mouse.MouseColorMatrix;
import org.inventivetalent.chromaclient.effects.mousepad.EffectMousepadCustom;
import org.inventivetalent.chromaclient.effects.mousepad.EffectMousepadNone;
import org.inventivetalent.chromaclient.effects.mousepad.MousepadColorArray;

import java.awt.*;

public class TestAllKeys {

	public static void main(String[] args) throws UnirestException, InterruptedException, IllegalAccessException {
		long start = System.currentTimeMillis();

		final ChromaClient client = new ChromaClient(new Application("testApp",
				"Test application for the ChromaRESTClient",
				new Application.Author("inventivetalent", "inventivetalent.org"),
				DeviceType.values(),
				"application"));

		client.init();

		Thread.sleep(500);

		// Turn off everything
		client.createAndSetEffect(new EffectChromaLinkNone());
		client.createAndSetEffect(new EffectHeadsetNone());
		client.createAndSetEffect(new EffectKeyboardNone());
		client.createAndSetEffect(new EffectKeypadNone());
		client.createAndSetEffect(new EffectMouseNone());
		client.createAndSetEffect(new EffectMousepadNone());

		Thread.sleep(1000);

		// ChromaLink
		new Thread(new Runnable() {
			public void run() {
				ChromaLinkColorArray array = new ChromaLinkColorArray();
				for (int i = 0; i < array.getLength(); i++) {
					array.setColor(i, Color.cyan);
					try {
						client.createAndSetEffect(new EffectChromaLinkCustom(array));
						Thread.sleep(1000);
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
			}
		}).start();

		// Headset
		new Thread(new Runnable() {
			public void run() {
				HeadsetColorArray array = new HeadsetColorArray();
				for (int i = 0; i < array.getLength(); i++) {
					array.setColor(i, Color.cyan);
					try {
						client.createAndSetEffect(new EffectHeadsetCustom(array));
						Thread.sleep(1000);
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
			}
		}).start();

		// Keyboard
		new Thread(new Runnable() {
			public void run() {
				KeyboardColorMatrix matrix = new KeyboardColorMatrix();
				for (int y = 0; y < matrix.getRows(); y++) {
					for (int x = 0; x < matrix.getColumns(); x++) {
						matrix.setColor(x, y, Color.cyan);
						try {
							client.createAndSetEffect(new EffectKeyboardCustom(matrix));
							Thread.sleep(75);
						} catch (Exception e) {
							throw new RuntimeException(e);
						}
					}
				}
			}
		}).start();

		// Keypad
		new Thread(new Runnable() {
			public void run() {
				KeypadColorMatrix matrix = new KeypadColorMatrix();
				for (int y = 0; y < matrix.getRows(); y++) {
					for (int x = 0; x < matrix.getColumns(); x++) {
						matrix.setColor(x, y, Color.cyan);
						try {
							client.createAndSetEffect(new EffectKeypadCustom(matrix));
							Thread.sleep(500);
						} catch (Exception e) {
							throw new RuntimeException(e);
						}
					}
				}
			}
		}).start();

		// Mouse
		new Thread(new Runnable() {
			public void run() {
				MouseColorMatrix matrix = new MouseColorMatrix();
				for (int x = 0; x < matrix.getColumns(); x++) {
					for (int y = 0; y < matrix.getRows(); y++) {
						matrix.setColor(x, y, Color.cyan);
						try {
							client.createAndSetEffect(new EffectMouseCustom(matrix));
							Thread.sleep(100);
						} catch (Exception e) {
							throw new RuntimeException(e);
						}
					}
				}
			}
		}).start();

		// Mousepad
		new Thread(new Runnable() {
			public void run() {
				MousepadColorArray array = new MousepadColorArray();
				for (int i = 0; i < array.getLength(); i++) {
					array.setColor(i, Color.cyan);
					try {
						client.createAndSetEffect(new EffectMousepadCustom(array));
						Thread.sleep(700);
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
			}
		}).start();


		System.out.println((System.currentTimeMillis() - start) + "ms");

		Thread.sleep(15000);

		// Turn off everything
		client.createAndSetEffect(new EffectChromaLinkNone());
		client.createAndSetEffect(new EffectHeadsetNone());
		client.createAndSetEffect(new EffectKeyboardNone());
		client.createAndSetEffect(new EffectKeypadNone());
		client.createAndSetEffect(new EffectMouseNone());
		client.createAndSetEffect(new EffectMousepadNone());

		Thread.sleep(100);

		client.unInit();
	}

}
