import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonSteps {

	public static void ElementWait_UntilVisible(WebElement webElement) throws Exception{
		WebDriver driver = new FirefoxDriver();
		Integer waitTime = 60;
		WebDriverWait wait = new WebDriverWait(driver,waitTime);
		wait.until(ExpectedConditions.visibilityOf((webElement)));
	}

	
}
