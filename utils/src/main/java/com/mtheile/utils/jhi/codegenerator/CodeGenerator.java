package com.mtheile.utils.jhi.codegenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.mtheile.utils.jhi.codegenerator.model.EntityModel;
import com.mtheile.utils.jhi.codegenerator.model.EntityModelService;
import com.mtheile.utils.jhi.codegenerator.profiles.client.ClientCodeGenerator;
import com.mtheile.utils.jhi.codegenerator.profiles.server.ServerCodeGenerator;

public class CodeGenerator {

	public static final String PROJECT_HOME = "C:\\Users\\theil\\git\\com.lithodat.app\\";
	
	public static final String PROFILES_HOME = "/com/mtheile/utils/jhi/codegenerator/profiles/";


	public static final String MODULNAME_TOKEN = "MODULNAME_TOKEN";
	public static final String MODULNAME_LOWERCASE_TOKEN = "MODULNAME_LOWERCASE_TOKEN";
	public static final String MODULNAME_UPPERCASE_TOKEN = "MODULNAME_UPPERCASE_TOKEN";
	public static final String PARENTNAME_TOKEN = "PARENTNAME_TOKEN";
	public static final String ENTITYNAME_TOKEN = "ENTITYNAME_TOKEN";
	public static final String PARENTNAME_FIRSTLETTER_LOWERCASE_TOKEN = "PARENTNAME_FIRSTLETTER_LOWERCASE_TOKEN";
	public static final String ENTITYNAME_FIRSTLETTER_LOWERCASE_TOKEN = "ENTITYNAME_FIRSTLETTER_LOWERCASE_TOKEN";
		
	private static List<EntityModel> getEntityMetaInfos() throws Exception {

		List<EntityModel> entityMetaInfos = new ArrayList<>();

		File jHipsterDir = new File(PROJECT_HOME + ".jhipster\\");
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LCombinedMeasurement"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LSampleIntroMethod"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LICPMSType"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LDataReductionPackage"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LSolutionIntroSystem"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LLaserSystem"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LLaserWaveLength"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LLaserPulseWidthUnit"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LLaserSamplingMode"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LAblationCellType"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LTubingMaterial"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LTubingMaterialInternalDiameter"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LInternalStandard"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LICPMSModel"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LZeroMCICPMS"));
//
//		
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,  "ICPMSMetadata"));          // parent: "DataPoint",    
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,  "LaserMetadata"));          // parent: "ICPMSMetadata",
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,  "SolutionOtherMetadata"));  // parent: "ICPMSMetadata",
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,  "LaserMetadata"));          // parent: "ICPMSMetadata",
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,  "QICPMSMetadata"));         // parent: "ICPMSMetadata",
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,  "MCICPMSMetadata"));        // parent: "ICPMSMetadata",
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,  "ICPMSMSMetadata"));        // parent: "ICPMSMetadata",
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,  "HRICPMSMetadata"));        // parent: "ICPMSMetadata",

//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "UPbDataPoint"));
// 		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "UPbSpotData"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "UPbAgeGroup"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LUPbGrainDomain"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LUPbGroup"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LUPbDetectorIntensityUnit"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LUncertainty"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LUPbCommonPbCorrection"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LUPbPreferredAgeTypeSingleSpot"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LUPbAgeGroupCalcType"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LUPbDataInterpretationTool"));


		
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LDataType"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LPredictedParameter"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LConstraintType"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LDiffusionModel"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LAnnealingModel"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LImplantedTracks"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LProjectedLengths"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LKinematicIndicator"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LPopulationType"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LModelApproach"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LModelType"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LModelSoftware"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LPathType"));
		
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "THDataPoint"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "THist"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "THistInput"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "THistNickpoint"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "THPredResult"));
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "THModelConstraint"));
		
//		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "Tag"));
		
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "IsoMeasurable"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "IsoProcedure"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "IsoMeasurement"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "IsoDataPoint"));
		
		return entityMetaInfos;

	}

	public static void main(String[] args) throws Exception {
		
		for (EntityModel entityMetaInfo : getEntityMetaInfos()) {

			ServerCodeGenerator.generate(entityMetaInfo);

			ClientCodeGenerator.generate(entityMetaInfo);

		}

	}

	
	public static void template2Code(String parentName, String modulName, String entityName, String sourceFile, String targetFile) throws Exception {

		new AbstractTemplateProcessor(sourceFile) {

			@Override
			public String getTargetFilePath() {

				return targetFile;

			}

			@Override
			public String processTemplate(String template) {

				template = template.replaceAll(ENTITYNAME_TOKEN, entityName);
				template = template.replaceAll(ENTITYNAME_FIRSTLETTER_LOWERCASE_TOKEN, firstLetterToLowerCase(entityName));
				template = template.replaceAll(PARENTNAME_TOKEN, parentName);
				template = template.replaceAll(PARENTNAME_FIRSTLETTER_LOWERCASE_TOKEN, firstLetterToLowerCase(parentName));
				template = template.replaceAll(MODULNAME_TOKEN, modulName);
				template = template.replaceAll(MODULNAME_LOWERCASE_TOKEN, modulName.toLowerCase());
				template = template.replaceAll(MODULNAME_UPPERCASE_TOKEN, modulName.toUpperCase());

				return template;

			}

		}.execute();
	}

	/**
	 * This is a helper class to create templates.
	 */
	public static void code2Template(String parentName, String modulName, String entityName, String sourceFile, String targetFile) throws Exception {

		new AbstractTemplateProcessor(sourceFile) {

			@Override
			public String getTargetFilePath() {

				return targetFile;

			}

			@Override
			public String processTemplate(String template) {

				template = template.replaceAll(entityName, ENTITYNAME_TOKEN);
				template = template.replaceAll(firstLetterToLowerCase(entityName), ENTITYNAME_FIRSTLETTER_LOWERCASE_TOKEN);
				template = template.replaceAll(parentName, PARENTNAME_TOKEN);
				template = template.replaceAll(firstLetterToLowerCase(parentName), PARENTNAME_FIRSTLETTER_LOWERCASE_TOKEN);
				
				template = template.replaceAll(modulName, MODULNAME_TOKEN);
				template = template.replaceAll(modulName.toLowerCase(), MODULNAME_LOWERCASE_TOKEN);
				template = template.replaceAll(modulName.toUpperCase(), MODULNAME_UPPERCASE_TOKEN);

				return template;

			}

		}.execute();
	}

	public static String firstLetterToLowerCase(String input) {

		if (input == null) {
			return null;
		}

		if (input.isEmpty()) {
			return input;
		}

		return input.substring(0, 1).toLowerCase() + input.substring(1);

	}

}
