package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	
	
	// variabila globala "extentReport" de tip "ExtentReports".
	static ExtentReports extentReport;          
	
	
	
	// aceasta metoda este "statica" pentru ca vrem sa o accesam doar prin numele clasei ("ExtentReporter").
	public static ExtentReports getExtentReport() {
		
		String extentReportPath = System.getProperty("user.dir")+"\\reports\\extentreport.html";        // calea relativa catre fisierul "extentreport.html".
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		reporter.config().setReportName("QAtests Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Operating System","Windows 11");
		extentReport.setSystemInfo("Tested By","Marian");
		
		return extentReport;
	}
	
	
	
	
	
	
	
	
}
