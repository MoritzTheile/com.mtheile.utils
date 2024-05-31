package com.mtheile.utils.jhi.codegenerator.profiles.client;

import com.mtheile.utils.file.textfile.TextFileManipulator;
import com.mtheile.utils.jhi.codegenerator.AbstractTemplateProcessor;
import com.mtheile.utils.jhi.codegenerator.AbstractTemplateProcessor.MODE;
import com.mtheile.utils.jhi.codegenerator.AbstractTextFileProcessor;
import com.mtheile.utils.jhi.codegenerator.CodeGenerator;
import com.mtheile.utils.jhi.codegenerator.model.EntityModel;
import com.mtheile.utils.jhi.codegenerator.model.EntityModel.FieldModel;

public class ClientCodeGenerator {

	private static String PROJECT_HOME = CodeGenerator.PROJECT_HOME;

	public static void generate(EntityModel entityMetaInfo) throws Exception {
		/**
		 * "EntityListRenderer.tsx" 
		 * "EntityColumns.tsx"
		 * "EntityFields.tsx" 
		 * "EntityResource.tsx"
		 */
		ClientCodeGenerator.generateCRUDCode(entityMetaInfo, MODE.SKIP_IF_FILE_EXISTS);

		/**
		 * no templates used
		 */
		ClientCodeGenerator.addSimpleFields(entityMetaInfo);

		/**
		 * no templates used
		 */
		ClientCodeGenerator.addReferenceFields(entityMetaInfo);

		/**
		 * no templates used
		 */
		 ClientCodeGenerator.addSimpleColumns(entityMetaInfo);
		ClientCodeGenerator.addReferenceColumns(entityMetaInfo);

		/**
		 * "ts/GetSubMenu.template.tsx"
		 */
		ClientCodeGenerator.generateListMenuEntry(entityMetaInfo);
	}

	/**
	 * "EntityListRenderer.tsx" 
	 * "EntityColumns.tsx"
	 * "EntityFields.tsx" 
	 * "EntityResource.tsx"
	 */
	private static void generateCRUDCode(EntityModel entityMetaInfo, MODE mode) throws Exception {

		CodeGenerator.template2Code( //
				entityMetaInfo.getLithoParent(), //
				entityMetaInfo.getLithoModule(), //
				entityMetaInfo.name, //
				CodeGenerator.PROFILES_HOME+"client/templates/EntityListRenderer.tsx", //
				PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityMetaInfo.getLithoModule() + "\\" + entityMetaInfo.name + "\\renderer\\EntityListRenderer.tsx",//
				mode
		);
		
		CodeGenerator.template2Code( //
				entityMetaInfo.getLithoParent(), //
				entityMetaInfo.getLithoModule(), //
				entityMetaInfo.name, //
				CodeGenerator.PROFILES_HOME+"client/templates/EntityColumns.tsx", //
				getPathToEntityColumns_tsx(entityMetaInfo),//
				mode
		);
		

		CodeGenerator.template2Code( //
				entityMetaInfo.getLithoParent(), //
				entityMetaInfo.getLithoModule(), //
				entityMetaInfo.name, //
				CodeGenerator.PROFILES_HOME+"client/templates/EntityFields.tsx", //
				getPathToEntityField_tsx(entityMetaInfo),//
				mode
				
		);
		

		CodeGenerator.template2Code( //
				entityMetaInfo.getLithoParent(), //
				entityMetaInfo.getLithoModule(), //
				entityMetaInfo.name, //
				CodeGenerator.PROFILES_HOME+"client/templates/EntityResource.tsx", //
				PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityMetaInfo.getLithoModule() + "\\" + entityMetaInfo.name + "\\EntityResource.tsx",//
				mode
		);
		
		new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\mydata.tsx") {

			@Override
			public String processFileText(String text) throws Exception {
				{ // adding import
					String element = "import { " + entityMetaInfo.name + "RAResource } from 'app/litho-ui/mydata/resources/" + entityMetaInfo.getLithoModule() + "/" + entityMetaInfo.name + "/EntityResource';";

					if (!text.contains(element)) {
						String replacement = //
								element + "\n" + //
										"// <!-- CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS (don't remove) -->\n";

						text = TextFileManipulator.replaceSection(text, "// <!--", "CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS", "-->", replacement);
					}
				}
				{ // adding resource
					String element = "{" + entityMetaInfo.name + "RAResource}";

					if (!text.contains(element)) {
						String replacement = //
								element + "\n" + //
										"        {/*<!-- CODEGENERATOR_NEEDLE_FOR_ADDING_RESOURCES (don't remove) -->*/}\n";

						text = TextFileManipulator.replaceSection(text, "{/*", "CODEGENERATOR_NEEDLE_FOR_ADDING_RESOURCES", "*/}", replacement);
					}
				}
				return text;
			}
		}.execute();

	}
	
	private static String getPathToEntityColumns_tsx(EntityModel entityMetaInfo) {
		return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityMetaInfo.getLithoModule() + "\\" + entityMetaInfo.name + "\\EntityColumns.tsx";
	}

	/**
	 * "ts/GetSubMenu.template.tsx"
	 */
	private static void generateListMenuEntry(EntityModel entityMetaInfo) throws Exception {

		// 01. Create SubMenu file if not exists

		new AbstractTemplateProcessor(CodeGenerator.PROFILES_HOME+"client/templates/GetSubMenu.template.tsx") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\layout\\submenues\\GetSubMenu" + entityMetaInfo.getLithoModule() + ".tsx";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODULNAME_TOKEN", entityMetaInfo.getLithoModule());
				result = result.replaceAll("MODULNAME_LOWERCASE_TOKEN", entityMetaInfo.getLithoModule().toLowerCase());
				
				return result;
			}

		}.execute(MODE.SKIP_IF_FILE_EXISTS);

		// 02. Add SubMenu Code to main Menu if not already added.

		new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\layout\\Menu.tsx") {

			@Override
			public String processFileText(String text) throws Exception {
				{ // adding import
					String element = "import { getSubMenu" + entityMetaInfo.getLithoModule() + " } from 'app/litho-ui/mydata/layout/submenues/GetSubMenu" + entityMetaInfo.getLithoModule() + "';";

					if (!text.contains(element)) {
						String replacement = //
								element + "\n" + //
										"// <!-- CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS (don't remove) -->\n";

						text = TextFileManipulator.replaceSection(text, "// <!--", "CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS", "-->", replacement);
					}
				}
				{ // adding resource
					String element = "              <SubMenu\r\n" + "                handleToggle={() => handleToggle('" + entityMetaInfo.getLithoModule() + "')}\r\n" + "                isOpen={state." + entityMetaInfo.getLithoModule() + "}\r\n" + "                sidebarIsOpen={open}\r\n" + "                isNested={true}\r\n" + "                name=\"" + entityMetaInfo.getLithoModule() + "\"\r\n" + "                icon={<ChevronRightIcon />}\r\n" + "                dense={dense}\r\n" + "                to={''}\r\n" + "              >\r\n" + "                {getSubMenu" + entityMetaInfo.getLithoModule() + "(onMenuClick, open, dense)}\r\n" + "              </SubMenu>\r\n" + "";

					if (!text.contains("isOpen={state." + entityMetaInfo.getLithoModule() + "}")) {
						String replacement = //
								element + "\n" + //
										"        {/*<!-- CODEGENERATOR_NEEDLE_FOR_ADDING_MENU_ENTRIES (don't remove) -->*/}\n";

						text = TextFileManipulator.replaceSection(text, "{/*", "CODEGENERATOR_NEEDLE_FOR_ADDING_MENU_ENTRIES", "*/}", replacement);
					}
				}
				return text;
			}
		}.execute();

		// 03. Fill SubMenu file;

		new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\layout\\submenues\\GetSubMenu" + entityMetaInfo.getLithoModule() + ".tsx") {

			@Override
			public String processFileText(String text) throws Exception {
				{ // adding import
					String element = "import { getSubMenu" + entityMetaInfo.getLithoModule() + " } from 'app/litho-ui/mydata/layout/submenues/GetSubMenu" + entityMetaInfo.getLithoModule() + "';";

					if (!text.contains("import { getSubMenu" + entityMetaInfo.getLithoModule() + " }")) {
						String replacement = //
								element + "\n" + //
										"// <!-- CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS (don't remove) -->\n";

						text = TextFileManipulator.replaceSection(text, "// <!--", "CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS", "-->", replacement);
					}
				}
				{ // adding resource
					String element = "" + "<MenuItemLink\r\n" + "        to={'/" + entityMetaInfo.getLithoModule().toLowerCase() + "/" + entityMetaInfo.name + "'}\r\n" + "        primaryText={`" + entityMetaInfo.name + "`}\r\n" + "        leftIcon={<TocIcon />}\r\n" + "        onClick={onMenuClick}\r\n" + "        sidebarIsOpen={open}\r\n" + "        dense={dense}\r\n" + "      />";

					if (!text.contains(element)) {
						String replacement = //
								element + "\n" + //
										"        {/*<!-- CODEGENERATOR_NEEDLE_FOR_ADDING_MENU_ENTRIES (don't remove) -->*/}\n";

						text = TextFileManipulator.replaceSection(text, "{/*", "CODEGENERATOR_NEEDLE_FOR_ADDING_MENU_ENTRIES", "*/}", replacement);
					}
				}
				return text;
			}
		}.execute();
	}

	/**
	 * no templates used
	 */
	private static void addSimpleFields(EntityModel entityModel) throws Exception {

		for (EntityModel.FieldModel fieldModel : entityModel.fields) {

			new AbstractTextFileProcessor(getPathToEntityField_tsx(entityModel)) {

				@Override
				public String processFileText(String text) throws Exception {

					{ // adding resource
						String element = getInputFieldCode(entityModel, fieldModel);

						if (!text.contains("\""+fieldModel.fieldName+"\"")) {

							String replacement = element + "\n" + "			{/*{<!-- CODEGENERATOR_NEEDLE_FOR_ADDING_FIELDS (don't remove) -->}*/}";

							text = TextFileManipulator.replaceSection(text, "{/*{<!--", "CODEGENERATOR_NEEDLE_FOR_ADDING_FIELDS", "-->}*/}", replacement);

						}

					}

					return text;

				}

			}.execute();

		}
	}
	
	private static void addSimpleColumns(EntityModel entityModel) throws Exception {

		for (EntityModel.FieldModel fieldModel : entityModel.fields) {

			new AbstractTextFileProcessor(getPathToEntityColumns_tsx(entityModel)) {

				@Override
				public String processFileText(String text) throws Exception {

					{ // adding resource
						String element = getFieldCode(entityModel, fieldModel.fieldName, fieldModel.getLithoLabel());

						if (!text.contains("\""+fieldModel.fieldName+"\"")) {

							String replacement = element + "\n" + "  // <!-- CODEGENERATOR_NEEDLE_FOR_ADDING_FIELDS (don't remove) -->";

							text = TextFileManipulator.replaceSection(text, "  // <!-- ", "CODEGENERATOR_NEEDLE_FOR_ADDING_FIELDS", "-->", replacement);

						}

					}

					return text;

				}

			}.execute();

		}

	}
	/**
	 * no templates used
	 */
	private static void addReferenceColumns(EntityModel entityModel) throws Exception {

		for (EntityModel.Relationship relationship : entityModel.relationships) {
			
			new AbstractTextFileProcessor(getPathToEntityColumns_tsx(entityModel)) {

				@Override
				public String processFileText(String text) throws Exception {

					{ // adding resource
						String element = getFieldCode(entityModel, relationship.otherEntityName, relationship.getLithoLabel());

						if (!text.contains("\""+relationship.otherEntityName+"\"")) {

							String replacement = element + "\n" + "  // <!-- CODEGENERATOR_NEEDLE_FOR_ADDING_FIELDS (don't remove) -->";

							text = TextFileManipulator.replaceSection(text, "  // <!-- ", "CODEGENERATOR_NEEDLE_FOR_ADDING_FIELDS", "-->", replacement);

						}

					}

					return text;

				}

			}.execute();
		}
	}
	/**
	 * no templates used
	 */
	private static void addReferenceFields(EntityModel entityModel) throws Exception {

		for (EntityModel.Relationship relationship : entityModel.relationships) {

			// if (!"many-to-one".equals(relationship.relationshipType)) {
			// continue;
			// }

			new AbstractTextFileProcessor(getPathToEntityField_tsx(entityModel)) {

				@Override
				public String processFileText(String text) throws Exception {

					{ // adding import

						String element = "import { EntityPicker" + firstLetterToUpperCase(relationship.otherEntityName) + " } from 'app/litho-ui/mydata/resources/" + entityModel.getLithoModule() + "/" + firstLetterToUpperCase(relationship.otherEntityName) + "/EntityResource';";

						if (!text.contains(element)) {
							String replacement = //
									element + "\n" + //
											"// <!-- CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS (don't remove) -->";

							text = TextFileManipulator.replaceSection(text, "// <!--", "CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS", "-->", replacement);
						}

					}

					{ // adding resource

						String element = "<EntityPicker" + firstLetterToUpperCase(relationship.otherEntityName) + " source={'" + relationship.relationshipName + "Id'}  label={'"+relationship.getLithoLabel()+"'}  description={'"+relationship.getLithoDocumentation()+"'}/>";

						if (!text.contains("'"+relationship.relationshipName+"Id'")) {

							String replacement = element + "\n" + "        {/*{<!-- CODEGENERATOR_NEEDLE_FOR_ADDING_FIELDS (don't remove) -->}*/}";

							text = TextFileManipulator.replaceSection(text, "{/*{<!--", "CODEGENERATOR_NEEDLE_FOR_ADDING_FIELDS", "-->}*/}", replacement);

						}

					}

					return text;

				}

			}.execute();

		}
	}

	private static String getPathToEntityField_tsx(EntityModel entityModel) {
		return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityModel.getLithoModule() + "\\" + entityModel.name + "\\EntityFields.tsx";
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

	private static String getFieldCode(EntityModel entityModel, String fieldName, String fieldLabel) throws Exception {
		if(fieldLabel== null || fieldLabel.isEmpty()) {
			fieldLabel = fieldName;
		}
		
			return "  <TextField label=\"" + fieldLabel + "\" source=\"" + fieldName + "\" />,";
	}

	private static String getInputFieldCode(EntityModel entityModel, FieldModel fieldModel) throws Exception {
		
		String fieldLabel = fieldModel.getLithoLabel();
		
		if(fieldLabel== null || fieldLabel.isEmpty()) {
			fieldLabel = fieldModel.fieldName;
		}
		
		String labelAttrib = createLabelAttrib(fieldLabel);
		
		if ("String".contentEquals(fieldModel.fieldType)) {

			return "<LithoTextInput  source=\"" + fieldModel.fieldName + "\" "+labelAttrib+" helpText={'"+fieldModel.getLithoDocumentation()+"'} />";

		} else if ("Integer".contentEquals(fieldModel.fieldType)) {

			return "<LithoTextInput  source=\"" + fieldModel.fieldName + "\" "+labelAttrib+" helpText={'"+fieldModel.getLithoDocumentation()+"'} />";

		} else if ("Float".contentEquals(fieldModel.fieldType)) {

			return "<LithoTextInput  source=\"" + fieldModel.fieldName + "\" "+labelAttrib+" helpText={'"+fieldModel.getLithoDocumentation()+"'} />";

		} else if ("Boolean".contentEquals(fieldModel.fieldType)) {

			return "<LithoBooleanInput  source=\"" + fieldModel.fieldName + "\" "+labelAttrib+" helpText={'"+fieldModel.getLithoDocumentation()+"'} />";

		} else if (fieldModel.fieldTypeBlobContent!=null && "text".contentEquals(fieldModel.fieldTypeBlobContent) ) {

			return "<LithoTextMultilineInput source=\"" + fieldModel.fieldName + "\" "+labelAttrib+" helpText={'"+fieldModel.getLithoDocumentation()+"'} />";

		} else {
			System.out.println("Warning: Field type '" + fieldModel.fieldType + "' not found.");
			return "<div>"+fieldModel.fieldType+" not generated (codemarker=qe7r6gqaerg)</div>";
		}
	}

	private static String createLabelAttrib(String lithoLabel) {
		if(lithoLabel==null || lithoLabel.trim().isEmpty()) {
			return "";
		}
		return "label={'"+lithoLabel+"'}";
	}

}
