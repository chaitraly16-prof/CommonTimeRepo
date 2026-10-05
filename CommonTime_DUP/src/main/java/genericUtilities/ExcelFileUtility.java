package genericUtilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
		
		public String ReadData(String sh, int rownum, int cellnum) throws Exception {
			FileInputStream fis = new FileInputStream("C:\\Users\\chait\\Desktop\\JAVA2026\\CommonTime\\src\\test\\resources\\LessonInfo.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			return wb.getSheet(sh).getRow(rownum).getCell(cellnum).toString();
		}
	}

