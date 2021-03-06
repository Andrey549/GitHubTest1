import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");
        mainPage = new MainPage(driver);
    }
    @Test
    public void signIn(){
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }
    @Test
    public void registerFailTest(){
        SignUpPage signUpPage = mainPage.registr("TestUser","testmail","testpass");
        String error = signUpPage.getErrorUserMail();
        Assert.assertEquals("Email is invalid or already taken",error);
    }
    @Test
    public void signUpEmptyUserNameTest(){
        SignUpPage signUpPage=mainPage.registr("1","asdfasd","11111111");
        String error = signUpPage.getErrorText();
        Assert.assertEquals("Username 1 is not available.",error);

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
