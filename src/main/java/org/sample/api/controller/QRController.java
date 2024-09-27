package org.sample.api.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.sample.api.service.QRService;

@RestController
@RequestMapping("/api/v1/qr-code")
@RequiredArgsConstructor
public class QRController {

  private final QRService qrService;

  @GetMapping("/generate")
  public ResponseEntity<byte[]> generateQRCode(@RequestBody String text) {
    try {
      return ResponseEntity.ok()
          .contentType(MediaType.IMAGE_PNG)
          .body(qrService.generateQRCodeImage(text));
    } catch (Exception e) {
      return null;
    }
  }
}
