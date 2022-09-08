package com.CertificateValidator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExtractExcelSheet{
	String certificateName;
	int empCode;
	String empName;
	String empStatus;
	String status;
	String dateApplied;
	String examPassDate;
	float creditpnt;
	String certId;
	
	private static final String excelPath="C:\\Users\\himanshu_baghel\\Downloads\\Certificate_Report_Demo.xlsx";
	FileInputStream inputStream;
	//HSSFWorkbook wb;
	XSSFWorkbook wb;
	//HSSFSheet sheet;
	XSSFSheet sheet;
	DataFormatter dataformatter;
	public List<ExtractExcelSheet> getExcelDetails() throws IOException {
		List<ExtractExcelSheet> excelDataList=new ArrayList<ExtractExcelSheet>();
		inputStream=new FileInputStream(new File(excelPath));
		//wb=new HSSFWorkbook(inputStream);
		wb=new XSSFWorkbook(inputStream);
		sheet=wb.getSheetAt(0);
		dataformatter=new DataFormatter();
		Iterator<org.apache.poi.ss.usermodel.Sheet> sheets=wb.sheetIterator();
		while(sheets.hasNext()) {
			org.apache.poi.ss.usermodel.Sheet sh = sheets.next();
			Iterator<Row> iterator = sh.iterator();
			iterator.next();
			while(iterator.hasNext()) {
				Row row = iterator.next();
				ExtractExcelSheet excelrowdata=new ExtractExcelSheet();
				Iterator<Cell> cellIterator = row.iterator();
				int cnt=0;
				while(cellIterator.hasNext()){
					Cell cell = cellIterator.next();
					String cellValue = dataformatter.formatCellValue(cell);
					//System.out.print(cellValue+"\t");
					switch(cnt){
					case 0:{
						excelrowdata.certificateName=cellValue;
						cnt++;
						break;
					}
					case 1:{
						excelrowdata.empCode=Integer.parseInt(cellValue);
						cnt++;
						break;
					}
					case 2:{
						excelrowdata.empName=cellValue;
						cnt++;
						break;
					}
					case 3:{
						excelrowdata.empStatus=cellValue;
						cnt++;
						break;
					}
					case 4:{
						excelrowdata.status=cellValue;
						cnt++;
						break;
					}
					case 5:{
						excelrowdata.dateApplied=cellValue;
						cnt++;
						break;
					}
					case 6:{
						excelrowdata.examPassDate=cellValue;
						cnt++;
						break;
					}
					case 7:{
						//excelrowdata.creditpnt=Float.parseFloat(cellValue);
						cnt++;
						break;
					}
					case 8:{
						excelrowdata.certId=cellValue;
						cnt++;
						break;
					}
					default:{
						
					}
				}
					
			}
				excelDataList.add(excelrowdata);//System.out.println();
		}
	}
		return excelDataList;
	}
	@Override
	public String toString() {
		return "[certName=" + this.certificateName + ", empCode=" + this.empCode + ", empName=" + this.empName
				+ ", empStatus=" + this.empStatus + ", status=" + this.status + ", dateApplied=" + this.dateApplied + ", examPassDate="
				+ this.examPassDate + ", creditpnt=" + this.creditpnt + ", certId=" + this.certId + "]";
	}
}
