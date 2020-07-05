package com.eStudent.http;

import java.util.HashMap;

import com.eStudent.FrontController.FrontController;
import com.eStudent.domain.User;
import com.eStudent.validators.Validator;

public class Request {
  public final static String METHOD_GET = "GET";
  public final static String METHOD_POST = "POST";
  public final static String METHOD_PUT = "PUT";
  public final static String METHOD_DELETE = "DELETE";

  private final String method;
  private final String endpoint;
  private String resource;
  private User session;
  /*
   * {
   *  data: {}
   * }
   */
  private HashMap<String, Object> content;

  public Request(String method, String endpoint, User session) {
    this.method = method;
    this.endpoint = endpoint;
    this.session = session;
  }

  public Request(String method, String endpoint, HashMap<String, Object> content) {
    this.method = method;
    this.endpoint = endpoint;
    this.content = content;
  }

  public Request(String method, String endpoint, User session, HashMap<String, Object> content) {
    this.method = method;
    this.endpoint = endpoint;
    this.session = session;
    this.content = content;
  }

  public String getResource() {
    return resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

  public User getSession() {
    return session;
  }

  public void setSession(User session) {
    this.session = session;
  }

  public HashMap<String, Object> getContent() {
    return content;
  }

  public void setContent(HashMap<String, Object> content) {
    this.content = content;
  }

  public String getMethod() {
    return method;
  }

  public String getEndpoint() {
    return endpoint;
  }

  public boolean validate(HashMap<String, Object> rules) {
    Validator validator = new Validator(rules, this.content);
    validator.validate();
    if (validator.getMessages().isEmpty()) return true;
    else {
      this.content = validator.getMessages();
      return false;
    }
  }
}
