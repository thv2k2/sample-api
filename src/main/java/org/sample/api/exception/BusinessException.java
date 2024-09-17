package org.sample.api.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessException extends RuntimeException {
  private final String errorCode;
  private final String errorMsg;

  public BusinessException(ErrorCode error) {
    this.errorCode = error.getServiceErrorCode();
    this.errorMsg = error.getDesc();
  }
}
