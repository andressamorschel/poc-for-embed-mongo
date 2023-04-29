package com.demo.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SheetService {

    public Workbook createSheet() {
        var workbook = getWorkbook();
        var sheet = workbook.createSheet();
        createHeader(sheet);
        autoSizeColumns(sheet);
        blockHeader(workbook);

        return workbook;
    }

    public void blockHeader(Workbook workbook) {
//        if(y==0) {
//            unlockedCellStyle.setLocked(true);
//            sheet.lockFormatCells(true);
//            sheet.enableLocking();
//        }else {
//            unlockedCellStyle.setLocked(false);
//            sheet.lockFormatCells(false);
//            sheet.enableLocking();
//        }
//        cell.setCellStyle(unlockedCellStyle);
        CellStyle unlockedCellStyle = workbook.createCellStyle();
        unlockedCellStyle.setLocked(false);

        Sheet sheet = workbook.createSheet();
        sheet.protectSheet("password");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("TEST");
        cell.setCellStyle(unlockedCellStyle);
    }


    public Workbook getWorkbook() {
        return new XSSFWorkbook();
    }

    public void createHeader(Sheet sheet) {
        sheet.createRow(0);
        sheet.getRow(0).createCell(0).setCellValue("Cell 1");
        sheet.getRow(0).createCell(1).setCellValue("Cell 2");
        sheet.getRow(0).createCell(2).setCellValue("Cell 3");
    }

    private void autoSizeColumns(Sheet sheet) {
        short lastCellNum = sheet.getRow(0).getLastCellNum();
        for (int i = 0; i <= lastCellNum; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    //    private InputStreamResource toStreamResource(final Workbook workbook) {
//        return new InputStreamResource(toStream(workbook));
//    }
//
    public InputStream toStream(final Workbook workbook) {
        var stream = new ByteArrayOutputStream();
        try {
            workbook.write(stream);
        } catch (IOException e) {
            System.out.println("deu ruim");
        }

        return new ByteArrayInputStream(stream.toByteArray());
    }
}
