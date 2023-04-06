package com.mtheile.utils.jhi.codegenerator;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mtheile.utils.file.textfile.TextFileManipulator;

public class ListGenerator {

	private static final String PROJECT_HOME = "C:\\Users\\theil\\git\\com.lithodat.app\\";

	public static void main(String[] args) throws Exception {

		final String modelName = "ICPMS";
		//final String entityName = "LAblationCellType";
		final String entityName = "LCombinedMeasurement";
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
										"        // <!-- CODEGENERATOR_NEEDLE_FOR_ADDING_IMPORTS (don't remove) -->\n";

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
