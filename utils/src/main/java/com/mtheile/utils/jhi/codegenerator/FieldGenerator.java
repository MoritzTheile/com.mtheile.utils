package com.mtheile.utils.jhi.codegenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.mtheile.utils.file.textfile.TextFileManipulator;
import com.mtheile.utils.jhi.codegenerator.model.EntityModel;
import com.mtheile.utils.jhi.codegenerator.model.EntityModelService;
import com.mtheile.utils.jhi.codegenerator.utils.batcheditor.BatchEditorUtils;

public class FieldGenerator {

	private static final String PROJECT_HOME = "C:\\Users\\theil\\git\\com.lithodat.app\\";

	private static List<EntityModel> getEntityMetaInfos() throws Exception {

		List<EntityModel> entityModels = new ArrayList<>();

		entityModels.add(EntityModelService.getModelInfosFromJHipster( //
				new File(PROJECT_HOME + ".jhipster\\"), //
				"icpms", //
				"ICPMSMetadata", //
				"LaserMetadata"//
		));

		return entityModels;

	}

	public static void main(String[] args) throws Exception {

		for (EntityModel entityModel : getEntityMetaInfos()) {

			addBatchEditorFields(entityModel);

		}
	}

	private static void addBatchEditorFields(EntityModel entityModel) throws Exception {

		for (EntityModel.FieldModel fieldModel : entityModel.fields) {

			new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\adapters\\" + entityModel.name + "BatchAdapter.java") {

				@Override
				public String processFileText(String text) throws Exception {

					{ // adding resource
						String element = "\t\t" + BatchEditorUtils.getAdapterFieldCode(entityModel, fieldModel);

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
						String element =  BatchEditorUtils.getAdapterRef(entityModel, relationship);

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
