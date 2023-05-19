package com.mtheile.utils.jhi.codegenerator.profiles.server;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.mtheile.utils.file.textfile.TextFileManipulator;
import com.mtheile.utils.jhi.codegenerator.AbstractTemplateProcessor;
import com.mtheile.utils.jhi.codegenerator.AbstractTextFileProcessor;
import com.mtheile.utils.jhi.codegenerator.AbstractTemplateProcessor.MODE;
import com.mtheile.utils.jhi.codegenerator.model.EntityModel;
import com.mtheile.utils.jhi.codegenerator.model.EntityModelService;
import com.mtheile.utils.jhi.codegenerator.model.EntityModel.LITHO_PROFILE;

public class ServerCodeGenerator {

	private static final String PROJECT_HOME = "C:\\Users\\theil\\git\\com.lithodat.app\\";

	private	static List<EntityModel> getEntityMetaInfos() throws Exception {

		List<EntityModel> entityModels = new ArrayList<>();
		

		return entityModels;

	}

	

	public static void generateEntityServiceCode(EntityModel entityMetaInfo) throws Exception {

		// --------------- START - JAVA ----------------------------

		new AbstractTemplateProcessor("ChildLithoService.java.template") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\" + entityMetaInfo.getLithoModule().toLowerCase() + "\\" + entityMetaInfo.name + "LithoService.java";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.getLithoModule().toLowerCase());
				//result = result.replaceAll("PARENTNAME_TOKEN", entityMetaInfo.parentName);
				return result;
			}

		}.execute(MODE.SKIP_IF_FILE_EXISTS);

		new AbstractTemplateProcessor("CRUDLithoResource.java.template") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\web\\rest\\" + entityMetaInfo.getLithoModule().toLowerCase() + "\\" + entityMetaInfo.name + "LithoResource.java";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.getLithoModule().toLowerCase());
				//result = result.replaceAll("PARENTNAME_TOKEN", entityMetaInfo.parentName);
				return result;
			}

		}.execute();
	}

	public static void generateEntityBatchCode(EntityModel entityMetaInfo) throws Exception {

		new AbstractTemplateProcessor("ChildImporter.java.template") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\tableimporter\\" + entityMetaInfo.name + "Importer.java";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.getLithoModule().toLowerCase());
				return result;
			}

		}.execute();
		
		new AbstractTemplateProcessor("BatchAdapter.java.template") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\adapters\\" + entityMetaInfo.name + "BatchAdapter.java";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.getLithoModule().toLowerCase());
				//result = result.replaceAll("PARENTNAME_TOKEN", entityMetaInfo.parentName);
				return result;
			}

		}.execute();


		new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\dto\\BatchTableDTO.java") {

			@Override
			public String processFileText(String text) throws Exception {

				{ // adding resource
					String element = ", " + entityMetaInfo.name;

					if (!text.contains(element)) {

						String replacement = element + "\n" + "        // <!-- CODEGENERATOR_NEEDLE_FOR_ADDING_TABLES (don't remove) -->\n";

						text = TextFileManipulator.replaceSection(text, "// <!--", "CODEGENERATOR_NEEDLE_FOR_ADDING_TABLES", "-->", replacement);

					}
					
				}
				
				return text;
			}
		}.execute();
	}

	public static void generateListServiceCode(EntityModel entityMetaInfo) throws Exception {
	
		new AbstractTemplateProcessor("ListLithoService.java.template") {
	
			@Override
			public String getTargetFilePath() {
	
				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\icpms\\" + entityMetaInfo.name + "LithoService.java";
	
			}
	
			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				return result;
			}
	
		}.execute();
	
		new AbstractTemplateProcessor("CRUDLithoResource.java.template") {
	
			@Override
			public String getTargetFilePath() {
	
				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\web\\rest\\" + entityMetaInfo.getLithoModule().toLowerCase() + "\\" + entityMetaInfo.name + "LithoResource.java";
	
			}
	
			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.getLithoModule().toLowerCase());
				return result;
			}
	
		}.execute();
	
	}
	
	public static void generateListBatchCode(EntityModel entityMetaInfo) throws Exception {
		new AbstractTemplateProcessor("ListImporter.java.template") {
	
			@Override
			public String getTargetFilePath() {
	
				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\tableimporter\\lists\\" + entityMetaInfo.name + "Importer.java";
	
			}
	
			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.getLithoModule().toLowerCase());
				return result;
			}
	
		}.execute();
	
		new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\dto\\BatchTableDTO.java") {
	
			@Override
			public String processFileText(String text) throws Exception {
	
				{ // adding resource
					String element = ", " + entityMetaInfo.name;
	
					if (!text.contains(element)) {
	
						String replacement = element + "\n" + "        // <!-- CODEGENERATOR_NEEDLE_FOR_ADDING_TABLES (don't remove) -->\n";
	
						text = TextFileManipulator.replaceSection(text, "// <!--", "CODEGENERATOR_NEEDLE_FOR_ADDING_TABLES", "-->", replacement);
	
					}
				}
				return text;
			}
		}.execute();
	
	}

}
