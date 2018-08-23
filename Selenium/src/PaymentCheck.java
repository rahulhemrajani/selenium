import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentCheck {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver\\chromedriver.exe");
		WebDriver webdriver = new ChromeDriver();
		
		String baseUrl = "https://my.idmobile.co.uk/web/cpw/home";
		String tagName = "";
		
		webdriver.get(baseUrl);
		tagName = webdriver.findElement(By.id("_58_login")).getTagName();
		
		webdriver.findElement(By.id("_58_login")).sendKeys("pankajdash");;
		Thread.sleep(2500);
		
		tagName = webdriver.findElement(By.id("temppassword")).getTagName();
		tagName = webdriver.findElement(By.id("loginButton")).getTagName();
		
		WebElement elementP = webdriver.findElement(By.id("temppassword"));
		elementP.sendKeys("Oct@2017");
		Thread.sleep(2500);
        webdriver.findElement(By.id("loginButton")).click();


        String winHandleOld = webdriver.getWindowHandle();
        webdriver.findElement(By.id("Popup")).click();

        for(String winHandle:webdriver.getWindowHandles()){
            webdriver.switchTo().window(winHandle);
        }
        Thread.sleep(2000);

        //String newUrl = webdriver.getCurrentUrl();

//		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver\\chromedriver.exe");
//		WebDriver webdriver = new ChromeDriver();

		/*String newUrl = "https://my.idmobile.co.uk/web/cpw/payment";
		webdriver.get(newUrl);*/

        webdriver.findElement(By.id("amount")).sendKeys("100");
        webdriver.findElement(By.xpath(".//*[@id='MakePaymentForm']/div[2]/button")).click();
        webdriver.findElement(By.id("currpwd")).sendKeys("Oct@2017");
        webdriver.findElement(By.xpath(".//*[@id='oneOfPaymentCheckPassword']/div/div/div[1]/div[1]/div/div[4]/button[1]")).click();
        System.out.println(tagName);
        Thread.sleep(7000);
        webdriver.close();
        webdriver.switchTo().window(winHandleOld);

        //Opening webAxn url in new Tab
		String webAxnUrl = "https://mobi.idmobile.co.uk/webaxn/";
//		webdriver.get(webAxnUrl);
		((JavascriptExecutor) webdriver).executeScript("window.open(arguments[0])", webAxnUrl);
//		webdriver.navigate().to(webAxnUrl);
		System.out.println("At Web Axn");
		Thread.sleep(3000);
//		webdriver.close();
		
		//Opening rnp-broker page
		String rnpBroker = "http://admin:admin@192.168.230.122:8161/admin/queues.jsp";
//        webdriver.findElement(By.linkText(rnpBroker)).sendKeys(Keys.CONTROL,"t");
//		webdriver.get(rnpBroker);
//		((JavascriptExecutor) webdriver).executeScript("window.open(arguments[0])", rnpBroker);
        webdriver.navigate().to(rnpBroker);
        Thread.sleep(3000);
        System.out.println("At rnp broker end 1. Scrolling");
        Thread.sleep(3000);
//        ((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView(true);",webdriver.findElement(By.xpath("//*[@id=\"queues\"]/tbody/tr[13]/td[1]")));
		((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", webdriver.findElement(By.xpath("//*[@id=\"queues\"]/tbody/tr[17]/td[1]/a")));
        Thread.sleep(3000);
        System.out.println("At rnp broker end 2");
//		webdriver.close();
//		Actions actions = new Actions(webdriver);
//		actions.sendKeys(Keys.PAGE_DOWN);
//		((JavascriptExecutor) webdriver).executeScript("scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
//		Alert alert = webdriver.switchTo().alert();
//		alert.setAuthenticationCredentials("admin","admnin");
//		webdriver.switchTo().defaultContent();


        //CCR 1 Monitor
		String ccrLink1 = "http://192.168.230.121:8080/pnp4nagios/graph?host=cwumgtl1.cpwlocal&srv=CREDIT_CONTROL_REQUEST";
		webdriver.get(ccrLink1);
//		((JavascriptExecutor) webdriver).executeScript("window.open(arguments[0])", ccrLink1);
//		webdriver.navigate().to(ccrLink1);
        Thread.sleep(2000);
		webdriver.findElement(By.xpath("//*[@id=\"button\"]/img")).click();
        Thread.sleep(3000);
//        new WebDriverWait(webdriver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dpstart\"]")));
        Date start = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy 00:00");
        System.out.println("Date: "+dateFormat.format(start));
        webdriver.findElement(By.xpath("//*[@id=\"dpstart\"]")).sendKeys(dateFormat.format(start));
		Thread.sleep(2000);
		webdriver.findElement(By.xpath("//*[@id=\"toggle-timerange\"]/div[2]/form/fieldset/img[2]")).click();
        Thread.sleep(2000);
		webdriver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[3]/button[1]")).click();
        Thread.sleep(2000);
		webdriver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        System.out.println("At CCR1 End");
        Thread.sleep(3000);


        //CCR 2 Monitor
        String ccrLink2 = "http://192.168.230.121:8080/pnp4nagios/graph?host=cwuprol2.cpwlocal&srv=CREDIT_CONTROL_REQUEST";
//        webdriver.get(ccrLink2);
//		((JavascriptExecutor) webdriver).executeScript("window.open(arguments[0])", ccrLink2);
        webdriver.navigate().to(ccrLink2);
        webdriver.findElement(By.xpath("//*[@id=\"button\"]/img")).click();
        Thread.sleep(3000);
//        new WebDriverWait(webdriver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dpstart\"]")));
        /*Date start2 = new Date();
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yy 00:00");
        webdriver.findElement(By.xpath("//*[@id=\"dpstart\"]")).sendKeys(dateFormat2.format(start2));
        Thread.sleep(2000);
        webdriver.findElement(By.xpath("//*[@id=\"toggle-timerange\"]/div[2]/form/fieldset/img[2]")).click();
        Thread.sleep(2000);
        webdriver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[3]/button[1]")).click();
        Thread.sleep(2000);*/
        webdriver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        System.out.println("At CCR2 End");
        webdriver.quit();
	}
}
