package com.mtheile.utils.batcheditor;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class AdapterGenerator {
	public static String DTONAME_TOKEN = "DTONAME_TOKEN";
	public static String CNAME_TOKEN = "CNAME_TOKEN";
	public static String GETSETPOSTFIX_TOKEN = "GETSETPOSTFIX_TOKEN";
	public static String DTOGETTER_TOKEN = "DTOGETTER_TOKEN";

	public static void main(String args[]) throws Exception {

		String dtoName = "HeDataPointLithoDTO";
		String dtoGetter = "\\.getHeDataPointDTO()";

		for (Field field : getFields()) {

			String cName = removeAdditionalText(field.technName);
			String getSetPostfix = capitalizeGetSetPostfix(removeAdditionalText(field.technName));

			if ("String".contentEquals(field.datatype)) {
				String string = replaceTokens(adapterTemplateString, dtoName, cName, getSetPostfix, dtoGetter);
				System.out.println(string);
			} else if ("Integer".contentEquals(field.datatype)) {
				String string = replaceTokens(adapterTemplateInteger, dtoName, cName, getSetPostfix, dtoGetter);
				System.out.println(string);
			} else if ("Float".contentEquals(field.datatype)) {
				String string = replaceTokens(adapterTemplateFloat, dtoName, cName, getSetPostfix, dtoGetter);
				System.out.println(string);
			} else if ("Boolean".contentEquals(field.datatype)) {
				String string = replaceTokens(adapterTemplateBoolean, dtoName, cName, getSetPostfix, dtoGetter);
				System.out.println(string);
			} else {
				String string = replaceTokenInRefCellAdapter(field.datatype, dtoName, cName, getSetPostfix, dtoGetter);
				System.out.println(string);
			}
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

	static class Field {

		public Field(String techName, String datatype) {
			this.technName = techName;
			this.datatype = datatype;
		}

		String technName;
		String datatype;
	}

	private static List<Field> getFields() throws Exception {

		List<Field> list = new ArrayList<>();

		BufferedReader bufferedReader = new BufferedReader(new StringReader(fieldsAsTSV()));

		try {

			for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {

				line = line.trim();

				String[] columns = line.split("\\t");

				if (columns.length != 2) {

					throw new Exception("line '" + line + "' does not have 2 columns");

				}

				list.add(new Field(columns[0], columns[1]));

			}

		} finally {
			bufferedReader.close();
		}

		return list;

	}

	private static String fieldsAsTSV() {
		return ""
				+ "mineral	Material\r\n" +
				"mountID	String\r\n" +
				"datasetID	String\r\n" +
				"referenceMaterial	ReferenceMaterial (shared across models)\r\n" +
				"numAliquots	Integer\r\n" +
				"grainDimensionEquations	LHeGrainDimensionEq\r\n" +
				"alphaStopDistRef	LHeAlphaStopDistRef\r\n" +
				"ftEquation	LHeFTEquation\r\n" +
				"rSVequation	LHeRSVEq\r\n" +
				"rFTequation	LHeRFTEq\r\n" +
				"eUEquation	LHeeUEquation\r\n" +
				"heAgeEquation	LHeAgeEquation\r\n" +
				"correctedHeAgeMethod	LHeCorrectedAgeMethod\r\n" +
				"uncertaintyComment	TextBlob\r\n" +
				"meanUncorrectedHeAge	Float\r\n" +
				"meanUncorrectedHeAgeError	Float\r\n" +
				"meanUncorrectedHeAgeErrorType	LErrorType\r\n" +
				"weightedMeanUncorrectedHeAge	Float\r\n" +
				"weightedMeanUncorrectedHeAgeError	Float\r\n" +
				"weightedMeanUncorrectedHeAgeErrorType	LErrorType\r\n" +
				"mswdUncorrected	Float\r\n" +
				"confidenceInterval95Uncorrected	Float\r\n" +
				"chi2pctUncorrected	Float\r\n" +
				"iqrUncorrected	Float\r\n" +
				"meanCorrectedHeAge	Float\r\n" +
				"meanCorrectedHeAgeError	Float\r\n" +
				"meanCorrectedHeAgeErrorType	LErrorType\r\n" +
				"weightedMeanCorrectedHeAge	Float\r\n" +
				"weightedMeanCorrectedHeAgeError	Float\r\n" +
				"weightedMeanCorrectedHeAgeErrorType	LErrorType\r\n" +
				"mswdCorrected	Float\r\n" +
				"confidenceInterval95Corrected	Float\r\n" +
				"chi2pctCorrected	Float\r\n" +
				"iqrCorrected	Float\r\n" +
				"comment	TextBlob\r\n" +
				"pitMeasuringTechnique	LHePitMeasuringTechnique\r\n" +
				"pitVolumeSoftware	LHePitVolumeSoftware\r\n" +
				"insituHeTechnique	LHeInSituMeasurementTechnique\r\n" +
				"insituParentTechnique	LParentInSituMeasurementTechnique"

				//				+ "geochemAnalyticalType	LGCAnalyticalTechnique\r\n" +
				//				"dataReductionSoftware	LDataReductionSoftware\r\n" +
				//				"analyticalSessionID	String\r\n" +
				//				"mountID	String\r\n" +
				//				"analysisScale	LGCAnalysisScale\r\n" +
				//				"mineral	Material (filtered for mineral)\r\n" +
				//				"referenceMaterial	ReferenceMaterial (shared across models)\r\n" +
				//				"oxideErrorType	LErrorType\r\n" +
				//				"elementErrorType	LErrorType"

				//				+ "mountIDCount	String\r\n" +
				//				"analyticalSessionID	String\r\n" +
				//				"mountIDLength	String\r\n" +
				//				"ftCharacterisationMethod	LFTCharacterisationMethod \r\n" +
				//				"ftUDeterminationTechnique	LFTUDeterminationTechnique\r\n" +
				//				"noOfGrains	Integer\r\n" +
				//				"area	Float\r\n" +
				//				"rhod	Float\r\n" +
				//				"nd	Integer\r\n" +
				//				"rhoS	Float\r\n" +
				//				"ns	Integer\r\n" +
				//				"rhoi	Float\r\n" +
				//				"ni	Integer\r\n" +
				//				"dosimeter	LDosimeter\r\n" +
				//				"uCont	Float\r\n" +
				//				"uStandardError	Float\r\n" +
				//				"dPar	Float\r\n" +
				//				"dParStandardError	Float\r\n" +
				//				"dPer	Float\r\n" +
				//				"dPerStandardError	Float\r\n" +
				//				"rmr0	Float\r\n" +
				//				"rmr0StandardError	Float\r\n" +
				//				"kParameter	Float\r\n" +
				//				"kParameterStandardError	Float\r\n" +
				//				"rmr0Equation	LRmr0Equation\r\n" +
				//				"chi2pct	Float\r\n" +
				//				"dispersion	Float\r\n" +
				//				"ftAgeType	LFTAgeType\r\n" +
				//				"ftAgeEquation	LFTAgeEquation\r\n" +
				//				"meanAgeMa	Float\r\n" +
				//				"meanErrorMa	Float\r\n" +
				//				"centralAgeMa	Float\r\n" +
				//				"centralErrorMa	Float\r\n" +
				//				"pooledAgeMa	Float\r\n" +
				//				"pooledErrorMa	Float\r\n" +
				//				"popAgeMa	Float\r\n" +
				//				"popErrorMa	Float\r\n" +
				//				"ageComment	String\r\n" +
				//				"ageErrorType	LErrorType\r\n" +
				//				"mtl	Float\r\n" +
				//				"mtl1se	Float\r\n" +
				//				"nTracks	Integer\r\n" +
				//				"stdDevMu	Float\r\n" +
				//				"etchant	LEtchant\r\n" +
				//				"etchingTime	Float\r\n" +
				//				"etchingTemp	Float\r\n" +
				//				"zetaCalibration	Float\r\n" +
				//				"zetaError	Float\r\n" +
				//				"zetaErrorType	LErrorType\r\n" +
				//				"range (ok, instead of r?)	Float\r\n" +
				//				"lambda	LLambda\r\n" +
				//				"lambdaF	LLambdaF\r\n" +
				//				"qEfficiencyFactor	Float\r\n" +
				//				"irradiationReactor	IrradiationReactor\r\n" +
				//				"comment	Text\r\n" +
				//				"neutronDose	Integer\r\n" +
				//				"uCaRatio	Float\r\n" +
				//				"uCaRatioError	Float\r\n" +
				//				"dParNumTotal	Integer\r\n" +
				//				"dPerNumTotal	Integer\r\n" +
				//				"ftAnalyticalSoftware	LFTAnalyticalSoftware\r\n" +
				//				"ftAnalyticalAlgorithm	LFTAnalyticalAlgorithm\r\n" +
				//				"cfIrradiation	boolean"
				+ "";
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
