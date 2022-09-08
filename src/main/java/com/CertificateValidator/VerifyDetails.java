package com.CertificateValidator;

public class VerifyDetails {
	ExtractPdfData extractPdfData=new ExtractPdfData();
	
	public  boolean checkSubstring(String str,String substr) {
		if(str.indexOf(substr)>0) {
			return true;
		}
		return false;
	}
	public boolean verifyDetails(String pdfdata,ExtractExcelSheet extractExcelSheet) {//&& checkSubstring(pdfdata, extractExcelSheet.examPassDate)
		if (checkSubstring(pdfdata, extractExcelSheet.certificateName)&& checkSubstring(pdfdata, extractExcelSheet.empName)
				 && checkSubstring(pdfdata, extractExcelSheet.certId))
			return true;
		return false;		
	}
}
