package com.main.test.service;

import com.main.test.properties.TemplateProperties;
import com.main.test.resolver.ClientTemplateResolver;
import com.main.test.util.Header;
import com.main.test.util.ResponseUtils;
import com.main.test.util.TemplateUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Service("templateService")
public class TemplateService {

    private static final String template = "template." + XSSFWorkbookType.XLSX.getExtension();

    @Autowired
    private ClientTemplateResolver clientTemplateResolver;

    public void generateTemplate(Long id, HttpServletResponse response) throws IOException {
        TemplateProperties templateProperties = clientTemplateResolver.resolve(id);
        XSSFWorkbook workbook = TemplateUtils.generateWorkBook(templateProperties);

        Map<String, String> headers = ResponseUtils.generateHeaders(
                new Header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE),
                new Header(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%d_%s", id, template)));
        ResponseUtils.updateHeaders(headers, response);

        TemplateUtils.writeWorkbook(workbook, response.getOutputStream());
        response.flushBuffer();
    }
}
