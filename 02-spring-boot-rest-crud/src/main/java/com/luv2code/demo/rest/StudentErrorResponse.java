package com.luv2code.demo.rest;

public class StudentErrorResponse {
  private int status;
  private long timestamp;
  private String message;


  public StudentErrorResponse() {}

  public StudentErrorResponse(int status, long timestamp, String message) {
    this.status = status;
    this.timestamp = timestamp;
    this.message = message;
  }

  public int getStatus() {
    return this.status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public long getTimestamp() {
    return this.timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
