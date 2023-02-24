package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReporterNg {

    public static ExtentReports getReportObject(){

         String path = System.getProperty("user.dir")+"\\reports\\index.html";
         ExtentSparkReporter reporter = new ExtentSparkReporter(path);
         reporter.config().setReportName("Web Automation Results");
         reporter.config().setDocumentTitle("Test Results");

         ExtentReports extent = new ExtentReports();
         extent.attachReporter(reporter);
         extent.setSystemInfo("Tester", "Gonzalo Molina");
         return extent;

    }
}
