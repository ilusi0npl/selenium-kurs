package ddt;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;


//Klasa służy do odczytania zadanego pliku z rozszerzenie *.xlsx, a następnie pobrania arkusza o danej nazwie
public class ExcelSheetReader {

    private XSSFWorkbook excelWBook;
    private XSSFSheet excelWSheet;

    //Metoda służy do odczytania arkusza o danej nazwie dla zadanego pliku *.xlsx
    public void setExcelFileSheet(String excelFileLocation, String sheetName) throws IOException {
        FileInputStream ExcelFile = new FileInputStream(excelFileLocation);
        excelWBook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWBook.getSheet(sheetName);
        if (excelWSheet == null) {
            throw new RuntimeException("Excel Sheet was null! Please check name of the excel sheet!");
        }
    }

    //Pobranie przeczytanego wcześniej arkusza
    public XSSFSheet getExcelSheet() {
        return excelWSheet;
    }

}