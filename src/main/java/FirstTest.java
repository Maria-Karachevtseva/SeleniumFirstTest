import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;

public class FirstTest {


    @Test
    public void mobileAccountReplenishment() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver() ;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



        driver.get("https://next.privat24.ua/mobile");


        driver.findElement(By.xpath(".//input[@data-qa-node='phone-number']")).sendKeys(new CharSequence[]{"954546443"});
        driver.findElement(By.xpath(".//input[@data-qa-node='amount']")).clear();
        driver.findElement(By.xpath(".//input[@data-qa-node='amount']")).sendKeys(new CharSequence[]{"10"});
        driver.findElement(By.xpath(".//input[@data-qa-node='numberdebitSource']")).sendKeys(new CharSequence[]{"4552331448138217"});
        driver.findElement(By.xpath(".//input[@data-qa-node='expiredebitSource']")).sendKeys(new CharSequence[]{"0524"});
        driver.findElement(By.xpath(".//input[@data-qa-node='cvvdebitSource']")).sendKeys(new CharSequence[]{"111"});
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//button[contains(text(), 'В кошик')]")).click();



        By details = By.xpath(".//span[@data-qa-node='details']");
        By payerCard = By.xpath(".//td[@data-qa-node='card']");
        By receiverName = By.xpath(".//span[@data-qa-node='nameB']");
        By amount = By.xpath(".//span[@data-qa-node='amount']");
        By currency = By.xpath(".//small[@data-qa-node='currency']");
        By commission = By.xpath(".//span[@data-qa-node='commission']");
        By commissionCurrency = By.xpath(".//small[@data-qa-node='commission-currency']");


        Assert.assertEquals("Поповнення телефону. На номер +380954546443", driver.findElement(details).getText());
        Assert.assertEquals("4552 **** **** 8217", driver.findElement(payerCard).getText());
        Assert.assertEquals("Vodafone", driver.findElement(receiverName).getText());
        Assert.assertEquals("10", driver.findElement(amount).getText());
        Assert.assertEquals(" UAH", driver.findElement(currency).getText());
        Assert.assertEquals("2", driver.findElement(commission).getText());
        Assert.assertEquals(" UAH", driver.findElement(commissionCurrency).getText());

        driver.findElement(By.xpath(".//button[contains(text(), 'Підтвердити')]")).click();
    }



}
