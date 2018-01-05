package uk.gov.pages;


import org.openqa.selenium.By;
import uk.gov.base.TestBase;

public class GetVehicleInformationPage extends TestBase {
	
public void clickOnStrartNow(){
	driver.findElement(By.xpath(OR.getProperty("startnow_xpath"))).click();
		}

}
