package uk.gov.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import uk.gov.base.TestBase;
import uk.gov.pages.CheckIfaVehicleIsTaxedAndHasAnMOTPage;
import uk.gov.pages.EnterRegistrationNumberOfTheVehiclePage;
import uk.gov.pages.GetVehicleInformationPage;
import uk.gov.pages.IsThisTheVehicleYouAreLookingForPage;

public class VehicleTest extends TestBase {
	
	GetVehicleInformationPage getVehicleInformationPage = new GetVehicleInformationPage();
	EnterRegistrationNumberOfTheVehiclePage enterRegNumber = new EnterRegistrationNumberOfTheVehiclePage();
	IsThisTheVehicleYouAreLookingForPage isThisTheVehicleYouAreLookingForPage = new IsThisTheVehicleYouAreLookingForPage();
	CheckIfaVehicleIsTaxedAndHasAnMOTPage checkIfaVehicleIsTaxedAndHasAnMOTPage = new CheckIfaVehicleIsTaxedAndHasAnMOTPage();
	
	@BeforeMethod
	public void openApplication(){
		InitializeDriver("browser");
		navigate("url");
	}
	
	@Test(dataProvider="getData")
	public void checkVehicle(String registrationNumber, String make){
		getVehicleInformationPage.clickOnStrartNow();
		enterRegNumber.enterRegistrationNumber(registrationNumber);
		enterRegNumber.clickOnContinue();
		isThisTheVehicleYouAreLookingForPage.clickOnYes();
		isThisTheVehicleYouAreLookingForPage.clickOnContinue();
		String actualMake = checkIfaVehicleIsTaxedAndHasAnMOTPage.checkVehicleMake();
		String expectedMake = make;
		Assert.assertEquals(expectedMake,actualMake);

	}
	
	@DataProvider
	public  Object[][] getData(){
	
		XLS_Reader xls = new XLS_Reader(System.getProperty("user.dir")+"/Vehicle.xlsx");
		int rows = xls.getRowCount("VehicleDetails");
		int cols = xls.getColumnCount("VehicleDetails");
		System.out.println("Total rows are = "+rows);
		System.out.println("Total columns are = "+cols);
		Object data[][] = new Object[rows-1][cols];
		for(int rowNum=2;rowNum<=rows;rowNum++){
			for(int colNum=0;colNum<cols;colNum++){
				System.out.print(xls.getCellData("VehicleDetails", colNum, rowNum)+"==");
				data[rowNum-2][colNum] = xls.getCellData("VehicleDetails", colNum, rowNum);
			}
			System.out.println();
		}
		return data;	
	}
	
	@AfterMethod
	public void closeBrowser(){
		closeDriver();
	}

}
