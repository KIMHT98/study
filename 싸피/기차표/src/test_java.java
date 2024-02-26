import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test_java {
	public static void runchrome() {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,5);
		driver.get("https://www.naver.com");
		
		WebElement financeBtn = driver.findElement(By.cssSelector("#shortcutArea > ul > li:nth-child(6) > a"));
		financeBtn.click();
		
//		WebElement KoreafinanceBtn = driver.findElement(By.cssSelector("#menu > ul > li.m2 > a "));
//		KoreafinanceBtn.click();
		
		ArrayList tabs = new ArrayList(driver.getWindowHandles());
		
		for (Object win : tabs) {
			System.out.println(win);
		}
		
		driver.switchTo().window((String) tabs.get(1));
		
		WebElement searchInput = driver.findElement(By.cssSelector("#stock_items"));
		searchInput.sendKeys("삼성전자");
		searchInput.sendKeys(Keys.ENTER);
		
		WebElement news = driver.findElement(By.cssSelector("#content > div.article > div.section > div.news_area._replaceNewsLink > div > ul > li:nth-child(1) > span > a"));
		
//		System.out.println(news.getText());
//		List news = driver.findElements(By.cssSelector("#content > div.article > div.section > div.news_area._replaceNewsLink > div > ul > li"));
//		for (Object header : news) {
//			System.out.println(((WebElement)header).getText());
//		}
	}
}

