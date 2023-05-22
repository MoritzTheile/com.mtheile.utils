package com.mtheile.utils.jhi.codegenerator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntityModel {
	
	public static enum LITHO_PROFILE {LIST, CHILD, UNKNOWN};
	
	public String name;
	public String javadoc;

	public String getLithoModule(){
		
		return getLithoAnnotation(javadoc, "lithoModule");
				
	}
	public String getLithoParent(){
		
		return getLithoAnnotation(javadoc, "lithoParent");
				
	}


	public LITHO_PROFILE getLithoProfile(){
		
		String profileAsString = getLithoAnnotation(javadoc, "lithoProfile");
		
		try {
			return LITHO_PROFILE.valueOf(profileAsString.toUpperCase());
		}catch (Exception e) {
			// nothing, most likely unknown profileString
		}
		
		return LITHO_PROFILE.UNKNOWN;
				
	}

	public String getLithoDocumentation(){
		
		return getLithoAnnotation(javadoc, "lithoDocumentation");
				
	}
	public String getLithoLabel(){
		
		return getLithoAnnotation(javadoc, "lithoLabel");
				
	}
	
	public List<FieldModel> fields;
	
	public static class FieldModel {
		
		public String fieldName;
		public String fieldType;
		public String fieldTypeBlobContent;
		public String javadoc;

		public String getLithoDocumentation(){
			
			return getLithoAnnotation(javadoc, "lithoDocumentation");
					
		}
		public String getLithoLabel(){
			
			return getLithoAnnotation(javadoc, "lithoLabel");
					
		}
			
	}
	
	public List<Relationship> relationships = new ArrayList<>();
	
	public static class Relationship {
		
		public String relationshipType;
        public String otherEntityName;
        public String otherEntityRelationshipName;
        public String relationshipName;
        public String otherEntityField;
        public String ownerSide;
		public String javadoc;
       
		public String getLithoDocumentation(){
			
			return getLithoAnnotation(javadoc, "lithoDocumentation");
					
		}
		public String getLithoLabel(){
			
			return getLithoAnnotation(javadoc, "lithoLabel");
					
		}
	}
	

	public static String getLithoAnnotation(String text, String javadocAnnotationName){
		System.out.println("huhu javadoc "+ text);
		if(text == null) {
			return "";
		}
		
		String fullRegex = "@"+javadocAnnotationName+".*\\[(.*)\\]";

		Pattern pattern = Pattern.compile(fullRegex);

		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			
			return matcher.group(1);
			
		}
		
		return "";

	}
	
}
