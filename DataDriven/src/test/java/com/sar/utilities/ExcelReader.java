package com.sar.utilities;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static  XSSFWorkbook workbook;
	 static XSSFSheet sheet;
	 

	 
	 public ExcelReader(String pathname) {
			try {
				workbook = new XSSFWorkbook(pathname);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	 }	

		public int getRowCount(String sheetname) throws IOException {

			int rowCount = 0;
			
			
			sheet = workbook.getSheet(sheetname);
			
			
			try {
				
			  rowCount = sheet.getPhysicalNumberOfRows();
				System.out.println("the row count is : "+rowCount);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return rowCount;
		}
		
		public int getColCount(String sheetname ) throws IOException {
			int colCount = 0;
			
			sheet = workbook.getSheet(sheetname);
		
			
			try {
				colCount = sheet.getRow(0).getPhysicalNumberOfCells();
				System.out.println("the col count is : "+colCount);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			return colCount;
		}

		public String getDataString(int rowNum, int colNum, String sheetname) throws IOException {
			
			String cellData = null ;
			
			
		 sheet = workbook.getSheet(sheetname);
		
			
			try {
		
			    cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
				//System.out.println(cellData);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cellData;
			}
			
		/*
			public double getDataNumeric(int rowNum, int colNum) {
				
				double cellData= 0;
				
				try {
					double cellvalue = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
					//System.out.println(cellvalue);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	            return cellData;
			
		}
		*/

	}




