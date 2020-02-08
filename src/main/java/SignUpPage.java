import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private WebDriver driver;
    public SignUpPage(WebDriver driver){
        this.driver=driver;
    }
    private By userLogin = By.xpath("//input[@name=\"user[login]\"]");
    private By userEmail = By.xpath("//input[@name=\"user[email]\"]");
    private By userPassword = By.xpath("//input[@name=\"user[password]\"]");
    private By checkBoxSendMe = By.xpath("//input[@name=\"all_emails\"]");
    private By signUpFormButton = By.xpath("//button[@class=\"btn-mktg signup-btn  js-octocaptcha-form-submit width-full\"]");
    private By errorusername = By.xpath("//div[@class=\"mb-1 \"]");
    private By errorusermail = By.xpath("//dd[contains(text(),'Email is invalid or already taken')]");
    private By heading = By.xpath("//h1[@class=\"d-none d-md-block mt-0 mb-3 text-center h00-mktg lh-condensed-ultra \"]");



    public SignUpPage typeUserName(String username){
        driver.findElement(userLogin).sendKeys(username);
        return this;
    }
    public SignUpPage typeUserEmail(String username){
        driver.findElement(userEmail).sendKeys(username);
        return this;
    }
    public SignUpPage typeUserPassword(String Password){
        driver.findElement(userPassword).sendKeys(Password);
        return this;
    }
    public SignUpPage loginWithInvalidCreds(String username,String userEmail, String password){
        this.typeUserName(username);
        this.typeUserEmail(userEmail);
        this.typeUserPassword(password);
        driver.findElement(checkBoxSendMe).click();
        driver.findElement(signUpFormButton).click();
        return new SignUpPage(driver);
    }
    public String getErrorText(){
        return  driver.findElement(errorusername).getText();
    }
    public String getErrorUserMail(){
        return  driver.findElement(errorusermail).getText();
    }
    public String getHeaingText(){return driver.findElement(heading).getText();}
}