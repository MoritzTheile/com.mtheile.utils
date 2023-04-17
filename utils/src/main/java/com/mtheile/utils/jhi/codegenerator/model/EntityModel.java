package com.mtheile.utils.jhi.codegenerator.model;

import java.util.List;

public class EntityModel {
	
	public String name;
	public String parentName;
	public String modelName;
	
	public List<FieldModel> fields;
	static class FieldModel {
		public String fieldName;
		public String fieldType;
	}
}
