package com.beniregev.demos_and_tutorials.demos.apache_poi.service;

import com.beniregev.demos_and_tutorials.demos.apache_poi.model.Contact;
import com.beniregev.demos_and_tutorials.demos.apache_poi.model.InputResources;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class GenerateExcelXlsxFile {
    private String dataDirectory;
    private XSSFWorkbook workbook;
    private XSSFSheet activeSheet = null;
    private StringBuilder sheetName = null;

    public GenerateExcelXlsxFile(String dataDirectory) {
        this.dataDirectory = dataDirectory;
        //  Initialization: Create the workbook
        createNewWorkbook();
    }

    public XSSFWorkbook getWorkbook() {
        return this.workbook;
    }

    public void setWorkbook(XSSFWorkbook workbook) {
        this.workbook = workbook;
    }

    public void createNewWorkbook() {
        this.workbook = new XSSFWorkbook();
    }

    public String getDataDirectory() {
        return dataDirectory;
    }

    public void setDataDirectory(String dataDirectory) {
        this.dataDirectory = dataDirectory;
    }

    public StringBuilder getSheetName() {
        return sheetName;
    }

    public void setSheetName(StringBuilder sheetName) {
        this.sheetName = sheetName;
    }

    public XSSFSheet getActiveSheet() {
        return this.activeSheet;
    }

    public void createNewSheet(final String sheetName) {
        this.sheetName = new StringBuilder(sheetName);
        this.activeSheet = workbook.createSheet(sheetName);
    }

    /**
     * <div>
     *     <div>
     *         This method <b>is only an example</b> of how to populate and
     *         style a sheet in an Excel workbook.
     *     </div>
     *     <div>
     *         The data used to populate the sheet comes from {@link InputResources}
     *         singleton class. You can, of course, use your own method(s), your own
     *         data, and style(s). <b>This is only an example to demonstrate the class
     *         and its capabilities</b>.
     *     </div>
     * </div>
     */
    public void populateActiveSheetExample() {
        String[] columns = InputResources.INSTANCE.getColumns();
        List<Contact> contactList = InputResources.INSTANCE.getContacts();

        //  Set the Font for header row: Bold, Height 14px, Red
        Font headerFont = this.getWorkbook().createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        //  Create a CellStyle for the header row
        CellStyle headerCellStyle = this.getWorkbook().createCellStyle();
        headerCellStyle.setFont(headerFont);

        //  Create the header row
        Row headerRow = this.getActiveSheet().createRow(0);
        //  Create the columns of the header row from the columns[] array, and set the cell-style to `HeaderCellStyle` created and defined above
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        int rowNumber = 1;
        for (Contact contact : contactList) {
            //  For each Contact in the contacts List a row will be created and the cells populated with data from the Contact in the List
            Row row = this.getActiveSheet().createRow(rowNumber++);
            int cellNumber = 0;
            row.createCell(cellNumber++).setCellValue(contact.getFirstName());
            row.createCell(cellNumber++).setCellValue(contact.getLastName());
            row.createCell(cellNumber++).setCellValue(contact.getEmail());
            row.createCell(cellNumber).setCellValue(contact.getDateOfBirth());
        }

        //  Resize all columns of the sheet to fit the content size
        for (int i = 0; i < columns.length; i++) {
            this.getActiveSheet().autoSizeColumn(i);
        }
    }

    public void generateExcelFile(final String fileName) throws IOException {
        //  Write/output the result to a file (e.g., "./data/" + "Test_Data_Contacts.xlsx")
        FileOutputStream fileOut = new FileOutputStream(this.dataDirectory + fileName);
        this.getWorkbook().write(fileOut);
        //  Cleanup - Close the output file and the workbook
        fileOut.close();
    }

    public void closeWorkbook() throws IOException {
        this.getWorkbook().close();
    }

    public static void main(String[] args) throws IOException {
        GenerateExcelXlsxFile generator = new GenerateExcelXlsxFile("./data/");

        //  Create the sheet for Contacts
        generator.createNewSheet("contacts");

        //  EXAMPLE method to populating the active-sheet
        generator.populateActiveSheetExample();

        //  Write/output the result to a file
        generator.generateExcelFile("Test_Data_Contacts.xlsx");

        generator.closeWorkbook();
    }
}
