package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class ReadExcelData {

	// se instancia clase para archivo xlsx libro
	private static XSSFWorkbook excelwBook;

	// para archivo con extensión xlsx hoja
	private static XSSFSheet excelwSheet;

	// archivo con extensión xlsx celda
	private static XSSFCell cell;

	public static void setExcelFile(String path, String sheetName) throws IOException {

		try {
			// open the Excel file
			FileInputStream excelFile = new FileInputStream(path);

			// access the required test data sheet

			excelwBook = new XSSFWorkbook(excelFile);
			excelwSheet = excelwBook.getSheet(sheetName);

		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("este es  el error :" + e);
		} catch (IOException e1) {
			System.out.println("este es el error: " + e1);
		}

	}

	@DataProvider(name = "getDatosPrueba")
	public static Object[][] getDatos() {

		int filas = 1;
		int columnas = 4;

		Object[][] datos = new Object[filas][columnas];

		try {

			setExcelFile("src/test/resources/DatosPruebas.xlsx", "hoja1");

			// recorre las filas
			for (int i = 0; i < filas; i++) {
				// recorre las columnas
				int con = 0;
				for (int j = 0; j < columnas; j++) {
					cell = excelwSheet.getRow(i).getCell(j);

					datos[i][j] = cell.getStringCellValue();
					/*
					 * if(con < 2) { datos[i][j] = cell.getStringCellValue(); }else { datos[i][j]
					 * =(int) (cell.getNumericCellValue()); } System.out.println(datos[i][j]); con =
					 * con+1;
					 */
				}
			}

			return datos;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error " + e);
			return null;
		}

	}

	@DataProvider(name = "getDatosPruebaPaciente")
	public static Object[][] getDatosPaciente() {

		int filas = 2;
		int columnas = 4;

		Object[][] datos = new Object[filas][columnas];

		try {

			setExcelFile("src/test/resources/DatosPaciente.xlsx", "hoja1");

			// recorre las filas
			for (int i = 0; i < filas; i++) {
				// recorre las columnas
				int con = 0;
				for (int j = 0; j < columnas; j++) {
					cell = excelwSheet.getRow(i).getCell(j);

					datos[i][j] = cell.getStringCellValue();
				//	System.out.println(datos[i][j] = cell.getStringCellValue());
					/*
					 * if(con < 2) { datos[i][j] = cell.getStringCellValue(); }else { datos[i][j]
					 * =(int) (cell.getNumericCellValue()); } System.out.println(datos[i][j]); con =
					 * con+1;
					 */
				}
			}

			return datos;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error " + e);
			return null;
		}

	}
	
	
	@DataProvider(name = "getDatosHabitacion")
	public static Object[][] getDatosHabitacion() {

		int filas = 1;
		int columnas = 1;

		Object[][] datos = new Object[filas][columnas];

		try {

			setExcelFile("src/test/resources/DatosHabitacio.xlsx", "hoja1");

			// recorre las filas
			for (int i = 0; i < filas; i++) {
				// recorre las columnas
				int con = 0;
				for (int j = 0; j < columnas; j++) {
					cell = excelwSheet.getRow(i).getCell(j);

					datos[i][j] = cell.getStringCellValue();
					
				}
			}

			return datos;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error " + e);
			return null;
		}

	}
	


}
