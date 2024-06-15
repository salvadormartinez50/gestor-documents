package org.documents.service.impl;


import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.documents.dtos.GenericAnswer;

import org.springframework.stereotype.Service;

import io.quarkus.logging.Log;

import jakarta.ws.rs.WebApplicationException;

import org.documents.service.DocumentService;

import static io.smallrye.config._private.ConfigLogging.log;

@Service
public class DocumentServiceImpl implements DocumentService {

    public GenericAnswer fileUpLoad(InputStream file, String cve) {
        log.info("user " + cve);
        StringBuilder merchants = new StringBuilder();
        merchants.append("'");
        try {

            Workbook workbook = new XSSFWorkbook(file);
            int sheetsNumber = workbook.getNumberOfSheets();
            Log.info("sheetsNumber" + sheetsNumber);

            Sheet firstSheet = workbook.getSheetAt(0);

            for (Row row : firstSheet) {
                if (row.getRowNum() > 0) {
                    if (row.getCell(0) == null) {
                        break;
                    }

                    merchants.append(row.getCell(0).getStringCellValue() + "', '");

                }
            }

        } catch (IOException e) {
            throw new WebApplicationException("Error processing Excel file", e);
        }
        String str = merchants.toString();
        Log.info("merchants " + merchants);
        Log.info("str " + str);
        return new GenericAnswer("200", "success");
    }




}
