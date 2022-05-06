

import java.util.List;

import org.apache.http.client.HttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ABCdTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.google.com");
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int Nooflinks = allLinks.size();
		System.out.println(Nooflinks);
		for(WebElement ele:allLinks) {
			
				System.out.println(ele.getText());
			
					
		}

	}

}
