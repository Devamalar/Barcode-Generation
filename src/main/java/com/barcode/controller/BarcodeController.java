package com.barcode.controller;

import com.barcode.service.BarcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.image.BufferedImage;

@Controller
@RequestMapping(value = "/barcode", produces = MediaType.IMAGE_PNG_VALUE)
public class BarcodeController {

    @Autowired
    private BarcodeService barcodeService;

    @GetMapping(value = "/qrcode/{barcodeText}")
    @ResponseBody
    public ResponseEntity<BufferedImage> qrCode(@PathVariable("barcodeText") String barcodeText) {
        return ResponseEntity.ok(barcodeService.generateQRCodeImage(barcodeText));
    }

    @GetMapping(value = "/ean13/{barcodeText}")
    @ResponseBody
    public ResponseEntity<BufferedImage> ean13Code(@PathVariable("barcodeText") String barcodeText) {
        return ResponseEntity.ok(barcodeService.generateEAN13BarcodeImage(barcodeText));
    }

    @GetMapping(value = "/code128/{barcodeText}")
    @ResponseBody
    public ResponseEntity<BufferedImage> code128(@PathVariable("barcodeText") String barcodeText) {
        return ResponseEntity.ok(barcodeService.generateCode128BarcodeImage(barcodeText));
    }

    @GetMapping(value = "/code39/{barcodeText}")
    @ResponseBody
    public ResponseEntity<BufferedImage> code39(@PathVariable("barcodeText") String barcodeText) {
        return ResponseEntity.ok(barcodeService.generateCode39BarcodeImage(barcodeText));
    }

    @GetMapping(value = "/code93/{barcodeText}")
    @ResponseBody
    public ResponseEntity<BufferedImage> code93(@PathVariable("barcodeText") String barcodeText) {
        return ResponseEntity.ok(barcodeService.generateCode93BarcodeImage(barcodeText));
    }
}
