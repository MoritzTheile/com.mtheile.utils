package com.mtheile.utils.jhi.entityprocessor;

import java.io.File;

import com.mtheile.utils.file.directory.FileUtils;
import com.mtheile.utils.file.textfile.TextFileManipulator;

public class EntityProcessor {

	public static final String JHI_PROJ_HOME = "C:\\Users\\theil\\git\\com.lithodat.app";
	public static final String DOMAIN_DIR = JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\domain\\";
	public static final String SERVICE_DIR = JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\service";
	public static final String DTO_DIR = JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\service\\dto\\";
	public static final String MAPPER_DIR = JHI_PROJ_HOME + "\\src\\main\\java\\com\\lithodat\\app\\service\\mapper";

	public static void main(String[] args) throws Exception {
		removeStringLobs();
		makeLobFetchLazy();
		addCascadingRemoves();
		makeCreateSpecificationPublic();
		fixUpperLowerCaseButInMapper();
		addChangedByInterfaceToDTOs();
		makeEntityLazy("DataPoint.java");
	}

	private static void fixUpperLowerCaseButInMapper() throws Exception {
		for (File file : FileUtils.listFiles(MAPPER_DIR, false)) {
			if (!file.isDirectory()) {

				TextFileManipulator.searchAndReplace("source = \"sHRIMP", "source = \"SHRIMP", file);
				TextFileManipulator.searchAndReplace("target = \"sHRIMP", "target = \"SHRIMP", file);

				TextFileManipulator.searchAndReplace("source = \"fTRawDataPoint", "source = \"FTRawDataPoint", file);
				TextFileManipulator.searchAndReplace("target = \"fTRawDataPoint", "target = \"FTRawDataPoint", file);

				TextFileManipulator.searchAndReplace(" = \"uUncertaintyType", " = \"UUncertaintyType", file);

				TextFileManipulator.searchAndReplace(" = \"dPerUncertaintyType", " = \"DPerUncertaintyType", file);

				TextFileManipulator.searchAndReplace(" = \"fTDataPoint", " = \"FTDataPoint", file);

				TextFileManipulator.searchAndReplace(" = \"eUEquation", " = \"EUEquation", file);
				TextFileManipulator.searchAndReplace(" = \"rFTequation", " = \"RFTequation", file);
				TextFileManipulator.searchAndReplace(" = \"rSVequation", " = \"RSVequation", file);
				TextFileManipulator.searchAndReplace(" = \"uAmountUncertaintyType", " = \"UAmountUncertaintyType", file);
				TextFileManipulator.searchAndReplace(" = \"uConcentrationUncertaintyType", " = \"UConcentrationUncertaintyType", file);
				TextFileManipulator.searchAndReplace(" = \"eUUncertaintyType", " = \"EUUncertaintyType", file);

				TextFileManipulator.searchAndReplace(" = \"gCDataPoint", " = \"GCDataPoint", file);
				TextFileManipulator.searchAndReplace(" = \"lAICPMS", " = \"LAICPMS", file);

			}
		}

	}

	private static void makeCreateSpecificationPublic() throws Exception {
		for (File file : FileUtils.listFiles(SERVICE_DIR, false)) {
			if (!file.isDirectory()) {
				TextFileManipulator.searchAndReplace("private (.*) createSpecification", "public $1 createSpecification", file);
			}
		}

	}

	// also see here: https://docs.google.com/presentation/d/1XcV1d1unRogclBpn0d-B22SxIKOVYsUwO98pqr9CPO4/edit#slide=id.g1256d3a3867_0_14
	private static void removeStringLobs() throws Exception {
		for (File file : FileUtils.listFiles(DOMAIN_DIR, false)) {
			if (!file.isDirectory()) {
				TextFileManipulator.searchAndReplace("(.*@Lob.*\\R)(.*@Column\\(name = \".*\"\\)\\R.*private String.*;\\R)", "// removed by EntityProcessor $1$2", file);
			}
		}

	}

	// also see here: https://docs.google.com/presentation/d/1XcV1d1unRogclBpn0d-B22SxIKOVYsUwO98pqr9CPO4/edit#slide=id.g1256d3a3867_0_14
	private static void printStringLobs() throws Exception {
		for (File file : FileUtils.listFiles(DOMAIN_DIR, false)) {
			if (!file.isDirectory()) {
				for (String string : TextFileManipulator.getMatches("(    @Lob .*\\R)(    @Column\\(name = \".*\"\\)\\R    private String .*;\\R)", file)) {
					//					for (String string2 : TextFileManipulator.getMatches("@Table\\(name = \".*\"\\)", file)) {
					//						System.out.println(string2);
					//					}
					System.out.println(string);
				}
			}
		}

	}

	private static void makeLobFetchLazy() throws Exception {
		for (File file : FileUtils.listFiles(DOMAIN_DIR, false)) {
			if (!file.isDirectory()) {
				// In order to prevent the storage of text via link reference activate next line
				// TextFileManipulator.searchAndReplace("@Lob\\R", "//removed by EntityProcessor: @Lob @Basic(fetch = FetchType.LAZY)\n", file);
				TextFileManipulator.searchAndReplace("@Lob\\R", "@Lob @Basic(fetch = FetchType.LAZY)\n", file);
			}
		}

	}

	private static void makeEntityLazy(String entityFile) throws Exception {
		File file = new File(DOMAIN_DIR + entityFile);

		TextFileManipulator.searchAndReplace("@OneToOne\\(", "@OneToOne(fetch = FetchType.LAZY, ", file);
		TextFileManipulator.searchAndReplace("@ManyToOne", "@ManyToOne(fetch = FetchType.LAZY)", file);

	}

	private static void addChangedByInterfaceToDTOs() throws Exception {
		addChangedByInterfaceToDTO("SampleDTO.java");
		addChangedByInterfaceToDTO("DataPointDTO.java");
		addChangedByInterfaceToDTO("DataPackageDTO.java");
		addChangedByInterfaceToDTO("PersonDTO.java");
		addChangedByInterfaceToDTO("LiteratureDTO.java");
		addChangedByInterfaceToDTO("FundingDTO.java");
		addChangedByInterfaceToDTO("ArchiveDTO.java");
		addChangedByInterfaceToDTO("StratigraphicUnitDTO.java");
		addChangedByInterfaceToDTO("ReferenceMaterialDTO.java");
		addChangedByInterfaceToDTO("MaterialDTO.java");
		addChangedByInterfaceToDTO("MachineDTO.java");
	}

	private static void addChangedByInterfaceToDTO(String entityFile) throws Exception {

		File file = new File(DTO_DIR + entityFile);

		TextFileManipulator.searchAndReplace("implements Serializable", "implements Serializable, ChangedBy", file);
		TextFileManipulator.searchAndReplace("package com.lithodat.app.service.dto;", "package com.lithodat.app.service.dto;\nimport com.lithodat.app.litho.service.dto.base.ChangedBy;", file);
	}

	private static void addCascadingRemoves() throws Exception {

		addCascadeTypeRemove("DataPackage.java", "dataPackage2Supervisors");
		addCascadeTypeRemove("DataPackage.java", "dataPackage2Editors");
		addCascadeTypeRemove("DataPackage.java", "dataPoints");
		addCascadeTypeRemove("DataPackage.java", "baskets");
		addCascadeTypeRemove("DataPackage.java", "samples");

		addCascadeTypeRemove("DataPoint.java", "tag2DataPoints");
		addCascadeTypeRemove("DataPoint.java", "flag2DataPoints");
		addCascadeTypeRemove("DataPoint.java", "literature2DataPoints");
		addCascadeTypeRemove("DataPoint.java", "person2DataPoints");
		addCascadeTypeRemove("DataPoint.java", "funding2DataPoints");
		addCascadeTypeRemove("DataPoint.java", "lab2DataPoints");
		addCascadeTypeRemove("DataPoint.java", "machine2DataPoints");
		addCascadeTypeRemove("DataPoint.java", "statements");
		addCascadeTypeRemove("DataPoint.java", "datapointProperties");

		addCascadeTypeRemove("Sample.java", "literature2Samples");
		addCascadeTypeRemove("Sample.java", "person2Samples");
		addCascadeTypeRemove("Sample.java", "funding2Samples");
		addCascadeTypeRemove("Sample.java", "analytes");
		addCascadeTypeRemove("Sample.java", "images");
		addCascadeTypeRemove("Sample.java", "sampleProperties");
		addCascadeTypeRemove("Sample.java", "tag2Samples");

		addCascadeTypeRemove("Statement.java", "geoEventAtAge");
		addCascadeTypeRemove("Statement.java", "tempAtAge");
		addCascadeTypeRemove("Statement.java", "tempGradient");

		addCascadeTypeRemove("GeoEventAtAge.java", "sHRIMPAge");

		addCascadeTypeRemove("SHRIMPDataPoint.java", "sHRIMPSpots");
		addCascadeTypeRemove("SHRIMPDataPoint.java", "dataPoints");
	}

	private static void addCascadeTypeRemove(String entityFile, String assoName) throws Exception {

		File file = new File(DOMAIN_DIR + entityFile);

		TextFileManipulator.searchAndReplace(getRegex1(assoName), replacement1, file);
		TextFileManipulator.searchAndReplace(getRegex2(assoName), replacement2, file);

	}

	public static final String ASSOSTRING_TOKEN = "ASSOSTRING_TOKEN";

	private static String getRegex1(String assoName) {
		return matcher1.replaceAll(ASSOSTRING_TOKEN, assoName);
	}

	private static String getRegex2(String assoName) {
		return matcher2.replaceAll(ASSOSTRING_TOKEN, assoName);
	}

	public static final String matcher1 = ""
			+ "(?s)" // switch on DOTALL: dot matches line breaks now
			+ "@OneToMany\\(mappedBy = \"(.*)\"\\)" // this line gets replaced using $1
			+ ""
			+ "(" // start of $2
			+ ""
			+ ".*?"
			+ "private Set<.*> " + ASSOSTRING_TOKEN + " = new HashSet<>\\(\\);"
			+ ""
			+ ")";

	public static final String replacement1 = "@OneToMany(mappedBy = \"$1\", cascade = CascadeType.REMOVE)$2";

	public static final String matcher2 = "(?s)" // switch on DOTALL: dot matches line breaks now
			+ "    @OneToOne(\\R"
			+ "    .*"
			+ "    private .* " + ASSOSTRING_TOKEN + ";\\R)"
			+ "";

	public static final String replacement2 = "    @OneToOne(cascade = CascadeType.REMOVE)$1";
}
