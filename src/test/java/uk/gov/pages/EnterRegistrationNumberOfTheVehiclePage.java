package uk.gov.pages;

import org.openqa.selenium.By;
import uk.gov.base.TestBase;

public class EnterRegistrationNumberOfTheVehiclePage extends TestBase {
	
	public void enterRegistrationNumber(String registrationNumber){
		
		driver.findElement(By.id(OR.getProperty("registrationNumber_id"))).sendKeys(registrationNumber);
		}
	
	public void clickOnContinue(){
		driver.findElement(By.name(OR.getProperty("continue_name"))).click();
	}

}
