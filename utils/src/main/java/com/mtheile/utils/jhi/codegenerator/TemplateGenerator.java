package com.mtheile.utils.jhi.codegenerator;

public class TemplateGenerator {

	public static void main(String[] args) throws Exception {

		// Using UPb module files as master code
		
		String parentName = "UPbDataPoint"; // stays the same for all UPb files
		
		String modulName = "UPb"; // stays the same for all UPb files
		
		code2Template(parentName, modulName, //
				"LUPbGrainDomain", //
				"C:\\Users\\theil\\git\\com.lithodat.app\\src\\main\\java\\com\\lithodat\\app\\litho\\service\\upb\\LUPbGrainDomainLithoService.java", //
				"C:\\Users\\theil\\git\\com.mtheile.utils\\utils\\src\\main\\java\\com\\mtheile\\utils\\jhi\\codegenerator\\profiles\\server\\templates\\service\\ListLithoService.java.template" //
				);

		

	}

	private static void code2Template(String parentName, String modulName, String entityName, String sourceFile, String targetFile) throws Exception {
		
		new AbstractTemplateProcessor(sourceFile) {

			@Override
			public String getTargetFilePath() {

				return targetFile;

			}

			@Override
			public String processTemplate(String template) {
				
				template = template.replaceAll( entityName, "ENTITYNAME_TOKEN");
				template = template.replaceAll( parentName, "PARENTNAME_TOKEN");
				template = template.replaceAll( modulName, "MODULNAME_TOKEN");
				template = template.replaceAll( modulName.toLowerCase(), "MODULNAME_LOWERCASE_TOKEN");
				
				return template;
				
			}

		}.execute();
	}

}
