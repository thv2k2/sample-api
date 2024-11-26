package org.sample.api.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
  private final String errorCode;
  private final String errorMsg;

  public BusinessException(BusinessCode error) {
    super(error.getDesc());
    this.errorCode = error.getCode();
    this.errorMsg = error.getDesc();
  }
}
