package com.main.test.properties;

import java.util.List;

public class TemplateProperties {

    private boolean displayGrid;
    private Integer headerRowPosition;
    private Integer headerColumnPosition;
    private String sheetName;
    private List<String> headers;

    public boolean isDisplayGrid() {
        return displayGrid;
    }

    public void setDisplayGrid(boolean displayGrid) {
        this.displayGrid = displayGrid;
    }

    public Integer getHeaderRowPosition() {
        return headerRowPosition;
    }

    public void setHeaderRowPosition(Integer headerRowPosition) {
        this.headerRowPosition = headerRowPosition;
    }

    public Integer getHeaderColumnPosition() {
        return headerColumnPosition;
    }

    public void setHeaderColumnPosition(Integer headerColumnPosition) {
        this.headerColumnPosition = headerColumnPosition;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }
}
