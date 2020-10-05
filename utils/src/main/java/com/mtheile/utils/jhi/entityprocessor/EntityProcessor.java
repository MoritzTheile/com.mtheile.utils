package com.mtheile.utils.jhi.entityprocessor;

import java.io.File;

import com.mtheile.utils.file.textfile.TextFileManipulator;

public class EntityProcessor {

	public static final String JHI_PROJ_HOME = "C:\\Users\\theil\\git\\com.lithodat.app";

	public static void main(String[] args) throws Exception {

		addCascadeTypeRemove("DataPackage.java", "dataPackage2Supervisors");
		addCascadeTypeRemove("DataPackage.java", "dataPackage2Editors");
		addCascadeTypeRemove("DataPackage.java", "dataPoints");
		addCascadeTypeRemove("DataPackage.java", "baskets");

	}

	private static void addCascadeTypeRemove(String entityFile, String assoName) throws Exception {

		File file = new File(JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\domain\\" + entityFile);

		TextFileManipulator.searchAndReplace(getRegex(assoName), replacement, file);

	}

	private static String getRegex(String assoName) {
		return matcher.replaceAll(ASSOSTRING_TOKEN, assoName);
	}

	public static final String ASSOSTRING_TOKEN = "ASSOSTRING_TOKEN";

	public static final String matcher = ""
			+ "(?s)" // switch on DOTALL: dot matches line breaks now
			+ "@OneToMany\\(mappedBy = \"(.*)\"\\)" // this line gets replaced using $1
			+ ""
			+ "(" // start of $2
			+ ""
			+ ".*?"
			+ "private Set<.*> " + ASSOSTRING_TOKEN + " = new HashSet<>\\(\\);"
			+ ""
			+ ")";

	public static final String replacement = "@OneToMany(mappedBy = \"$1\", cascade = CascadeType.REMOVE)$2";

}
