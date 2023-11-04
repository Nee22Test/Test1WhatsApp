package org.Utility1;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;

public class ExcelDataConfig {
   XSSFWorkbook wb;
    XSSFSheet sheet1;

    public ExcelDataConfig(String excelPath) {
        try {
            File src = new File(excelPath);
            FileInputStream fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);
        } catch (Exception e) {
                System.out.println(e.getMessage());
            }

    }

    public String getData(int sheetNumber, int row, int column) {


if(wb!=null)
{
         sheet1 = wb.getSheetAt(sheetNumber);
     }

      //  String data = sheet1.getRow(row).getCell(column).toString();
        String data = sheet1.getRow(row).getCell(column).toString();

        return data;
    }

    public String getInt(int sheetNumber, int row, int column) {
        sheet1 = wb.getSheetAt(sheetNumber);
        double number = sheet1.getRow(row).getCell(column).getNumericCellValue();

        String datanumber = Integer.toString((int) number);
        return datanumber;

    }

    public String getDate(int sheetNumber, int row, int column) throws ParseException {
        sheet1 = wb.getSheetAt(sheetNumber);
        DataFormatter formatter = new DataFormatter();

        String val = formatter.formatCellValue(sheet1.getRow(row).getCell(column));
        return val;
    }
    public void writeExcel(String status,int rowno, int columno) throws IOException {
        FileInputStream fis =new FileInputStream("src/test/java/TestData/TestData1.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheet("TestData");
        Cell cells=null;
        cells=sheet.getRow(rowno).getCell(columno);
        System.out.println("Excel data"+status);
        cells.setCellValue(status);
        FileOutputStream fos =new FileOutputStream("src/test/java/TestData/TestData1.xlsx");
        workbook.write(fos);
        fos.close();
    }
    public static void writeExcel1(String status, int rowno, int columno) throws IOException {

        FileInputStream fis =new FileInputStream("C:\\Users\\SIB\\eclipse-workspace\\Mirror Plus_POC\\src\\org\\TestData\\TestData.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
      
        XSSFSheet sheet=workbook.getSheetAt(1);


        Cell cells=null;

        //cells=sheet.getRow(rowno).getCell(columno);
              // cells.setCellValue(status);

        XSSFRow r1=sheet.createRow(rowno);
       XSSFCell c1=r1.createCell(columno);

        c1.setCellValue(status);
       // if (cells.getCellType() != CellType.BLANK) {
           // cells.setCellValue(BLANK)
      // }
        FileOutputStream fos =new FileOutputStream("C:\\Users\\SIB\\eclipse-workspace\\Mirror Plus_POC\\src\\org\\TestData\\TestData.xlsx");
        workbook.write(fos);
        fos.close();
       workbook.close();
        //Cell cells=null;
       // cells=sheet.getRow(rowno).getCell(columno);
        //System.out.println("Excel data"+status);
       // cells.setCellValue(status);
        //FileOutputStream fos =new FileOutputStream("src/test/java/TestData/TestData1.xlsx");
        //workbook.write(fos);
        //fos.close();
    }
}

