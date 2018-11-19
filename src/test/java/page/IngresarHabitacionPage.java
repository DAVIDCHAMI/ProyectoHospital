package page;

import java.sql.CallableStatement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import constantes.CosntantesPrueba;

public class IngresarHabitacionPage {
	
	private WebDriver driver;

	public IngresarHabitacionPage(WebDriver driver) {
		super();
		this.driver = driver;
         PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using="/html/body/div/div/div/div[2]/div/div/div/div/div[1]/div/a[3]")
	private WebElement ingresarHabitacion;
	
	@FindBy(how = How.NAME, using="name")
	private WebElement numeros;
	
	@FindBy(how = How.XPATH, using="/html/body/div/div/div/div[3]/div[2]/div[1]/div/label/input")
	private WebElement hDoble;
	
	
	@FindBy(how = How.XPATH, using="/html/body/div/div/div/div[3]/div[1]/a")
	private WebElement guardar;
	
	
	
	public void IngresarHabi(String habitacion) {
		driver.get(CosntantesPrueba.URL);
		System.out.println("se  ingresa al metodo");
		
		ingresarHabitacion.click();
		
		numeros.sendKeys(habitacion);
		
		hDoble.click();
		
		guardar.click();
		
		
	}

	
	

}
