package com.mtheile.utils.jhi.entityremover;

import com.mtheile.utils.file.directory.FileUtils;
import com.mtheile.utils.file.textfile.TextFileManipulator;

public class EntityRemover {

	public static final String JHI_PROJ_HOME = "C:\\Users\\theil\\git\\com.lithodat.app";

	public static final String ENTITY_NAME = "ChronoProperty";

	public static void main(String[] args) throws Exception {

		// CacheConfiguration.java
		TextFileManipulator.deleteLinesMatching(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\config\\CacheConfiguration.java", "createCache\\(cm, com\\.lithodat\\.app\\.domain\\." + ENTITY_NAME + "\\.class\\.getName\\(\\)");
		TextFileManipulator.deleteLinesMatching(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\config\\CacheConfiguration.java", "\\.class\\.getName\\(\\) \\+ \"\\." + firstLetterToLowerCase(ENTITY_NAME) + "s\"\\);");

		// .jhipster
		FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\.jhipster", ENTITY_NAME + ".json");

		// liquibase/changelog
		FileUtils.deleteFilesFromDir(JHI_PROJ_HOME + "\\src\\main\\resources\\config\\liquibase\\changelog", ".*" + ENTITY_NAME + "\\.xml");

		// liquibase/data
		FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\main\\resources\\config\\liquibase\\data", seperateCamelCase(ENTITY_NAME).toLowerCase() + ".csv");

		// liquibase/master.xml
		TextFileManipulator.deleteLinesMatching(JHI_PROJ_HOME + "\\src\\main\\resources\\config\\liquibase\\master.xml", "_" + ENTITY_NAME + "\\.xml\"");

		// domain
		FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\domain", ENTITY_NAME + ".java");

		// domain/enumeration
		FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\domain\\enumeration", ENTITY_NAME + ".java");

		// repository
		FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\repository", ENTITY_NAME + "Repository.java");

		// web/rest
		FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\web\\rest", ENTITY_NAME + "Resource.java");

		// service
		FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\service", ENTITY_NAME + "Service.java");
		FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\service", ENTITY_NAME + "QueryService.java");

		// service/dto
		FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\service\\dto", ENTITY_NAME + "DTO.java");
		FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\service\\dto", ENTITY_NAME + "Criteria.java");

		// service/impl
		FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\service\\impl", ENTITY_NAME + "ServiceImpl.java");

		// service/mapper
		FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\service\\mapper", ENTITY_NAME + "Mapper.java");

		// webapp\app\entities folder
		FileUtils.deleteTree(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\entities\\" + seperateCamelCase(ENTITY_NAME, "-").toLowerCase());

		// webapp\app\entities\index.tsx
		TextFileManipulator.deleteLinesMatching(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\entities\\index.tsx", " " + ENTITY_NAME + " ");
		TextFileManipulator.deleteLinesMatching(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\entities\\index.tsx", "\\{" + ENTITY_NAME + "\\}");

		// \webapp\app\shared\layout\menus\entities.tsx
		TextFileManipulator.deleteSection(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\shared\\layout\\menus\\entities.tsx", "<MenuItem ", seperateCamelCase(ENTITY_NAME, "-").toLowerCase(), "</MenuItem>");

		// service/mapper
		FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\shared\\model", seperateCamelCase(ENTITY_NAME, "-").toLowerCase() + ".model.ts");

		// \src\main\webapp\app\shared\reducers\index.ts
		TextFileManipulator.deleteSection(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\shared\\reducers\\index.ts", "import ", ENTITY_NAME + "State", ".reducer';");
		TextFileManipulator.deleteLinesMatching(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\shared\\reducers\\index.ts", ENTITY_NAME + "State");
		TextFileManipulator.deleteLinesMatching(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\shared\\reducers\\index.ts", firstLetterToLowerCase(ENTITY_NAME));

		// \src\main\webapp\i18n\en\testAsdf.json
		FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\main\\webapp\\i18n\\en", firstLetterToLowerCase(ENTITY_NAME) + ".json");

		// \src\test\java\com\lithodat\app\web\rest\ ResourceIT.java
		FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\test\\java\\com\\lithodat\\app\\web\\rest\\", ENTITY_NAME + "ResourceIT.java");

		FileUtils.deleteTree(JHI_PROJ_HOME + "\\src\\test\\javascript\\spec\\app\\entities\\" + seperateCamelCase(ENTITY_NAME, "-").toLowerCase());

	}

	private static String firstLetterToLowerCase(String string) {

		if (string.isEmpty()) {
			return string;
		}

		String firstLetter = string.substring(0, 1).toLowerCase();

		String withoutFirstLetter = string.substring(1, string.length());

		return firstLetter + withoutFirstLetter;

	}

	private static String seperateCamelCase(String name) {
		return seperateCamelCase(name, "_");
	}

	/**
	 * Convert to UPPER_UNDERSCORE format detecting upper case acronyms
	 */

	private static String seperateCamelCase(String name, String seperator) {

		String SEPERATOR = seperator;

		StringBuffer result = new StringBuffer();
		boolean begin = true;
		boolean lastUppercase = false;
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			if (Character.isUpperCase(ch)) {
				// is start?
				if (begin) {
					result.append(ch);
				} else {
					if (lastUppercase) {
						// test if end of acronym
						if (i + 1 < name.length()) {
							char next = name.charAt(i + 1);
							if (Character.isUpperCase(next)) {
								// acronym continues
								result.append(ch);
							} else {
								// end of acronym
								result.append(SEPERATOR).append(ch);
							}
						} else {
							// acronym continues
							result.append(ch);
						}
					} else {
						// last was lowercase, insert SEPERATOR
						result.append(SEPERATOR).append(ch);
					}
				}
				lastUppercase = true;
			} else {
				result.append(ch);
				lastUppercase = false;
			}
			begin = false;
		}
		return result.toString();
	}

}
