package com.mtheile.utils.jhi.codegenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.mtheile.utils.jhi.codegenerator.model.EntityModel;
import com.mtheile.utils.jhi.codegenerator.model.EntityModel.MODEL_PROFILE;
import com.mtheile.utils.jhi.codegenerator.profiles.entity.EntityGenerator;
import com.mtheile.utils.jhi.codegenerator.profiles.list.ListGenerator;
import com.mtheile.utils.jhi.codegenerator.model.EntityModelService;

public class CodeGenerator {

	public static final String PROJECT_HOME = "C:\\Users\\theil\\git\\com.lithodat.app\\";

	private static List<EntityModel> getEntityMetaInfos() throws Exception {

		List<EntityModel> entityMetaInfos = new ArrayList<>();

		File jHipsterDir = new File(PROJECT_HOME + ".jhipster\\");
		
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,MODEL_PROFILE.LIST, "ICPMS", null, "LCombinedMeasurement"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,MODEL_PROFILE.LIST, "ICPMS", null, "LSampleIntroMethod"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,MODEL_PROFILE.LIST, "ICPMS", null, "LICPMSType"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,MODEL_PROFILE.LIST, "ICPMS", null, "LDataReductionPackage"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,MODEL_PROFILE.LIST, "ICPMS", null, "LSolutionIntroSystem"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,MODEL_PROFILE.LIST, "ICPMS", null, "LLaserSystem"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,MODEL_PROFILE.LIST, "ICPMS", null, "LLaserWaveLength"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,MODEL_PROFILE.LIST, "ICPMS", null, "LLaserPulseWidthUnit"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,MODEL_PROFILE.LIST, "ICPMS", null, "LLaserSamplingMode"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,MODEL_PROFILE.LIST, "ICPMS", null, "LAblationCellType"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,MODEL_PROFILE.LIST, "ICPMS", null, "LTubingMaterial"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,MODEL_PROFILE.LIST, "ICPMS", null, "LTubingMaterialInternalDiameter"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,MODEL_PROFILE.LIST, "ICPMS", null, "LInternalStandard"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,MODEL_PROFILE.LIST, "ICPMS", null, "LICPMSModel"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir,MODEL_PROFILE.LIST, "ICPMS", null, "LZeroMCICPMS"));

		
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, MODEL_PROFILE.ENTITY, "ICPMS", "DataPoint", "ICPMSMetadata"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, MODEL_PROFILE.ENTITY,"ICPMS", "ICPMSMetadata", "LaserMetadata"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, MODEL_PROFILE.ENTITY,"ICPMS", "ICPMSMetadata", "SolutionOtherMetadata"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, MODEL_PROFILE.ENTITY,"ICPMS", "ICPMSMetadata", "LaserMetadata"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, MODEL_PROFILE.ENTITY,"ICPMS", "ICPMSMetadata", "QICPMSMetadata"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, MODEL_PROFILE.ENTITY,"ICPMS", "ICPMSMetadata", "MCICPMSMetadata"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, MODEL_PROFILE.ENTITY,"ICPMS", "ICPMSMetadata", "ICPMSMSMetadata"));
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, MODEL_PROFILE.ENTITY,"ICPMS", "ICPMSMetadata", "HRICPMSMetadata"));

		return entityMetaInfos;

	}

	public static void main(String[] args) throws Exception {

		for (EntityModel entityMetaInfo : getEntityMetaInfos()) {

			if(!MODEL_PROFILE.LIST.equals(entityMetaInfo.modelProfile)) {
				continue;
			}
			ListGenerator.generateListJavaCode(entityMetaInfo);
//			ListGenerator.generateListJavaScriptCode(entityMetaInfo);
			EntityGenerator.generateJavaScriptCode(entityMetaInfo);
			ListGenerator.generateListMenuEntries(entityMetaInfo);

		}
		
		for (EntityModel entityMetaInfo : getEntityMetaInfos()) {

			if(!MODEL_PROFILE.ENTITY.equals(entityMetaInfo.modelProfile)) {
				continue;
			}

			EntityGenerator.generateServiceJavaCode(entityMetaInfo);
			EntityGenerator.generateBatchJavaCode(entityMetaInfo);
			EntityGenerator.generateJavaScriptCode(entityMetaInfo);
			EntityGenerator.generateListMenuEntries(entityMetaInfo);
			
			FieldGenerator.generate(entityMetaInfo);

		}

	}

}
