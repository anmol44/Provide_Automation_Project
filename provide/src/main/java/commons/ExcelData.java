package commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	@SuppressWarnings("unchecked")
	public static HashMap<Integer, HashMap<String, String>> getExcelData(String Name) throws Exception {
		String path = System.getProperty("user.dir");
		HashMap<Integer, HashMap<String, String>> map = new HashMap<Integer, HashMap<String, String>>();
		HashMap<String, String> mapInner = new HashMap<String, String>();

		try {

			FileInputStream src = new FileInputStream(path + "\\test\\" + Name + ".xlsx");
			Workbook workbook = new XSSFWorkbook(src);
			Sheet sheet = workbook.getSheetAt(0);

			int rows = sheet.getLastRowNum();

			for (int i = 1; i <= rows; i++) {
				int columnNum = sheet.getRow(i).getLastCellNum();
				for (int j = 0; j < columnNum; j++) {
					if (sheet.getRow(i).getCell(j) == null)
						// sheet.getRow(i).getCell(j).setCellValue(" ");
						sheet.getRow(i).createCell(j).setCellValue(" ");
					// System.out.println(sheet.getRow(i).getCell(j));
					mapInner.put(sheet.getRow(0).getCell(j).getStringCellValue(),
							sheet.getRow(i).getCell(j).toString());
				}
				map.put(i, (HashMap<String, String>) mapInner.clone());
				mapInner.clear();

			}

			workbook.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		return map;
	}

}
