package com.project.healthcare.Supporter.exception_handler;

public class UnauthorizedException extends RuntimeException {
  public UnauthorizedException(String message) {
    super(message);
  }
}