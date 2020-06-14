package com.eStudent.http;

import java.util.HashMap;

public class Response {
    public final static int HTTP_OK = 200;
    public final static int HTTP_BAD_REQUEST = 400;
    public final static int HTTP_UNAUTHORIZED = 401;
    public final static int HTTP_PROXY_AUTHENTICATION_REQUIRED = 407;
    
    private int statusCode;
    private HashMap<String, Object> content;
    
    public Response() {}
    
	public Response(int statusCode, HashMap<String, Object> content) {
		super();
		this.statusCode = statusCode;
		this.content = content;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public HashMap<String, Object> getContent() {
		return content;
	}

	public void setContent(HashMap<String, Object> content) {
		this.content = content;
	}
}
