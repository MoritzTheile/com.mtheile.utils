package com.mtheile.utils.jhi.codegenerator.model;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class EntityModelService {


	public static EntityModel getModelInfosFromJHipster(File jsonDir, String modelName, String parentName, String entityName) throws Exception {

		File jsonFile = new File(jsonDir.getAbsolutePath() + "\\" + entityName + ".json");

		String json = fileToString(jsonFile);

		EntityModel entityModel = jsonToEntityModelObject(json);
		entityModel.parentName = parentName;
		entityModel.modelName = modelName;
		return entityModel;
		
	}

	private static EntityModel jsonToEntityModelObject(String json) throws Exception {

		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		EntityModel entityMetaInfo = objectMapper.readValue(json, EntityModel.class);

		return entityMetaInfo;
	}

	public static void main(String[] args) throws Exception {
		
		String modelName = "icpms";
		String parentName = "";
		String entityName = "LaserMetadata";
		EntityModel entityModel = getModelInfosFromJHipster(new File("C:\\Users\\theil\\git\\com.lithodat.app\\.jhipster\\"), modelName,  parentName, entityName);
		System.out.println("name="+entityModel.name);
		printDTO(entityModel);
	}
	
	private static String fileToString(File file) throws IOException {

		Path path = Paths.get(file.getPath());

		byte[] bytesFromFile = Files.readAllBytes(path);

		return new String(bytesFromFile, StandardCharsets.UTF_8);

	}
	
	private static void printDTO(Object dto) throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		System.out.println(objectMapper.writeValueAsString(dto));

	}

}
