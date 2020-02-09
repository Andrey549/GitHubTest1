import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;q

public class SignUpPageTest {
    WebDriver driver;
    SignUpPage signUpPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");

        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/join?source=header-home");
        signUpPage = new SignUpPage(driver);


    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
