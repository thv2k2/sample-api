package org.sample.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/convert")
public class ConvertController {

  @PostMapping("/htmlToPdf")
  public ResponseEntity<Boolean> convertHtmlToPDF() {
    try {
      return ResponseEntity.ok(true);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(false);
    }
  }
}
