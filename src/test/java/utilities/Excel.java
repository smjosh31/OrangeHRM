package utilities;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

//import static jdk.jfr.internal.SecuritySupport.newFileInputStream;

public class Excel {
    public static String getValue(String path, String sheet, int r, int c) {
        String v = "";
        try {
            Workbook wb = WorkbookFactory.create(new FileInputStream(path));
            v = wb.getSheet(sheet).getRow(r).getCell(c).toString();

        } catch (Exception e) {

        }
        return v;
    }

    //Method to Count Number of Row values in excel
    public static int getRowCount(String path, String sheet) {
        int rc = 0;
        try {
            Workbook wb = WorkbookFactory.create(new FileInputStream(path));
            rc = wb.getSheet(sheet).getPhysicalNumberOfRows();

        } catch (Exception e) {
            // TODO: handle exception
        }
        return rc;
    }

    public static int getColumnCount(String path, String sheet, int r) {
        int cc = 0;
        try {
            Workbook wb = WorkbookFactory.create(new FileInputStream(path));
            cc = wb.getSheet(sheet).getRow(r).getPhysicalNumberOfCells();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return cc;

    }
}