package com.mtheile.utils.jhi.codegenerator;

import com.mtheile.utils.file.textfile.TextFileManipulator;
import com.mtheile.utils.jhi.codegenerator.AbstractTemplateProcessor.MODE;

public class CodeGenerator {

	private static final String PROJECT_HOME = "C:\\Users\\theil\\git\\com.lithodat.app\\";
	private static final String modelName = "ICPMS";
	//private static final String entityName = "LAblationCellType";
	//private static final String entityName = "LCombinedMeasurement";
	private static final String entityName = "LSampleIntroMethod";
	
	public static void main(String[] args) throws Exception {
		
//		generateListJavaCode();
//		generateListJavaScriptCode();
		generateListMenuEntries();
	}
	
	private static void generateListMenuEntries() throws Exception{
		
		// 01. Create SubMenu file if not exists
		
		new AbstractTemplateProcessor("ts/GetSubMenu.template.tsx") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\layout\\submenues\\GetSubMenu"+modelName+".tsx";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityName);
				result = result.replaceAll("MODELNAME_TOKEN", modelName);
				return result;
			}

		}.execute(MODE.SKIP_IF_FILE_EXISTS);
		
		// 02. Add SubMenu Code to main Menu if not already added.
		
		new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\layout\\Menu.tsx") {

			@Override
			public String processFileText(String text) throws Exception {
				{ // adding import
					String element = "import { getSubMenu"+modelName+" } from 'app/litho-ui/mydata/layout/submenues/GetSubMenu"+modelName+"';";

					if (!text.contains(element)) {
						String replacement = //
								element + "\n" + //
										"// <!-- CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS (don't remove) -->\n";

						text = TextFileManipulator.replaceSection(text, "// <!--", "CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS", "-->", replacement);
					}
				}
				{ // adding resource
					String element = "              <SubMenu\r\n"
							+ "                handleToggle={() => handleToggle("+modelName+"')}\r\n"
							+ "                isOpen={state."+modelName+"}\r\n"
							+ "                sidebarIsOpen={open}\r\n"
							+ "                isNested={true}\r\n"
							+ "                name=\""+modelName+"\"\r\n"
							+ "                icon={<ChevronRightIcon />}\r\n"
							+ "                dense={dense}\r\n"
							+ "                to={''}\r\n"
							+ "              >\r\n"
							+ "                {getSubMenu"+modelName+"(onMenuClick, open, dense)}\r\n"
							+ "              </SubMenu>\r\n"
							+ "";

					if (!text.contains(element)) {
						String replacement = //
								element + "\n" + //
										"        {/*<!-- CODEGENERATOR_NEEDLE_FOR_ADDING_MENU_ENTRIES (don't remove) -->*/}\n";

						text = TextFileManipulator.replaceSection(text, "{/*", "CODEGENERATOR_NEEDLE_FOR_ADDING_RESOURCES", "*/}", replacement);
					}
				}
				return text;
			}
		}.execute();
		
		// 03. Fill SubMenu file;
	}

	private static void generateListJavaCode() throws Exception{
		
		// --------------- START - JAVA ----------------------------

		new AbstractTemplateProcessor("ListLithoService.java.template") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\icpms\\" + entityName + "LithoService.java";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityName);
				return result;
			}

		}.execute();

		new AbstractTemplateProcessor("ListLithoResource.java.template") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\web\\rest\\"+modelName.toLowerCase()+"\\" + entityName + "LithoResource.java";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityName);
				result = result.replaceAll("MODELNAME_TOKEN", modelName.toLowerCase()); 
				return result;
			}

		}.execute();

		new AbstractTemplateProcessor("Importer.java.template") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\tableimporter\\lists\\" + entityName + "Importer.java";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityName);
				result = result.replaceAll("MODELNAME_TOKEN", modelName.toLowerCase());
				return result;
			}

		}.execute();
		
		new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\dto\\BatchTableDTO.java") {

			@Override
			public String processFileText(String text) throws Exception {
				
				{ // adding resource
					String element = ", " + entityName ;
					
					if (!text.contains(element)) {
						
						String replacement = element + "\n" + "        // <!-- CODEGENERATOR_NEEDLE_FOR_ADDING_TABLES (don't remove) -->\n";

						text = TextFileManipulator.replaceSection(text, "// <!--", "CODEGENERATOR_NEEDLE_FOR_ADDING_TABLES", "-->", replacement);
						
					}
				}
				return text;
			}
		}.execute();
	}
	private static void generateListJavaScriptCode() throws Exception{

		// --------------- START - JAVASCRIPT ----------------------------
		new AbstractTemplateProcessor("ts/EntityCreateFields.tsx") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityName + "\\EntityCreateFields.tsx";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityName);
				result = result.replaceAll("MODELNAME_TOKEN", modelName.toLowerCase());
				return result;
			}

		}.execute();
		new AbstractTemplateProcessor("ts/EntityCreateForm.tsx") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityName + "\\EntityCreateForm.tsx";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityName);
				result = result.replaceAll("MODELNAME_TOKEN", modelName.toLowerCase());
				return result;
			}

		}.execute();
		new AbstractTemplateProcessor("ts/EntityEdit.tsx") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityName + "\\EntityEdit.tsx";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityName);
				result = result.replaceAll("MODELNAME_TOKEN", modelName.toLowerCase());
				return result;
			}

		}.execute();
		new AbstractTemplateProcessor("ts/EntityList.tsx") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityName + "\\EntityList.tsx";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityName);
				result = result.replaceAll("MODELNAME_TOKEN", modelName.toLowerCase());
				return result;
			}

		}.execute();
		new AbstractTemplateProcessor("ts/EntityPicker.tsx") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityName + "\\EntityPicker.tsx";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityName);
				result = result.replaceAll("MODELNAME_TOKEN", modelName.toLowerCase());
				return result;
			}

		}.execute();
		new AbstractTemplateProcessor("ts/EntityResource.tsx") {

			@Override
			public String getTargetFilePath() {

				return PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\resources\\" + entityName + "\\EntityResource.tsx";

			}

			@Override
			public String processTemplate(String template) {
				String result = template.replaceAll("ENTITYNAME_TOKEN", entityName);
				result = result.replaceAll("MODELNAME_TOKEN", modelName.toLowerCase());
				return result;
			}

		}.execute();

		new AbstractTextFileProcessor(PROJECT_HOME + "src\\main\\webapp\\app\\litho-ui\\mydata\\mydata.tsx") {

			@Override
			public String processFileText(String text) throws Exception {
				{ // adding import
					String element = "import { " + entityName + "RAResource } from 'app/litho-ui/mydata/resources/" + entityName + "/EntityResource';";

					if (!text.contains(element)) {
						String replacement = //
								element + "\n" + //
										"// <!-- CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS (don't remove) -->\n";

						text = TextFileManipulator.replaceSection(text, "// <!--", "CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS", "-->", replacement);
					}
				}
				{ // adding resource
					String element = "{" + entityName + "RAResource}";

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
