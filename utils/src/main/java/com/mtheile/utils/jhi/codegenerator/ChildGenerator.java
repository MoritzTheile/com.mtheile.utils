package com.mtheile.utils.jhi.codegenerator;

import java.util.ArrayList;
import java.util.List;

import com.mtheile.utils.file.textfile.TextFileManipulator;
import com.mtheile.utils.jhi.codegenerator.AbstractTemplateProcessor.MODE;

public class ChildGenerator {

	private static final String PROJECT_HOME = "C:\\Users\\theil\\git\\com.lithodat.app\\";

	private static List<EntityMetaInfo> getEntityMetaInfos() {

		List<EntityMetaInfo> entityMetaInfos = new ArrayList<>();

		entityMetaInfos.add(new EntityMetaInfo("ICPMS", "LaserMetadata", "ICPMSMetadata"));

		return entityMetaInfos;

	}

	public static void main(String[] args) throws Exception {

		for (EntityMetaInfo entityMetaInfo : getEntityMetaInfos()) {

			generateServiceJavaCode(entityMetaInfo);
			generateBatchJavaCode(entityMetaInfo);
			generateJavaScriptCode(entityMetaInfo);
			generateListMenuEntries(entityMetaInfo);

		}
	}

	static class EntityMetaInfo {
		public final String modelName;
		public final String entityName;
		public final String parentName;

		public EntityMetaInfo(String modelName, String entityName, String parentName) {
			this.modelName = modelName;
			this.entityName = entityName;
			this.parentName = parentName;
		}

	}

	private static void generateListMenuEntries(EntityMetaInfo entityMetaInfo) throws Exception {

		// 01. Create SubMenu file if not exists

		new AbstractTemplateProcessor("ts/GetSubMenu.template.tsx") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\layout\\submenues\\GetSubMenu" + entityMetaInfo.modelName + ".tsx";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.entityName);
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
					String element = "" + "<MenuItemLink\r\n" + "        to={'/" + entityMetaInfo.modelName.toLowerCase() + "/" + entityMetaInfo.entityName + "'}\r\n" + "        primaryText={`" + entityMetaInfo.entityName + "`}\r\n" + "        leftIcon={<TocIcon />}\r\n" + "        onClick={onMenuClick}\r\n" + "        sidebarIsOpen={open}\r\n" + "        dense={dense}\r\n" + "      />";

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

	private static void generateServiceJavaCode(EntityMetaInfo entityMetaInfo) throws Exception {

		// --------------- START - JAVA ----------------------------

		new AbstractTemplateProcessor("ChildLithoService.java.template") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\" + entityMetaInfo.modelName.toLowerCase() + "\\" + entityMetaInfo.entityName + "LithoService.java";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.entityName);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName.toLowerCase());
				result = result.replaceAll("PARENTNAME_TOKEN", entityMetaInfo.parentName);
				return result;
			}

		}.execute(MODE.SKIP_IF_FILE_EXISTS);

		new AbstractTemplateProcessor("CRUDLithoResource.java.template") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\web\\rest\\" + entityMetaInfo.modelName.toLowerCase() + "\\" + entityMetaInfo.entityName + "LithoResource.java";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.entityName);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName.toLowerCase());
				result = result.replaceAll("PARENTNAME_TOKEN", entityMetaInfo.parentName);
				return result;
			}

		}.execute();
	}

	private static void generateBatchJavaCode(EntityMetaInfo entityMetaInfo) throws Exception {

		new AbstractTemplateProcessor("ChildImporter.java.template") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\tableimporter\\" + entityMetaInfo.entityName + "Importer.java";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.entityName);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName.toLowerCase());
				return result;
			}

		}.execute();
		
		new AbstractTemplateProcessor("BatchAdapter.java.template") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\adapters\\" + entityMetaInfo.entityName + "BatchAdapter.java";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.entityName);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName.toLowerCase());
				return result;
			}

		}.execute();


		new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\dto\\BatchTableDTO.java") {

			@Override
			public String processFileText(String text) throws Exception {

				{ // adding resource
					String element = ", " + entityMetaInfo.entityName;

					if (!text.contains(element)) {

						String replacement = element + "\n" + "        // <!-- CODEGENERATOR_NEEDLE_FOR_ADDING_TABLES (don't remove) -->\n";

						text = TextFileManipulator.replaceSection(text, "// <!--", "CODEGENERATOR_NEEDLE_FOR_ADDING_TABLES", "-->", replacement);

					}
					
				}
				
				return text;
			}
		}.execute();
	}

	private static void generateJavaScriptCode(EntityMetaInfo entityMetaInfo) throws Exception {

		// --------------- START - JAVASCRIPT ----------------------------
		new AbstractTemplateProcessor("childts/EntityListRenderer.tsx") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityMetaInfo.modelName + "\\" + entityMetaInfo.entityName + "\\renderer\\EntityListRenderer.tsx";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.entityName);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName);
				return result;
			}

		}.execute();

		new AbstractTemplateProcessor("childts/EntityColumns.tsx") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityMetaInfo.modelName + "\\" + entityMetaInfo.entityName + "\\EntityColumns.tsx";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.entityName);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName);
				return result;
			}

		}.execute();


		new AbstractTemplateProcessor("childts/EntityFields.tsx") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityMetaInfo.modelName + "\\" + entityMetaInfo.entityName + "\\EntityFields.tsx";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.entityName);
				result = result.replaceAll("MODELNAME_TOKEN", entityMetaInfo.modelName);
				return result;
			}

		}.execute();

		new AbstractTemplateProcessor("childts/EntityResource.tsx") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityMetaInfo.modelName + "\\" + entityMetaInfo.entityName + "\\EntityResource.tsx";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityMetaInfo.entityName);
				result = result.replaceAll("MODELNAME_TOKEN_LOWERCASE", entityMetaInfo.modelName.toLowerCase());
				return result;
			}

		}.execute();


		
		
		new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\mydata.tsx") {

			@Override
			public String processFileText(String text) throws Exception {
				{ // adding import
					String element = "import { " + entityMetaInfo.entityName + "RAResource } from 'app/litho-ui/mydata/resources/" + entityMetaInfo.modelName + "/" + entityMetaInfo.entityName + "/EntityResource';";

					if (!text.contains(element)) {
						String replacement = //
								element + "\n" + //
										"// <!-- CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS (don't remove) -->\n";

						text = TextFileManipulator.replaceSection(text, "// <!--", "CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS", "-->", replacement);
					}
				}
				{ // adding resource
					String element = "{" + entityMetaInfo.entityName + "RAResource}";

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
