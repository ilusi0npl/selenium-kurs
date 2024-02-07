package ddt;

import java.io.IOException;
import java.util.List;

public class ExcelFileReader {

    public static void main(String[] args) {

        //Indeks określający kolumnę o nazwie Search Query w arkuszu DuckDuckGoSearch
        int queryColumn = 0;

        //Indeks określający kolumnę o nazwie Expected result w arkuszu DuckDuckGoSearch
        int expectedResultColumn = 1;

        //Utworzenie instancji klasy ExcelSheetReader
        ExcelSheetReader excelSheetReader = new ExcelSheetReader();

        try {
            //Odczytanie/Pobranie pliku o nazwie DDT_FILE.xslx oraz arkusza wewnątrz pliku o nazwie DuckDuckGoSearch
            String excelFileLocation = System.getProperty("user.dir") + "/src/main/resources/" + "DDT_FILE.xlsx";
            excelSheetReader.setExcelFileSheet(excelFileLocation, "DuckDuckGoSearch");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Utworzenie instancji klasy SheetDataReader, która w konstruktorze przyjmuje obiekt arkusza - w naszym wypadku jest to arkusz o nazwie DuckDuckGoSearch
        SheetDataReader sheetDataReader = new SheetDataReader(excelSheetReader.getExcelSheet());

        //Pobranie wartości dla kolumny Search query
        List<String> searchQueryList = sheetDataReader.getDataForColumn(queryColumn);

        //Pobranie wartości dla kolumny Expected Result
        List<String> expectedResultList = sheetDataReader.getDataForColumn(expectedResultColumn);

        System.out.println(searchQueryList.toString());
        System.out.println(expectedResultList.toString());
    }

}
