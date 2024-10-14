package testng.practice.tests;

public class IncorrectLoginTestData {

    private String username;
    private String password;
    private String expectedMessage;

    public IncorrectLoginTestData(String username, String password, String expectedMessage) {
        this.username = username;
        this.password = password;
        this.expectedMessage = expectedMessage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getExpectedMessage() {
        return expectedMessage;
    }

    public void setExpectedMessage(String expectedMessage) {
        this.expectedMessage = expectedMessage;
    }
}