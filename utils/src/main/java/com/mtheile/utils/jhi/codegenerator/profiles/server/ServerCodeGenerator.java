package com.mtheile.utils.jhi.codegenerator.profiles.server;

import com.mtheile.utils.file.textfile.TextFileManipulator;
import com.mtheile.utils.jhi.codegenerator.AbstractTemplateProcessor;
import com.mtheile.utils.jhi.codegenerator.AbstractTextFileProcessor;
import com.mtheile.utils.jhi.codegenerator.CodeGenerator;
import com.mtheile.utils.jhi.codegenerator.model.EntityModel;
import com.mtheile.utils.jhi.codegenerator.model.EntityModel.LITHO_PROFILE;
import com.mtheile.utils.jhi.codegenerator.utils.batcheditor.BatchEditorUtils;

public class ServerCodeGenerator {

	private static final String PROJECT_HOME = CodeGenerator.PROJECT_HOME;

	public static void generate(EntityModel entityMetaInfo) throws Exception {

		{ // SERVICE CODE
			if (LITHO_PROFILE.LIST.equals(entityMetaInfo.getLithoProfile())) {

				/**
				 * "ListLithoService.java.template"
				 */
				ServerCodeGenerator.generateListServiceCode(entityMetaInfo);
				
			}
			
			/**
			 * "CRUDLithoResource.java.template"
			 */
			ServerCodeGenerator.generateResourceCode(entityMetaInfo);

			if (LITHO_PROFILE.CHILD.equals(entityMetaInfo.getLithoProfile())) {

				/**
				 * "ChildLithoService.java.template"
				 */
				ServerCodeGenerator.generateChildServiceCode(entityMetaInfo);

			}
		}
		{ // BATCH CODE

			if (LITHO_PROFILE.LIST.equals(entityMetaInfo.getLithoProfile())) {

				/**
				 * "ListImporter.java.template"
				 */
				ServerCodeGenerator.generateListBatchCode(entityMetaInfo);

			}
			
			ServerCodeGenerator.registerToBatch(entityMetaInfo);

			if (LITHO_PROFILE.CHILD.equals(entityMetaInfo.getLithoProfile())) {

				/**
				 * "ChildImporter.java.template" "BatchAdapter.java.template"
				 */
				ServerCodeGenerator.generateEntityBatchCode(entityMetaInfo);

				/**
				 * no templates used
				 */
				ServerCodeGenerator.addBatchEditorFields(entityMetaInfo);
			}
		}
	}
	

	/**
	 * "ChildLithoService.java.template"
	 */
	private static void generateChildServiceCode(EntityModel entityMetaInfo) throws Exception {

		new AbstractTemplateProcessor("server/templates/service/ChildLithoService.java.template") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\" + entityMetaInfo.getLithoModule().toLowerCase() + "\\" + entityMetaInfo.name + "LithoService.java";

			}

			@Override
			public String processTemplate(String template) {
				
				template = template.replaceAll("ENTITYNAME_FIRSTLETTER_LOWERCASE_TOKEN", firstLetterToLowerCase(entityMetaInfo.name));
				template = template.replaceAll("PARENTNAME_FIRSTLETTER_LOWERCASE_TOKEN", firstLetterToLowerCase(entityMetaInfo.getLithoParent()));
				template = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				template = template.replaceAll("PARENTNAME_TOKEN", entityMetaInfo.getLithoParent());
				template = template.replaceAll("MODELNAME_LOWERCASE_TOKEN", entityMetaInfo.getLithoModule().toLowerCase());
				
				return template;
			}

		}.execute();

	}
	public static String firstLetterToLowerCase(String input) {
		
		if (input == null) {
			return null;
		}
	
		if (input.isEmpty()) {
			return input;
		}
	
		return input.substring(0, 1).toLowerCase() + input.substring(1);
	
	}

	private static void generateResourceCode(EntityModel entityMetaInfo) throws Exception {
		new AbstractTemplateProcessor("server/templates/service/CRUDLithoResource.java.template") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\web\\rest\\" + entityMetaInfo.getLithoModule().toLowerCase() + "\\" + entityMetaInfo.name + "LithoResource.java";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.getLithoModule().toLowerCase());
				result = result.replaceAll("PARENTNAME_TOKEN", entityMetaInfo.getLithoParent());
				return result;
			}

		}.execute();
	}

	/**
	 * "ChildImporter.java.template" 
	 * "BatchAdapter.java.template"
	 */
	private static void generateEntityBatchCode(EntityModel entityMetaInfo) throws Exception {

		new AbstractTemplateProcessor("server/templates/batch/ChildImporter.java.template") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\tableimporter\\" + entityMetaInfo.name + "Importer.java";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.getLithoModule().toLowerCase());
				result = result.replaceAll("MODELNAME_TOKEN_LOWERCASE", entityMetaInfo.getLithoModule().toLowerCase());
				
				return result;
			}

		}.execute();

		new AbstractTemplateProcessor("server/templates/batch/BatchAdapter.java.template") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\adapters\\" + entityMetaInfo.name + "BatchAdapter.java";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.getLithoModule().toLowerCase());
				result = result.replaceAll("PARENTNAME_TOKEN", entityMetaInfo.getLithoParent());
				return result;
			}

		}.execute();

	}

	/**
	 * "ListLithoService.java.template"
	 */
	private static void generateListServiceCode(EntityModel entityMetaInfo) throws Exception {

		new AbstractTemplateProcessor("server/templates/service/ListLithoService.java.template") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\" + entityMetaInfo.getLithoModule().toLowerCase() +"\\" + entityMetaInfo.name + "LithoService.java";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN_LOWERCASE", entityMetaInfo.getLithoModule().toLowerCase());
				
				return result;
			}

		}.execute();

	}

	/**
	 *  "ListImporter.java.template"
	 *  
	 */
	private static void generateListBatchCode(EntityModel entityMetaInfo) throws Exception {
		new AbstractTemplateProcessor("server/templates/batch/ListImporter.java.template") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\tableimporter\\lists\\" + entityMetaInfo.name + "Importer.java";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.getLithoModule().toLowerCase());
				result = result.replaceAll("MODELNAME_TOKEN_LOWERCASE", entityMetaInfo.getLithoModule().toLowerCase());
				
				return result;
			}

		}.execute();

	}

	private static void registerToBatch(EntityModel entityMetaInfo) throws Exception {
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

	/**
	 *	no templates used 
	 */
	private static void addBatchEditorFields(EntityModel entityModel) throws Exception {

		for (EntityModel.FieldModel fieldModel : entityModel.fields) {

			new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\adapters\\" + entityModel.name + "BatchAdapter.java") {

				@Override
				public String processFileText(String text) throws Exception {

					{ // adding resource
						String element = BatchEditorUtils.getAdapterFieldCode(entityModel, fieldModel);

						if (!text.contains(element)) {

							String replacement = element + "\n" + "        // <!-- CODEGENERATOR_NEEDLE_FOR_ADDING_FIELDS (don't remove) -->";

							text = TextFileManipulator.replaceSection(text, "// <!--", "CODEGENERATOR_NEEDLE_FOR_ADDING_FIELDS", "-->", replacement);

						}

					}

					return text;

				}

			}.execute();

		}

		for (EntityModel.Relationship relationship : entityModel.relationships) {

			new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\adapters\\" + entityModel.name + "BatchAdapter.java") {

				@Override
				public String processFileText(String text) throws Exception {

					{ // adding resource
						String element = BatchEditorUtils.getAdapterRef(entityModel, relationship);

						if (!text.contains(element)) {

							String replacement = element + "\n" + "        // <!-- CODEGENERATOR_NEEDLE_FOR_ADDING_FIELDS (don't remove) -->";

							text = TextFileManipulator.replaceSection(text, "// <!--", "CODEGENERATOR_NEEDLE_FOR_ADDING_FIELDS", "-->", replacement);

						}

					}

					return text;

				}

			}.execute();

		}
	}

}
