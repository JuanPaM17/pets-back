package com.spring.pets.config;

import org.json.JSONObject;

import jakarta.servlet.http.HttpServletResponse;

public class BaseController {

	public void writeResponse(JSONObject result, HttpServletResponse response) {
		try {
			response.setContentType("application/json");
			response.getWriter().write(result.toString());
		} catch (Exception e) {
		}
	}

}
