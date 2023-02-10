package com.beniregev.demos_and_tutorials.demos.apache_poi.service;

import com.beniregev.demos_and_tutorials.demos.apache_poi.model.Contact;
import com.beniregev.demos_and_tutorials.demos.apache_poi.model.InputResources;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class GenerateExcelXlsxFile {
    public static void main(String[] args) throws IOException {
        String[] columns = InputResources.INSTANCE.getColumns();
        List<Contact> contactList = InputResources.INSTANCE.getContacts();

        //  Create the workbook
        Workbook workbook = new XSSFWorkbook();

        //  Create the sheet for Contacts
        Sheet sheet = workbook.createSheet("Contacts");

        //  Set the Font for header row: Bold, Height 14px, Red
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        //  Create a CellStyle for the header row
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        //  Create the header row
        Row headerRow = sheet.createRow(0);
        //  Create the columns of the header row from the columns[] array, and set the cell-style to `HeaderCellStyle` created and defined above
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        int rowNumber = 1;
        for (Contact contact : contactList) {
            //  For each Contact in the contacts List a row will be created and the cells populated with data from the Contact in the List
            Row row = sheet.createRow(rowNumber++);
            int cellNumber = 0;
            row.createCell(cellNumber++).setCellValue(contact.getFirstName());
            row.createCell(cellNumber++).setCellValue(contact.getLastName());
            row.createCell(cellNumber++).setCellValue(contact.getEmail());
            row.createCell(cellNumber).setCellValue(contact.getDateOfBirth());
        }

        //  Resize all columns of the sheet to fit the content size
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        //  Write/output the result to a file
        FileOutputStream fileOut = new FileOutputStream("./data/contacts.xlsx");
        workbook.write(fileOut);

        //  Cleanup - Close the output file and the workbook
        fileOut.close();
        workbook.close();

    }
}
