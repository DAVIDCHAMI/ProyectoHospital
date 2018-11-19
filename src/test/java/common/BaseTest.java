package common;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

	public WebDriver driver;
	
	@Parameters({"browser"})
	@BeforeTest
	public void abrirNavegador(String browser) throws MalformedURLException {

		if ("chrome".equals(browser)) {

			// definir propiedad que contiene el drivers
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			ChromeOptions chromeoptions = new ChromeOptions();
			// preferencias del navegador
			chromeoptions.addArguments("start-maximized");
			// driver = new FirefoxDriver;
			// driver = new InternetExploreDriver;
			driver = new ChromeDriver(chromeoptions);

			// para que se ejecuten las pruebas sin abrir el navegador ("--headless")
			// ("disable-")

			/*
			 * // Preferencias del navegador
			 * chromeOptions.addArguments("--headless","start-maximized", "--incognito",
			 * "disable-infobars");
			 */

		} else if("remote".equals(browser)){
			
			DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.WINDOWS);
			//driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			driver= new RemoteWebDriver(new URL("http:/172.30.4.172/:4444/wd/hub"),capabilities);
              /*
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			//driver = new ();
			// preferencias del navegador
			//firefox.addArguments("start-maximized");
			// driver = new FirefoxDriver;
			// driver = new InternetExploreDriver;
			*/
			System.out.println("El  parametro no esta configurado");

		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

	}

	@AfterTest
	public void cerrarNavegador() {
		if (driver != null) {
			driver.quit();
			System.out.println("Se cierra el  navegador");
		} else {
			System.out.println("No  hay driver con sesión activa");
		}
	}

	
	
}
