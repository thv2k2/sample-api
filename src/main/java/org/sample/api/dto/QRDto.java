package org.sample.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class QRDto {

  @Getter
  @Setter
  @Builder
  public static class QRCodeRequest {
    private String text;
    private Integer with;
    private Integer height;
  }
}
