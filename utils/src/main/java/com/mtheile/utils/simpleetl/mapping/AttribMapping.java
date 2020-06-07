package com.mtheile.utils.simpleetl.mapping;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AttribMapping {

	public enum MAPPING_TYPE {
		STRING, NUMBER, BOOLEAN, TIMESTAMP
	}

	private boolean isPrimKey = false;
	private MAPPING_TYPE mappingType;
	private String sourceAttribName;
	private String targetAttribName;

	protected AttribMapping(String sourceAttribName, String targetAttribName, MAPPING_TYPE mappingType) {
		super();
		this.sourceAttribName = sourceAttribName;
		this.targetAttribName = targetAttribName;
		this.mappingType = mappingType;
	}

	protected AttribMapping(String sourceAttribName, String targetAttribName, MAPPING_TYPE mappingType, boolean isPrimKey) {
		super();
		this.sourceAttribName = sourceAttribName;
		this.targetAttribName = targetAttribName;
		this.mappingType = mappingType;
		this.isPrimKey = isPrimKey;
	}

	public String toSQLString(Object obj) {

		if (obj == null) {
			return null;
		}

		if (MAPPING_TYPE.STRING.equals(mappingType)) {
			return "'" + obj.toString() + "'";
		}

		if (MAPPING_TYPE.NUMBER.equals(mappingType)) {
			return obj.toString();
		}

		if (MAPPING_TYPE.BOOLEAN.equals(mappingType)) {
			return obj.toString();
		}
		if (MAPPING_TYPE.TIMESTAMP.equals(mappingType)) {
			if (obj instanceof Timestamp) {

				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 2020-03-06 11:32:51
				return "'" + df.format(new Date((((Timestamp) obj).getTime()))) + "'";

			} else {
				throw new RuntimeException("obj needs to be of type Timestamp. It is " + obj.getClass().getName());
			}

		}

		throw new RuntimeException("mapping type not supported: " + mappingType);

	}

	public String getSourceAttribName() {
		return sourceAttribName;
	}

	public String getTargetAttribName() {
		return targetAttribName;
	}

	public boolean isPrimKey() {
		return isPrimKey;
	}

}