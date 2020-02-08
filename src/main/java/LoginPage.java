import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;

    }
    private By userLogin = By.xpath("//input[@id=\"login_field\"]");
    private By userPassword = By.xpath("//input[@name=\"password\"]");
    private By signUpFormButton = By.xpath("//input[@name=\"commit\"]");
    private By heading = By.xpath("//h1");
    private By error = By.xpath("//div[@class='flash flash-full flash-error']//div[@class=\"container\"]");
    private By createAnAccount = By.xpath("//a[contains(text(),'Create an account')]");

    public LoginPage typeUserName (String username){
        driver.findElement(userLogin).sendKeys(username);
        return this;
    }

    public LoginPage typePassword (String password){
        driver.findElement(userPassword).sendKeys(password);
        return this;
    }

    public LoginPage loginWithInvalidCreds(String username, String password){
        this.typeUserName(username);
        this.typePassword(password);
        driver.findElement(signUpFormButton).click();
        return new LoginPage(driver);
    }
    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }
    public String getErrorText(){
        return driver.findElement(error).getText();
    }

    public SignUpPage createAccount(){
        driver.findElement(createAnAccount).click();
        return new SignUpPage(driver);
    }
}
