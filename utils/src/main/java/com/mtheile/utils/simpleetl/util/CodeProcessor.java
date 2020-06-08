package com.mtheile.utils.simpleetl.util;

import java.io.File;
import java.util.List;

import com.mtheile.utils.file.directory.FileUtils;
import com.mtheile.utils.file.textfile.TextFileManipulator;

public class CodeProcessor {

	public static final String DOMAIN = "source";

	public static final String sourceDir = "C:\\Users\\theil\\git\\com.lithodat.app\\src\\main\\java\\com\\lithodat\\app\\domain";

	private static final String destDir = "C:\\Users\\theil\\git\\com.mtheile.utils.simpleetl\\src\\main\\java\\com\\mtheile\\simpleetl\\" + DOMAIN + "\\domain";

	public static void main(String[] args) throws Exception {

		{// cleanup folders

			File destDirFile = new File(destDir);

			FileUtils.deleteTree(destDirFile);

			destDirFile.mkdir();

			new File(destDir + "\\enumeration").mkdir();

		}

		List<File> destDirFiles = FileUtils.copyFilesToDir(FileUtils.listFiles(sourceDir, false), destDir);

		List<File> enumerationDirFiles = FileUtils.copyFilesToDir(FileUtils.listFiles(sourceDir + "\\enumeration", false), destDir + "\\enumeration");

		for (File file : destDirFiles) {

			TextFileManipulator.searchAndReplace("" +
					"@GeneratedValue\\(strategy = GenerationType\\.SEQUENCE, generator = \"sequenceGenerator\"\\)\\R    @SequenceGenerator\\(name = \"sequenceGenerator\"\\)\\R",
					"@GeneratedValue(generator = \"prod-generator\")\n@GenericGenerator(name = \"prod-generator\", strategy = \"com.mtheile.utils.simpleetl.util.CustomIdGenerator\")\n", file);

			TextFileManipulator.searchAndReplace("" +
					"implements Serializable \\{",
					"extends WithCustomId implements Serializable \\{", file);

			TextFileManipulator.searchAndReplace("" +
					"com.lithodat.app.domain",
					"com.mtheile.utils.simpleetl." + DOMAIN + ".domain", file);

			TextFileManipulator.searchAndReplace("" +
					"import org\\.hibernate\\.annotations\\.CacheConcurrencyStrategy;",
					"import org.hibernate.annotations.CacheConcurrencyStrategy;\r\n"
							+ "import org.hibernate.annotations.GenericGenerator;\n"
							+ "import com.mtheile.utils.simpleetl.util.WithCustomId;\r\n"
							+ "",
					file);

		}

		for (File file : enumerationDirFiles) {

			TextFileManipulator.searchAndReplace("" +
					"com.lithodat.app.domain",
					"com.mtheile.utils.simpleetl." + DOMAIN + ".domain", file);

		}

		TextFileManipulator.searchAndReplace("extends AbstractAuditingEntity", "", getFile(destDirFiles, "User.java"));
		TextFileManipulator.searchAndReplace("import com\\.lithodat\\.app\\.config\\.Constants;", "", getFile(destDirFiles, "User.java"));
		TextFileManipulator.searchAndReplace("import org\\.apache\\.commons\\.lang3\\.StringUtils;", "", getFile(destDirFiles, "User.java"));
		TextFileManipulator.searchAndReplace("@Pattern", "// @Pattern", getFile(destDirFiles, "User.java"));
		TextFileManipulator.searchAndReplace("this\\.login = StringUtils\\.lowerCase\\(login, Locale\\.ENGLISH\\);", "this.login = login;", getFile(destDirFiles, "User.java"));

		TextFileManipulator.searchAndReplace("extends WithCustomId", "", getFile(destDirFiles, "AbstractAuditingEntity.java"));
		TextFileManipulator.searchAndReplace("@Audited", "", getFile(destDirFiles, "AbstractAuditingEntity.java"));
		TextFileManipulator.searchAndReplace("import org\\.hibernate\\.envers\\.Audited;", "", getFile(destDirFiles, "AbstractAuditingEntity.java"));

		TextFileManipulator.searchAndReplace("extends WithCustomId", "", getFile(destDirFiles, "PersistentAuditEvent.java"));
		TextFileManipulator.searchAndReplace("@GenericGenerator", "// @GenericGenerator", getFile(destDirFiles, "PersistentAuditEvent.java"));

	}

	private static File getFile(List<File> files, String name) {

		for (File file : files) {
			if (!file.isDirectory() && file.getName().equals(name)) {
				return file;
			}

		}
		return null;
	}

}
