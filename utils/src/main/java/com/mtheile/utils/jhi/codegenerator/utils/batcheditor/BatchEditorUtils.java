package com.mtheile.utils.jhi.codegenerator.utils.batcheditor;

import com.mtheile.utils.jhi.codegenerator.model.EntityModel;
import com.mtheile.utils.jhi.codegenerator.model.EntityModel.FieldModel;

public class BatchEditorUtils {
	
	public static String DTONAME_TOKEN = "DTONAME_TOKEN";
	public static String CNAME_TOKEN = "CNAME_TOKEN";
	public static String GETSETPOSTFIX_TOKEN = "GETSETPOSTFIX_TOKEN";
	public static String DTOGETTER_TOKEN = "DTOGETTER_TOKEN";

	public static String getAdapterCode(EntityModel entityModel, FieldModel fieldModel) throws Exception {
		
		String dtoGetter = "";

			String cName = removeAdditionalText(fieldModel.fieldName);
			String getSetPostfix = capitalizeGetSetPostfix(removeAdditionalText(fieldModel.fieldName));
			String dtoName = entityModel.name+"DTO";
			
			if ("String".contentEquals(fieldModel.fieldType)) {
				return replaceTokens(adapterTemplateString, dtoName, cName, getSetPostfix, dtoGetter);

			} else if ("byte[]".contentEquals(fieldModel.fieldType) && "text".contentEquals(fieldModel.fieldTypeBlobContent)) {
				return replaceTokens(adapterTemplateString, dtoName, cName, getSetPostfix, dtoGetter);

			} else if ("Integer".contentEquals(fieldModel.fieldType)) {
				return replaceTokens(adapterTemplateInteger, dtoName, cName, getSetPostfix, dtoGetter);

			} else if ("Float".contentEquals(fieldModel.fieldType)) {
				return replaceTokens(adapterTemplateFloat, dtoName, cName, getSetPostfix, dtoGetter);

			} else if ("Boolean".contentEquals(fieldModel.fieldType)) {
				return replaceTokens(adapterTemplateBoolean, dtoName, cName, getSetPostfix, dtoGetter);

			}else {
				throw new Exception("Error: Field type '"+fieldModel.fieldType+"' not found.");

			}


	}

	private static String removeAdditionalText(String technName) {

		// splitting white spaces
		String[] splittedString = technName.split("\\s");

		return splittedString[0];

	}

	private static String capitalizeGetSetPostfix(String technName) throws Exception {

		if (technName.length() < 2) {
			throw new Exception("technName must have at least length 2 ('" + technName + "')");
		}

		String firstChar = technName.substring(0, 1);
		String secondChar = technName.substring(1, 2);
		String trailingChars = "";

		if (technName.length() > 2) {
			trailingChars = technName.substring(2, technName.length());
		}

		// case aaxxx => Aaxxx
		if (firstChar.toLowerCase().equals(firstChar) && secondChar.toLowerCase().equals(secondChar)) {
			return firstChar.toUpperCase() + secondChar + trailingChars;
		}

		// case Aaxxx => Aaxxx
		if (firstChar.toUpperCase().equals(firstChar) && secondChar.toLowerCase().equals(secondChar)) {
			return firstChar + secondChar + trailingChars;
		}

		// case aAxxx => aAxxx
		if (firstChar.toLowerCase().equals(firstChar) && secondChar.toUpperCase().equals(secondChar)) {
			return firstChar + secondChar + trailingChars;
		}

		// case AAxxx => aAxxx
		if (firstChar.toUpperCase().equals(firstChar) && secondChar.toUpperCase().equals(secondChar)) {
			return firstChar.toLowerCase() + secondChar + trailingChars;
		}

		return technName;
	}

	private static String replaceTokens(String template, String dtoName, String cName, String getSetPostfix, String dtoGetter) {

		template = template.replaceAll(DTONAME_TOKEN, dtoName);
		template = template.replaceAll(CNAME_TOKEN, cName);
		template = template.replaceAll(GETSETPOSTFIX_TOKEN, getSetPostfix);
		template = template.replaceAll(DTOGETTER_TOKEN, dtoGetter);

		return template;

	}

	private static String replaceTokenInRefCellAdapter(String dataType, String dtoName, String cName, String getSetPostfix, String dtoGetter) {

		String DTONAME_TOKEN = "DTONAME_TOKEN";
		String CNAME_TOKEN = "CNAME_TOKEN";
		String GETSETPOSTFIX_TOKEN = "GETSETPOSTFIX_TOKEN";
		String DTOGETTER_TOKEN = "DTOGETTER_TOKEN";
		String TABLENAME_TOKEN = "TABLENAME_TOKEN";

		String template = ""
				+ "addCellAdapter(new AbstractRefCellAdapter<" + DTONAME_TOKEN + ">(\"" + CNAME_TOKEN + "\", false, TABLE." + TABLENAME_TOKEN + ") {\r\n" +
				"\r\n" +
				"	@Override\r\n" +
				"	public Long getRefIdFromEntity(" + DTONAME_TOKEN + " entityDTO) {\r\n" +
				"		return entityDTO" + DTOGETTER_TOKEN + ".get" + GETSETPOSTFIX_TOKEN + "Id();\r\n" +
				"	}\r\n" +
				"\r\n" +
				"	@Override\r\n" +
				"	public String getRefNameFromEntity(" + DTONAME_TOKEN + " entityDTO) {\r\n" +
				"		return entityDTO" + DTOGETTER_TOKEN + ".get" + GETSETPOSTFIX_TOKEN + "Name();\r\n" +
				"	}\r\n" +
				"\r\n" +
				"	@Override\r\n" +
				"	public void setRefIdOnEntity(Long value, " + DTONAME_TOKEN + " entityDTO) {\r\n" +
				"		entityDTO" + DTOGETTER_TOKEN + ".set" + GETSETPOSTFIX_TOKEN + "Id(value);\r\n" +
				"	}\r\n" +
				"\r\n" +
				"});";

		template = template.replaceAll(TABLENAME_TOKEN, dataType);
		template = template.replaceAll(DTONAME_TOKEN, dtoName);
		template = template.replaceAll(CNAME_TOKEN, cName);
		template = template.replaceAll(GETSETPOSTFIX_TOKEN, getSetPostfix);
		template = template.replaceAll(DTOGETTER_TOKEN, dtoGetter);

		return template;

	}


	
	private static String adapterTemplateString = ""
			+ "addCellAdapter(new AbstractStringValueCellAdapter<" + DTONAME_TOKEN + ">(\"" + CNAME_TOKEN + "\", false) {\r\n" +
			"\r\n" +
			"			@Override\r\n" +
			"			public String getValueFromEntity(" + DTONAME_TOKEN + " entityDTO) {\r\n" +
			"				return entityDTO" + DTOGETTER_TOKEN + ".get" + GETSETPOSTFIX_TOKEN + "();\r\n" +
			"			}\r\n" +
			"\r\n" +
			"			@Override\r\n" +
			"			public void setValueOnEntity(String value, " + DTONAME_TOKEN + " entityDTO) {\r\n" +
			"				entityDTO" + DTOGETTER_TOKEN + ".set" + GETSETPOSTFIX_TOKEN + "(value);\r\n" +
			"			}\r\n" +
			"		});";

	private static String adapterTemplateInteger = ""
			+ "addCellAdapter(new AbstractIntegerValueCellAdapter<" + DTONAME_TOKEN + ">(\"" + CNAME_TOKEN + "\", false) {\r\n" +
			"\r\n" +
			"			@Override\r\n" +
			"			public Integer getValueFromEntity(" + DTONAME_TOKEN + " entityDTO) {\r\n" +
			"				return entityDTO" + DTOGETTER_TOKEN + ".get" + GETSETPOSTFIX_TOKEN + "();\r\n" +
			"			}\r\n" +
			"\r\n" +
			"			@Override\r\n" +
			"			public void setValueOnEntity(Integer value, " + DTONAME_TOKEN + " entityDTO) {\r\n" +
			"				entityDTO" + DTOGETTER_TOKEN + ".set" + GETSETPOSTFIX_TOKEN + "(value);\r\n" +
			"			}\r\n" +
			"		});";

	private static String adapterTemplateFloat = ""
			+ "addCellAdapter(new AbstractFloatValueCellAdapter<" + DTONAME_TOKEN + ">(\"" + CNAME_TOKEN + "\", false) {\r\n" +
			"\r\n" +
			"			@Override\r\n" +
			"			public Float getValueFromEntity(" + DTONAME_TOKEN + " entityDTO) {\r\n" +
			"				return entityDTO" + DTOGETTER_TOKEN + ".get" + GETSETPOSTFIX_TOKEN + "();\r\n" +
			"			}\r\n" +
			"\r\n" +
			"			@Override\r\n" +
			"			public void setValueOnEntity(Float value, " + DTONAME_TOKEN + " entityDTO) {\r\n" +
			"				entityDTO" + DTOGETTER_TOKEN + ".set" + GETSETPOSTFIX_TOKEN + "(value);\r\n" +
			"			}\r\n" +
			"		});";

	private static String adapterTemplateBoolean = ""
			+ "addCellAdapter(new AbstractBooleanValueCellAdapter<" + DTONAME_TOKEN + ">(\"" + CNAME_TOKEN + "\", false) {\r\n" +
			"\r\n" +
			"			@Override\r\n" +
			"			public Boolean getValueFromEntity(" + DTONAME_TOKEN + " entityDTO) {\r\n" +
			"				return entityDTO" + DTOGETTER_TOKEN + ".get" + GETSETPOSTFIX_TOKEN + "();\r\n" +
			"			}\r\n" +
			"\r\n" +
			"			@Override\r\n" +
			"			public void setValueOnEntity(Boolean value, " + DTONAME_TOKEN + " entityDTO) {\r\n" +
			"				entityDTO" + DTOGETTER_TOKEN + ".set" + GETSETPOSTFIX_TOKEN + "(value);\r\n" +
			"			}\r\n" +
			"		});";

}
