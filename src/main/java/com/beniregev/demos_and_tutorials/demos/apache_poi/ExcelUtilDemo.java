package com.beniregev.demos_and_tutorials.demos.apache_poi;

import com.beniregev.demos_and_tutorials.demos.apache_poi.service.GenerateExcelXlsxFile;
import com.beniregev.demos_and_tutorials.demos.apache_poi.service.ReadExcelXlsxFile;

/**
 * <div>
 *     Demonstrate the usage of {@link GenerateExcelXlsxFile} and {@link ReadExcelXlsxFile}
 *     classes as Java Excel utility class.
 * </div>
 */
public class ExcelUtilDemo {
    public static void main(String[] args) {
        final int SHEET_INDEX = 0;
        final String EXCEL_FILE_NAME = "Test_Data_Contacts.xlsx";
        GenerateExcelXlsxFile generator = new GenerateExcelXlsxFile("./data/");
        ReadExcelXlsxFile reader = new ReadExcelXlsxFile(EXCEL_FILE_NAME, SHEET_INDEX);

    }
}
