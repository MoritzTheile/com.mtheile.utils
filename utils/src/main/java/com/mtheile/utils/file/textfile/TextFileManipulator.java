package com.mtheile.utils.file.textfile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFileManipulator {

	public static void searchAndReplace(String regex, String replacement, File file) throws Exception {

		String textFromFile = fileToString(file);

		textFromFile = textFromFile.replaceAll(regex, replacement);

		if (file.exists()) {
			file.delete();
		}

		Path path = Paths.get(file.getPath());

		Files.write(path, textFromFile.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);

	}

	public static void deleteLinesMatching(String file, String regex) throws Exception {
		deleteLines(new File(file), regex);
	}

	public static void deleteLines(File file, String regex) throws Exception {
		replaceLines(file, regex, "");
	}

	public static void replaceLines(String file, String regex, String replacement) throws Exception {
		replaceLines(new File(file), regex, replacement);
	}

	public static void deleteSection(String file, String sectionStart, String sectionMarker, String sectionEnd) throws Exception {
		deleteSection(new File(file), sectionStart, sectionMarker, sectionEnd);
	}

	public static void deleteSection(File file, String sectionStart, String sectionMarker, String sectionEnd) throws Exception {

		replaceSection(file, sectionStart, sectionMarker, sectionEnd, "");

	}

	public static void replaceLines(File file, String regex, String replacement) throws Exception {
		// searchAndReplace("(?m)^.*" + regex + ".*$[\\r?\\n?]", replacement, file);
		searchAndReplace("(?m)^.*" + regex + ".*$[\\r]{0,1}[\\n]{0,1}", replacement, file);
	}

	public static void replaceSection(File file, String sectionStart, String sectionMarker, String sectionEnd, String replacement) throws Exception {

		String textFromFile = fileToString(file);

		// interesting: https://www.rexegg.com/regex-quantifiers.html
		String fullRegex = "(?s)" + Pattern.quote(sectionStart) + ".*?" + Pattern.quote(sectionEnd);

		Pattern pattern = Pattern.compile(fullRegex);

		Matcher matcher = pattern.matcher(textFromFile);

		while (matcher.find()) {

			String section = matcher.group();

			if (section.contains(sectionMarker)) {

				// in case section is followed by newline also delete new line
				textFromFile = textFromFile.replaceAll(Pattern.quote(section) + "[\\r]{0,1}[\\n]{0,1}", replacement);

				// in case section is not followed by newline
				textFromFile = textFromFile.replaceAll(Pattern.quote(section), replacement);

			}

		}

		Files.write(Paths.get(file.getPath()), textFromFile.getBytes(StandardCharsets.UTF_8));

	}

	private static String fileToString(File file) throws IOException {

		Path path = Paths.get(file.getPath());

		byte[] bytesFromFile = Files.readAllBytes(path);

		return new String(bytesFromFile, StandardCharsets.UTF_8);

	}

}
