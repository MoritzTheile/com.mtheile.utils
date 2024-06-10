package com.mtheile.utils.jhi.codegenerator;

public class TemplateGenerator {

	public static void main(String[] args) throws Exception {

		//
		// Using UPb module files as master code
		//

		String parentName = "IsoDataPoint"; // stays the same for all Iso files

		String modulName = "Iso"; // stays the same for all Iso files

		//createListTemplatesFromMaster("LIsoGrainDomain", parentName, modulName);

		createListTemplatesFromMaster("IsoDataPoint", parentName, modulName);

	}

	private static void createBatchTemplatesFromMaster(String entityName, String parentName, String modulName) throws Exception {

		CodeGenerator.code2Template(parentName, modulName, entityName, //
				"C:\\Users\\theil\\git\\com.lithodat.app\\src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\tableimporter\\UPbSpotDataImporter.java", //
				"C:\\Users\\theil\\git\\com.mtheile.utils\\utils\\src\\main\\java\\com\\mtheile\\utils\\jhi\\codegenerator\\profiles\\server\\templates\\batch\\ChildImporter.java.template" //
		);
	}
	
	
	
	private static void createListTemplatesFromMaster(String entityName, String parentName, String modulName) throws Exception {

		CodeGenerator.code2Template(parentName, modulName, entityName, //
				"C:\\Users\\theil\\git\\com.lithodat.app\\src\\main\\java\\com\\lithodat\\app\\litho\\service\\iso\\IsoDataPointLithoService.java", //
				"C:\\Users\\theil\\git\\com.mtheile.utils\\utils\\src\\main\\java\\com\\mtheile\\utils\\jhi\\codegenerator\\profiles\\server\\templates\\service\\DataPointLithoService.java.template" //
		);

//		CodeGenerator.code2Template(parentName, modulName, entityName, //
//				"C:\\Users\\theil\\git\\com.lithodat.app\\src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\tableimporter\\lists\\LUPbGrainDomainImporter.java", //
//				"C:\\Users\\theil\\git\\com.mtheile.utils\\utils\\src\\main\\java\\com\\mtheile\\utils\\jhi\\codegenerator\\profiles\\server\\templates\\batch\\ChildImporter.java.template" //
//		);

	}

	private static void createDataPointTemplatesFromMaster(String entityName, String parentName, String modulName) throws Exception {

		CodeGenerator.code2Template(parentName, modulName, entityName, //
				"C:\\Users\\theil\\git\\com.lithodat.app\\src\\main\\java\\com\\lithodat\\app\\litho\\service\\"+modulName.toLowerCase()+"\\"+entityName+"LithoService.java", //
				"C:\\Users\\theil\\git\\com.mtheile.utils\\utils\\src\\main\\java\\com\\mtheile\\utils\\jhi\\codegenerator\\profiles\\server\\templates\\service\\DataPointLithoService.java.template" //
		);

//		CodeGenerator.code2Template(parentName, modulName, entityName, //
//				"C:\\Users\\theil\\git\\com.lithodat.app\\src\\main\\java\\com\\lithodat\\app\\litho\\web\\rest\\"+modulName.toLowerCase()+"\\"+entityName+"LithoResource.java", //
//				"C:\\Users\\theil\\git\\com.mtheile.utils\\utils\\src\\main\\java\\com\\mtheile\\utils\\jhi\\codegenerator\\profiles\\server\\templates\\service\\DataPointLithoResource.java.template" //
//		);

	}

	

}
