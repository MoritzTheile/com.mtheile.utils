package com.mtheile.utils.jhi.codegenerator;

public class ListGenerator {

	private static final String PROJECT_HOME = "C:\\Users\\theil\\git\\com.lithodat.app\\";

	public static void main(String[] args) throws Exception {

		final String modelName = "ICPMS";
		final String entityName = "LAblationCellType";
		// --------------- START - JAVA ----------------------------

//		new AbstractTemplateProcessor("LAblationCellType", "ListLithoService.java.template") {
//
//			@Override
//			public String getTargetFilePath(String entityName) {
//
//				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\icpms\\" + entityName + "LithoService.java";
//
//			}
//
//			@Override
//			public String processTemplate(String template) {
//				String result = template.replaceAll("ENTITYNAME_TOKEN", this.entityName);
//				return result;
//			}
//
//		}.execute();

//		new AbstractTemplateProcessor("ListLithoResource.java.template") {
//
//			@Override
//			public String getTargetFilePath() {
//
//				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\web\\rest\\"+modelName.toLowerCase()+"\\" + entityName + "LithoResource.java";
//
//			}
//
//			@Override
//			public String processTemplate(String template) {
//				String result = template.replaceAll("ENTITYNAME_TOKEN", entityName);
//				result = result.replaceAll("MODELNAME_TOKEN", modelName.toLowerCase()); 
//				return result;
//			}
//
//		}.execute();
//
//		new AbstractTemplateProcessor("Importer.java.template") {
//
//			@Override
//			public String getTargetFilePath() {
//
//				return PROJECT_HOME + "src\\main\\java\\com\\lithodat\\app\\litho\\service\\other\\batch\\tableimporter\\lists\\" + entityName + "Importer.java";
//
//			}
//
//			@Override
//			public String processTemplate(String template) {
//				String result = template.replaceAll("ENTITYNAME_TOKEN", entityName);
//				result = result.replaceAll("MODELNAME_TOKEN", modelName.toLowerCase());
//				return result;
//			}
//
//		}.execute();

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
	}
}
