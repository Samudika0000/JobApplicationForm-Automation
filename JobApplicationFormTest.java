
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

    import javax.swing.*;
import java.util.Date;

public class JobApplicationFormTest {
    static WebDriver driver;

    public JobApplicationFormTest() {
    }

    public void launchBrowser()  {
        //launchBrowser
        System.setProperty("webdriver.chrome.driver", "/Users/samudikathilakarathne/Downloads/chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //launch URL
        driver.get("https://demoqa.com/automation-practice-form");
    }

    public void validFormSubmission()  {

        driver.get("https://demoqa.com/automation-practice-form");

        //Enter first and last name
        driver.findElement(By.id("firstName")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Doe");

        driver.findElement(By.id("userEmail")).sendKeys("john.doe@example.com");

        //gender selection using radio button click
        WebElement RadioButton =driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label")); //Male
        RadioButton.click();
        RadioButton.isDisplayed();
        RadioButton.isEnabled();
        RadioButton.isSelected();

        System.out.println(RadioButton.getText());

        //Enter Contact Number
        driver.findElement(By.id("userNumber")).sendKeys("1234567890");

        //date of birth
        driver.findElement(By.id("dateOfBirthInput")).click();

        Select month = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        month.selectByVisibleText("January");  // Select january

        Select year = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        year.selectByVisibleText("1995");  // Select 1995

        driver.findElement(By.className("react-datepicker__day react-datepicker__day--002")).click();// Select 2

        // Enter Subject (Maths) and select it
        WebElement subjectField = driver.findElement(By.xpath("subjectsInput"));
        subjectField.sendKeys("Maths");
        subjectField.submit(); // Select from autocomplete

        /*//Select hobby
        WebElement CheckBox = driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label")); //Sports
        CheckBox.click();
        Thread.sleep(5000);
        CheckBox.click();

        System.out.println(CheckBox.getText());*/



        //Upload picture
        driver.findElement(By.id("uploadPicture")).sendKeys("/Users/samudikathilakarathne/Documents/img/rev1.jpg");
       // Enter address
        driver.findElement(By.id("currentAddress")).sendKeys("123 Main Street, Anytown, CA 12345");
        //Select State and City
        driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[1]/div[1]")).click();
        driver.findElement(By.id("stateCity-wrapper")).sendKeys("Delhi");
        driver.findElement(By.id("submit")).click();
    }

    public static void main(String[] args)   {
        JobApplicationFormTest obj = new JobApplicationFormTest();
        obj.launchBrowser();
        obj.validFormSubmission();

        driver.quit();

    }
}

