import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver=driver;
    }
    private By signInButton = By.xpath("//a[@class='HeaderMenu-link no-underline mr-3']");
    private By signUpButton = By.xpath("//a[@class='HeaderMenu-link d-inline-block no-underline border border-gray-dark rounded-1 px-2 py-1']");
    private By userName = By.xpath("//input[@id='user[login]']");
    private By userEmail = By.xpath("//input[@id='user[email]']");
    private By userPassword = By.xpath("//input[@id='user[password]']");
    private By signUpFormButton = By.xpath("//button[@class='btn-mktg btn-primary-mktg btn-large-mktg f4 btn-block my-3']");

    public LoginPage clickSignIn(){
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }
    public SignUpPage clickSignUp(){
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }
    public SignUpPage clicksignUpForm(){
        driver.findElement(signUpFormButton).click();
        return new SignUpPage(driver);
    }
    public MainPage typeUserName(String username){
        driver.findElement(userName).sendKeys(username);
        return this;
    }
    public MainPage typeUserEmail(String username){
        driver.findElement(userEmail).sendKeys(username);
        return this;
    }
    public MainPage typeUserPassword(String Password){
        driver.findElement(userPassword).sendKeys(Password);
        return this;
    }
    public SignUpPage registr(String username,String email, String password){
        this.typeUserName(username);
        this.typeUserEmail(email);
        this.typeUserPassword(password);
        this.clicksignUpForm();
        return new SignUpPage(driver);

    }

}
