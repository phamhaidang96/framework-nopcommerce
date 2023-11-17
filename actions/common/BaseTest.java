package common;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	protected final Log log;

	@BeforeSuite
	public void deleteFileInReport() {
		// Remove all file in ReportNG screenshot (image)
		// deleteAllFileInFolder("reportNGImage");

		// Remove all file in Allure attachment (json file)
		deleteAllFileInFolder("allure-json");
	}

	protected WebDriver getBrowserDriver(String browserName, String environmentUrl) {
		if (browserName.contains("chrome")) {
			driver = WebDriverManager.chromedriver().create();
		}

		else if (browserName.contains("firefox")) {
			driver = WebDriverManager.firefoxdriver().create();
		}

		else if (browserName.contains("edge")) {
			driver = WebDriverManager.edgedriver().create();
		}

		else if (browserName.contains("safari")) {
			driver = WebDriverManager.safaridriver().create();
		}

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(environmentUrl);
		return driver;
	}

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected int randNumber() {
//		Random rand = new Random();
//		return rand.nextInt(99999);
		return new Random().nextInt(99999);
	}

	public WebDriver getDriverInstance() {
		return driver;
	}

	public void deleteAllFileInFolder(String folderName) {
		try {
			String pathFolderDownload = GlobalConstants.PROJECT_PATH + File.separator + folderName;
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			if (listOfFiles.length != 0) {
				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
						new File(listOfFiles[i].toString()).delete();
					}
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

}
