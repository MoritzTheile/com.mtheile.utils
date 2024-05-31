package com.mtheile.utils.jhi.codegenerator.profiles.server;

import com.mtheile.utils.file.textfile.TextFileManipulator;
import com.mtheile.utils.jhi.codegenerator.AbstractTextFileProcessor;
import com.mtheile.utils.jhi.codegenerator.CodeGenerator;
import com.mtheile.utils.jhi.codegenerator.AbstractTemplateProcessor.MODE;
import com.mtheile.utils.jhi.codegenerator.model.EntityModel;
import com.mtheile.utils.jhi.codegenerator.model.EntityModel.LITHO_PROFILE;
import com.mtheile.utils.jhi.codegenerator.utils.batcheditor.BatchEditorUtils;

public class ServerCodeGenerator {

	public static void generate(EntityModel entityMetaInfo) throws Exception {

		if (LITHO_PROFILE.DATAPOINT.equals(entityMetaInfo.getLithoProfile())) {

			CodeGenerator.template2Code( //
					entityMetaInfo.getLithoParent(), //
					entityMetaInfo.getLithoModule(), //
					entityMetaInfo.name, //
					CodeGenerator.PROFILES_HOME + "server/templates/service/DataPointLithoService.java.template", //
					CodeGenerator.PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\" + entityMetaInfo.getLithoModule().toLowerCase() + "\\" + entityMetaInfo.name + "LithoService.java", //
					MODE.DEFAULT
			);

			CodeGenerator.template2Code( //
					entityMetaInfo.getLithoParent(), //
					entityMetaInfo.getLithoModule(), //
					entityMetaInfo.name, //
					CodeGenerator.PROFILES_HOME + "server/templates/service/DataPointLithoResource.java.template", //
					CodeGenerator.PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\web\\rest\\" + entityMetaInfo.getLithoModule().toLowerCase() + "\\" + entityMetaInfo.name + "LithoResource.java", //
					MODE.DEFAULT
			);

			// batch code:

			CodeGenerator.template2Code( //
					entityMetaInfo.getLithoParent(), //
					entityMetaInfo.getLithoModule(), //
					entityMetaInfo.name, //
					CodeGenerator.PROFILES_HOME + "server/templates/batch/DataPointImporter.java.template", //
					CodeGenerator.PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\tableimporter\\" + entityMetaInfo.name + "Importer.java", //
					MODE.DEFAULT
			);

			ServerCodeGenerator.registerToBatch(entityMetaInfo);

			CodeGenerator.template2Code( //
					entityMetaInfo.getLithoParent(), //
					entityMetaInfo.getLithoModule(), //
					entityMetaInfo.name, //
					CodeGenerator.PROFILES_HOME + "server/templates/batch/DataPointBatchAdapter.java.template", //
					CodeGenerator.PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\adapters\\" + entityMetaInfo.name + "BatchAdapter.java", //
					MODE.SKIP_IF_FILE_EXISTS
	);

			/**
			 * no templates used
			 */
			ServerCodeGenerator.addBatchAdaptorFields(entityMetaInfo);

		}
		
		if (LITHO_PROFILE.CHILD.equals(entityMetaInfo.getLithoProfile())) {

			CodeGenerator.template2Code( //
					entityMetaInfo.getLithoParent(), //
					entityMetaInfo.getLithoModule(), //
					entityMetaInfo.name, //
					CodeGenerator.PROFILES_HOME + "server/templates/service/ChildLithoService.java.template", //
					CodeGenerator.PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\" + entityMetaInfo.getLithoModule().toLowerCase() + "\\" + entityMetaInfo.name + "LithoService.java", //
					MODE.DEFAULT
		);

			CodeGenerator.template2Code( //
					entityMetaInfo.getLithoParent(), //
					entityMetaInfo.getLithoModule(), //
					entityMetaInfo.name, //
					CodeGenerator.PROFILES_HOME + "server/templates/service/CRUDLithoResource.java.template", //
					CodeGenerator.PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\web\\rest\\" + entityMetaInfo.getLithoModule().toLowerCase() + "\\" + entityMetaInfo.name + "LithoResource.java", //
					MODE.DEFAULT
			);

			// batch code:

			CodeGenerator.template2Code( //
					entityMetaInfo.getLithoParent(), //
					entityMetaInfo.getLithoModule(), //
					entityMetaInfo.name, //
					CodeGenerator.PROFILES_HOME + "server/templates/batch/ChildImporter.java.template", //
					CodeGenerator.PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\tableimporter\\" + entityMetaInfo.name + "Importer.java", //
					MODE.DEFAULT
			);

			ServerCodeGenerator.registerToBatch(entityMetaInfo);

			CodeGenerator.template2Code( //
					entityMetaInfo.getLithoParent(), //
					entityMetaInfo.getLithoModule(), //
					entityMetaInfo.name, //
					CodeGenerator.PROFILES_HOME + "server/templates/batch/ChildBatchAdapter.java.template", //
					CodeGenerator.PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\adapters\\" + entityMetaInfo.name + "BatchAdapter.java", //
					MODE.DEFAULT
	);

			/**
			 * no templates used
			 */
			ServerCodeGenerator.addBatchAdaptorFields(entityMetaInfo);

		}

		if (LITHO_PROFILE.LIST.equals(entityMetaInfo.getLithoProfile())) {

			CodeGenerator.template2Code( //
					entityMetaInfo.getLithoParent(), //
					entityMetaInfo.getLithoModule(), //
					entityMetaInfo.name, //
					CodeGenerator.PROFILES_HOME + "server/templates/service/ListLithoService.java.template", //
					CodeGenerator.PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\" + entityMetaInfo.getLithoModule().toLowerCase() + "\\" + entityMetaInfo.name + "LithoService.java", //
					MODE.DEFAULT
			);

			CodeGenerator.template2Code( //
					entityMetaInfo.getLithoParent(), //
					entityMetaInfo.getLithoModule(), //
					entityMetaInfo.name, //
					CodeGenerator.PROFILES_HOME + "server/templates/service/CRUDLithoResource.java.template", //
					CodeGenerator.PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\web\\rest\\" + entityMetaInfo.getLithoModule().toLowerCase() + "\\" + entityMetaInfo.name + "LithoResource.java", //
					MODE.DEFAULT
			);

			// batch code:

			ServerCodeGenerator.registerToBatch(entityMetaInfo);

			CodeGenerator.template2Code( //
					entityMetaInfo.getLithoParent(), //
					entityMetaInfo.getLithoModule(), //
					entityMetaInfo.name, //
					CodeGenerator.PROFILES_HOME + "server/templates/batch/ListImporter.java.template", //
					CodeGenerator.PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\tableimporter\\lists\\" + entityMetaInfo.name + "Importer.java", //
					MODE.DEFAULT
			);

		}

	}

	private static void registerToBatch(EntityModel entityMetaInfo) throws Exception {
		new AbstractTextFileProcessor(CodeGenerator.PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\dto\\BatchTableDTO.java") {

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
	 * no templates used
	 */
	private static void addBatchAdaptorFields(EntityModel entityModel) throws Exception {

		for (EntityModel.FieldModel fieldModel : entityModel.fields) {

			new AbstractTextFileProcessor(CodeGenerator.PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\adapters\\" + entityModel.name + "BatchAdapter.java") {

				@Override
				public String processFileText(String text) throws Exception {

					{ // adding resource
						String element = BatchEditorUtils.getAdapterFieldCode(entityModel, fieldModel);

						if (!text.contains("\""+fieldModel.fieldName+"\"")) {

							String replacement = element + "\n" + "        // <!-- CODEGENERATOR_NEEDLE_FOR_ADDING_FIELDS (don't remove) -->";

							text = TextFileManipulator.replaceSection(text, "// <!--", "CODEGENERATOR_NEEDLE_FOR_ADDING_FIELDS", "-->", replacement);

						}

					}

					return text;

				}

			}.execute();

		}

		for (EntityModel.Relationship relationship : entityModel.relationships) {

			new AbstractTextFileProcessor(CodeGenerator.PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\adapters\\" + entityModel.name + "BatchAdapter.java") {

				@Override
				public String processFileText(String text) throws Exception {

					{ // adding resource
						String element = BatchEditorUtils.getAdapterRef(entityModel, relationship);

						if (!text.contains("\""+entityModel.getLithoParent()+"\"")) {

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
