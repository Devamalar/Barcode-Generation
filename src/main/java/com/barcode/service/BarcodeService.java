package com.barcode.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.oned.Code93Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class BarcodeService {

    public BufferedImage generateQRCodeImage(String barcodeText) {
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix =
                null;
        try {
            bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 200, 200);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    public BufferedImage generateEAN13BarcodeImage(String barcodeText) {
        EAN13Writer barcodeWriter = new EAN13Writer();
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.EAN_13, 300, 150);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    public BufferedImage generateCode128BarcodeImage(String barcodeText) {
        Code128Writer barcodeWriter = new Code128Writer();
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.CODE_128, 300, 150);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    public BufferedImage generateCode39BarcodeImage(String barcodeText) {
        Code39Writer barcodeWriter = new Code39Writer();
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.CODE_39, 300, 150);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    public BufferedImage generateCode93BarcodeImage(String barcodeText) {
        Code93Writer barcodeWriter = new Code93Writer();
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.CODE_93, 300, 150);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}
