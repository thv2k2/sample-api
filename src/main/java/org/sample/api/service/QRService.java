package org.sample.api.service;

public interface QRService {
  byte[] generateQRCodeImage(String text) throws Exception;
}
