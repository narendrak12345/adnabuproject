package MainBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {


		public static WebDriver driver;
		public static Properties prop;
		public static FileInputStream fis;

		public baseTest() throws IOException {

			prop = new Properties();
			String home = System.getProperty("user.dir");
			fis = new FileInputStream(home + "\\src\\main\\resources\\Properties\\testData.properties");
			prop.load(fis);
		}

		public void init() {

			WebDriverManager.chromedriver().setup();
			String browser = prop.getProperty("browser");

			if (browser.equals("chrome")) {
				driver = new ChromeDriver();
				
			} else if (browser.equals("firefox")) {
				driver = new FirefoxDriver();
				
			} else if (browser.equals("ie")) {
				driver = new InternetExplorerDriver();

			}
				else if (browser.equals("edge")) {
					driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
			driver.get(prop.getProperty("url"));
		}
	}