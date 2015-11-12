import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {

	public static void main(String[] args) throws Exception {
		Integer waitTime = 600;
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		driver.get("http://mobile.walmart.com");
		// Find the text input element by its name
		driver.findElement(By.id("search")).sendKeys("socks");
		driver.findElement(By.xpath(".//*[@id='top']/div[3]/div/div/div/div/div[3]/form/div/div[3]/button")).click();
		WebElement element = driver.findElement(By
				.className("js-product-image"));
		System.out.println("print element" + element);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// Thread.sleep(1000);
		WebElement webElement = driver.findElement(By.id("WMItemQtyDropDown"));
		new Select(webElement).selectByIndex(0);
		webElement.click();
		WebElement webElement1 = driver
				.findElement(By.id("WMItemAddToCartBtn"));
		System.out.println("print the element name" + webElement);
		CommonSteps.ElementWait_UntilVisible(webElement1);
		webElement1.click();
		String val = driver.findElement(
				By.className("js-header-cart-count header-cart-item-count"))
				.getText();
		int count = Integer.parseInt("val");
		if (count == 1) {
			driver.findElement(
					By.xpath(".//*[@id='flyout15']/ul/span[2]/li[1]/a"))
					.click();
			driver.findElement(By.id("login-username")).sendKeys(
					"testaccount@gmail.com");
			driver.findElement(By.id("login-password")).sendKeys("password");
			driver.findElement(
					By.xpath("html/body/div[2]/section/section[4]/div/div/div/div/div/div/div/form/div/button"))
					.click();
			driver.findElement(By.className("wmicon wmicon-cart")).click();
			String url = driver.getCurrentUrl();
			driver.findElement(By.id(".//*[@id='CartChkOutBtn']")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By
					.className("checkout")));
			List<WebElement> checks = driver.findElements(By
					.className("radio-expanded radio-option-blue js-shipping"));
			// verify 1st checkbox is checked
			checks.get(0).isSelected();
			driver.findElement(By.id("COAC1ShpOptContBtn")).click();
			String element1 = driver.findElement(By.id("COAC2ShpSelAddress0"))
					.getText();
			System.out.println("print the element text" + element1);
			Assert.assertEquals("element1", "Selected");
			driver.findElement(By.id(".//*[@id='COAC2ShpAddrContBtn']"))
					.click();
			String url1 = driver.getCurrentUrl();
			Assert.assertEquals("url1",
					"https://www.walmart.com/checkout/#checkout/payment");
			driver.findElement(By.className("wmicon wmicon-cart")).click();
			driver.navigate().to("https://www.walmart.com/cart/");
			driver.findElement(By.id(".//*[@id='CartRemItemBtn']")).click();
		} else {
			String ele = driver
					.findElement(
							By.className("js-header-cart-count header-cart-item-count hide-content"))
					.getText();
			int count1 = Integer.parseInt("ele");
			System.out.println("print the value" + count1);
			WebElement element2 = driver.findElement(By.linkText("My Account"));

			Actions action = new Actions(driver);

			action.moveToElement(element2).build().perform();

			driver.findElement(By.linkText("Sign Out")).click();

			driver.close();

		}

	}

}