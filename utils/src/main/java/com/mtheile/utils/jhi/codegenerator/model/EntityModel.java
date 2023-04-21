package com.mtheile.utils.jhi.codegenerator.model;

import java.util.ArrayList;
import java.util.List;

public class EntityModel {
	
	public static enum MODEL_PROFILE {LIST, ENTITY};
	
	public MODEL_PROFILE modelProfile;
	
	public String name;
	public String parentName;
	public String modelName;
	
	public List<FieldModel> fields;
	public static class FieldModel {
		public String fieldName;
		public String fieldType;
		public String fieldTypeBlobContent;
	}
	
	public List<Relationship> relationships = new ArrayList<>();
	public static class Relationship {
		public String relationshipType;
        public String otherEntityName;
        public String otherEntityRelationshipName;
        public String relationshipName;
        public String otherEntityField;
        public String ownerSide;
	}
}
