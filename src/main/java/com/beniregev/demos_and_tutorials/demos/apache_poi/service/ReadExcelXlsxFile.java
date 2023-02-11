package com.beniregev.demos_and_tutorials.demos.apache_poi.service;

import com.beniregev.demos_and_tutorials.demos.apache_poi.model.InputResources;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ReadExcelXlsxFile {
    private final int SHEET_INDEX;
    private final String EXCEL_FILE_NAME;
    private final DataFormatter dataFormatter = new DataFormatter();
    private XSSFWorkbook workbook = null;
    private XSSFSheet xssfSheet;

    //  region constructors
    public ReadExcelXlsxFile() {
        this.EXCEL_FILE_NAME = "Test_Data_Contacts.xlsx";
        this.SHEET_INDEX = 0;
        try {
            this.workbook = new XSSFWorkbook(InputResources.EXCEL_FILE_PATH + EXCEL_FILE_NAME);
            this.xssfSheet = workbook.getSheet(workbook.getSheetName(0));  // get teh first sheet, index start from 0
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ReadExcelXlsxFile(String EXCEL_FILE_NAME, int sheetIndex) {
        this.EXCEL_FILE_NAME = EXCEL_FILE_NAME;
        this.SHEET_INDEX = sheetIndex;
        try {
            workbook = new XSSFWorkbook(InputResources.EXCEL_FILE_PATH + EXCEL_FILE_NAME);
            xssfSheet = workbook.getSheet(workbook.getSheetName(this.SHEET_INDEX));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //  endregion default constructor

    //  region Getters and Setters
    public int getSheetCount() {
        return workbook.getNumberOfSheets();
    }

    public DataFormatter getDataFormatter() {
        return this.dataFormatter;
    }

    public int getSHEET_INDEX() {
        return this.SHEET_INDEX;
    }

    public XSSFSheet getXssfSheet() {
        return this.xssfSheet;
    }
    //  endregion Getters and Setters

    public XSSFSheet getSheetByIndex(final int sheetIndex) {
        return workbook.getSheet(workbook.getSheetName(sheetIndex));
    }

    /**
     * Get physical number of rows in the Sheet that was used in the constructor
     * @return Number of physical rows in the sheet
     */
    public int getSheetRowCount() {
        return xssfSheet.getPhysicalNumberOfRows();
    }

    public int getSheetRowCount(final int sheetIndex) {
        XSSFSheet sheet = getSheetByIndex(sheetIndex);  // get teh first sheet, index start from 0
        return sheet.getPhysicalNumberOfRows();
    }

    /**
     * Get physical number of cells in the requested row in the sheet
     * that was used in the constructor
     * @param rowNum the row-number to get its number of physical cells
     * @return Number of physical cells in the row of the sheet
     */
    public int getSheetRowCellCount(final int rowNum) {
        return xssfSheet.getRow(rowNum).getPhysicalNumberOfCells();
    }

    public int getSheetRowCellCount(final int sheetIndex, final int rowNum) {
        XSSFSheet sheet = workbook.getSheet(workbook.getSheetName(sheetIndex));  // get teh first sheet, index start from 0
        return sheet.getRow(rowNum).getPhysicalNumberOfCells();
    }

    public void getRowCellsStringValues(final int rowNum) {
        getRowCellsStringValues(SHEET_INDEX, rowNum);
    }

    /**
     * [ _NONE, NUMERIC, STRING, FORMULA, BLANK, BOOLEAN, ERROR ]
     * Scan the cells of the given {@code row} in the given {@code sheet}
     * and print the content of each cell according to its type.
     */
    public void getRowCellsStringValues(final int sheetIndex, final int rowNum) {
        final XSSFRow row = this.getSheetByIndex(sheetIndex).getRow(rowNum);
        final int numberOfCells = row.getPhysicalNumberOfCells();
        System.out.printf("Sheet index %d, row number %d%n", sheetIndex, rowNum);
        for (int i = 0; i < numberOfCells; i++) {
            final XSSFCell cell = row.getCell(i);
            final String cellTypeName = cell.getCellType().name();
            switch (cellTypeName) {
                case "_NONE":
                    System.out.printf("\t %s value = \"_NONE\"%n", cellTypeName);
                    break;
                case "NUMERIC": {
                    System.out.printf("\t%s value = %d%n", cellTypeName, cell.getNumericCellValue());
                    break;
                }
                case "STRING": {
                    System.out.printf("\t%s value = %s%n", cellTypeName, cell.getStringCellValue());
                    break;
                }
                case "FORMULA": {
                    System.out.printf("\t%s value = %s%n", cellTypeName, cell.getCellFormula());
                    break;
                }
                case "BLANK": {
                    System.out.printf("\t %s value = \"\"%n", cellTypeName);
                    break;
                }
                case "BOOLEAN": {
                    System.out.printf("\t%s value = %b%n", cellTypeName, cell.getBooleanCellValue());
                    break;
                }
                default: {
                    System.out.printf("\t%s value = %s %n\t\t%s%n", cellTypeName, cell.getErrorCellValue(), cell.getErrorCellString());
                    break;
                }
            }
        }

    }

    public List<String> getCellsValuesUsingDataFormatter(final int rowNum) {
       return getCellsValuesUsingDataFormatter(SHEET_INDEX, rowNum);
    }

    public List<String> getCellsValuesUsingDataFormatter(final int sheetIndex, final int rowNum) {
        final XSSFRow row = this.getSheetByIndex(sheetIndex).getRow(rowNum);
        final int numberOfCells = row.getPhysicalNumberOfCells();
        List<String> listCellStringValues = new ArrayList<>();
        System.out.printf("getCellsValuesUsingDataFormatter --> %n\tSheet index %d, row number %d%n", sheetIndex, rowNum);
        for (int i = 0; i < numberOfCells; i++) {
            listCellStringValues.add(dataFormatter.formatCellValue(row.getCell(i)));
            System.out.println(dataFormatter.formatCellValue(row.getCell(i)));
        }
        return listCellStringValues;
    }

    public List<Cell> getRowCellsAsList(final int rowNum) {
        return getRowCellsAsList(SHEET_INDEX, rowNum);
    }

    public List<Cell> getRowCellsAsList(final int sheetIndex, final int rowNum) {
        final XSSFRow row = this.getSheetByIndex(sheetIndex).getRow(rowNum);

        ////    Before Java 8, without using Stream API
        //final int numberOfCells = row.getPhysicalNumberOfCells();
        //List<XSSFCell> listCells = new ArrayList<>();
        //for (int i = 0; i < numberOfCells; i++) {
        //    listCells.add(row.getCell(i));
        //}
        //return listCells;

        return StreamSupport.stream(row.spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<String> getRowCellsStringValues(List<Cell> listCells) {
        ////    Before Java 8, without using Stream API
        //List<String> listValues = new ArrayList<>();
        //for (Cell cell : listCells) {
        //    listValues.add(dataFormatter.formatCellValue(xssfCell));
        //}
        //return listValues;
        return listCells.stream()
                //.map(x -> dataFormatter.formatCellValue(x))
                .map(dataFormatter::formatCellValue)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        final int sheetIndex = 0;
        final int rowNumber = 0;

        ReadExcelXlsxFile demo = new ReadExcelXlsxFile();
        System.out.println("Number of sheets = " + demo.getSheetCount());
        System.out.println("Sheet row-count = " + demo.getSheetRowCount(sheetIndex));
        System.out.println(String.format("Sheet %d, Row %d cell-count = ", sheetIndex, rowNumber)
                + demo.getSheetRowCellCount(sheetIndex, rowNumber));

        //  Print the values of CellType enum using Arrays.stream(..).forEach(..)
        System.out.print("Arrays.stream(CellType.values()).forEach(..) =  { ");
        Arrays.stream(CellType.values())
                .forEach(x -> System.out.print(x.name() + ", "));
        System.out.println('}');

        //  Print the values of CellType enum using Arrays.stream(..).map(..).collect(..)
        System.out.println("Arrays.stream(CellType.values())" +
                ".map(x -> x.name()).collect(Collectors.toList()) = " +
                Arrays.stream(CellType.values())
                        //.map(x -> x.name())
                        .map(Enum::name)
                        .collect(Collectors.toList())
        );

        //  Print the row's cells values using CellType and cell.getXxxxxxxCellValue() methods
        demo.getRowCellsStringValues(sheetIndex, 1);
        //  Print the row's cells values using DataFormatter class
        System.out.println(demo.getCellsValuesUsingDataFormatter(sheetIndex, 2));

        final List<Cell> listRowCells = demo.getRowCellsAsList(sheetIndex, 3);
        final List<String> listRowCellsStringValues = demo.getRowCellsStringValues(listRowCells);
        System.out.printf("demo.getRowCellsAsList(%d, 3) %n\t%s%n", sheetIndex, listRowCells);
        System.out.printf("demo.getRowCellsValues(%d, 3) %n\t%s%n", sheetIndex, listRowCellsStringValues);


    }
}

