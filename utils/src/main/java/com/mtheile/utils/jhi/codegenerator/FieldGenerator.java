package com.mtheile.utils.jhi.codegenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.mtheile.utils.file.textfile.TextFileManipulator;
import com.mtheile.utils.jhi.codegenerator.model.EntityModel;
import com.mtheile.utils.jhi.codegenerator.model.EntityModelService;

public class FieldGenerator {

	private static final String PROJECT_HOME = "C:\\Users\\theil\\git\\com.lithodat.app\\";

	private static List<EntityModel> getEntityMetaInfos() throws Exception {

		List<EntityModel> entityModels = new ArrayList<>();

		entityModels.add(EntityModelService.getModelInfosFromJHipster( //
				new File(PROJECT_HOME), //
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
		
		new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\dto\\BatchTableDTO.java") {

			@Override
			public String processFileText(String text) throws Exception {

				{ // adding resource
					String element = ", " + entityModel.name;

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
