package com.mtheile.utils.fileprocessor;

import java.io.BufferedReader;
import java.io.StringReader;

public class FileProcessor {

	public static void main(String args[]) throws Exception {
		//System.out.println(surroundDigitsWithUnderscores("aaaa234bbbb2857cccc"));
		//System.out.println("aaaa234bbbb2857cccc".replaceAll("\\w(\\d+)\\w", "_$1_"));

		BufferedReader bufferedReader = new BufferedReader(new StringReader(fieldsAsTSV()));

		try {

			for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
				line = line.trim();
				String technName = removeAdditionalText(line);
				//System.out.println(camelToSnake(technName).replaceAll("\\w(\\d+)\\w", "_$1_"));
				System.out.println(upperUnderscoreWithAcronyms(line));
			}

		} finally {

			bufferedReader.close();

		}

	}

	private static String upperUnderscoreWithAcronyms(String name) {
		final StringBuilder result = new StringBuilder();

		boolean lastUppercase = false;

		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			char lastEntry = i == 0 ? 'X' : result.charAt(result.length() - 1);
			if (ch == ' ' || ch == '_' || ch == '-' || ch == '.') {
				lastUppercase = false;

				if (lastEntry == '_') {
					continue;
				} else {
					ch = '_';
				}
			} else if (Character.isUpperCase(ch)) {
				ch = Character.toLowerCase(ch);
				// is start?
				if (i > 0) {
					if (lastUppercase) {
						// test if end of acronym
						if (i + 1 < name.length()) {
							char next = name.charAt(i + 1);
							if (!Character.isUpperCase(next) && Character.isAlphabetic(next)) {
								// end of acronym
								if (lastEntry != '_') {
									result.append('_');
								}
							}
						}
					} else {
						// last was lowercase, insert _
						if (lastEntry != '_') {
							result.append('_');
						}
					}
				}
				lastUppercase = true;
			} else {
				lastUppercase = false;
			}

			result.append(ch);
		}
		return result.toString();
	}

	public static String camelToSnake(String str) {

		// Empty String
		String result = "";

		// Append first character(in lower case)
		// to result string
		char c = str.charAt(0);
		result = result + Character.toLowerCase(c);

		// Traverse the string from
		// ist index to last index
		for (int i = 1; i < str.length(); i++) {

			char ch = str.charAt(i);

			// Check if the character is upper case
			// then append '_' and such character
			// (in lower case) to result string
			if (Character.isUpperCase(ch)) {
				result = result + '_';
				result = result
						+ Character.toLowerCase(ch);
			}

			// If the character is lower case then
			// add such character into result string
			else {
				result = result + ch;
			}
		}

		// return the result
		return result;
	}

	private static String removeAdditionalText(String technName) {

		// splitting white spaces
		String[] splittedString = technName.split("\\s");

		return splittedString[0];

	}

	private static String fieldsAsTSV() {
		return "sampleID\r\n" +
				"igsn\r\n" +
				"laboratory\r\n" +
				"analyst\r\n" +
				"analysisDate\r\n" +
				"analysisTime\r\n" +
				"literature\r\n" +
				"mineral\r\n" +
				"mountID\r\n" +
				"datasetID\r\n" +
				"referenceMaterial\r\n" +
				"numAliquots\r\n" +
				"grainDimensionEquations\r\n" +
				"alphaStopDistRef\r\n" +
				"ftEquation\r\n" +
				"rSVequation\r\n" +
				"rFTequation\r\n" +
				"eUEquation\r\n" +
				"heAgeEquation\r\n" +
				"correctedHeAgeMethod\r\n" +
				"uncertaintyComment\r\n" +
				"meanUncorrectedHeAge\r\n" +
				"meanUncorrectedHeAgeError\r\n" +
				"meanUncorrectedHeAgeErrorType\r\n" +
				"weightedMeanUncorrectedHeAge\r\n" +
				"weightedMeanUncorrectedHeAgeError\r\n" +
				"weightedMeanUncorrectedHeAgeErrorType\r\n" +
				"mswdUncorrected\r\n" +
				"confidenceInterval95Uncorrected\r\n" +
				"chi2pctUncorrected\r\n" +
				"iqrUncorrected\r\n" +
				"meanCorrectedHeAge\r\n" +
				"meanCorrectedHeAgeError\r\n" +
				"meanCorrectedHeAgeErrorType\r\n" +
				"weightedMeanCorrectedHeAge\r\n" +
				"weightedMeanCorrectedHeAgeError\r\n" +
				"weightedMeanCorrectedHeAgeErrorType\r\n" +
				"mswdCorrected\r\n" +
				"confidenceInterval95Corrected\r\n" +
				"chi2pctCorrected\r\n" +
				"iqrCorrected\r\n" +
				"comment\r\n" +
				"pitMeasuringTechnique\r\n" +
				"pitVolumeSoftware\r\n" +
				"insituHeTechnique\r\n" +
				"insituParentTechnique";
	}

}
