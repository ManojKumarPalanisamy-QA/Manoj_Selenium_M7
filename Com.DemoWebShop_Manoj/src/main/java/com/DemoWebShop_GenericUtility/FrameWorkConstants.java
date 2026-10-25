package com.DemoWebShop_GenericUtility;

public interface FrameWorkConstants {
	
	JavaUtility javautility = new JavaUtility();
	
	static String propertyFilePath = "./src/test/resources/TestData/commonData.properties";
	
	static String excelFilePath = "./src/test/resources/TestData/testScriptData.xlsx";
	
	static String screenShotsPath = "./screenshots/" + javautility.localDateAndTime() + ".png" ;
	
	static String reportsPath = "./reports/" + javautility.localDateAndTime() + ".html" ;
	
	
	

}
