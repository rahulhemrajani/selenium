import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaymentCheck {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver\\chromedriver.exe");
		WebDriver webdriver = new ChromeDriver();
		
		String baseUrl = "https://my.idmobile.co.uk/web/cpw/home";
		String tagName = "";
		
		webdriver.get(baseUrl);
		tagName = webdriver.findElement(By.id("_58_login")).getTagName();
		
		WebElement element = webdriver.findElement(By.id("_58_login"));
		element.sendKeys("pankajdash");
		Thread.sleep(2500);
		
		tagName = webdriver.findElement(By.id("temppassword")).getTagName();
		tagName = webdriver.findElement(By.id("loginButton")).getTagName();
		
		WebElement elementP = webdriver.findElement(By.id("temppassword"));
		elementP.sendKeys("Oct@2017");
		Thread.sleep(2500);
		
		webdriver.findElement(By.id("loginButton")).click();
		webdriver.findElement(By.id("Popup")).click();
//		webdriver.close();
		//String newUrl = webdriver.getCurrentUrl();
		
//		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver\\chromedriver.exe");
//		WebDriver webdriver = new ChromeDriver();
		
		String newUrl = "https://my.idmobile.co.uk/web/cpw/payment";
		webdriver.get(newUrl);
		
		webdriver.findElement(By.id("amount")).sendKeys("100");
		webdriver.findElement(By.xpath(".//*[@id='MakePaymentForm']/div[2]/button")).click();
		webdriver.findElement(By.id("currpwd")).sendKeys("Oct@2017");
		webdriver.findElement(By.xpath(".//*[@id='oneOfPaymentCheckPassword']/div/div/div[1]/div[1]/div/div[4]/button[1]")).click();
		System.out.println(tagName);
		webdriver.close();

		//Opening webAxn url in new Tab
		String webAxnUrl = "https://mobi.idmobile.co.uk/webaxn/";
		webdriver.get(webAxnUrl);
//		((JavascriptExecutor) webdriver).executeScript("window.open(arguments[0])", webAxnUrl);
		webdriver.navigate().to(webAxnUrl);
		System.out.println("At Web Axn");
		webdriver.close();
		
		//Opening rnp-broker page
		String rnpBroker = "http://admin:admin@192.168.230.122:8161/admin/queues.jsp";
		webdriver.get(rnpBroker);
//		((JavascriptExecutor) webdriver).executeScript("window.open(arguments[0])", rnpBroker);
		webdriver.navigate().to(rnpBroker);
		System.out.println("At rnp broker end 1");
		((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView();", webdriver.findElement(By.xpath("//*[@id=\"queues\"]/tbody/tr[14]/td[1]/a")));
		System.out.println("At rnp broker end 2");
		webdriver.close();
//		Actions actions = new Actions(webdriver);
//		actions.sendKeys(Keys.PAGE_DOWN);
//		((JavascriptExecutor) webdriver).executeScript("scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
//		Alert alert = webdriver.switchTo().alert();
//		alert.setAuthenticationCredentials("admin","admnin");
//		webdriver.switchTo().defaultContent();
		
		String ccrLink1 = "http://192.168.230.121:8080/pnp4nagios/graph?host=cwuprol1.cpwlocal&srv=CREDIT_CONTROL_REQUEST";
		webdriver.get(ccrLink1);
//		((JavascriptExecutor) webdriver).executeScript("window.open(arguments[0])", ccrLink1);
		webdriver.navigate().to(ccrLink1);
		webdriver.findElement(By.xpath("//*[@id=\"button\"]/img")).click();
		System.out.println("At CCR1 End");
		webdriver.close();
	}
}
