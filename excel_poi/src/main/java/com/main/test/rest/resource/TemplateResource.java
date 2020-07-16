package com.main.test.rest.resource;

import com.main.test.rest.response.GenericErrorResponse;
import com.main.test.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class TemplateResource {

    @Autowired
    private TemplateService templateService;

    @GetMapping(value = "/templates/{id}")
    public void getTemplate(@PathVariable(name = "id") Long id, HttpServletResponse response) throws Exception {
        templateService.generateTemplate(id, response);
    }

    @ExceptionHandler
    private GenericErrorResponse handleException(Exception e) {
        return new GenericErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage());
    }
}
