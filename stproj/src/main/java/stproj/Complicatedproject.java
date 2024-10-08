import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Complicatedproject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.Launch the browser
		WebDriver driver=new ChromeDriver();
		//2.To get URL
		driver.get("https://www.wittee.in//");
		driver.manage().window().maximize();
		WebElement searchBox=driver.findElement(By.name("s"));
		searchBox.sendKeys("Led Zeppelin Oversized T-shirt |Smokey Design");
		searchBox.submit();
		
		String mainPage=driver.getWindowHandle();
		System.out.println("Main page="+mainPage);
		
		driver.findElement(By.xpath("//a[normalize-space()='Led Zeppelin Oversized T-shirt | Smokey Design']")).click();
		Set<String> allPages=driver.getWindowHandles();
		for(String page : allPages) {
			if(!page.equals(mainPage)) {
				driver.switchTo().window(page);
				break;
			}
		}
		System.out.println(driver.getCurrentUrl());
		List<WebElement> products=driver.findElements(By.className("product_title entry-title wd-entities-title"));
		System.out.println(products.size());
		for(WebElement product:products) {
			System.out.println(product.getText());
		}
	}

}