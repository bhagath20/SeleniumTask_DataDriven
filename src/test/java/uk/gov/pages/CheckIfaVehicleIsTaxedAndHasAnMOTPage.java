package uk.gov.pages;

import org.openqa.selenium.By;
import uk.gov.base.TestBase;

public class CheckIfaVehicleIsTaxedAndHasAnMOTPage extends TestBase {
	
	public String checkVehicleMake(){
		
		String text = driver.findElement(By.xpath(OR.getProperty("vehicleMake_xpath"))).getText();
		return text;
		
	}

}
