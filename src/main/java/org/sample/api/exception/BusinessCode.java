package org.sample.api.exception;

import lombok.Getter;

@Getter
public enum BusinessCode implements ErrorCode {
  //    ACCOUNT_NOT_FOUND("404_ACCOUNT_NOT_FOUND", "Account not found"),
  USERNAME_OR_PASSWORD_IS_INCORRECT(
      "400_USERNAME_OR_PASSWORD_IS_INCORRECT", "username or password not found"),
  ;

  private final String code;
  private final String desc;

  BusinessCode(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public String getServicePrefix() {
    return "BC";
  }
}
