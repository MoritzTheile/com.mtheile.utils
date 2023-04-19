package com.mtheile.utils.jhi.codegenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.mtheile.utils.file.textfile.TextFileManipulator;
import com.mtheile.utils.jhi.codegenerator.AbstractTemplateProcessor.MODE;
import com.mtheile.utils.jhi.codegenerator.model.EntityModel;
import com.mtheile.utils.jhi.codegenerator.model.EntityModelService;

public class ChildGenerator {

	private static final String PROJECT_HOME = "C:\\Users\\theil\\git\\com.lithodat.app\\";

	private	static List<EntityModel> getEntityMetaInfos() throws Exception {

		List<EntityModel> entityModels = new ArrayList<>();

//		entityModels.add(EntityModelService.getModelInfosFromJHipster( //
//				new File(PROJECT_HOME + ".jhipster\\"), //
//				"ICPMS", //
//				"ICPMSMetadata", //
//				"LaserMetadata" //
//		));
		entityModels.add(EntityModelService.getModelInfosFromJHipster( //
				new File(PROJECT_HOME + ".jhipster\\"), //
				"ICPMS", //
				"DataPoint", //
				"ICPMSMetadata" //
		));
		
		return entityModels;

	}

	public static void main(String[] args) throws Exception {

		for (EntityModel entityMetaInfo : getEntityMetaInfos()) {

			generateServiceJavaCode(entityMetaInfo);
			generateBatchJavaCode(entityMetaInfo);
			generateJavaScriptCode(entityMetaInfo);
			generateListMenuEntries(entityMetaInfo);
			
			FieldGenerator.generate(entityMetaInfo);
		}
	}

	

	private static void generateListMenuEntries(EntityModel entityMetaInfo) throws Exception {

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

	private static void generateServiceJavaCode(EntityModel entityMetaInfo) throws Exception {

		// --------------- START - JAVA ----------------------------

		new AbstractTemplateProcessor("ChildLithoService.java.template") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\" + entityMetaInfo.modelName.toLowerCase() + "\\" + entityMetaInfo.name + "LithoService.java";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName.toLowerCase());
				result = result.replaceAll("PARENTNAME_TOKEN", entityMetaInfo.parentName);
				return result;
			}

		}.execute(MODE.SKIP_IF_FILE_EXISTS);

		new AbstractTemplateProcessor("CRUDLithoResource.java.template") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\web\\rest\\" + entityMetaInfo.modelName.toLowerCase() + "\\" + entityMetaInfo.name + "LithoResource.java";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName.toLowerCase());
				result = result.replaceAll("PARENTNAME_TOKEN", entityMetaInfo.parentName);
				return result;
			}

		}.execute();
	}

	private static void generateBatchJavaCode(EntityModel entityMetaInfo) throws Exception {

		new AbstractTemplateProcessor("ChildImporter.java.template") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\tableimporter\\" + entityMetaInfo.name + "Importer.java";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName.toLowerCase());
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
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName.toLowerCase());
				result = result.replaceAll("PARENTNAME_TOKEN", entityMetaInfo.parentName);
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

	private static void generateJavaScriptCode(EntityModel entityMetaInfo) throws Exception {

		// --------------- START - JAVASCRIPT ----------------------------
		new AbstractTemplateProcessor("childts/EntityListRenderer.tsx") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityMetaInfo.modelName + "\\" + entityMetaInfo.name + "\\renderer\\EntityListRenderer.tsx";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName);
				return result;
			}

		}.execute();

		new AbstractTemplateProcessor("childts/EntityColumns.tsx") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityMetaInfo.modelName + "\\" + entityMetaInfo.name + "\\EntityColumns.tsx";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName);
				return result;
			}

		}.execute();


		new AbstractTemplateProcessor("childts/EntityFields.tsx") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityMetaInfo.modelName + "\\" + entityMetaInfo.name + "\\EntityFields.tsx";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName);
				return result;
			}

		}.execute();

		new AbstractTemplateProcessor("childts/EntityResource.tsx") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityMetaInfo.modelName + "\\" + entityMetaInfo.name + "\\EntityResource.tsx";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.name);
				result = result.replaceAll("MODELNAME_TOKEN_LOWERCASE", entityMetaInfo.modelName.toLowerCase());
				return result;
			}

		}.execute();


		
		
		new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\mydata.tsx") {

			@Override
			public String processFileText(String text) throws Exception {
				{ // adding import
					String element = "import { " + entityMetaInfo.name + "RAResource } from 'app/litho-ui/mydata/resources/" + entityMetaInfo.modelName + "/" + entityMetaInfo.name + "/EntityResource';";

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

}
