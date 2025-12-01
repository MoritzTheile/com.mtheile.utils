package com.mtheile.utils.jhi.codegenerator;

public class TemplateGenerator {

	public static void main(String[] args) throws Exception {

		//
		// Using UPb module files as master code
		//


		//createListTemplatesFromMaster("LIsoGrainDomain", parentName, modulName);

		// update CRUD Litho Resource Templates
		//updateCRUDLithoResourceTemplate("LUncertainty", "UPbDataPoint", "UPb");

		// update Child Litho Service Templates
		updateChildLithoServiceTemplate("UPbSpotData", "UPbDataPoint", "UPb");
	}

	private static void updateCRUDLithoResourceTemplate(String entityName, String parentName, String modulName) throws Exception {

		CodeGenerator.code2Template(parentName, modulName, entityName, //
				"C:\\Users\\theil\\git\\com.lithodat.app\\src\\main\\java\\com\\lithodat\\app\\litho\\web\\rest\\"+modulName.toLowerCase()+"\\"+entityName+"LithoResource.java", //
				"C:\\Users\\theil\\git\\com.mtheile.utils\\utils\\src\\main\\java\\com\\mtheile\\utils\\jhi\\codegenerator\\profiles\\server\\templates\\service\\CRUDLithoResource.java.template" //
		);
	}
	
	private static void updateChildLithoServiceTemplate(String entityName, String parentName, String modulName) throws Exception {

		CodeGenerator.code2Template(parentName, modulName, entityName, //
				"C:\\Users\\theil\\git\\com.lithodat.app\\src\\main\\java\\com\\lithodat\\app\\litho\\service\\"+modulName.toLowerCase()+"\\"+entityName+"LithoService.java", //
				"C:\\Users\\theil\\git\\com.mtheile.utils\\utils\\src\\main\\java\\com\\mtheile\\utils\\jhi\\codegenerator\\profiles\\server\\templates\\service\\ChildLithoService.java.template" //
		);
	}

	private static void updateBatchAdapterTemplate(String entityName, String parentName, String modulName) throws Exception {

		CodeGenerator.code2Template(parentName, modulName, entityName, //
				"C:\\Users\\theil\\git\\com.lithodat.app\\src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\adapters\\"+entityName+"BatchAdapter.java", //
				"C:\\Users\\theil\\git\\com.mtheile.utils\\utils\\src\\main\\java\\com\\mtheile\\utils\\jhi\\codegenerator\\profiles\\server\\templates\\batch\\DataPointBatchAdapter.java.template" //
				
		);
		
		
	}
	
	
	
	


	private static void createDataPointTemplatesFromMaster(String entityName, String parentName, String modulName) throws Exception {

		CodeGenerator.code2Template(parentName, modulName, entityName, //
				"C:\\Users\\theil\\git\\com.lithodat.app\\src\\main\\java\\com\\lithodat\\app\\litho\\service\\"+modulName.toLowerCase()+"\\"+entityName+"LithoService.java", //
				"C:\\Users\\theil\\git\\com.mtheile.utils\\utils\\src\\main\\java\\com\\mtheile\\utils\\jhi\\codegenerator\\profiles\\server\\templates\\service\\DataPointLithoService.java.template" //
		);

	}

	

}
