import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
        loginPage = new LoginPage(driver);
    }
    @Test
    public void loginWithEmptyCredsTest(){
      LoginPage newLOginPage = loginPage.loginWithInvalidCreds("","");
      String error = newLOginPage.getErrorText();
      Assert.assertEquals("Incorrect username or password.",error);

    }
    @Test
    public void loginWithIncorrectCredsTest(){
      LoginPage newLOginPage = loginPage.loginWithInvalidCreds("qwerty","qwerty");
      String error = newLOginPage.getErrorText();
      Assert.assertEquals("Incorrect username or password.",error);

    }
    @Test
    public void creatNewAccaunt(){
        SignUpPage signUpPage=loginPage.createAccount();
        String heading = signUpPage.getHeaingText();
        Assert.assertEquals("Create your account",heading);

    }













    @After
    public void tearDown(){
        driver.quit();
    }
}
