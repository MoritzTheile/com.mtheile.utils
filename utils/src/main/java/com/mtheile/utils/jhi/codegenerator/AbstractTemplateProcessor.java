package com.mtheile.utils.jhi.codegenerator;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.mtheile.utils.STATICUtils;

public abstract class AbstractTemplateProcessor {
	
	public static enum MODE {SKIP_IF_FILE_EXISTS, DEFAULT}


	private String templateName;

	public AbstractTemplateProcessor(String templateName) {

		super();

		this.templateName = templateName;

	}

	public abstract String processTemplate(String template); 

	public abstract String getTargetFilePath();

	public void execute() throws Exception {
		execute(MODE.DEFAULT);
	}
	
	public void execute(MODE mode) throws Exception {

		if(new File(getTargetFilePath()).exists() && MODE.SKIP_IF_FILE_EXISTS.equals(mode)) {
			return;
		}

		String template = null;
		
		if(templateName.contains(":")) { // enabling absolute file locations besides resources
			template =  new String(Files.readAllBytes(Paths.get(templateName)));
		}else {
			template = new String(STATICUtils.getResourceAsByteArray(templateName));
		}
		
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
