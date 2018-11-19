package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class IngresarDoctorPage {

	private WebDriver driver;

	public IngresarDoctorPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * Elementos mapeados
	 */

	@FindBy(xpath = "/html/body/div/div/div/div[2]/div/div/div/div/div[1]/div/a[1]")
	private WebElement agregarDoct1;

	By agregarDoct = By.xpath("/html/body/div/div/div/div[2]/div/div/div/div/div[1]/div/a[1]");

	@FindBy(id = "name")
	private WebElement name1;

	// By name = By.cssSelector("//input[@id='name']");

	By name = By.id("name");

	@FindBy(id = "last_name")
	private WebElement apellidos1;

	By apellidos = By.id("last_name");

	@FindBy(id = "telephone")
	private WebElement telefonos1;

	By telefonos = By.id("telephone");

	@FindBy(id = "identification_type")
	private WebElement listaDesplegable1;

	By listaDesplegable = By.id("identification_type");

	@FindBy(id = "identification")
	private WebElement documento1;

	By documento = By.id("identification");

	@FindBy(xpath = "/html/body/div/div/div/div[3]/div/a")
	private WebElement Guardar1;

	By Guardar = By.xpath("/html/body/div/div/div/div[3]/div/a");
	
	@FindBy(xpath="/html/body/div/div/div/div[2]/div[1]/h3")
	 WebElement confirmar1;

	By confirmar = By.xpath("/html/body/div/div/div/div[2]/div[1]/h3");

	public void registrarDoctor(String nombre, String apellido, String telefono, String identificacion)
			throws InterruptedException {
		// driver.get(CosntantesPrueba.URL);

		System.out.println("entre al metodo" + telefono);

		agregarDoct1.click();

		name1.sendKeys(nombre);

		apellidos1.sendKeys(apellido);

		telefonos1.sendKeys((telefono));

		Thread.sleep(3000);
		Select listaCuatro = new Select(listaDesplegable1);
		listaCuatro.selectByIndex(0);

		documento1.sendKeys(identificacion);

		Guardar1.click();

		// assertEquals(driver.findElement(confirmar).getText(), "Guardado:");

	}

	public WebElement getConfirmar1() {
		return confirmar1;
	}
	
	

	/*
	 * @Test(dataProvider="getDatosPrueba",dataProviderClass=ReadExcelData.class)
	 * public void registrarDoctor(String nombre, String apellido, String telefono,
	 * String identificacion) throws InterruptedException {
	 * driver.get(CosntantesPrueba.URL);
	 * 
	 * //CharSequence[] aux =(telefono);
	 * 
	 * System.out.println("entre al metodo" + telefono);
	 * 
	 * 
	 * driver.findElement(agregarDoct).click();
	 * 
	 * //agregarDoct1.click();
	 * 
	 * //name1.sendKeys(nombre);
	 * 
	 * driver.findElement(name).sendKeys(nombre); //apellidos.sendKeys(apellido);
	 * driver.findElement(apellidos).sendKeys(apellido);
	 * 
	 * //telefonos.sendKeys((telefono));
	 * 
	 * 
	 * driver.findElement(telefonos).sendKeys((telefono));
	 * 
	 * Thread.sleep(3000); Select listaCuatro = new
	 * Select(driver.findElement(listaDesplegable)); listaCuatro.selectByIndex(0);
	 * 
	 * //documento.sendKeys(identificacion);
	 * driver.findElement(documento).sendKeys(identificacion);
	 * 
	 * //Guardar.click(); driver.findElement(Guardar).click();
	 * 
	 * 
	 * assertEquals(driver.findElement(confirmar).getText(), "Guardado:");
	 * 
	 * }
	 * 
	 */

}
