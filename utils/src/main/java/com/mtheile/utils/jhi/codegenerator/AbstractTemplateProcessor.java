package com.mtheile.utils.jhi.codegenerator;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.mtheile.utils.STATICUtils;

public abstract class AbstractTemplateProcessor {

	private static final String EXAMPLE_FILE_RESOURCE = "/com/mtheile/utils/jhi/codegenerator/templates/";

	private String templateName;

	public AbstractTemplateProcessor(String templateName) {

		super();

		this.templateName = templateName;

	}

	public abstract String processTemplate(String template); 

	public abstract String getTargetFilePath();

	public void execute() throws Exception {

		String template = new String(STATICUtils.getResourceAsByteArray(EXAMPLE_FILE_RESOURCE + templateName));
		String result = processTemplate(template);
		saveAsFile(getTargetFilePath(), result);

	}
	
	private void saveAsFile(String targetFilePath, String result) throws Exception {
		
		File targetFile = new File(targetFilePath);
		
		if (targetFile.exists()) {
			
			targetFile.delete();
			targetFile.createNewFile();
			
		}
		
		File dir = targetFile.getParentFile();
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		targetFile.createNewFile();
		
		Files.write(Paths.get(targetFile.getPath()), result.getBytes(StandardCharsets.UTF_8));

	}
}
