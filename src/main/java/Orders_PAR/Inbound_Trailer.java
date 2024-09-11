package Orders_PAR;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Checkbox;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.codehaus.jettison.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v113.webaudio.model.AudioListenerWillBeDestroyed;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import groovyjarjarantlr4.v4.codegen.model.Action;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Inbound_Trailer extends UtilClass {

	public static String DateTime;

	public static String sendkeys = "PAR-18158";

	public static String Released_ID_1;

	public static String Released_ID_2;

	public static String Released_ID_3;

	public static String Order_BOL_1;

	public static String Order_BOL_2;

	public static String Order_BOL_3;

	@FindBy(id = "loginText2")
	public static WebElement ssoLogin;

	@FindBy(className = "table-row")
	public static WebElement code;

	@FindBy(id = "idTxtBx_SAOTCC_OTC")
	public static WebElement send;

	@FindBy(id = "idSubmit_SAOTCC_Continue")
	public static WebElement click;

	@FindBy(xpath = "//input[@placeholder='Search']")
	public static WebElement SearchInput;

	@FindBy(xpath = "//button//i[@class='pi pi-search-2']")
	public static WebElement SearchClick;

	@FindBy(xpath = "//span//a[contains(text(), 'OrderServicePackage Services ProcessData')]")
	public static WebElement ClickonProcessData;

	@FindBy(xpath = "//div[contains(@class,'launch-portals')]/descendant::a")
	public static WebElement LaunchPortal;

	@FindBy(xpath = "//span[contains(text(),'WareHouse UserPortal')]")
	public static WebElement warehouse;

	@FindBy(xpath = "//li[@title='Orders PAR']")
	public static WebElement OrdersPAR;

	@FindBy(xpath = "//h3[contains(text(),'OS&D')]")
	public static WebElement OSD;

	@FindBy(xpath = "//h3[contains(text(),'Inbound Trailer')]")
	public static WebElement InboundTrailer;

	@FindBy(xpath = "(//input[@type= 'checkbox']/ancestor::table[@class='gridTable ']/tbody/tr[2]/td/div)[2]")
	public static WebElement Row1_PAR_Order;

	@FindBy(xpath = "(//input[@type= 'checkbox']/ancestor::table[@class='gridTable ']/tbody/tr[3]/td/div)[2]")
	public static WebElement Row2_PAR_Order;

	@FindBy(xpath = "(//input[@type= 'checkbox']/ancestor::table[@class='gridTable ']/tbody/tr[4]/td/div)[2]")
	public static WebElement Row3_PAR_Order;

	@FindBy(xpath = "(//input[@type= 'checkbox']/ancestor::table[@class='gridTable ']/tbody/tr[2]/td/div/input)[2]")
	public static WebElement Click_Row1_PAR_Order_checkbox;

	@FindBy(xpath = "(//input[@type= 'checkbox']/ancestor::table[@class='gridTable ']/tbody/tr[3]/td/div/input)[2]")
	public static WebElement Click_Row2_PAR_Order_checkbox;

	@FindBy(xpath = "(//input[@type= 'checkbox']/ancestor::table[@class='gridTable ']/tbody/tr[4]/td/div/input)[2]")
	public static WebElement Click_Row3_PAR_Order_checkbox;

	@FindBy(xpath = "//span[contains(text(), 'PAR')]/ancestor::table[@class='gridTable ']/tbody/tr[2]//td[1]/div/span")
	public static WebElement Row1_Popup_Order;

	@FindBy(xpath = "//table[@class='gridTable ']/tbody/tr[2]/td[2]")
	public static WebElement Row1_BOL_Popup_Order;

	@FindBy(xpath = "//span[contains(text(), 'PAR')]/ancestor::table[@class='gridTable ']/tbody/tr[3]//td[1]/div/span")
	public static WebElement Row2_Popup_Order;

	@FindBy(xpath = "//table[@class='gridTable ']/tbody/tr[3]/td[2]")
	public static WebElement Row2_BOL_Popup_Order;

	@FindBy(xpath = "//span[contains(text(), 'PAR')]/ancestor::table[@class='gridTable ']/tbody/tr[4]//td[1]/div/span")
	public static WebElement Row3_Popup_Order;

	@FindBy(xpath = "//table[@class='gridTable ']/tbody/tr[4]/td[2]")
	public static WebElement Row3_BOL_Popup_Order;

	@FindBy(xpath = "(//div[contains(text(), 'Total BOL:')]/following::div/span)[1]")
	public static WebElement Total_BOL;

	@FindBy(xpath = "(//div[contains(text(), 'Total HU:')]/following::div/span)[1]")
	public static WebElement Total_HU;

	@FindBy(xpath = "//button[contains(text(), 'Receive Order')]")
	public static WebElement Click_Receive_Order;

	@FindBy(xpath = "//button[contains(text(), 'Assign Trailer')]")
	public static WebElement Click_Assign_trailer;

	@FindBy(xpath = "//input[@type='text']/ancestor::table[@role='presentation']/tbody/tr/td/div/div/span/div/div/div/div/span/input")
	public static WebElement Assign_Trailer_Input_Text;

	@FindBy(xpath = "//button[contains(text(), '  Assign Trailer ')]")
	public static WebElement Click_Assign_Trailer_inside_Popup;

	@FindBy(xpath = "//button[contains(text(), '  Assign Trailer ')]")
	public static WebElement CLick_Assign_Trailer_in_Popup;

	@FindBy(xpath = "(//a[@id='pui_filter'])[2]")
	public static WebElement Click_OrderID_Filter;

	@FindBy(xpath = "//label[contains(text(), 'Search Text')]/following::div/span/input")
	public static WebElement Click_Search_Text_Filter;

	@FindBy(xpath = "//button[contains(text(), 'Apply')]")
	public static WebElement Click_Apply_Filter;

	@FindBy(xpath = "//button[contains(text(), 'Refresh ')]")
	public static WebElement Click_Refresh;

	@FindBy(xpath = "//div[contains(text(), 'Trailer Number')]/ancestor::table[@class='gridTable ']/tbody/tr[2]/td[7]/div/span")
	public static WebElement Trailer_Number_PAR_Order;

	@FindBy(xpath = "(//a[@id='pui_filter'])[3]")
	public static WebElement Click_Planned_Date;

	@FindBy(xpath = "(//a[@id='pui_filter'])[7]")
	public static WebElement Click_checkbox_Trailer_Number_Filter;

	@FindBy(xpath = "(//a[@id='pui_filter'])[8]")
	public static WebElement Click_checkbox_Status_Filter;

//	@FindBy(xpath = "(//table[@class='gridTable '])[2]/tbody/tr[3]/td/div/input[2]")
//	public static WebElement Click_checkbox_any_Filter;

	@FindBy(xpath = "//a[contains(text(), 'Clear Filter')]/following::table[@class='gridTable ']/tbody/tr[2]/td/div/input[2]")
	public static WebElement Click_checkbox_any_Filter;

	@FindBy(xpath = "(//table[@class='gridTable '])[2]/tbody/tr[2]/td/div/input[2]")
	public static WebElement Click_checkbox1_any_filter;

	@FindBy(xpath = "//button[contains(text(), 'Print Manifest')]")
	public static WebElement Click_Print_Manifest;

	@FindBy(xpath = "//*[contains(@alt, 'Choose from calendar')]")
	public static WebElement Click_on_Calendar;

	@FindBy(xpath = "//button[contains(text(), '  Receive ')]")
	public static WebElement Click_Received_ReceiveOrder_Popup;

	// **** Outbound Loads****

	@FindBy(xpath = "//h3[contains(text(),'Outbound Loads')]")
	public static WebElement OutBound_Loads;

	@FindBy(xpath = "//button[contains(text(), 'Assign Carrier')]")
	public static WebElement Click_Assign_Carrier;

	@FindBy(xpath = "//select[contains(@name, 'AssignedTradingPartnerName')]")
	public static WebElement Assign_Carrier_Dropdown;

	@FindBy(xpath = "//button[contains(text(), '  Assign Carrier ')]")
	public static WebElement Click_Assign_Carrier_in_Popup;

	@FindBy(xpath = "//span[contains(text(), 'Estes Express')]")
	public static WebElement Assign_Outbound_Carrier_PAR_Order;

	@FindBy(xpath = "//a[contains(text(), 'Refresh ')]")
	public static WebElement Click_Refresh_Outbound_Loads;

	@FindBy(xpath = "//button[contains(text(), 'Assign Load ID')]")
	public static WebElement Click_Assign_Load_ID;

	@FindBy(xpath = "//input[@type='text']/ancestor::table[@role='presentation']/tbody/tr/td/div/div/span/div/div/div/div/span/input")
	public static WebElement Assign_Load_ID_Input_Text;

	@FindBy(xpath = "//button[contains(text(), '  Outbound Load ')]")
	public static WebElement Outbound_Load_Assign_Load_ID;

	@FindBy(xpath = "//div[contains(text(), 'Outbound Load')]/ancestor::table[@class='gridTable ']/tbody/tr[2]/td[5]/div/span")
	public static WebElement Outbound_Load_Grid;

	@FindBy(xpath = "//button[contains(text(), 'Assign OB Trailer')]")
	public static WebElement Click_Assign_OB_Trailer;

	@FindBy(xpath = "(//label[contains(text(), 'From')]/following::div/span/input)[1]")
	public static WebElement date_1_Loaded_Date;

	@FindBy(xpath = "(//input[@type='text']/preceding::label[contains(text(), 'Trailer Number')]/following::div/span/input)[1]")
	public static WebElement Trailer_Number_Assign_OB_Trailer_Popup;

	@FindBy(xpath = "//button[contains(text(), '  Loaded ')]")
	public static WebElement Loaded_Assign_OB_Trailer_Popup;

	@FindBy(xpath = "//div[contains(text(), 'Outbound Trailer')]/ancestor::table[@class='gridTable ']/tbody/tr[2]/td[4]/div/span")
	public static WebElement Outbound_Trailer_Grid;

	@FindBy(xpath = "(//a[@id='pui_filter'])[11]")
	public static WebElement Loaded_Date_Grid_Filter;

	@FindBy(xpath = "(//img[@aria-label='Open date picker'])[1]")
	public static WebElement Calendar_1_Loaded_Date_Filter;

	@FindBy(xpath = "(//img[@aria-label='Open date picker'])[2]")
	public static WebElement Calendar_2_Loaded_Date_Filter;

	@FindBy(xpath = "//div[contains(text(), 'Outbound Trailer')]/ancestor::table[@class='gridTable ']/tbody/tr[2]/td[11]/div/span")
	public static WebElement Loaded_Date_Grid;

	// **** Print OB Manifest ****

	@FindBy(xpath = "//input[@placeholder= 'Select Outbound Trailer']")
	public static WebElement Outbound_Trailer_Header_Search;

	@FindBy(xpath = "//table[@class='gridTable ']/tbody/tr/td[4]")
	public static List<WebElement> Outbound_Trailer_Searched_Orders;

	@FindBy(xpath = "//div[@class='token-cancel token-cancel-img']")
	public static WebElement Outbound_Trailer_Header_Close;

	@FindBy(xpath = "//input[@placeholder= 'Search by Carrier Name']")
	public static WebElement Outbound_Carrier_Name;

	@FindBy(xpath = "//div[@class='header-content']")
	public static WebElement Click_Header_Content;

	@FindBy(xpath = "//table[@class='gridTable ']/tbody/tr/td[6]")
	public static WebElement Outbound_Carrier_Searched_Orders;

	@FindBy(xpath = "//table[@class='gridTable ']/tbody/tr/td[11]")
	public static WebElement Loaded_Date_Searched_Orders;

	// **** Released ****
	@FindBy(xpath = "//button[contains(text(), 'Released')]")
	public static WebElement Click_Released_button;

	@FindBy(xpath = "//span[contains(text(), 'No items for the filters applied')]")
	public static WebElement No_items_for_the_filters_applied;

	@FindBy(xpath = "//div[contains(text(), 'Outbound Trailer')]/ancestor::table[@class='gridTable ']/tbody/tr[2]/td[2]/div/span")
	public static WebElement Case_ID_Grid;

	// **** POD Review ****
	@FindBy(xpath = "//h3[contains(text(), 'POD Review')]")
	public static WebElement Click_POD_Review;

	@FindBy(xpath = "//div[contains(text(), 'Order ID')]/ancestor::table[@class='gridTable ']/tbody/tr[2]/td[2]/div/span")
	public static WebElement Order_ID_Grid;

	@FindBy(xpath = "(//a[@id='pui_filter'])[1]")
	public static WebElement Click_OrderID_Filter_POD_Review;

	@FindBy(xpath = "//div[contains(text(), 'Attach Doc')]/ancestor::table[@class='gridTable ']/tbody/tr[2]/td[11]/div/span/a/i")
	public static WebElement Attach_DOC;

	@FindBy(xpath = "//img[@title='Upload local file']")
	public static WebElement Click_Local_File;

	@FindBy(xpath = "//label[contains(text(), 'Name')]/following::div/span/input[@placeholder='Enter document name']")
	public static WebElement Enter_Document_Name;

	@FindBy(xpath = "//div[@id='uniqueIDforMultiFilePath']/input[@name='$PpyAttachmentPage$ppxAttachName']")
	public static WebElement Click_Select_File_Local_File;

	@FindBy(xpath = "//input[@name='$PAddRecentContent$ppyLabel']")
	public static WebElement RichText_Name;

	@FindBy(xpath = "//button[contains(text(), '  Submit ')]")
	public static WebElement Attachment_Submit;

	@FindBy(xpath = "(//label[contains(text(), 'Status Search')]/following::div/div/input[@role='listbox'])[1]")
	public static WebElement Status_Search_Header_Filter;

	@FindBy(xpath = "//label[contains(text(), 'Status Search')]/following::div/div/span/div[2]")
	public static WebElement Status_Search_Cancel;

	@FindBy(xpath = "//a[contains(text(), 'View')]")
	public static WebElement View_Doc_View;

	@FindBy(xpath = "//i[@role='gridcell']")
	public static WebElement Elipsis_Doc_View_popup;

	@FindBy(xpath = "//span[contains(text(), 'Delete')]")
	public static WebElement Delete_Doc_View_popup;

	@FindBy(xpath = "//span[normalize-space(text())='Attachment List']/parent::div//button[@id='container_close']")
	public static WebElement Close_Doc_View;

	@FindBy(xpath = "//span[contains(text(), 'No items')]")
	public static WebElement No_items_Doc_View_popup;

	@FindBy(xpath = "//div[contains(text(), 'Attached?')]/ancestor::table[@class='gridTable ']/tbody/tr[2]/td[10]/div/span")
	public static WebElement Req_Status_Result;

	@FindBy(xpath = "//label[contains(text(), 'BOL Search')]/following::div/div/input[@role='listbox']")
	public static WebElement BOL_Header_Search;

	@FindBy(xpath = "//label[contains(text(), 'BOL Search')]/following::div/div/span/div[2]")
	public static WebElement Close_Bol_Header_Old_Search;

	// **** Frames ****

	@FindBy(xpath = "//iframe[contains(@name, 'PegaGadget')]")
	public static WebElement frameName_Main;

	@FindBy(xpath = "//iframe[@name='PegaGadget0Ifr']")
	public static WebElement frameName0;

	@FindBy(xpath = "//iframe[@name='PegaGadget1Ifr']")
	public static WebElement frameName1;

	@FindBy(xpath = "//iframe[@name='PegaGadget2Ifr']")
	public static WebElement frameName2;

	@FindBy(xpath = "//iframe[@name='PegaGadget3Ifr']")
	public static WebElement frameName3;

	@FindBy(xpath = "//iframe[@name='PegaGadget4Ifr']")
	public static WebElement frameName4;

	
	// Using Constructor to initialize the Web driver
	public Inbound_Trailer(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public void PAR_Order_Creation() throws Exception {

		String dirpath = System.getProperty("user.dir");
		File file = new File(dirpath + "//PAR.json");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(file);
		String actual = node.toPrettyString();
		JSONObject jsonObject = new JSONObject(actual);
		JSONObject orderRefs = jsonObject.getJSONObject("OrderRefs");

		orderRefs.put("BOL", Math.ceil(Math.random() * 100000000));
		orderRefs.put("TrackingNumber", Math.ceil(Math.random() * 100000000));
		orderRefs.put("InvoiceNumber", Math.ceil(Math.random() * 100000000));

		RestAssured.baseURI = "https://epicuatlb.estes-express.com";
		Response response = RestAssured.given().auth().basic("EpicSevicesTest1", "Rules@1234")
				.contentType("application/json").body(jsonObject.toString())
				.post("/prweb/api/OrderServicePackage/V1/CreateOrUpdateOrder");
		String responseBody = response.getBody().asString();
		String[] split = responseBody.split("Reference is ");

		sendkeys = split[1];
		System.out.println(sendkeys);
		System.out.println("<------Result of PAR Json------>");
		System.out.println("Response Body: " + responseBody);
		int statusCode = response.getStatusCode();
		System.out.println("Status Code: " + statusCode);
		// extentTest.log(Status.PASS, "Successfully created PAR Order");
	}

	public void PEGALogin() throws InterruptedException {
		ssoLogin.click();
		waits(code);
		code.click();

		// ****Scanner class to handle OTP****
		String scanner = scanner();
		send.sendKeys(scanner);
		waits(click);
		click.click();
	}

	public void LaunchWarehousePortal() throws InterruptedException {
//		waits(LaunchPortal);
		Await();
		LaunchPortal.click();
//		waits(warehouse);
		Await();
		warehouse.click();
		Await();
		Windows();
//		extentTest.log(Status.PASS, "Enetered into Warehouse Portal");

	}

	public void OrdersPAR() throws Exception {
		Await();
		OrdersPAR.click();
		Await();
//		frameSwitch();
		Frames_Switch_EPIC();
		Await();

		waits(OSD);
		OSD.click();
		waits(InboundTrailer);

	}

	public void InboundTrailer_WorkQueue() throws InterruptedException {
		InboundTrailer.click();
		Await();

		String Case_ID_1 = Row1_PAR_Order.getText();
		String Case_ID_2 = Row2_PAR_Order.getText();
		String Case_ID_3 = Row3_PAR_Order.getText();

		List<WebElement> Order_ID_Column = driver.findElements(By.xpath(
				"//table[@class='gridTable ']/tbody/tr/th[@aria-label='Order ID']/div/following::tr/td[2]/div/span/a"));

		for (WebElement element : Order_ID_Column) {
			String orderText = element.getText().trim();

			if (orderText.equals(Case_ID_1.trim())) {
				Click_Row1_PAR_Order_checkbox.click();
				break;
			}
		}
		for (WebElement element : Order_ID_Column) {
			String orderText = element.getText().trim();
			if (orderText.equals(Case_ID_2.trim())) {
				Click_Row2_PAR_Order_checkbox.click();
				break;
			}
		}

		for (WebElement element : Order_ID_Column) {
			String orderText = element.getText().trim();
			if (orderText.equals(Case_ID_3.trim())) {
				Click_Row3_PAR_Order_checkbox.click();
				break;
			}
		}
		Await();
		Click_Receive_Order.click();
		Await();

		String Order1_Text_Receive_Order = Row1_Popup_Order.getText();
		assertTrue(Order1_Text_Receive_Order.contains(Case_ID_1));
		System.out.println("successfuly validated PAR Order1 :" + Order1_Text_Receive_Order);

		String Order2_Text_Receive_Order = Row2_Popup_Order.getText();
		assertTrue(Order2_Text_Receive_Order.contains(Case_ID_2));
		System.out.println("successfuly validated PAR Order2 :" + Order2_Text_Receive_Order);

		String Order3_Text_Receive_Order = Row3_Popup_Order.getText();
		assertTrue(Order3_Text_Receive_Order.contains(Case_ID_3));
		System.out.println("successfuly validated PAR Order3 :" + Order3_Text_Receive_Order);
		Await();

		String Total_BOL_Receive_Order = Total_BOL.getText();
		System.out.println("Total BOL :" + Total_BOL_Receive_Order);
		Await();
		String Total_HU_Receive_Order = Total_HU.getText();
		System.out.println("Total HU :" + Total_HU_Receive_Order);

		Click_on_Calendar.click();
		Await();
		Calendarss();
		Await();
		Click_Received_ReceiveOrder_Popup.click();
		Await();
	}

	public void Assign_Trailer_InboundTrailer() throws InterruptedException {

		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();

		String Case_ID_1 = Row1_PAR_Order.getText();
		String Case_ID_2 = Row2_PAR_Order.getText();
		String Case_ID_3 = Row3_PAR_Order.getText();

		List<WebElement> Order_ID_Column = driver.findElements(By.xpath(
				"//table[@class='gridTable ']/tbody/tr/th[@aria-label='Order ID']/div/following::tr/td[2]/div/span/a"));

		for (WebElement element : Order_ID_Column) {

			String orderText = element.getText().trim();
			if (orderText.equals(Case_ID_1.trim())) {
				clickIgnoringStaleElementException(Click_Row1_PAR_Order_checkbox);

				// Click_Row1_PAR_Order_checkbox.click();
				break;
			}
		}
		for (WebElement element : Order_ID_Column) {
			String orderText = element.getText().trim();
			if (orderText.equals(Case_ID_2.trim())) {
				Click_Row2_PAR_Order_checkbox.click();
				break;
			}
		}

		for (WebElement element : Order_ID_Column) {
			String orderText = element.getText().trim();
			if (orderText.equals(Case_ID_3.trim())) {
				Click_Row3_PAR_Order_checkbox.click();
				break;
			}
		}
		Await();
		Click_Assign_trailer.click();
		Await();
		String Assign_trailer_Order1 = Row1_Popup_Order.getText();
		assertTrue(Assign_trailer_Order1.contains(Case_ID_1));
		System.out.println("successfuly validated PAR Order1 :" + Assign_trailer_Order1);

		String Assign_trailer_Order2 = Row2_Popup_Order.getText();
		assertTrue(Assign_trailer_Order2.contains(Case_ID_2));
		System.out.println("successfuly validated PAR Order2 :" + Assign_trailer_Order2);

		String Assign_trailer_Order3 = Row3_Popup_Order.getText();
		assertTrue(Assign_trailer_Order3.contains(Case_ID_3));
		System.out.println("successfuly validated PAR Order3 :" + Assign_trailer_Order3);
		Await();
		String Total_BOL_Assign_Trailer_Order1 = Total_BOL.getText();
		System.out.println("Total BOL :" + Total_BOL_Assign_Trailer_Order1);
		Await();
		String Total_HU_Assign_Trailer_Order1 = Total_HU.getText();
		System.out.println("Total HU :" + Total_HU_Assign_Trailer_Order1);
		Await();
		String Assign_Trailer_Input = "5678";
		Assign_Trailer_Input_Text.sendKeys(Assign_Trailer_Input);
		Await();
		Click_Assign_Trailer_inside_Popup.click();
		Await();
		CLick_Assign_Trailer_in_Popup.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Click_OrderID_Filter.click();
		Await();
		Click_Search_Text_Filter.sendKeys(Assign_trailer_Order1);
		Await();
		Click_Apply_Filter.click();

		Await();
		String Trailer_Num_PAR_Order_1 = Trailer_Number_PAR_Order.getText();

		if (Trailer_Num_PAR_Order_1.contains(Assign_Trailer_Input)) {
			System.out.println("Successfully Validated Assign_Trailer_Number :" + Trailer_Num_PAR_Order_1);
		}

		Await();
		Click_Refresh.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Click_OrderID_Filter.click();
		Await();
		Click_Search_Text_Filter.sendKeys(Assign_trailer_Order2);
		Click_Apply_Filter.click();

		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();

		String Trailer_Num_PAR_Order_2 = Trailer_Number_PAR_Order.getText();

		if (Trailer_Num_PAR_Order_2.contains(Assign_Trailer_Input)) {
			System.out.println("Successfully Validated Assign_Trailer_Number :" + Trailer_Num_PAR_Order_2);
		}

		Await();
		Click_Refresh.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Click_OrderID_Filter.click();
		Await();
		Click_Search_Text_Filter.sendKeys(Assign_trailer_Order3);
		Click_Apply_Filter.click();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();

		String Trailer_Num_PAR_Order_3 = Trailer_Number_PAR_Order.getText();

		if (Trailer_Num_PAR_Order_3.contains(Assign_Trailer_Input)) {
			System.out.println("Successfully Validated Assign_Trailer_Number :" + Trailer_Num_PAR_Order_3);
		}

		Await();
		Click_Refresh.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Click_Planned_Date.click();
		Await();
		Click_checkbox_any_Filter.click();
		Await();
		Click_Apply_Filter.click();
		Await();
		Click_checkbox_Trailer_Number_Filter.click();
		Await();
		Click_checkbox1_any_filter.click();
		Await();
		Click_Apply_Filter.click();
		Await();
		Click_checkbox_Status_Filter.click();
		Await();
		Click_Search_Text_Filter.sendKeys("  Pickup Scheduled  ");
//		Click_checkbox_any_Filter.click();
		Await();
		Click_Apply_Filter.click();
		Await();
		Click_Print_Manifest.click();
		Await();
		Windows();
		driver.close();
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();

	}

	public void Outbound_Loads_Assign_Carrier() throws InterruptedException {
		Await();
		OutBound_Loads.click();

		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();

		Await();
		String Case_ID_1 = Row1_PAR_Order.getText();
		String Case_ID_2 = Row2_PAR_Order.getText();
		String Case_ID_3 = Row3_PAR_Order.getText();

		List<WebElement> Order_ID_Column = driver.findElements(By.xpath(
				"//table[@class='gridTable ']/tbody/tr/th[@aria-label='Case ID']/div/following::tr/td[2]/div/span/a"));

		for (WebElement element : Order_ID_Column) {
			String orderText = element.getText().trim();

			if (orderText.equals(Case_ID_1.trim())) {
				Click_Row1_PAR_Order_checkbox.click();
				System.out.println(Case_ID_1);
				break;
			}
		}
		for (WebElement element : Order_ID_Column) {
			String orderText = element.getText().trim();
			if (orderText.equals(Case_ID_2.trim())) {
				Click_Row2_PAR_Order_checkbox.click();
				System.out.println(Case_ID_2);

				break;
			}
		}

		for (WebElement element : Order_ID_Column) {
			String orderText = element.getText().trim();
			if (orderText.equals(Case_ID_3.trim())) {
				Click_Row3_PAR_Order_checkbox.click();
				System.out.println(Case_ID_3);

				break;
			}
		}
		Await();
		Click_Assign_Carrier.click();
		Await();
		String Assign_Trailer_Order1 = Row1_Popup_Order.getText();
		assertTrue(Assign_Trailer_Order1.contains(Case_ID_1));
		System.out.println("successfuly validated PAR Order1 :" + Assign_Trailer_Order1);

		String Assign_Trailer_Order2 = Row2_Popup_Order.getText();
		assertTrue(Assign_Trailer_Order2.contains(Case_ID_2));
		System.out.println("successfuly validated PAR Order2 :" + Assign_Trailer_Order2);

		String Assign_Trailer_Order3 = Row3_Popup_Order.getText();
		assertTrue(Assign_Trailer_Order3.contains(Case_ID_3));
		System.out.println("successfuly validated PAR Order3 :" + Assign_Trailer_Order3);
		Await();
		String Total_BOL_Assign_trailer_Order = Total_BOL.getText();
		System.out.println("Total BOL :" + Total_BOL_Assign_trailer_Order);
		Await();
		String Total_HU_Assign_trailer_Order = Total_HU.getText();
		System.out.println("Total HU :" + Total_HU_Assign_trailer_Order);
		Await();
		SelectClass(Assign_Carrier_Dropdown, "Estes Express Lines");
		Await();
		System.out.println("Successfully Selected Assign carrier");
		Click_Assign_Carrier_in_Popup.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Click_OrderID_Filter.click();
		Await();
		Click_Search_Text_Filter.sendKeys(Assign_Trailer_Order1);
		Await();
		Click_Apply_Filter.click();

		String Assign_Carrier_Name_1 = "Estes Express Lines";

		String Assign_OutBound_PAR_1 = Assign_Outbound_Carrier_PAR_Order.getText();

		if (Assign_OutBound_PAR_1.contains(Assign_Carrier_Name_1)) {
			System.out.println("Successfully Validated Assign_Trailer_Number :" + Assign_OutBound_PAR_1);
		}

		Await();
		Click_Refresh_Outbound_Loads.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Click_OrderID_Filter.click();
		Await();
		Click_Search_Text_Filter.sendKeys(Assign_Trailer_Order2);
		Await();
		Click_Apply_Filter.click();
		Await();
		String Assign_Carrier_Name_2 = "Estes Express Lines";

		String Assign_OutBound_PAR_2 = Assign_Outbound_Carrier_PAR_Order.getText();

		if (Assign_OutBound_PAR_2.contains(Assign_Carrier_Name_2)) {
			System.out.println("Successfully Validated Assign_Trailer_Number :" + Assign_OutBound_PAR_2);
		}

		Await();
		Click_Refresh_Outbound_Loads.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Click_OrderID_Filter.click();
		Await();
		Click_Search_Text_Filter.sendKeys(Assign_Trailer_Order3);
		Await();
		Click_Apply_Filter.click();

		String Assign_Carrier_Name_3 = "Estes Express Lines";
		Await();

		String Assign_OutBound_PAR_3 = Assign_Outbound_Carrier_PAR_Order.getText();

		if (Assign_OutBound_PAR_3.contains(Assign_Carrier_Name_3)) {
			System.out.println("Successfully Validated Assign_Trailer_Number :" + Assign_OutBound_PAR_3);
		}

		Await();
		Click_Refresh_Outbound_Loads.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();

		Await();
	}

	public void Outbound_Loads_Assign_Load_ID() throws InterruptedException {
		String Case_ID_1_1 = Row1_PAR_Order.getText();
		String Case_ID_2_1 = Row2_PAR_Order.getText();
		String Case_ID_3_1 = Row3_PAR_Order.getText();

		List<WebElement> Order_ID_Column_1 = driver.findElements(By.xpath(
				"//table[@class='gridTable ']/tbody/tr/th[@aria-label='Case ID']/div/following::tr/td[2]/div/span/a"));

		for (WebElement element : Order_ID_Column_1) {
			String orderText = element.getText().trim();

			if (orderText.equals(Case_ID_1_1.trim())) {
				Click_Row1_PAR_Order_checkbox.click();
				System.out.println(Case_ID_1_1);
				break;
			}
		}
		for (WebElement element : Order_ID_Column_1) {
			String orderText = element.getText().trim();
			if (orderText.equals(Case_ID_2_1.trim())) {
				Click_Row2_PAR_Order_checkbox.click();
				System.out.println(Case_ID_2_1);

				break;
			}
		}

		for (WebElement element : Order_ID_Column_1) {
			String orderText = element.getText().trim();
			if (orderText.equals(Case_ID_3_1.trim())) {
				Click_Row3_PAR_Order_checkbox.click();
				System.out.println(Case_ID_3_1);

				break;
			}
		}
		Await();
		Click_Assign_Load_ID.click();
		Await();
		String Assign_Outbound_Load_ID_1 = Row1_Popup_Order.getText();
		assertTrue(Assign_Outbound_Load_ID_1.contains(Case_ID_1_1));
		System.out.println("successfuly validated PAR Order1 :" + Assign_Outbound_Load_ID_1);

		String Assign_Outbound_Load_ID_2 = Row2_Popup_Order.getText();
		assertTrue(Assign_Outbound_Load_ID_2.contains(Case_ID_2_1));
		System.out.println("successfuly validated PAR Order2 :" + Assign_Outbound_Load_ID_2);

		String Assign_Outbound_Load_ID_3 = Row3_Popup_Order.getText();
		assertTrue(Assign_Outbound_Load_ID_3.contains(Case_ID_3_1));
		System.out.println("successfuly validated PAR Order3 :" + Assign_Outbound_Load_ID_3);
		Await();
		String Total_BOL_Assign_Outload_ID_Order1 = Total_BOL.getText();
		System.out.println("Total BOL :" + Total_BOL_Assign_Outload_ID_Order1);
		Await();
		String Total_HU_Assign_Outload_ID_Order1 = Total_HU.getText();
		System.out.println("Total HU :" + Total_HU_Assign_Outload_ID_Order1);
		Await();
		String Assign_Outbound_Load_ID_input = "5678";
		Assign_Load_ID_Input_Text.sendKeys(Assign_Outbound_Load_ID_input);
		Await();
		Outbound_Load_Assign_Load_ID.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Click_OrderID_Filter.click();
		Await();
		Click_Search_Text_Filter.sendKeys(Assign_Outbound_Load_ID_1);
		Await();
		Click_Apply_Filter.click();
		Await();

		String Load_ID_PAR_Order_1 = Outbound_Load_Grid.getText();

		if (Load_ID_PAR_Order_1.contains(Assign_Outbound_Load_ID_input)) {
			System.out.println("Successfully Validated Assign_Trailer_Number :" + Load_ID_PAR_Order_1);
		}

		Await();
		Click_Refresh_Outbound_Loads.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Click_OrderID_Filter.click();
		Await();
		Click_Search_Text_Filter.sendKeys(Assign_Outbound_Load_ID_2);
		Click_Apply_Filter.click();

		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();

		String Load_ID_PAR_Order_2 = Outbound_Load_Grid.getText();

		if (Load_ID_PAR_Order_2.contains(Assign_Outbound_Load_ID_input)) {
			System.out.println("Successfully Validated Assign_Trailer_Number :" + Load_ID_PAR_Order_2);
		}

		Await();
		Click_Refresh_Outbound_Loads.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Click_OrderID_Filter.click();
		Await();
		Click_Search_Text_Filter.sendKeys(Assign_Outbound_Load_ID_3);
		Click_Apply_Filter.click();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();

		String Load_ID_PAR_Order_3 = Outbound_Load_Grid.getText();

		if (Load_ID_PAR_Order_3.contains(Assign_Outbound_Load_ID_input)) {
			System.out.println("Successfully Validated Assign_Trailer_Number :" + Load_ID_PAR_Order_3);
		}

		Await();
		Click_Refresh_Outbound_Loads.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();

		Await();
	}

	public static void getAttribute() {
		DateTime = date_1_Loaded_Date.getAttribute("data-value");
		System.out.println(DateTime);
	}

	public void Outbound_Loads_Assign_OB_Trailer() throws InterruptedException {
		String Case_ID_1_1 = Row1_PAR_Order.getText();
		String Case_ID_2_1 = Row2_PAR_Order.getText();
		String Case_ID_3_1 = Row3_PAR_Order.getText();

		List<WebElement> Order_ID_Column_1 = driver.findElements(By.xpath(
				"//table[@class='gridTable ']/tbody/tr/th[@aria-label='Case ID']/div/following::tr/td[2]/div/span/a"));

		for (WebElement element : Order_ID_Column_1) {
			String orderText = element.getText().trim();

			if (orderText.equals(Case_ID_1_1.trim())) {
				Click_Row1_PAR_Order_checkbox.click();
				System.out.println(Case_ID_1_1);
				break;
			}
		}
		for (WebElement element : Order_ID_Column_1) {
			String orderText = element.getText().trim();
			if (orderText.equals(Case_ID_2_1.trim())) {
				Click_Row2_PAR_Order_checkbox.click();
				System.out.println(Case_ID_2_1);

				break;
			}
		}

		for (WebElement element : Order_ID_Column_1) {
			String orderText = element.getText().trim();
			if (orderText.equals(Case_ID_3_1.trim())) {
				Click_Row3_PAR_Order_checkbox.click();
				System.out.println(Case_ID_3_1);

				break;
			}
		}
		Await();
		Click_Assign_OB_Trailer.click();
		Await();
		String Assign_OB_Trailer_1 = Row1_Popup_Order.getText();
		assertTrue(Assign_OB_Trailer_1.contains(Case_ID_1_1));
		System.out.println("successfuly validated PAR Order1 :" + Assign_OB_Trailer_1);

		String Assign_OB_Trailer_2 = Row2_Popup_Order.getText();
		assertTrue(Assign_OB_Trailer_2.contains(Case_ID_2_1));
		System.out.println("successfuly validated PAR Order2 :" + Assign_OB_Trailer_2);

		String Assign_OB_Trailer_3 = Row3_Popup_Order.getText();
		assertTrue(Assign_OB_Trailer_3.contains(Case_ID_3_1));
		System.out.println("successfuly validated PAR Order3 :" + Assign_OB_Trailer_3);
		Await();
		Click_on_Calendar.click();
		Calendarss();
		Await();
		String Trailer_Number_OB_Trailer = "5678";
		Trailer_Number_Assign_OB_Trailer_Popup.sendKeys(Trailer_Number_OB_Trailer);
		Await();
		Loaded_Assign_OB_Trailer_Popup.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Click_OrderID_Filter.click();
		Await();
		Click_Search_Text_Filter.sendKeys(Assign_OB_Trailer_1);
		Await();
		Click_Apply_Filter.click();
		Await();

		String Trailer_Num_PAR_Order_1 = Outbound_Trailer_Grid.getText();

		if (Trailer_Num_PAR_Order_1.contains(Trailer_Number_OB_Trailer)) {
			System.out.println("Successfully Validated Assign_Trailer_Number :" + Trailer_Num_PAR_Order_1);
		}

		Await();
		Click_Refresh_Outbound_Loads.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Click_OrderID_Filter.click();
		Await();
		Click_Search_Text_Filter.sendKeys(Assign_OB_Trailer_2);
		Click_Apply_Filter.click();

		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();

		String Trailer_Num_PAR_Order_2 = Outbound_Trailer_Grid.getText();

		if (Trailer_Num_PAR_Order_2.contains(Trailer_Number_OB_Trailer)) {
			System.out.println("Successfully Validated Assign_Trailer_Number :" + Trailer_Num_PAR_Order_2);
		}

		Await();
		Click_Refresh_Outbound_Loads.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Click_OrderID_Filter.click();
		Await();
		Click_Search_Text_Filter.sendKeys(Assign_OB_Trailer_2);
		Click_Apply_Filter.click();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();

		String Trailer_Num_PAR_Order_3 = Outbound_Trailer_Grid.getText();

		if (Trailer_Num_PAR_Order_3.contains(Trailer_Number_OB_Trailer)) {
			System.out.println("Successfully Validated Assign_Trailer_Number :" + Trailer_Num_PAR_Order_3);
		}

		Await();
		Click_Refresh_Outbound_Loads.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();

		Await();
		Loaded_Date_Grid_Filter.click();
		Await();
		Calendar_1_Loaded_Date_Filter.click();
		Calendarss();
		Await();
		Calendar_2_Loaded_Date_Filter.click();
		Calendarss();
		Await();
		getAttribute();

		Await();
		String[] parts = DateTime.split(" ");
		Await();
		String datePart = parts[0];
		System.out.println("Date: " + datePart);
		String timePart = parts[1];
		System.out.println("Time: " + timePart);

		String New_Date = timePart.replace(timePart, " 1:00 AM");
		System.out.println(New_Date);
		date_1_Loaded_Date.clear();
		Await();
		String Current_Date = datePart.concat("").concat(New_Date);
		System.out.println(Current_Date);
		date_1_Loaded_Date.sendKeys(Current_Date);
		// date_1_Loaded_Date.sendKeys(datePart, New_Date);
		Await();
		Click_Apply_Filter.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Click_OrderID_Filter.click();
		Await();
		Click_Search_Text_Filter.sendKeys(Assign_OB_Trailer_1);
		Await();
		Click_Apply_Filter.click();
		Await();

		String Load_ID_PAR_Order_1 = Loaded_Date_Grid.getText();

		String[] dateComponents = datePart.split("/");

		// Get the first two digits of the year (last two digits of 2024)
		String yearShort = dateComponents[2].substring(2);

		// Concatenate the components into the desired format
		String Grid_Date = dateComponents[0] + "/" + dateComponents[1] + "/" + yearShort;

		// Output the result
		System.out.println("Formatted Date: " + Grid_Date);

//		String[] Date_Split = datePart.split("20");
//		System.out.println("Date_Split: " + Date_Split);
//		String Date = Date_Split[0];
//		System.out.println("Date :" + Date);
//		String year = Date_Split[1];
//		System.out.println("year :" + year);
//		String Grid_Date = Date.concat("").concat(year);
//		System.out.println(Grid_Date);

		assertTrue(Load_ID_PAR_Order_1.contains(Grid_Date));

		if (Load_ID_PAR_Order_1.contains(Grid_Date)) {
			System.out.println("Successfully Validated Assign_Trailer_Number :" + Grid_Date);
		}

		Await();
		Click_Refresh_Outbound_Loads.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();

		Await();
		Loaded_Date_Grid_Filter.click();
		Await();
		Calendar_1_Loaded_Date_Filter.click();
		Calendarss();
		Await();
		Calendar_2_Loaded_Date_Filter.click();
		Calendarss();
		Await();
		getAttribute();

		Await();
		String[] parts_2 = DateTime.split(" ");
		Await();
		String datePart_2 = parts_2[0];
		System.out.println("Date: " + datePart_2);
		String timePart_2 = parts[1];
		System.out.println("Time: " + timePart_2);

		String New_Date_2 = timePart_2.replace(timePart_2, " 1:00 AM");
		System.out.println(New_Date_2);
		date_1_Loaded_Date.clear();
		Await();
		String Current_Date_2 = datePart_2.concat("").concat(New_Date_2);
		System.out.println(Current_Date_2);
		date_1_Loaded_Date.sendKeys(Current_Date_2);
		// date_1_Loaded_Date.sendKeys(datePart, New_Date);
		Await();
		Click_Apply_Filter.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Click_OrderID_Filter.click();
		Await();
		Click_Search_Text_Filter.sendKeys(Assign_OB_Trailer_2);
		Await();
		Click_Apply_Filter.click();
		Await();

		String Load_ID_PAR_Order_2 = Loaded_Date_Grid.getText();
//		String[] Date_Split_2 = datePart_2.split("20");
//		String Date_2 = Date_Split_2[0];
//		String year_2 = Date_Split_2[1];
//		String Grid_Date_2 = Date_2.concat("").concat(year_2);
//		System.out.println(Grid_Date_2);

		String[] dateComponents_2 = datePart_2.split("/");

		String yearShort_2 = dateComponents_2[2].substring(2);

		String Grid_Date_2 = dateComponents_2[0] + "/" + dateComponents[1] + "/" + yearShort_2;
		assertTrue(Load_ID_PAR_Order_2.contains(Grid_Date_2));

		if (Load_ID_PAR_Order_2.contains(Grid_Date_2)) {
			System.out.println("Successfully Validated Assign_Trailer_Number :" + Grid_Date_2);
		}

		Await();
		Click_Refresh_Outbound_Loads.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();

		Await();
		Loaded_Date_Grid_Filter.click();
		Await();
		Calendar_1_Loaded_Date_Filter.click();
		Calendarss();
		Await();
		Calendar_2_Loaded_Date_Filter.click();
		Calendarss();
		Await();
		getAttribute();

		Await();
		String[] parts_3 = DateTime.split(" ");
		Await();
		String datePart_3 = parts_3[0];
		System.out.println("Date: " + datePart_3);
		String timePart_3 = parts[1];
		System.out.println("Time: " + timePart_3);

		String New_Date_3 = timePart_3.replace(timePart_3, " 1:00 AM");
		System.out.println(New_Date_3);
		date_1_Loaded_Date.clear();
		Await();
		String Current_Date_3 = datePart_3.concat("").concat(New_Date_3);
		System.out.println(Current_Date_3);
		date_1_Loaded_Date.sendKeys(Current_Date_3);
		// date_1_Loaded_Date.sendKeys(datePart, New_Date);
		Await();
		Click_Apply_Filter.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Click_OrderID_Filter.click();
		Await();
		Click_Search_Text_Filter.sendKeys(Assign_OB_Trailer_3);
		Await();
		Click_Apply_Filter.click();
		Await();

		String Load_ID_PAR_Order_3 = Loaded_Date_Grid.getText();
//		String[] Date_Split_3 = datePart_3.split("20");
//		String Date_3 = Date_Split_3[0];
//		String year_3 = Date_Split_3[1];
//		String Grid_Date_3 = Date_3.concat("").concat(year_3);
//		System.out.println(Grid_Date_3);

		String[] datecomponent_3 = datePart_3.split("/");
		String yearShort_3 = datecomponent_3[2].substring(2);
		String Grid_Date_3 = datecomponent_3[0] + "/" + datecomponent_3[1] + "/" + yearShort_3;

		assertTrue(Load_ID_PAR_Order_3.contains(Grid_Date_3));

		if (Load_ID_PAR_Order_3.contains(Grid_Date_3)) {
			System.out.println("Successfully Validated Assign_Trailer_Number :" + Grid_Date_3);
		}
		Await();
		Click_Refresh_Outbound_Loads.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
	}

	public void Print_OB_Manifest() throws InterruptedException {
		Outbound_Trailer_Header_Search.sendKeys("5678");
		Await();
		Outbound_Trailer_Header_Search.sendKeys(Keys.ENTER);
		Await();

		List<WebElement> Outbound_Trailer_List = driver
				.findElements(By.xpath("//table[@class='gridTable ']/tbody/tr/td[4]"));
		List<String> Trailer_Results = Outbound_Trailer_List.stream().map(ele -> ele.getText())
				.collect(Collectors.toList());
		String Trailer_Results_Print = Trailer_Results.toString();
		System.out.println(Trailer_Results_Print);
		int Outbound_Trailer_Results = Trailer_Results.size();
		System.out.println(Outbound_Trailer_Results);
//		for (WebElement outbound_results : Outbound_Trailer_Results) {
//			String end_results = outbound_results.getText();
//			System.out.println(end_results);
//
//		}
		Await();
		Outbound_Trailer_Header_Close.click();

		Outbound_Carrier_Name.sendKeys("Estes Express Lines");
		Await();
		Outbound_Carrier_Name.sendKeys(Keys.ENTER);
		Await();
		Click_Header_Content.click();
		Await();

		List<WebElement> Outbound_Carrier_List = driver
				.findElements(By.xpath("//table[@class='gridTable ']/tbody/tr/td[6]"));
		List<String> Carrier_Results = Outbound_Carrier_List.stream().map(ele -> ele.getText())
				.collect(Collectors.toList());
		String Carrier_Results_Print = Carrier_Results.toString();
		System.out.println(Carrier_Results_Print);
		int Outbound_Carrier_Results = Carrier_Results.size();
		System.out.println(Outbound_Carrier_Results);
		Await();
		Outbound_Carrier_Name.clear();
		Await();
		Click_Refresh_Outbound_Loads.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();

		Click_on_Calendar.click();
		Calendarss();
		Await();

		List<WebElement> Loaded_Date_List = driver
				.findElements(By.xpath("//table[@class='gridTable ']/tbody/tr/td[11]"));
		List<String> Loaded_Results = Loaded_Date_List.stream().map(ele -> ele.getText()).collect(Collectors.toList());
		String Loaded_Results_Print = Loaded_Results.toString();
		System.out.println(Loaded_Results_Print);
		int Loaded_Date_Results = Loaded_Results.size();
		System.out.println(Loaded_Date_Results);
		Await();
		Click_Refresh_Outbound_Loads.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();

	}

	public void Released_Status() throws InterruptedException {
		String Case_ID_1_1 = Row1_PAR_Order.getText();
		String Case_ID_2_1 = Row2_PAR_Order.getText();
		String Case_ID_3_1 = Row3_PAR_Order.getText();

		List<WebElement> Order_ID_Column_1 = driver.findElements(By.xpath(
				"//table[@class='gridTable ']/tbody/tr/th[@aria-label='Case ID']/div/following::tr/td[2]/div/span/a"));

		for (WebElement element : Order_ID_Column_1) {
			String orderText = element.getText().trim();

			if (orderText.equals(Case_ID_1_1.trim())) {
				Click_Row1_PAR_Order_checkbox.click();
				System.out.println(Case_ID_1_1);
				break;
			}
		}
		for (WebElement element : Order_ID_Column_1) {
			String orderText = element.getText().trim();
			if (orderText.equals(Case_ID_2_1.trim())) {
				Click_Row2_PAR_Order_checkbox.click();
				System.out.println(Case_ID_2_1);

				break;
			}
		}

		for (WebElement element : Order_ID_Column_1) {
			String orderText = element.getText().trim();
			if (orderText.equals(Case_ID_3_1.trim())) {
				Click_Row3_PAR_Order_checkbox.click();
				System.out.println(Case_ID_3_1);

				break;
			}
		}
		Await();
		Click_Released_button.click();
		Await();
		Released_ID_1 = Row1_Popup_Order.getText();
		Order_BOL_1 = Row1_BOL_Popup_Order.getText();

		assertTrue(Released_ID_1.contains(Case_ID_1_1));
		System.out.println("successfuly validated PAR Order1 :" + Released_ID_1);

		Released_ID_2 = Row2_Popup_Order.getText();
		Order_BOL_2 = Row2_BOL_Popup_Order.getText();
		assertTrue(Released_ID_2.contains(Case_ID_2_1));
		System.out.println("successfuly validated PAR Order2 :" + Released_ID_2);

		Released_ID_3 = Row3_Popup_Order.getText();
		Order_BOL_3 = Row3_BOL_Popup_Order.getText();
		assertTrue(Released_ID_3.contains(Case_ID_3_1));
		System.out.println("successfuly validated PAR Order3 :" + Released_ID_3);
		Await();
		String Total_BOL_Released_Order1 = Total_BOL.getText();
		System.out.println("Total BOL :" + Total_BOL_Released_Order1);
		Await();
		String Total_HU_Released_Order1 = Total_HU.getText();
		System.out.println("Total HU :" + Total_HU_Released_Order1);
		Await();
		Click_on_Calendar.click();
		Calendarss();
		Await();
		Click_Released_button.click();

		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Click_OrderID_Filter.click();
		Await();
		Click_Search_Text_Filter.sendKeys(Released_ID_1);
		Await();
		Click_Apply_Filter.click();
		Await();

		if (No_items_for_the_filters_applied.isDisplayed()) {
			System.out.println("Case Moved to POD Review");

		} else {
			System.out.println("Case still in Outbound Loads");

		}

		Await();
		Click_Refresh_Outbound_Loads.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Click_OrderID_Filter.click();
		Await();
		Click_Search_Text_Filter.sendKeys(Released_ID_2);
		Click_Apply_Filter.click();
		Await();

		if (No_items_for_the_filters_applied.isDisplayed()) {
			System.out.println("Case Moved to POD Review");

		} else {
			System.out.println("Case still in Outbound Loads");

		}

		Await();
		Click_Refresh_Outbound_Loads.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Click_OrderID_Filter.click();
		Await();
		Click_Search_Text_Filter.sendKeys(Released_ID_3);
		Click_Apply_Filter.click();
		Await();

		if (No_items_for_the_filters_applied.isDisplayed()) {
			System.out.println("Case Moved to POD Review");

		} else {
			System.out.println("Case still in Outbound Loads");

		}

	}

	public void POD_Review_Tab() throws InterruptedException, IOException, AWTException {
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Click_POD_Review.click();
		Await();
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Thread.sleep(15000);
		BOL_Header_Search.sendKeys(Order_BOL_1);
		Await();
		BOL_Header_Search.sendKeys(Keys.ENTER);

//		Click_OrderID_Filter_POD_Review.click();
//		Await();
//		Click_Search_Text_Filter.sendKeys(Released_ID_1);
//		Click_Apply_Filter.click();
//		Await();
//		
//
//		String Order_ID_1 = Order_ID_Grid.getText();
//		if (Order_ID_1.contains(Released_ID_1)) {
//			System.out.println("Successfully Validated Assign_Trailer_Number :" + Order_ID_1); 
//
//		}
		Await();
		Attach_DOC.click();
		Await();
		Await();
		Click_Local_File.click();
		System.out.println("Local file");
		Await();
		Await();

		Click_Select_File_Local_File.sendKeys(
				"C:\\Users\\kumarar\\eclipse-workspace\\Smoke_tetsing_EPIC\\PDF\\List of Inbound Trailer.pdf");
		Await();
		Await();
		Await();
		RichText_Name.sendKeys("Test");
		Await();
		Await();
		Attachment_Submit.click();
		Await();
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Thread.sleep(15000);
		Close_Bol_Header_Old_Search.click();
		Thread.sleep(10000);
		BOL_Header_Search.sendKeys(Order_BOL_2);
		Await();
		BOL_Header_Search.sendKeys(Keys.ENTER);

//		Click_OrderID_Filter_POD_Review.click();
//		Await();
//		Click_Search_Text_Filter.sendKeys(Released_ID_2);
//		Click_Apply_Filter.click();
//		Await();
//		
//
//		String Order_ID_2 = Order_ID_Grid.getText();
//		if (Order_ID_2.contains(Released_ID_2)) {
//			System.out.println("Successfully Validated Assign_Trailer_Number :" + Order_ID_2);
//
//		}		

		Await();
		Attach_DOC.click();
		Await();
		Await();
		Click_Local_File.click();
		System.out.println("Local file");
		Await();
		Await();

		Click_Select_File_Local_File.sendKeys(
				"C:\\Users\\kumarar\\eclipse-workspace\\Smoke_tetsing_EPIC\\PDF\\List of Inbound Trailer.pdf");
		Await();
		Await();
		Await();
		RichText_Name.sendKeys("Test");
		Await();
		Await();
		Attachment_Submit.click();
		Await();
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Thread.sleep(15000);
		Await();
		Close_Bol_Header_Old_Search.click();
		Thread.sleep(10000);
		BOL_Header_Search.sendKeys(Order_BOL_3);
		Await();
		BOL_Header_Search.sendKeys(Keys.ENTER);
//		Click_OrderID_Filter_POD_Review.click();
//		Await();
//		Click_Search_Text_Filter.sendKeys(Released_ID_3);
//		Click_Apply_Filter.click();
//		Await();
//
//		String Order_ID_3 = Order_ID_Grid.getText();
//		if (Order_ID_3.contains(Released_ID_3)) {
//			System.out.println("Successfully Validated Assign_Trailer_Number :" + Order_ID_3);
//
//		}
		Await();
		Attach_DOC.click();
		Await();
		Await();
		Click_Local_File.click();
		System.out.println("Local file");
		Await();
		Await();

		Click_Select_File_Local_File.sendKeys(
				"C:\\Users\\kumarar\\eclipse-workspace\\Smoke_tetsing_EPIC\\PDF\\List of Inbound Trailer.pdf");
		Await();
		Await();
		Await();
		RichText_Name.sendKeys("Test");
		Await();
		Await();
		Attachment_Submit.click();
		Await();
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Thread.sleep(15000);
		Thread.sleep(15000);
		Close_Bol_Header_Old_Search.click();
		Thread.sleep(10000);
		BOL_Header_Search.sendKeys(Order_BOL_1);
		Await();
		BOL_Header_Search.sendKeys(Keys.ENTER);
//		Click_OrderID_Filter_POD_Review.click();
//		Await();
//		Click_Search_Text_Filter.sendKeys(Released_ID_1);
//		Click_Apply_Filter.click();
		Await();
		View_Doc_View.click();
		Await();
		Elipsis_Doc_View_popup.click();
		Await();
		Delete_Doc_View_popup.click();
		Await();
		String No_Items_In_Doc_View = No_items_Doc_View_popup.getText();
		Assert.assertTrue(No_Items_In_Doc_View.contains("No items"));
		System.out.println("Successfully deleted attached item");
		Await();
		Close_Doc_View.click();
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Thread.sleep(15000);
		Await();
		Close_Bol_Header_Old_Search.click();

//		Click_OrderID_Filter_POD_Review.click();
//		Await();
//		Click_Search_Text_Filter.sendKeys(Released_ID_1);
//		Click_Apply_Filter.click();
		Thread.sleep(10000);
		BOL_Header_Search.sendKeys(Order_BOL_2);
		Await();
		BOL_Header_Search.sendKeys(Keys.ENTER);
		Await();
		View_Doc_View.click();
		Await();
		Elipsis_Doc_View_popup.click();
		Await();
		Delete_Doc_View_popup.click();
		Await();
		String No_Items_In_Doc_View_2 = No_items_Doc_View_popup.getText();
		Assert.assertTrue(No_Items_In_Doc_View_2.contains("No items"));
		System.out.println("Successfully deleted attached item");
		Await();
		Close_Doc_View.click();
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Thread.sleep(15000);
		Await();
		Close_Bol_Header_Old_Search.click();
		Thread.sleep(10000);
		BOL_Header_Search.sendKeys(Order_BOL_3);
		Await();
		BOL_Header_Search.sendKeys(Keys.ENTER);
//		Click_OrderID_Filter_POD_Review.click();
//		Await();
//		Click_Search_Text_Filter.sendKeys(Released_ID_1);
//		Click_Apply_Filter.click();
		Await();
		View_Doc_View.click();
		Await();
		Elipsis_Doc_View_popup.click();
		Await();
		Delete_Doc_View_popup.click();
		Await();
		String No_Items_In_Doc_View_3 = No_items_Doc_View_popup.getText();
		Assert.assertTrue(No_Items_In_Doc_View_3.contains("No items"));
		System.out.println("Successfully deleted attached item");
		Await();
		Close_Doc_View.click();
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		Frames_Switch_EPIC();
		Await();
		Click_Refresh_Outbound_Loads.click();
		
		
		
		

//		String[] Status_Search = { "Released", "POD Exception", "POD Received", "POD Accepted" };
//		Status_Search_Header_Filter.sendKeys(Status_Search[3]);
//		Await();
//		Status_Search_Header_Filter.sendKeys(Keys.ENTER);
//		Await();
//		Status_Search_Cancel.click();
//		Thread.sleep(15000);

	}
}
