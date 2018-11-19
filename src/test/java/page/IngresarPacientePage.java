package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constantes.CosntantesPrueba;

public class IngresarPacientePage {
	
	private WebDriver driver;

	public IngresarPacientePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//elementos
	
	@FindBy(how = How.XPATH, using="/html/body/div/div/div/div[2]/div/div/div/div/div[1]/div/a[2]")
	private WebElement ingresarPaciente;
	
	@FindBy(how = How.NAME, using="name")
	private WebElement nombres;
	
	
	@FindBy(how = How.NAME, using="last_name")
	private WebElement apellidos;
	
	@FindBy(how = How.NAME, using="telephone")
	private WebElement telefonos;
	
	@FindBy(how = How.NAME, using="identification_type")
	private WebElement documento;
	
	@FindBy(how = How.NAME, using="identification")
    private WebElement identificacion1;
	
	@FindBy(how = How.NAME, using="prepaid")
	private WebElement salud;
	
	
	@FindBy(how = How.XPATH, using="/html/body/div/div/div/div[3]/div/a")
	private WebElement guardar;
	
	
	
	                                
	
	public void registrarPaciente(String nombre, String apellido, String telefono, String identificacion) throws InterruptedException {
		
		System.out.println("entro al metodo registrar PACIENTE");
		driver.get(CosntantesPrueba.URL);
	  ingresarPaciente.click();
	   nombres.sendKeys(nombre);
	   apellidos.sendKeys(apellido);
       telefonos.sendKeys(telefono);
       
       Thread.sleep(3000);
		Select listaCuatro = new Select(documento);
		listaCuatro.selectByIndex(1);
		
		identificacion1.sendKeys(identificacion);
		salud.click();
		
		
	}


	

	
	
	
	
	
}
