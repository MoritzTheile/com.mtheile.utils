package com.mtheile.utils.jhi.codegenerator;

import com.mtheile.utils.file.textfile.TextFileManipulator;
import com.mtheile.utils.jhi.codegenerator.model.EntityModel;
import com.mtheile.utils.jhi.codegenerator.model.EntityModel.FieldModel;
import com.mtheile.utils.jhi.codegenerator.utils.batcheditor.BatchEditorUtils;

public class FieldGenerator {

	private static final String PROJECT_HOME = "C:\\Users\\theil\\git\\com.lithodat.app\\";

	public static void generate(EntityModel entityModel) throws Exception {
		addBatchEditorFields(entityModel);
		addTSEntityFields(entityModel);
		addTSListAssos(entityModel);
	}

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

	private static void addTSEntityFields(EntityModel entityModel) throws Exception {

		for (EntityModel.FieldModel fieldModel : entityModel.fields) {

			new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityModel.modelName + "\\" + entityModel.name + "\\EntityFields.tsx") {

				@Override
				public String processFileText(String text) throws Exception {

					{ // adding resource
						String element = getInputFieldCode(entityModel, fieldModel);

						if (!text.contains(element)) {

							String replacement = element + "\n" + "			{/*{<!-- CODEGENERATOR_NEEDLE_FOR_ADDING_FIELDS (don't remove) -->}*/}";

							text = TextFileManipulator.replaceSection(text, "{/*{<!--", "CODEGENERATOR_NEEDLE_FOR_ADDING_FIELDS", "-->}*/}", replacement);

						}

					}

					return text;

				}

			}.execute();

		}
		for (EntityModel.FieldModel fieldModel : entityModel.fields) {

			new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityModel.modelName + "\\" + entityModel.name + "\\EntityColumns.tsx") {

				@Override
				public String processFileText(String text) throws Exception {

					{ // adding resource
						String element = getFieldCode(entityModel, fieldModel);

						if (!text.contains(element)) {

							String replacement = element + "\n" + "  // <!-- CODEGENERATOR_NEEDLE_FOR_ADDING_FIELDS (don't remove) -->";

							text = TextFileManipulator.replaceSection(text, "  // <!-- ", "CODEGENERATOR_NEEDLE_FOR_ADDING_FIELDS", "-->", replacement);

						}

					}

					return text;

				}

			}.execute();

		}


	}

	private static void addTSListAssos(EntityModel entityModel) throws Exception {
		

		for (EntityModel.Relationship relationship : entityModel.relationships) {

//			if (!"many-to-one".equals(relationship.relationshipType)) {
//				continue;
//			}

			new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityModel.modelName + "\\" + entityModel.name + "\\EntityFields.tsx") {

				@Override
				public String processFileText(String text) throws Exception {

					{ // adding import
						String element = "import {EntityPicker as " + firstLetterToUpperCase(relationship.otherEntityName) + "EntityPicker} from \"app/litho-ui/mydata/resources/" + entityModel.modelName + "/" + firstLetterToUpperCase(relationship.otherEntityName) + "/EntityPicker\";";

						if (!text.contains(element)) {
							String replacement = //
									element + "\n" + //
											"// <!-- CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS (don't remove) -->";

							text = TextFileManipulator.replaceSection(text, "// <!--", "CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS", "-->", replacement);
						}

					}

					{ // adding resource
						String element = "<" + firstLetterToUpperCase(relationship.otherEntityName) + "EntityPicker dtoIdPath={'" + relationship.relationshipName + "'}/>";

						if (!text.contains(element)) {

							String replacement = element + "\n" + "        {/*{<!-- CODEGENERATOR_NEEDLE_FOR_ADDING_FIELDS (don't remove) -->}*/}";

							text = TextFileManipulator.replaceSection(text, "{/*{<!--", "CODEGENERATOR_NEEDLE_FOR_ADDING_FIELDS", "-->}*/}", replacement);

						}

					}

					return text;

				}

			}.execute();

		}
	}

	private static String firstLetterToUpperCase(String input) {

		if (input == null) {
			return null;
		}

		if (input.isEmpty()) {
			return input;
		}

		return input.substring(0, 1).toUpperCase() + input.substring(1);

	}

	private static String getInputFieldCode(EntityModel entityModel, FieldModel fieldModel) throws Exception {
		if ("String".contentEquals(fieldModel.fieldType)) {
			return "<TextInput variant=\"outlined\" inputProps={{ autocomplete: 'off' }} source=\"" + fieldModel.fieldName + "\" />";

		} else if ("byte[]".contentEquals(fieldModel.fieldType) && "text".contentEquals(fieldModel.fieldTypeBlobContent)) {
			return "<TextInput variant=\"outlined\" inputProps={{ autocomplete: 'off' }} source=\"" + fieldModel.fieldName + "\" />";

		} else if ("Integer".contentEquals(fieldModel.fieldType)) {
			return "<TextInput variant=\"outlined\" inputProps={{ autocomplete: 'off' }} source=\"" + fieldModel.fieldName + "\" />";

		} else if ("Float".contentEquals(fieldModel.fieldType)) {
			return "<TextInput variant=\"outlined\" inputProps={{ autocomplete: 'off' }} source=\"" + fieldModel.fieldName + "\" />";

		} else if ("Boolean".contentEquals(fieldModel.fieldType)) {
			return "<TextInput variant=\"outlined\" inputProps={{ autocomplete: 'off' }} source=\"" + fieldModel.fieldName + "\" />";

		} else {
			throw new Exception("Error: Field type '" + fieldModel.fieldType + "' not found.");

		}
	}

	private static String getFieldCode(EntityModel entityModel, FieldModel fieldModel) throws Exception {
		if ("String".contentEquals(fieldModel.fieldType)) {
			return "  <TextField label=\"" + fieldModel.fieldName + "\" source=\"" + fieldModel.fieldName + "\" />,";

		} else if ("byte[]".contentEquals(fieldModel.fieldType) && "text".contentEquals(fieldModel.fieldTypeBlobContent)) {
			return "  <TextField label=\"" + fieldModel.fieldName + "\" source=\"" + fieldModel.fieldName + "\" />,";

		} else if ("Integer".contentEquals(fieldModel.fieldType)) {
			return "  <TextField label=\"" + fieldModel.fieldName + "\" source=\"" + fieldModel.fieldName + "\" />,";

		} else if ("Float".contentEquals(fieldModel.fieldType)) {
			return "  <TextField label=\"" + fieldModel.fieldName + "\" source=\"" + fieldModel.fieldName + "\" />,";

		} else if ("Boolean".contentEquals(fieldModel.fieldType)) {
			return "  <TextField label=\"" + fieldModel.fieldName + "\" source=\"" + fieldModel.fieldName + "\" />,";

		} else {
			throw new Exception("Error: Field type '" + fieldModel.fieldType + "' not found.");

		}
	}

}
