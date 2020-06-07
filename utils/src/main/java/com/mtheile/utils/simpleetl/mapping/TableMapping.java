package com.mtheile.utils.simpleetl.mapping;

import java.util.ArrayList;
import java.util.List;

import com.mtheile.utils.simpleetl.mapping.AttribMapping.MAPPING_TYPE;

public class TableMapping {

	private List<AttribMapping> attribMappings = new ArrayList<>();

	private String sourceTableName;
	private String targetTableName;

	public TableMapping(String sourceTableName, String targetTableName) {
		super();
		this.sourceTableName = sourceTableName;
		this.targetTableName = targetTableName;
	}

	public void addAttribMapping(String sourceAttrib, String targetAttrib, MAPPING_TYPE mappingType) {

		attribMappings.add(new AttribMapping(sourceAttrib, targetAttrib, mappingType));

	}

	public void addAttribMapping(String sourceAttrib, String targetAttrib, MAPPING_TYPE mappingType, boolean isPrimKey) {

		attribMappings.add(new AttribMapping(sourceAttrib, targetAttrib, mappingType, isPrimKey));

	}

	public int getAttribCount() {
		return attribMappings.size();
	}

	public AttribMapping getAttribMapping(int index) {
		return attribMappings.get(index);
	}

	public String getSourceTableName() {
		return sourceTableName;
	}

	public void setSourceTableName(String sourceTableName) {
		this.sourceTableName = sourceTableName;
	}

	public String getTargetTableName() {
		return targetTableName;
	}

	public void setTargetTableName(String targetTableName) {

		this.targetTableName = targetTableName;

	}

	public static String getSELECTAll(TableMapping tableMapping) {

		String selectAttribs = getSelectAttribs(tableMapping);

		return "SELECT " + selectAttribs + " FROM " + tableMapping.getSourceTableName();

	}

	public static String getSELECTById(TableMapping tableMapping, Object[] objects) {

		String selectAttribs = getSelectAttribs(tableMapping);

		return "SELECT " + selectAttribs + " FROM " + tableMapping.getSourceTableName() + " WHERE " + getWHEREById(tableMapping, objects);

	}

	public static String getDELETEById(TableMapping tableMapping, Object[] objects) {

		return "DELETE  FROM " + tableMapping.getSourceTableName() + " WHERE " + getWHEREById(tableMapping, objects);

	}

	private static String getWHEREById(TableMapping tableMapping, Object[] objects) {

		String result = "";

		for (int i = 0; i < tableMapping.getAttribCount(); i++) {
			AttribMapping attribMapping = tableMapping.getAttribMapping(i);
			if (attribMapping.isPrimKey()) {
				result += " AND " + attribMapping.getTargetAttribName() + " = " + attribMapping.toSQLString(objects[i]);
			}
		}

		return result.replaceFirst(" AND", "");

	}

	private static String getSelectAttribs(TableMapping tableMapping) {

		String result = "";

		for (int i = 0; i < tableMapping.getAttribCount(); i++) {

			result += SEPERATOR + tableMapping.getAttribMapping(i).getSourceAttribName();

		}

		return result.replaceFirst(SEPERATOR, "");

	}

	public static String getINSERT(TableMapping tableMapping, Object[] values) {

		assert (tableMapping.getAttribCount() == values.length);

		String insertAttribs = getInsertAttribs(tableMapping);
		String insertValues = getInsertValues(tableMapping, values);

		return "INSERT INTO " + tableMapping.targetTableName + " (" + insertAttribs + ") VALUES (" + insertValues + ")";
	}

	private static String getInsertValues(TableMapping tableMapping, Object[] values) {

		String result = "";

		for (int i = 0; i < values.length; i++) {

			result += SEPERATOR + tableMapping.getAttribMapping(i).toSQLString(values[i]);

		}

		return result.replaceFirst(SEPERATOR, "");

	}

	private static String getInsertAttribs(TableMapping tableMapping) {

		String result = "";

		for (int i = 0; i < tableMapping.getAttribCount(); i++) {

			result += SEPERATOR + tableMapping.getAttribMapping(i).getTargetAttribName();

		}

		return result.replaceFirst(SEPERATOR, "");

	}

	private static final String SEPERATOR = ", ";

}
