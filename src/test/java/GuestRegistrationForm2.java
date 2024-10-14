import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utils.Utils;

import java.time.Duration;
import java.util.List;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GuestRegistrationForm2 {

    WebDriver driver;
    @BeforeAll
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
@Test
    public void guestForm() throws InterruptedException {
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");
        driver.findElement(By.id("first_name")).sendKeys("Rafi");
        driver.findElement(By.id("last_name")).sendKeys("Tas");
        driver.findElement(By.id("user_email")).sendKeys("rafitai@gmail.com");
        driver.findElement(By.id("user_pass")).sendKeys("pok*&22iio85@");
        driver.findElement(By.id("radio_1665627729_Male")).click();
    driver.findElement(By.id("input_box_1665629217")).sendKeys("Bangladeshi");
    List<WebElement> txtPhone = driver.findElements(By.id("phone_1665627880"));
    txtPhone.get(1).sendKeys("01778496852");


    String year="2023";
    String day = "21";

    Utils.scroll(driver,200);
    driver.findElement(By.xpath("//input[@class='ur-flatpickr-field regular-text without_icon flatpickr-input']")).click();


    while(true){
        String curYear = driver.findElement(By.className("cur-year")).getAttribute("value");

        if(curYear.contains(year)){
            break;
        }

        driver.findElement(By.className("flatpickr-prev-month")).click();

    }
    Select dropmonth = new Select(driver.findElement(By.className("flatpickr-monthDropdown-months")));

    dropmonth.selectByVisibleText("May");

    List<WebElement> dates = driver.findElements(By.xpath("//div[@class='dayContainer']//span"));
    for(WebElement ell:dates){
        if (ell.getText().contains(day)){
            ell.click();
            break;
        }
    }




        Select select= new Select(driver.findElement(By.id("country_1665629257")));
        select.selectByVisibleText("Bangladesh");

        Utils.scroll(driver, 1000);
         Thread.sleep(2000);
        driver.findElement(By.id("privacy_policy_1665633140")).click();
        List <WebElement> btnSubmit = driver.findElements(By.cssSelector("[type=submit]"));
        btnSubmit.get(2).click();

    String resultAct = driver.findElement(By.xpath("//div[@id='ur-submit-message-node']//ul")).getText();
    Assertions.assertTrue( resultAct.contains("User successfully registered"));





}







     @AfterAll
    public void finishTest(){

        driver.quit();

    }
}
