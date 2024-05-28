package com.neurogine.adminportal.enumeration;

public enum Category {
	MINIMARKET("Minimarket"), SUPERMARKET("Supermarket"), CONVENIENCE_STORE("Convenience Store"), PHARMACY("Pharmacy"),
	LIQUOR_STORE("Liquor Store");

	private String name;

	private Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
