package testUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class generateRandom {
	
	@Test
	public void Random() throws InterruptedException, IOException{

		String downloadPath1 = System.getProperty("user.dir")+"/Data_Files/Input_Data.xlsx";

		FileInputStream fis = new FileInputStream(downloadPath1);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		String Cilents = "Cilents,EditCilents";
		
		String[] CilentsCount = Cilents.split( "," );

		 for ( String Cilent : CilentsCount )  {

			XSSFSheet sheet = workbook.getSheet(Cilent);

			int rowcount = sheet.getPhysicalNumberOfRows();

			for(int j=1;j<=rowcount-1;j++ ) {

				SimpleDateFormat formatter= new SimpleDateFormat("MMddHHmmss");

				Date date = new Date(System.currentTimeMillis());

				String ProjectName ="auto_cilent_v"+formatter.format(date);

				sheet.getRow(j).createCell(0).setCellValue(ProjectName);

				FileOutputStream fos = new FileOutputStream(downloadPath1);
				
				XSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);

				workbook.write(fos);

				fos.close();
				
				Thread.sleep(1000);

			}
		}
		 
		 
		 
			String Items = "CreateItem,EditItem";
			
			String[] ItemsCount = Items.split( "," );

			 for ( String Item : ItemsCount )  {

				XSSFSheet sheet = workbook.getSheet(Item);

				int rowcount = sheet.getPhysicalNumberOfRows();

				for(int j=1;j<=rowcount-1;j++ ) {

					SimpleDateFormat formatter= new SimpleDateFormat("MMddHHmmss");

					Date date = new Date(System.currentTimeMillis());

					String ProjectName ="auto_item_v"+formatter.format(date);

					sheet.getRow(j).createCell(0).setCellValue(ProjectName);

					FileOutputStream fos = new FileOutputStream(downloadPath1);
					
					XSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);

					workbook.write(fos);

					fos.close();
					
					Thread.sleep(1000);

				}
			}
			 
			 
				String Printers = "CreatePrinter,EditPrinters";
				
				String[] PrintersCount = Printers.split( "," );

				 for ( String Printer : PrintersCount )  {

					XSSFSheet sheet = workbook.getSheet(Printer);

					int rowcount = sheet.getPhysicalNumberOfRows();

					for(int j=1;j<=rowcount-1;j++ ) {

						SimpleDateFormat formatter= new SimpleDateFormat("MMddHHmmss");

						Date date = new Date(System.currentTimeMillis());

						String ProjectName ="auto_printer_v"+formatter.format(date);

						sheet.getRow(j).createCell(0).setCellValue(ProjectName);

						FileOutputStream fos = new FileOutputStream(downloadPath1);
						
						XSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);

						workbook.write(fos);

						fos.close();
						
						Thread.sleep(1000);

					}
				}
				 
					String Quotes = "Quotes_Create,Quotes_Edit";
					
					String[] QuotesCount = Quotes.split( "," );

					 for ( String Quote : QuotesCount )  {

						XSSFSheet sheet = workbook.getSheet(Quote);

						int rowcount = sheet.getPhysicalNumberOfRows();

						for(int j=1;j<=rowcount-1;j++ ) {

							SimpleDateFormat formatter= new SimpleDateFormat("MMddHHmmss");

							Date date = new Date(System.currentTimeMillis());

							String ProjectName ="auto_Quote_v"+formatter.format(date);

							sheet.getRow(j).createCell(1).setCellValue(ProjectName);

							FileOutputStream fos = new FileOutputStream(downloadPath1);
							
							XSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);

							workbook.write(fos);

							fos.close();
							
							Thread.sleep(1000);

						}
					}
	}

}
