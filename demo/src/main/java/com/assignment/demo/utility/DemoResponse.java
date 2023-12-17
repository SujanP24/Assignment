package com.assignment.demo.utility;

import java.util.List;

public class DemoResponse {
	private Integer statusCode;
	private String status;
	private String message;
	private List<?> result;
	private String url;

	public DemoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DemoResponse(Integer statusCode, String status, String message, List<?> result, 
			String url) {
		super();
		this.statusCode = statusCode;
		this.status = status;
		this.message = message;
		this.result = result;
		this.url = url;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<?> getResult() {
		return result;
	}

	public void setResult(List<?> result) {
		this.result = result;
	}



	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
