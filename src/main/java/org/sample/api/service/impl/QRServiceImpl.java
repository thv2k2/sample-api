package org.sample.api.service.impl;

import com.google.gson.Gson;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import lombok.RequiredArgsConstructor;
import org.sample.api.common.SampleCommon;
import org.sample.api.service.QRService;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QRServiceImpl implements QRService {
  @Override
  public byte[] generateQRCodeImage(String text) throws Exception {

    Optional<BitMatrix> formatWriter =
        Optional.of(
            new MultiFormatWriter()
                .encode(
                    text,
                    BarcodeFormat.QR_CODE,
                    SampleCommon.QrWith,
                    SampleCommon.QrHeight));
    BitMatrix bitMatrix = formatWriter.orElseThrow(() -> new Exception("Field to encode text"));

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);

    return outputStream.toByteArray();
  }
}
