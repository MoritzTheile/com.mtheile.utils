package com.mtheile.utils.simpleetl.util;

import javax.persistence.Transient;

public class WithCustomId {
	
	@Transient
	private Long customId;

	public Long getCustomId() {
		return customId;
	}

	public void setCustomId(Long customId) {
		this.customId = customId;
	}
	
}
