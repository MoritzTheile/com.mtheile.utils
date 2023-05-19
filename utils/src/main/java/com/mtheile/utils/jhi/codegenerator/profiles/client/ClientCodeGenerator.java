package com.mtheile.utils.jhi.codegenerator.profiles.client;

import com.mtheile.utils.file.textfile.TextFileManipulator;
import com.mtheile.utils.jhi.codegenerator.AbstractTemplateProcessor;
import com.mtheile.utils.jhi.codegenerator.AbstractTemplateProcessor.MODE;
import com.mtheile.utils.jhi.codegenerator.AbstractTextFileProcessor;
import com.mtheile.utils.jhi.codegenerator.CodeGenerator;
import com.mtheile.utils.jhi.codegenerator.model.EntityModel;
import com.mtheile.utils.jhi.codegenerator.model.EntityModel.FieldModel;
import com.mtheile.utils.jhi.codegenerator.utils.batcheditor.BatchEditorUtils;

public class ClientCodeGenerator {
	
	private static String PROJECT_HOME = CodeGenerator.PROJECT_HOME;



	public static void generateCRUDCode(EntityModel entityMetaInfo) throws Exception {
	
		new AbstractTemplateProcessor("childts/EntityListRenderer.tsx") {
	
			@Override
			public String getTargetFilePath() {
	
				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityMetaInfo.getLithoModule() + "\\" + entityMetaInfo.name + "\\renderer\\EntityListRenderer.tsx";
	
			}
	
			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.getLithoModule());
				return result;
			}
	
		}.execute();
	
		new AbstractTemplateProcessor("childts/EntityColumns.tsx") {
	
			@Override
			public String getTargetFilePath() {
	
				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityMetaInfo.getLithoModule() + "\\" + entityMetaInfo.name + "\\EntityColumns.tsx";
	
			}
	
			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.getLithoModule());
				return result;
			}
	
		}.execute();
	
	
		new AbstractTemplateProcessor("childts/EntityFields.tsx") {
	
			@Override
			public String getTargetFilePath() {
	
				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityMetaInfo.getLithoModule() + "\\" + entityMetaInfo.name + "\\EntityFields.tsx";
	
			}
	
			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.getLithoModule());
				return result;
			}
	
		}.execute();
	
		new AbstractTemplateProcessor("childts/EntityResource.tsx") {
	
			@Override
			public String getTargetFilePath() {
	
				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityMetaInfo.getLithoModule() + "\\" + entityMetaInfo.name + "\\EntityResource.tsx";
	
			}
	
			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN_LOWERCASE", entityMetaInfo.getLithoModule().toLowerCase());
				return result;
			}
	
		}.execute();
	
	
		
		
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

	public static void generateListMenuEntry(EntityModel entityMetaInfo) throws Exception {
	
		// 01. Create SubMenu file if not exists
	
		new AbstractTemplateProcessor("ts/GetSubMenu.template.tsx") {
	
			@Override
			public String getTargetFilePath() {
	
				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\layout\\submenues\\GetSubMenu" + entityMetaInfo.getLithoModule() + ".tsx";
	
			}
	
			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.getLithoModule());
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
	
			new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityModel.getLithoModule() + "\\" + entityModel.name + "\\EntityFields.tsx") {
	
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
	
			new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityModel.getLithoModule() + "\\" + entityModel.name + "\\EntityColumns.tsx") {
	
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
	
				new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityModel.getLithoModule() + "\\" + entityModel.name + "\\EntityFields.tsx") {
	
					@Override
					public String processFileText(String text) throws Exception {
	
						{ // adding import
							//String element = "import {EntityPicker as " + firstLetterToUpperCase(relationship.otherEntityName) + "EntityPicker} from \"app/litho-ui/mydata/resources/" + entityModel.getLithoModule() + "/" + firstLetterToUpperCase(relationship.otherEntityName) + "/EntityPicker\";";
							String element = "import { EntityPickerPlus"+ firstLetterToUpperCase(relationship.otherEntityName) + " } from 'app/litho-ui/mydata/resources/"+ entityModel.getLithoModule() +"/"+ firstLetterToUpperCase(relationship.otherEntityName) +"/EntityResource';";
	
							if (!text.contains(element)) {
								String replacement = //
										element + "\n" + //
												"// <!-- CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS (don't remove) -->";
	
								text = TextFileManipulator.replaceSection(text, "// <!--", "CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS", "-->", replacement);
							}
	
						}
	
						{ // adding resource
							// String element = "<" + firstLetterToUpperCase(relationship.otherEntityName) + "EntityPicker dtoIdPath={'" + relationship.relationshipName + "'}/>";
							String element = "<EntityPickerPlus" + firstLetterToUpperCase(relationship.otherEntityName) + " dtoIdPath={'" + relationship.relationshipName + "Id'}/>";
	
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

	public static void generateFields(EntityModel entityModel) throws Exception {
		addBatchEditorFields(entityModel);
		addTSEntityFields(entityModel);
		addTSListAssos(entityModel);
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

}
