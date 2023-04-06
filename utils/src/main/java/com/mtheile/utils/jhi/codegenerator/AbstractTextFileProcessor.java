package com.mtheile.utils.jhi.codegenerator;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public abstract class AbstractTextFileProcessor {


	private String filePath;

	public AbstractTextFileProcessor(String filePath) {

		super();

		this.filePath = filePath;

	}

	public abstract String processFileText(String text) throws Exception; 

	public void execute() throws Exception {

		File file = new File(filePath);
		String fileText = fileToString(file);
		String result = processFileText(fileText);
		saveAsFile(file, result);

	}
	
	private void saveAsFile(File targetFile, String text) throws Exception {
		
		Files.write(Paths.get(targetFile.getPath()), text.getBytes(StandardCharsets.UTF_8));

	}
	
	private static String fileToString(File file) throws IOException {

		Path path = Paths.get(file.getPath());

		byte[] bytesFromFile = Files.readAllBytes(path);

		return new String(bytesFromFile, StandardCharsets.UTF_8);

	}
}
