import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Utils;
import java.time.Duration;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DigitalUnitWebAutomation1 {
WebDriver driver;
    @BeforeAll
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
public void practiseWebForm() throws InterruptedException {


        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    driver.findElement(By.id("edit-name")).sendKeys("Tetu User1");
        Thread.sleep(1000);
    driver.findElement(By.id("edit-number")).sendKeys("01854584123");




    WebElement txtCalenderElem = driver.findElement(By.id("edit-date"));
    txtCalenderElem.sendKeys(Keys.CONTROL,"a");
    txtCalenderElem.sendKeys(Keys.BACK_SPACE);
    txtCalenderElem.sendKeys("10/1/2024");

    driver.findElement(By.id("edit-email")).sendKeys("ttyituser1@test.com");
    driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("What are you doing guys?");

    Utils.scroll(driver,500);

    String relativePath = "\\src\\test\\resources\\Sam-Walton.jpg";
    String absolutePath = System.getProperty("user.dir") + relativePath;
    driver.findElement(By.id("edit-uploadocument-upload")).sendKeys(absolutePath);
        Thread.sleep(5000);

    driver.findElement(By.id("edit-age")).click();
    driver.findElement(By.id("edit-submit")).click();


        String actualResult = driver.findElement(By.id("block-pagetitle-2")).getText();

        Assertions.assertTrue(actualResult.contains("Thank you for your submission!"));


}

  // @AfterAll
    public void finishTest(){

        driver.quit();

    }
}
