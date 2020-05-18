package com.app.staycomida.admin.func;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

public class AdminCommon {
	
	private HttpServletRequest request;
	
	public AdminCommon() {}
	public AdminCommon(HttpServletRequest request) {
		this.request = request;
	}
	
	@SuppressWarnings("deprecation")
	public String getRedirectUrl() {
		String currentUrl = this.request.getRequestURI().toString() + (this.request.getQueryString() == null ? "" : "?" + this.request.getQueryString().toString());
		String redirectUrl = URLEncoder.encode(currentUrl);
		return redirectUrl;
	}
}
