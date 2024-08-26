package Smoke_Runner;

import org.testng.annotations.Test;

import Orders_PAR.Inbound_Trailer;
import Orders_PAR.UtilClass;

public class Runner extends UtilClass {
	@Test
	public void InboundTrailer() throws Exception {
		Inbound_Trailer login = new Inbound_Trailer(driver);
//		login.PAR_Order_Creation();
		login.PEGALogin();
		login.LaunchWarehousePortal();
		login.OrdersPAR();
//		login.InboundTrailer_WorkQueue();
//		login.Assign_Trailer_InboundTrailer();
		login.Outbound_Loads_Assign_Carrier();
		login.Outbound_Loads_Assign_Load_ID();
		login.Outbound_Loads_Assign_OB_Trailer();
		login.Print_OB_Manifest();
		login.Released_Status();
		login.POD_Review_Tab();
	}
}
