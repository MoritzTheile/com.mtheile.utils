package com.mtheile.utils.file.searchandreplace;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SearchAndReplace {

	public static void searchAndReplace(String regex, String replacement, File file) throws Exception{
		
		Path path = Paths.get(file.getPath());

		byte[] bytesFromFile = Files.readAllBytes(path);

		String textFromFile = new String(bytesFromFile, StandardCharsets.UTF_8);

		textFromFile = textFromFile.replaceAll(regex, replacement);

		Files.write(path, textFromFile.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
		
	}
}
