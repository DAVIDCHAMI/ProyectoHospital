package test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.BaseTest;
import common.ReadExcelData;
import page.IngresarPacientePage;

public class IngresarPacienteTest extends BaseTest{
	
	@Test(dataProvider="getDatosPruebaPaciente", dataProviderClass=ReadExcelData.class)
	public void IngresarPaciente(String nombre, String apellido, String telefono, String identificacion) throws InterruptedException {
		
		IngresarPacientePage paciente = new IngresarPacientePage(driver);
		paciente.registrarPaciente(nombre, apellido, telefono, identificacion);
		
	}
	/*
	@DataProvider(name="getDatosChamo")
	public static Object[][] getDatosPrueba(int filas, int columnas){
		
		Object[][] datos = ReadExcelData.getDatosPaciente();
		
		return datos;
		
	}
*/
}
