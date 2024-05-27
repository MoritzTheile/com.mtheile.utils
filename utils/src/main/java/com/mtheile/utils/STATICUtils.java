package com.mtheile.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class STATICUtils {

	public static byte[] getResourceAsByteArray(String resourceName) throws Exception {

		try {
			InputStream inputStream = STATICUtils.class.getResourceAsStream(resourceName);

			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			int nRead;
			byte[] data = new byte[1024];
			while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, nRead);
			}

			buffer.flush();

			byte[] byteArray = buffer.toByteArray();

			inputStream.close();
			return byteArray;
		} catch (Exception e) {
			throw new Exception("Could not get resource: " + resourceName, e);
		}
	}

	public static String firstCharToLowerCase(String string) {

		if (string.isEmpty()) {
			return string;
		}

		String firstChar = string.substring(0, 1);
		String trailingChars = string.substring(1, string.length());

		return firstChar.toLowerCase() + trailingChars;
	}

}
