package com.mtheile.utils.jhi.modelrebuilder;

import java.io.File;

import com.mtheile.utils.file.directory.FileUtils;
import com.mtheile.utils.file.textfile.TextFileManipulator;

public class ModelRebuilder {

	public static final String JHI_PROJ_HOME = "C:\\Users\\theil\\git\\com.lithodat.app";

	public static void main(String[] args) throws Exception {

		// CacheConfiguration.java
		TextFileManipulator.deleteSections(new File(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\config\\CacheConfiguration.java"), "// jhipster-needle-insertion-start\\R", "[\\t ]*// jhipster-needle-ehcache-add-entry\\R", true, true);
		//
		// .jhipster
		FileUtils.deleteFilesFromDir(JHI_PROJ_HOME + "\\.jhipster", ".*\\.json");
		//
		// // liquibase/changelog
		FileUtils.deleteFilesFromDirExcept(new File(JHI_PROJ_HOME + "\\src\\main\\resources\\config\\liquibase\\changelog"), "00000000000000_initial_schema\\.xml");
		//
		// // liquibase/data
		FileUtils.deleteFilesFromDirExcept(new File(JHI_PROJ_HOME + "\\src\\main\\resources\\config\\liquibase\\data"),
				"user.csv",
				"authority.csv",
				"user_authority.csv");
		//
		// // liquibase/master.xml
		TextFileManipulator.deleteSections(new File(JHI_PROJ_HOME + "\\src\\main\\resources\\config\\liquibase\\master.xml"), "<!--  jhipster-needle-insertion-start-changelog -->\\R", "[\\t ]*<!-- jhipster-needle-liquibase-add-changelog ", true, true);
		TextFileManipulator.deleteSections(new File(JHI_PROJ_HOME + "\\src\\main\\resources\\config\\liquibase\\master.xml"), "<!--  jhipster-needle-insertion-start-constraints -->\\R", "[\\t ]*<!-- jhipster-needle-liquibase-add-constraints-changelog", true, true);
		//
		// // domain
		FileUtils.deleteFilesFromDirExcept(new File(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\domain"),
				"AbstractAuditingEntity\\.java",
				"Authority\\.java",
				"package-info\\.java",
				"PersistentAuditEvent\\.java",
				"User\\.java");
		//
		// // domain/enumeration
		FileUtils.deleteFilesFromDirExcept(new File(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\domain\\enumeration"));
		//
		// // repository
		FileUtils.deleteFilesFromDirExcept(new File(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\repository"),
				"AuthorityRepository\\.java",
				"package-info\\.java",
				"PersistenceAuditEventRepository\\.java",
				"CustomAuditEventRepository\\.java",
				"UserRepository\\.java");
		//
		// // web/rest
		// FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\web\\rest", ENTITY_NAME + "Resource.java");
		FileUtils.deleteFilesFromDirExcept(new File(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\web\\rest"),
				"AccountResource\\.java",
				"package-info\\.java",
				"PersistenceAuditEventRepository\\.java",
				"ArchiveResource\\.java",
				"AuditResource\\.java",
				"ClientForwardController\\.java",
				"UserJWTController\\.java",
				"UserResource\\.java");
		//
		// // service
		// FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\service", ENTITY_NAME + "Service.java");
		// FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\service", ENTITY_NAME + "QueryService.java");
		FileUtils.deleteFilesFromDirExcept(new File(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\service"),
				"AuditEventService\\.java",
				"package-info\\.java",
				"MailService\\.java",
				"UserService\\.java");
		//
		// // service/dto
		// FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\service\\dto", ENTITY_NAME + "DTO.java");
		// FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\service\\dto", ENTITY_NAME + "Criteria.java");
		FileUtils.deleteFilesFromDirExcept(new File(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\service\\dto"),
				"UserDTO\\.java",
				"PasswordChangeDTO\\.java",
				"package-info\\.java");
		//
		// // service/impl
		// FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\service\\impl", ENTITY_NAME + "ServiceImpl.java");
		FileUtils.deleteFilesFromDirExcept(new File(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\service\\impl"),
				"package-info\\.java");
		//
		// // service/mapper
		// FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\service\\mapper", ENTITY_NAME + "Mapper.java");
		FileUtils.deleteFilesFromDirExcept(new File(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\service\\mapper"),
				"package-info\\.java",
				"UserMapper\\.java");
		//
		// // webapp\app\entities folder
		// FileUtils.deleteTree(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\entities\\" + seperateCamelCase(ENTITY_NAME, "-").toLowerCase());
		FileUtils.deleteDirsFromDirExcept(new File(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\entities\\"));
		//
		// // webapp\app\entities\index.tsx
		// TextFileManipulator.deleteLinesMatching(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\entities\\index.tsx", " " + ENTITY_NAME + " ");
		// TextFileManipulator.deleteLinesMatching(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\entities\\index.tsx", "\\{" + ENTITY_NAME + "\\}");
		TextFileManipulator.deleteSections(new File(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\entities\\index.tsx"), "// jhipster-needle-insertion-start-add-route-import\\R", "[\\t ]*/\\* jhipster-needle-add-route-import", true, true);
		TextFileManipulator.deleteSections(new File(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\entities\\index.tsx"), "// jhipster-needle-insertion-start-add-route-path\\R", "[\\t ]*\\{/\\* jhipster-needle-add-route-path", true, true);
		//
		// // \webapp\app\shared\layout\menus\entities.tsx
		// TextFileManipulator.deleteSection(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\shared\\layout\\menus\\entities.tsx", "<MenuItem ", seperateCamelCase(ENTITY_NAME, "-").toLowerCase(), "</MenuItem>");
		TextFileManipulator.deleteSections(new File(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\shared\\layout\\menus\\entities.tsx"), "\\{/\\* jhipster-needle-insertion-start-add-entity-to-menu\\*\\/}\\R", "[\\t ]\\{/\\* jhipster-needle-add-entity-to-menu", true, true);
		//
		// // service/mapper
		// FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\shared\\model", seperateCamelCase(ENTITY_NAME, "-").toLowerCase() + ".model.ts");
		FileUtils.deleteFilesFromDirExcept(new File(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\shared\\model"),
				"user.model.ts");

		// // \src\main\webapp\app\shared\reducers\index.ts
		// TextFileManipulator.deleteSection(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\shared\\reducers\\index.ts", "import ", ENTITY_NAME + "State", ".reducer';");
		// TextFileManipulator.deleteLinesMatching(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\shared\\reducers\\index.ts", ENTITY_NAME + "State");
		// TextFileManipulator.deleteLinesMatching(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\shared\\reducers\\index.ts", firstLetterToLowerCase(ENTITY_NAME));
		TextFileManipulator.deleteSections(new File(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\shared\\reducers\\index.ts"), "/\\* jhipster-needle-insertion-start-add-reducer-import \\*/\\R", "[\\t ]*/\\* jhipster-needle-add-reducer-import", true, true);
		TextFileManipulator.deleteSections(new File(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\shared\\reducers\\index.ts"), "/\\* jhipster-needle-insertion-start-add-reducer-type\\*/\\R", "[\\t ]*/\\* jhipster-needle-add-reducer-type", true, true);
		TextFileManipulator.deleteSections(new File(JHI_PROJ_HOME + "\\src\\main\\webapp\\app\\shared\\reducers\\index.ts"), "/\\* jhipster-needle-insertion-start-add-reducer-combine\\*/\\R", "[\\t ]*/\\* jhipster-needle-add-reducer-combine", true, true);
		//
		// // \src\main\webapp\i18n\en\testAsdf.json
		// FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\main\\webapp\\i18n\\en", firstLetterToLowerCase(ENTITY_NAME) + ".json");
		FileUtils.deleteFilesFromDirExcept(new File(JHI_PROJ_HOME + "\\src\\main\\webapp\\i18n\\en"),
				"activate.json",
				"audits.json",
				"configuration.json",
				"error.json",
				"global.json",
				"health.json",
				"home.json",
				"login.json",
				"logs.json",
				"metrics.json",
				"password.json",
				"register.json",
				"reset.json",
				"sessions.json",
				"settings.json",
				"user-management.json");
		//
		// // \src\test\java\com\lithodat\app\web\rest\ ResourceIT.java
		// FileUtils.deleteFileFromDir(JHI_PROJ_HOME + "\\src\\test\\java\\com\\lithodat\\app\\web\\rest\\", ENTITY_NAME + "ResourceIT.java");
		FileUtils.deleteFilesFromDirExcept(new File(JHI_PROJ_HOME + "\\src\\test\\java\\com\\lithodat\\app\\web\\rest\\"),
				"AccountResourceIT.java",
				"AuditResourceIT.java",
				"ClientForwardControllerIT.java",
				"TestUtil.java",
				"UserJWTControllerIT.java",
				"UserResourceIT.java");
		//
		// FileUtils.deleteTree(JHI_PROJ_HOME + "\\src\\test\\javascript\\spec\\app\\entities\\" + seperateCamelCase(ENTITY_NAME, "-").toLowerCase());
		FileUtils.deleteDirsFromDirExcept(new File(JHI_PROJ_HOME + "\\src\\test\\javascript\\spec\\app\\entities\\"),
				"");

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
