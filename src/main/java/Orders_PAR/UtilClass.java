package Orders_PAR;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.time.Duration;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(TestListener.class)
public class UtilClass {
	public static WebDriver driver;
	private static Scanner scanner;
	public static ExtentReports reports;
	public static ExtentTest extentTest;

	@BeforeClass
	public void extentReportInitialization() {
		String path = System.getProperty("user.dir");
		ExtentSparkReporter reporter = new ExtentSparkReporter(path + "/Test Report/Smoke.html");
		reports = new ExtentReports();
		reports.attachReporter(reporter);
	}

	@BeforeMethod
	public static void BrowserLaunch() {
	//	WebDriverManager.chromedriver().setup();
        String downloadDir =System.getProperty("user.dir")+"/Downloads";
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadDir);
        options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		driver.get("https://epicuatlb.estes-express.com/prweb/PRAuth/app/epic/vQbSpdBva3zBDbMlMRMsHQ*/!STANDARD");
		driver.manage().window().maximize();

	}

//	@AfterMethod
//	public void browser() {
//		driver.close();
//		driver.quit();
//	}
	public static void init(Object page) {
		PageFactory.initElements(driver, page);
	}

	public static String scanner() {
		scanner = new Scanner(System.in);
		String otp = scanner.nextLine();
		System.out.println(otp + " is the received OTP");
		return otp;

	}

	public static void Windows() {
		String handle = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();

		for (String eachwindow : allwindow) {
			if (!eachwindow.equals(handle)) {
				driver.switchTo().window(eachwindow);
			}
		}

	}

	public static void waits(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void SelectClass(WebElement status, String Dropdown) {
		try {
			Select SelectStatus = new Select(status);
			SelectStatus.selectByVisibleText(Dropdown);
		} catch (StaleElementReferenceException e) {
			Select SelectStatus = new Select(status);
			SelectStatus.selectByVisibleText(Dropdown);
		}
	}

	public static void SelectClass_Reson(WebElement status2, String Reason_Dropdown) {
		Select SelectStatus2 = new Select(status2);
		SelectStatus2.selectByVisibleText(Reason_Dropdown);

	}

	public static void Calendarss() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("d");
		String date = format.format(calendar.getTime());
		WebElement CalClick = driver.findElement(By.xpath("//a[text()= '" + date + "']"));
		CalClick.click();

	}

	public static void ScrollDown() {
		JavascriptExecutor ch = (JavascriptExecutor) driver;
		ch.executeScript("window.scrollBy(0,220)", " ");
		ch.executeScript("window.scrollBy(0,220)");
	}

//	public static void awaitility(WebElement element) {
//		Awaitility.await().atMost(Duration.ofSeconds(5)).untilAsserted(() -> Assert.assertTrue(element.isDisplayed()));
//	}

	public static void Await() throws InterruptedException {
		Thread.sleep(3000);
	}

	public static void clickIgnoringStaleElementException(WebElement element) {
		int attempt = 0;
		while (attempt < 3) {
			try {
				element.click();
				break;
			} catch (StaleElementReferenceException e) {
				attempt++;
			}
		}
	}

	public static void getIgnoringStaleElementException(WebElement element) {
		int attempt = 0;
		while (attempt < 3) {
			try {
				element.getText();
				break;
			} catch (StaleElementReferenceException e) {
				attempt++;
			}
		}
	}

	public String getdate(String format) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat form = new SimpleDateFormat(format);
		return form.format(cal.getTime());
	}
	
	public void Frames_Switch_EPIC() {
		String text = Inbound_Trailer.frameName_Main.getAttribute("name");

		if (text != null) {
			if (text.contains("PegaGadget0Ifr")) {
				driver.switchTo().frame(Inbound_Trailer.frameName0);
			} else if (text.contains("PegaGadget1Ifr")) {
				driver.switchTo().frame(Inbound_Trailer.frameName1);
			} else if (text.contains("PegaGadget2Ifr")) {
				driver.switchTo().frame(Inbound_Trailer.frameName2);
			} else if (text.contains("PegaGadget3Ifr")) {
				driver.switchTo().frame(Inbound_Trailer.frameName3);
			} else if (text.contains("PegaGadget4Ifr")) {
				driver.switchTo().frame(Inbound_Trailer.frameName4);
			} else {
				System.out.println("No matching frame found.");
			}
		} else {
			System.out.println("Invalid frame name");
		}
	}
	
	public static String validatePDF(String filename) throws Exception {
		
		File file=new File(System.getProperty("user.dir")+"/Downloads/");
		File[] listFiles = file.listFiles();
		String pdfText="";
		for (File file2 : listFiles) {
			if(file2.getName().contains(filename)) {
				PDDocument document = PDDocument.load(file2);
		        PDFTextStripper pdfStripper = new PDFTextStripper();
		         pdfText = pdfStripper.getText(document);
		        System.out.println("PDF Text:\n" + pdfText);
		        document.close();
			}
		}
		return pdfText;
        	}
	
	
	

}
