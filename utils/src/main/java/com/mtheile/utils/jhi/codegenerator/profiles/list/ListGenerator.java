package com.mtheile.utils.jhi.codegenerator.profiles.list;

import com.mtheile.utils.file.textfile.TextFileManipulator;
import com.mtheile.utils.jhi.codegenerator.AbstractTemplateProcessor;
import com.mtheile.utils.jhi.codegenerator.AbstractTemplateProcessor.MODE;
import com.mtheile.utils.jhi.codegenerator.AbstractTextFileProcessor;
import com.mtheile.utils.jhi.codegenerator.CodeGenerator;
import com.mtheile.utils.jhi.codegenerator.model.EntityModel;

public class ListGenerator {
	
	private static String PROJECT_HOME = CodeGenerator.PROJECT_HOME;

	public static void generateListJavaCode(EntityModel entityMetaInfo) throws Exception {
	
		// --------------- START - JAVA ----------------------------
	
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
	
				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\web\\rest\\" + entityMetaInfo.modelName.toLowerCase() + "\\" + entityMetaInfo.name + "LithoResource.java";
	
			}
	
			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName.toLowerCase());
				return result;
			}
	
		}.execute();
	
		new AbstractTemplateProcessor("ListImporter.java.template") {
	
			@Override
			public String getTargetFilePath() {
	
				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\tableimporter\\lists\\" + entityMetaInfo.name + "Importer.java";
	
			}
	
			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName.toLowerCase());
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

	public static void generateListJavaScriptCode(EntityModel entityMetaInfo) throws Exception {
	
		// --------------- START - JAVASCRIPT ----------------------------
		new AbstractTemplateProcessor("ts/EntityCreateFields.tsx") {
	
			@Override
			public String getTargetFilePath() {
	
				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\"+entityMetaInfo.modelName+"\\" + entityMetaInfo.name + "\\EntityCreateFields.tsx";
	
			}
	
			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName);
				return result;
			}
	
		}.execute();
		new AbstractTemplateProcessor("ts/EntityCreateForm.tsx") {
	
			@Override
			public String getTargetFilePath() {
	
				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\"+entityMetaInfo.modelName+"\\" + entityMetaInfo.name + "\\EntityCreateForm.tsx";
	
			}
	
			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName.toLowerCase());
				return result;
			}
	
		}.execute();
		new AbstractTemplateProcessor("ts/EntityEdit.tsx") {
	
			@Override
			public String getTargetFilePath() {
	
				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\"+entityMetaInfo.modelName+"\\" + entityMetaInfo.name + "\\EntityEdit.tsx";
	
			}
	
			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName.toLowerCase());
				return result;
			}
	
		}.execute();
		new AbstractTemplateProcessor("ts/EntityList.tsx") {
	
			@Override
			public String getTargetFilePath() {
	
				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\"+entityMetaInfo.modelName+"\\" + entityMetaInfo.name + "\\EntityList.tsx";
	
			}
	
			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName.toLowerCase());
				return result;
			}
	
		}.execute();
		new AbstractTemplateProcessor("ts/EntityPicker.tsx") {
	
			@Override
			public String getTargetFilePath() {
	
				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\"+entityMetaInfo.modelName+"\\" + entityMetaInfo.name + "\\EntityPicker.tsx";
	
			}
	
			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName.toLowerCase());
				return result;
			}
	
		}.execute();
		new AbstractTemplateProcessor("ts/EntityResource.tsx") {
	
			@Override
			public String getTargetFilePath() {
	
				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\"+entityMetaInfo.modelName+"\\" + entityMetaInfo.name + "\\EntityResource.tsx";
	
			}
	
			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName.toLowerCase());
				return result;
			}
	
		}.execute();
	
		new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\mydata.tsx") {
	
			@Override
			public String processFileText(String text) throws Exception {
				{ // adding import
					String element = "import { " + entityMetaInfo.name + "RAResource } from 'app/litho-ui/mydata/resources/"+entityMetaInfo.modelName+"/" + entityMetaInfo.name + "/EntityResource';";
	
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

	public static void generateListMenuEntries(EntityModel entityMetaInfo) throws Exception {
	
		// 01. Create SubMenu file if not exists
	
		new AbstractTemplateProcessor("ts/GetSubMenu.template.tsx") {
	
			@Override
			public String getTargetFilePath() {
	
				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\layout\\submenues\\GetSubMenu" + entityMetaInfo.modelName + ".tsx";
	
			}
	
			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName);
				return result;
			}
	
		}.execute(MODE.SKIP_IF_FILE_EXISTS);
	
		// 02. Add SubMenu Code to main Menu if not already added.
	
		new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\layout\\Menu.tsx") {
	
			@Override
			public String processFileText(String text) throws Exception {
				{ // adding import
					String element = "import { getSubMenu" + entityMetaInfo.modelName + " } from 'app/litho-ui/mydata/layout/submenues/GetSubMenu" + entityMetaInfo.modelName + "';";
	
					if (!text.contains(element)) {
						String replacement = //
								element + "\n" + //
										"// <!-- CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS (don't remove) -->\n";
	
						text = TextFileManipulator.replaceSection(text, "// <!--", "CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS", "-->", replacement);
					}
				}
				{ // adding resource
					String element = "              <SubMenu\r\n" + "                handleToggle={() => handleToggle('" + entityMetaInfo.modelName + "')}\r\n" + "                isOpen={state." + entityMetaInfo.modelName + "}\r\n" + "                sidebarIsOpen={open}\r\n" + "                isNested={true}\r\n" + "                name=\"" + entityMetaInfo.modelName + "\"\r\n" + "                icon={<ChevronRightIcon />}\r\n" + "                dense={dense}\r\n" + "                to={''}\r\n" + "              >\r\n" + "                {getSubMenu" + entityMetaInfo.modelName + "(onMenuClick, open, dense)}\r\n" + "              </SubMenu>\r\n" + "";
	
					if (!text.contains("isOpen={state." + entityMetaInfo.modelName + "}")) {
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
	
		new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\layout\\submenues\\GetSubMenu" + entityMetaInfo.modelName + ".tsx") {
	
			@Override
			public String processFileText(String text) throws Exception {
				{ // adding import
					String element = "import { getSubMenu" + entityMetaInfo.modelName + " } from 'app/litho-ui/mydata/layout/submenues/GetSubMenu" + entityMetaInfo.modelName + "';";
	
					if (!text.contains("import { getSubMenu" + entityMetaInfo.modelName + " }")) {
						String replacement = //
								element + "\n" + //
										"// <!-- CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS (don't remove) -->\n";
	
						text = TextFileManipulator.replaceSection(text, "// <!--", "CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS", "-->", replacement);
					}
				}
				{ // adding resource
					String element = "" + "<MenuItemLink\r\n" + "        to={'/" + entityMetaInfo.modelName.toLowerCase() + "/" + entityMetaInfo.name + "'}\r\n" + "        primaryText={`" + entityMetaInfo.name + "`}\r\n" + "        leftIcon={<TocIcon />}\r\n" + "        onClick={onMenuClick}\r\n" + "        sidebarIsOpen={open}\r\n" + "        dense={dense}\r\n" + "      />";
	
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

}
