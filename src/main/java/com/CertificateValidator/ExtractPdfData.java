package com.CertificateValidator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.parser.pdf.PDFParserConfig;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

public class ExtractPdfData {
	FileInputStream inputStream;
	PDFParser data=new PDFParser();
	BodyContentHandler handler = new BodyContentHandler();
    Metadata metadata = new Metadata();
    ParseContext pcontext = new ParseContext();
    

    PDFParserConfig config = new PDFParserConfig();

    //config.setExtractInlineImages(true);
    //config.setExtractUniqueInlineImagesOnly(true);
    
	public String getPDFdata(String filePath) throws FileNotFoundException {
		inputStream=new FileInputStream(new File(filePath));
		try {
			data.parse(inputStream, handler, metadata,pcontext);
			
			//data.setEnableAutoSpace(true);
			//data.stEx
			return handler.toString();
		} catch (IOException e){
			e.printStackTrace();
		} catch (SAXException e){
			e.printStackTrace();
		} catch (TikaException e){
			e.printStackTrace();
		}
		return "File not Found";
	}
	
}
