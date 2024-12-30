package base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();

	public static FileReader fr;
	public static FileReader fr1;
	
	@BeforeMethod
	public void setup() throws IOException {
		
		if(driver==null) {
			//System.out.println("The path is: " + System.getProperty("user.dir"));       //to get the path of file
			 fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			 fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
			
			prop.load(fr);
			loc.load(fr1);
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();    //base
		    driver= new ChromeDriver();       //base
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(prop.getProperty("testurl"));        //properties

		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();    //base
			driver= new FirefoxDriver();       //base
			driver.manage().window().maximize();
	//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   // it is deprecated by developers
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(prop.getProperty("testurl"));         //properties

		}
		
	}
	@AfterMethod
	public void tearDown() {
		
		driver.close();
		System.out.println("tearDown done");
		
		
	}
}
