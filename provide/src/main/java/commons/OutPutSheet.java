package commons;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aventstack.extentreports.ExtentReports;

public class OutPutSheet {
	
		static HashMap<Integer, HashMap<String,String>> excelData;
		static Cell cell;
		static CellStyle style;
	//	static String outputFile = System.getProperty("user.dir") +"/Output/OutputDataProvide.xlsx";
	
	public static Workbook createOutPutSheet(String inputFile, String outputFile ) {
		 FileSystem system = FileSystems.getDefault();
       Path original = system.getPath(inputFile);
	        Path target = system.getPath(outputFile);
          Workbook workbook = null;
	        try {
	            // Throws an exception if the original file is not found.
	            Files.copy(original, target, StandardCopyOption.REPLACE_EXISTING);
	            System.out.println(target);
	        	FileInputStream src = new FileInputStream(target.toString());
	        	System.out.println(src);
	        	
				 workbook = new XSSFWorkbook(src);
           
	        } catch (IOException ex) {
	            System.out.println("ERROR");
	        }
	        
	        return workbook;
	}
	
	
	public static CellStyle cellStyleColor(Workbook workbook,String status) {
        
		 CellStyle style = workbook.createCellStyle();
		 
			if(status.equals("FAIL")) {
				
				 style.setFillForegroundColor(IndexedColors.RED.getIndex());  
			     style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
				
			}else {
				 style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());  
			     style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
				 
			}
		return style ;
	}
	
	public static  void testStatusInSheet( XSSFWorkbook workbook,XSSFSheet sheet,HashMap<Integer, HashMap<String,String>> excelData) {
		 System.out.println(sheet);
		 System.out.println(excelData.get(1).size());
		 cell = sheet.getRow(0).createCell(excelData.get(1).size()+1);
		 cell.setCellValue("Test Status");
		
	}
	
	public static void outPutResultSheet(XSSFWorkbook workbook,ExtentReports extent, String outputFile ) throws IOException {
		
		 FileOutputStream outputStream = new FileOutputStream(outputFile);
	     workbook.write(outputStream);
	     workbook.close();
	     extent.flush();
	}
	
	public static void updateStatus(XSSFWorkbook workbook,XSSFSheet sheet,String status,int i,HashMap<Integer, HashMap<String,String>> excelData) throws IOException{
			
		if(status=="FAIL") {
			cell = sheet.getRow(i).createCell(excelData.get(1).size()+1);
			 cell.setCellValue("FAIL");
			style = OutPutSheet.cellStyleColor(workbook, status);
			cell.setCellStyle(style); 
		}else {
			cell = sheet.getRow(i).createCell(excelData.get(1).size()+1);
			 cell.setCellValue("PASS");
			 style = OutPutSheet.cellStyleColor( workbook, status);
			 cell.setCellStyle(style); 
			 
		}
	}

}
