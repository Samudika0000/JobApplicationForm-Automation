
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    WebDriver driver;

    public Main() {
    }

    public void lounchBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Users/samudikathilakarathne/Downloads/chromedriver-mac-arm64/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.get("https://demoqa.com/automation-practice-form");
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.lounchBrowser();
    }

}