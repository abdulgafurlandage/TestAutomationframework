package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSdata;

public class Test1 extends BaseTest {

	@Test(dataProviderClass=ReadXLSdata.class,dataProvider="exceldata")
	public static void LoginTest(String username, String password) {

		driver.findElement(By.className(loc.getProperty("signup"))).click(); // locators

		driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(username);

		driver.findElement(By.id(loc.getProperty("next_button"))).click();
		driver.findElement(By.id(loc.getProperty("pwd_field"))).sendKeys(password);
		driver.findElement(By.id(loc.getProperty("login_next_button"))).click();

	}
	
	
	
	

//	@DataProvider(name = "testdata")
//	public Object[][] tData() {
//
//		return new Object[][] { { "salmanlandage@gmail.com", "Salman@1997" },
//				{ "salmanlandage237@gmail.com", "Salm@1997" }, { "salmanlandage2337@gmail.com", "Sn@1997" },
//				{ "salmanlandage2337@gmail.com", "Salman@1997" }
//
//		};
//	}
}
