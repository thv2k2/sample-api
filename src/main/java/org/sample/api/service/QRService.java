package org.sample.api.service;

import org.sample.api.dto.QRDto;

public interface QRService {
  byte[] generateQRCodeImage(String text) throws Exception;
}
