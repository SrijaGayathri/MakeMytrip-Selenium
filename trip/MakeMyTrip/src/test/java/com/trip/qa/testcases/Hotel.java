package com.trip.qa.testcases;

import java.util.HashMap;
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
 
public class Hotel {
 
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\2164250\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
	    Thread.sleep(2000);
		WebElement iframe1 = null;
		try {
			iframe1 = driver
					.findElement(By.xpath("//iframe[@id='webklipper-publisher-widget-container-notification-frame']"));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Iframe element not found, Because  No ad pop-up came ");
		}
		if (iframe1 != null) {
			driver.switchTo().frame(iframe1);
 
			
			driver.findElement(By.xpath("//a[@class='close']")).click();
 
			
			driver.switchTo().defaultContent();
		}
		Thread.sleep(5000);
		//clicking on hotels
		driver.findElement(By.xpath("(//*[contains(@class,'headerIconText')])[2]")).click();
		Thread.sleep(5000);
		//city input box
		WebElement city = driver.findElement(By.xpath("//input[@Id='city']"));
		city.click();
		Thread.sleep(7000);
		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div/div[1]/div[1]/div[1]/div/div/div/div[1]/input"))
				.sendKeys("Hyderabad");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']")).click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("(//div[contains(text(),'28')])[2]")).click();
		WebElement element = driver.findElement(By.xpath("(//div[contains(text(),'28')])[2]"));
        // Use JavascriptExecutor to click on the element
       ((RemoteWebDriver) driver).executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		//driver.findElement(By.xpath("(//div[contains(text(),'31')])[1]")).click();
		WebElement element1 = driver.findElement(By.xpath("(//div[contains(text(),'31')])[1]"));
       ((RemoteWebDriver) driver).executeScript("arguments[0].click();", element1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='gstSlctCont'])[3]/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("((//div[@class='gstSlctCont'])[3]/ul/li)[2]")).click();
		Thread.sleep(2000);
		WebElement agedropdown = driver.findElement(By.xpath("((//div[@class='gstSlct'])[4])"));
	    ((RemoteWebDriver) driver).executeScript("arguments[0].click();", agedropdown);
		//driver.findElement(By.xpath("((//div[@class='gstSlct'])[4])")).click();
		Thread.sleep(2000);
		WebElement elementchildage = driver.findElement(By.xpath("((//div[@class='gstSlctCont gstDrpDown__cont'])/ul/li)[6]"));
	    ((RemoteWebDriver) driver).executeScript("arguments[0].click();", elementchildage);
		//driver.findElement(By.xpath("((//div[@class='gstSlctCont gstDrpDown__cont'])/ul/li)[6]")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		//Thread.sleep(2000);
	    WebElement apply = driver.findElement(By.xpath("//button[contains(text(),'Apply')]"));
	    ((RemoteWebDriver) driver).executeScript("arguments[0].click();", apply);
	    Thread.sleep(2000);
		//WebElement pricepernight = driver.findElement(By.xpath("//*[@class='hsw_inputBox travelFor']"));
	    //((RemoteWebDriver) driver).executeScript("arguments[0].click();", pricepernight);
		driver.findElement(By.xpath("//*[@class='hsw_inputBox travelFor']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@class='ppn__list']/li[2]")).click();
		//Thread.sleep(2000);
		WebElement pricepernightlist = driver.findElement(By.xpath("//*[@class='ppn__list']/li[2]"));
	    ((RemoteWebDriver) driver).executeScript("arguments[0].click();", pricepernightlist);
		
	    WebElement searchbutton= driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
	    ((RemoteWebDriver) driver).executeScript("arguments[0].click();", searchbutton);
	    //driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		//Thread.sleep(5000);
	    
	    WebElement higherpricelist = driver.findElement(By.xpath("//ul[@class='srtByFltr__list']/li[3]"));
	    ((RemoteWebDriver) driver).executeScript("arguments[0].click();", higherpricelist);
		//driver.findElement(By.xpath("//ul[@class='srtByFltr__list']/li[3]")).click();
		Thread.sleep(2000);
		HashMap<String, String> hoteldetailshigh = new HashMap<>();
		HashMap<String, String> hoteldetailslow = new HashMap<>();
		List<WebElement> Hotelnamesele = driver.findElements(By.xpath("//*[@class='latoBlack blackText font20']"));
		List<WebElement> pricesele = driver.findElements(By.xpath("//p[@class='latoBlack font22 blackText appendBottom5']"));
		for (int i = 0; i < Hotelnamesele.size(); i++) {
			String hotelname = Hotelnamesele.get(i).getText();
			String hotelprice = pricesele.get(i).getText();
			hoteldetailshigh.put(hotelname, hotelprice);
		}
		WebElement lowerpriceslist = driver.findElement(By.xpath("//ul[@class='srtByFltr__list']/li[4]"));
	    ((RemoteWebDriver) driver).executeScript("arguments[0].click();",lowerpriceslist);
		//driver.findElement(By.xpath("//ul[@class='srtByFltr__list']/li[4]")).click();
		Thread.sleep(2000);
		Hotelnamesele = driver.findElements(By.xpath("//*[@class='latoBlack blackText font20']"));
		pricesele = driver.findElements(By.xpath("//p[@class='latoBlack font22 blackText appendBottom5']"));
		for (int i = 0; i < Hotelnamesele.size(); i++) {
			String hotelname = Hotelnamesele.get(i).getText();
			String hotelprice = pricesele.get(i).getText();
			hoteldetailslow.put(hotelname, hotelprice);
		}
		System.out.println("-------------------Hotels Starting with higher prices--------------");
		System.out.println();
		for (String hotelname : hoteldetailshigh.keySet()) {
			System.out.println(hotelname + "   " + "price" + hoteldetailshigh.get(hotelname));
			System.out.println();
		}
		System.out.println("-------------------Hotels Starting with lower prices------------------------");
		System.out.println();
		for (String hotelname : hoteldetailslow.keySet()) {
			System.out.println(hotelname + "    " + "Price" + hoteldetailslow.get(hotelname));
			System.out.println();
		}
 
		driver.close();
 
	}
 
}
