package com.spring.pets.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String resource_name;
	private String fieldName;
	private String fieldValue;

	public ResourceNotFound(String resource_name, String fieldName, String fieldValue) {
		super(String.format("%s not found : %s : %s", resource_name, fieldName, fieldValue));
		this.resource_name = resource_name;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getResource_name() {
		return resource_name;
	}

	public void setResource_name(String resource_name) {
		this.resource_name = resource_name;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ResourceNotFound [resource_name=" + resource_name + ", fieldName=" + fieldName + ", fieldValue="
				+ fieldValue + "]";
	}

}
