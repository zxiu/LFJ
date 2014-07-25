package com.zhuoxiu.lfj.bean;

public class Parameter {
	String name = new String();
	String value = new String();
	String description = new String();

	public Parameter(String name, String description) {
		this.name = name;
		this.description = description;
	}
 
	public Parameter setValue(String value) {
		this.value = value;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public String toString() {
		return "&" + name + "=" + value;
	}

	public String toString(Parameter... parameters) {
		String result = new String();
		for (Parameter parameter : parameters) {
			result += parameter.toString();
		}
		return result;
	}
}
