package test;

import org.testng.annotations.Test;

import common.BaseTest;
import common.ReadExcelData;
import page.IngresarHabitacionPage;

public class IngresarHabitacionTest extends BaseTest{
	
	@Test(dataProvider="getDatosHabitacion",dataProviderClass=ReadExcelData.class)
	public void IngresarHabitacion(String habitacion) {
		
		IngresarHabitacionPage habi= new IngresarHabitacionPage(driver);
		habi.IngresarHabi(habitacion);
		
	}
	

}
