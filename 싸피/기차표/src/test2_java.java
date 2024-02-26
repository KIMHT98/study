import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test2_java {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,10); // 10초 기다리겠다.
		
		driver.get("https://www.google.com/search?q=%EA%B3%A0%EC%96%91%EC%9D%B4&sca_esv=597681688&tbm=isch&source=lnms&sa=X&ved=2ahUKEwjo2uud5taDAxXogFYBHTSPAjcQ_AUoAXoECAIQAw&biw=929&bih=879");
		
		List<WebElement> images = driver.findElements(By.cssSelector(".rg_i"));
		
		  int count = 0;

	        for (WebElement image : images) {
	            if (count == 10)
	                break;
	            count++;

	            image.click();

	            WebElement imgElement = wait
	                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".sFlh5c.pT0Scc.iPVvYb")));

	            String imgSrc = imgElement.getAttribute("src");
	            
	            if (imgSrc.contains(".webp")) {
	                count++;
	                continue;
	            }

	            try {
	                BufferedImage saveImage = ImageIO.read(new URL(imgSrc));
	                ImageIO.write(saveImage, "jpg", new File("cat" + count + ".jpg"));
	            } catch (IOException e) {
	                e.printStackTrace();
	            }

	        }

	    }
}
