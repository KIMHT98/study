import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ticket {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
//		WebDriverWait wait = new WebDriverWait(driver,5);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://etk.srail.kr/main.do");
		
		Select departure = new Select(driver.findElement(By.cssSelector("#dptRsStnCd")));
		departure.selectByVisibleText("수서");
		
		Select arrival = new Select(driver.findElement(By.cssSelector("#arvRsStnCd")));
		arrival.selectByValue("0010");

		WebElement calendarBtn = driver.findElement(By.cssSelector("#search-form > fieldset > div:nth-child(9) > div > input.calendar2"));
		calendarBtn.click();
//		Select calendar = new Select(driver.findElement(By.cssSelector("#search-form > fieldset > div:nth-child(9) > div > input.calendar2")));
//		calendar.selectByVisibleText("31");
		ArrayList tabs = new ArrayList(driver.getWindowHandles());
		
		
		driver.switchTo().window((String) tabs.get(1));
		WebElement dayBtn = driver.findElement(By.cssSelector("#wrap > div.contents.etk-calendar > div.area > div.calendar.this > table > tbody > tr:nth-child(5) > td:nth-child(4) "));
		dayBtn.click();
		driver.switchTo().window((String) tabs.get(0));
		WebElement searchBtn = driver.findElement(By.cssSelector("#search-form > fieldset > a"));
		searchBtn.click();
		ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
		
		driver.switchTo().window((String) tabs2.get(0));
//		WebElement a = wait
//                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#result-form > fieldset > div.tbl_wrap.th_thead > table > tbody > tr:nth-child(6) > td:nth-child(6) > a")));
		WebElement reservationBtn = driver.findElement(By.cssSelector("#result-form > fieldset > div.tbl_wrap.th_thead > table > tbody > tr:nth-child(3) > td:nth-child(7) > a"));
		reservationBtn.click();
		WebElement idInput = driver.findElement(By.cssSelector("#srchDvNm01"));
		idInput.sendKeys("2483014815");
		WebElement pwInput = driver.findElement(By.cssSelector("#hmpgPwdCphd01"));
		pwInput.sendKeys("gusxo1346798!");
		pwInput.sendKeys(Keys.ENTER);
		WebElement payBtn = driver.findElement(By.cssSelector("#list-form > fieldset > div.tal_c > a.btn_large.btn_blue_dark.val_m.mgr10"));
		payBtn.click();
		WebElement keypadBtn = driver.findElement(By.cssSelector("#Tk_stlCrCrdNo14_checkbox"));
		keypadBtn.click();
		WebElement card1Input = driver.findElement(By.cssSelector("#stlCrCrdNo11"));
		card1Input.sendKeys("9490");
		WebElement card2Input = driver.findElement(By.cssSelector("#stlCrCrdNo12"));
		card2Input.sendKeys("9402");
		WebElement card3Input = driver.findElement(By.cssSelector("#stlCrCrdNo13"));
		card3Input.sendKeys("7909");
		WebElement card4Input = driver.findElement(By.cssSelector("#stlCrCrdNo14"));
		card4Input.sendKeys("5025");
		Select month = new Select(driver.findElement(By.cssSelector("#crdVlidTrm1M")));
		month.selectByValue("06");
		Select year = new Select(driver.findElement(By.cssSelector("#crdVlidTrm1Y")));
		year.selectByValue("27");
		WebElement keypadBtn2 = driver.findElement(By.cssSelector("#Tk_vanPwd1_checkbox"));
		keypadBtn2.click();
		WebElement cardpwInput = driver.findElement(By.cssSelector("#vanPwd1"));
		cardpwInput.sendKeys("06");
		WebElement birthInput = driver.findElement(By.cssSelector("#athnVal1"));
		birthInput.sendKeys("980911");
		WebElement finishBtn = driver.findElement(By.cssSelector("#requestIssue1"));
		finishBtn.click();
		driver.switchTo().alert().accept();
		
		
		}

}
