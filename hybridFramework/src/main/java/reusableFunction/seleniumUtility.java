package reusableFunction;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.libraryClass;

public class seleniumUtility extends libraryClass {

	public seleniumUtility(WebDriver driver) {
		this.driver = driver;

	}

	public void to_take_screenshot(String path) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getTitle() {

		System.out.println(driver.getTitle());

	}

	public void Explicitlywait(String Locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Locator))));

	}

	public void quit() {
		driver.close();

	}

}
