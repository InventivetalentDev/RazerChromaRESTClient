package org.inventivetalent.chromaclient.data;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Application {

	private String       title;
	private String       description;
	private Author       author;
	@SerializedName("device_supported")
	private DeviceType[] deviceSupported;
	private String       category;

	@Data
	@AllArgsConstructor
	public static class Author {

		private String name;
		private String contact;

	}

}
