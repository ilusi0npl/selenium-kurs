package ddt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class DDTTests {

    private final String baseUrl = "http://google.pl";
    private WebDriver driver;
    private final String searchQuery;
    private final String expectedResult;

    public DDTTests(String searchQuery, String expectedResult) {
        this.searchQuery = searchQuery;
        this.expectedResult = expectedResult;
    }

    @Factory
    public static Object[] queriesTestData() {
        int queryColumn = 0;
        int expectedResultColumn = 1;

        ExcelSheetReader excelSheetReader = new ExcelSheetReader();

        try {
            String excelFileLocation = System.getProperty("user.dir") + "/src/main/resources/" + "DDT_FILE.xlsx";
            excelSheetReader.setExcelFileSheet(excelFileLocation, "GoogleSearch");
        } catch (IOException e) {
            e.printStackTrace();
        }

        SheetDataReader sheetDataReader = new SheetDataReader(excelSheetReader.getExcelSheet());

        List<String> searchQueryList = sheetDataReader.getDataForColumn(queryColumn);
        List<String> expectedResultList = sheetDataReader.getDataForColumn(expectedResultColumn);

        Object[] arrayOfTestCaseToExecute = new Object[expectedResultList.size()];

        for (int testCase = 0; testCase < expectedResultList.size(); testCase++) {
            arrayOfTestCaseToExecute[testCase] =
                    new DDTTests(searchQueryList.get(testCase), expectedResultList.get(testCase));
        }
        return arrayOfTestCaseToExecute;
    }

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void dataDrivenTest() {
        WebElement searchField = driver.findElement(By.name("q"));

        searchField.sendKeys(searchQuery);
        searchField.submit();

        assertEquals(driver.getTitle(), expectedResult);
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}