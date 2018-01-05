package uk.gov.pages;

import org.openqa.selenium.By;
import uk.gov.base.TestBase;

public class IsThisTheVehicleYouAreLookingForPage extends TestBase {
	
	public void clickOnYes() {
		
		driver.findElement(By.id(OR.getProperty("yes_id"))).click();
		}
	
	public void clickOnContinue(){
		driver.findElement(By.name(OR.getProperty("continue_name"))).click();
	}

}
