package com.main.test.util;

import com.main.test.builder.WorkbookBuilder;
import com.main.test.properties.TemplateProperties;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;

public class TemplateUtils {

    public static XSSFWorkbook generateWorkBook(TemplateProperties properties) {
        return WorkbookBuilder.get()
                .withDisplayGrid(properties.isDisplayGrid())
                .withHeaderRowPosition(properties.getHeaderRowPosition())
                .withHeaderColumnPosition(properties.getHeaderColumnPosition())
                .withHeaderCellStyle(null) //todo - add cell style based on client if needed
                .withHeaders(properties.getHeaders())
                .withSheetName(properties.getSheetName())
                .build();
    }

    public static void writeWorkbook(XSSFWorkbook workbook, OutputStream outputStream) throws IOException {
        workbook.write(outputStream);
    }
}
