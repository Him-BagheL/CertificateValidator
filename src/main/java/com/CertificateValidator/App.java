package com.CertificateValidator;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	ExtractPdfData extractData=new ExtractPdfData();
    	ExtractExcelSheet extractExcelsheet=new ExtractExcelSheet();
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter your EmpCode: ");
    	int empcode=sc.nextInt();
    	String filePath="C:\\Users\\himanshu_baghel\\Downloads\\Certifications - shrutijadhav-9446 _ Microsoft Docs (2).pdf";
    	String pdfdata = extractData.getPDFdata(filePath);
    	//System.out.println(pdfdata);
    	List<ExtractExcelSheet> excelSheetlist=extractExcelsheet.getExcelDetails();
//    	for(int i=1;i<=10;i++) {
//    		System.out.println(i+")."+excelSheetlist.get(i));
//    	}
    	int i;
    	for(i=0;i<excelSheetlist.size();i++) {
    		if(excelSheetlist.get(i).empCode==empcode)
    			break;
    	}
    	VerifyDetails verifyDetails=new VerifyDetails();
    	//System.out.println(excelSheetlist.get(i));
    	boolean result=verifyDetails.verifyDetails(pdfdata, excelSheetlist.get(i));
    	if(result) {
    		System.out.println("Certificate verified");
    	}
    	else {
    		System.out.println("Certificate is not valid");
    	}
    }
}
