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
import com.mtheile.utils.jhi.codegenerator.CodeGenerator;
import com.mtheile.utils.jhi.codegenerator.model.EntityModel.FieldModel;

public class EntityModelService {


	public static EntityModel getModelInfosFromJHipster(File jsonDir,  String entityName) throws Exception {

		File jsonFile = new File(jsonDir.getAbsolutePath() + "\\" + entityName + ".json");

		String json = fileToString(jsonFile);

//		entityModel.parentName = parentName;

		return jsonToEntityModelObject(json);
		
	}

	private static EntityModel jsonToEntityModelObject(String json) throws Exception {

		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		EntityModel entityMetaInfo = objectMapper.readValue(json, EntityModel.class);

		return entityMetaInfo;
	}

	
	private static String fileToString(File file) throws IOException {

		Path path = Paths.get(file.getPath());

		byte[] bytesFromFile = Files.readAllBytes(path);

		return new String(bytesFromFile, StandardCharsets.UTF_8);

	}
	
	@SuppressWarnings("unused")
	private static void printDTO(Object dto) throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		System.out.println(objectMapper.writeValueAsString(dto));

	}

	public static void main(String[] args) throws Exception {
		File jHipsterDir = new File(CodeGenerator.PROJECT_HOME + ".jhipster\\");
		
		EntityModel entityModel = EntityModelService.getModelInfosFromJHipster(jHipsterDir, "Sample");
		
		for(FieldModel field: entityModel.fields) {
			System.out.println(field.javadoc);
			System.out.println(field.getLithoDocumentation());
		}
	}
}
