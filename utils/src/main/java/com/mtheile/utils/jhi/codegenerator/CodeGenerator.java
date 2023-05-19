package com.mtheile.utils.jhi.codegenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.mtheile.utils.jhi.codegenerator.model.EntityModel;
import com.mtheile.utils.jhi.codegenerator.model.EntityModel.LITHO_PROFILE;
import com.mtheile.utils.jhi.codegenerator.profiles.entity.ServerCodeGenerator;
import com.mtheile.utils.jhi.codegenerator.profiles.list.ClientCodeGenerator;
import com.mtheile.utils.jhi.codegenerator.model.EntityModelService;

public class CodeGenerator {

	public static final String PROJECT_HOME = "C:\\Users\\theil\\git\\com.lithodat.app\\";

	private static List<EntityModel> getEntityMetaInfos() throws Exception {

		List<EntityModel> entityMetaInfos = new ArrayList<>();

		File jHipsterDir = new File(PROJECT_HOME + ".jhipster\\");
		
		entityMetaInfos.add(EntityModelService.getModelInfosFromJHipster(jHipsterDir, "LCombinedMeasurement"));
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

		return entityMetaInfos;

	}

	public static void main(String[] args) throws Exception {

		// server code
		for (EntityModel entityMetaInfo : getEntityMetaInfos()) {

			if(LITHO_PROFILE.LIST.equals(entityMetaInfo.lithoProfile)) {
				
				ServerCodeGenerator.generateListJavaCode(entityMetaInfo);
			}

			if(LITHO_PROFILE.ENTITY.equals(entityMetaInfo.lithoProfile)) {

				ServerCodeGenerator.generateEntityJavaCode(entityMetaInfo);
				ServerCodeGenerator.generateBatchJavaCode(entityMetaInfo);
				
			}

		}
		
		// client code
		for (EntityModel entityMetaInfo : getEntityMetaInfos()) {

			ClientCodeGenerator.generateCRUDCode(entityMetaInfo);

			ClientCodeGenerator.generateListMenuEntries(entityMetaInfo);
			

			if(LITHO_PROFILE.ENTITY.equals(entityMetaInfo.lithoProfile)) {
				
				ClientCodeGenerator.generateFields(entityMetaInfo);
				
			}

		}

	}

}
