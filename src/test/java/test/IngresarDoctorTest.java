package test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import common.BaseTest;
import common.ReadExcelData;
import constantes.CosntantesPrueba;
import page.IngresarDoctorPage;

public class IngresarDoctorTest  extends BaseTest{
	
	
	@Test(dataProvider="getDatosPrueba",  dataProviderClass=ReadExcelData.class)
	public void ingresarDoctor(String nombre, String apellido, String telefono, String identificacion) throws  IOException,InterruptedException {
		IngresarDoctorPage doctor = new IngresarDoctorPage(driver);
		driver.get(CosntantesPrueba.URL);
		doctor.registrarDoctor( nombre,  apellido,  telefono,  identificacion);
		String ux= doctor.getConfirmar1().getText();
		
		 assertEquals(ux, "Guardado:");
		
	}

}
