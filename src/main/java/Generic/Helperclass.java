package Generic;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MainBase.baseTest;

public class Helperclass extends baseTest{

	public Helperclass() throws IOException {
		super();
	}
	public int GetList(List<WebElement> alloptions, WebDriver driver) {

		List<WebElement> m = alloptions;
		int size = 0;
		for (WebElement text : m) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", text);
			size = m.size();
		}
		return size;
	}
	public void ClickAndWait(WebElement ele) {

		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(ele)).click();
	}
}