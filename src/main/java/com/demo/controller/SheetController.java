package com.demo.controller;

import com.demo.service.SheetService;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/sheet")
public class SheetController {

    private final SheetService sheetService;

    @GetMapping
    @ResponseBody
    public byte[] getSheet() throws IOException {
        var workbook = sheetService.createSheet();
        var outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        return outputStream.toByteArray();
    }

}
