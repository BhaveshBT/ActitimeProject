package com.Actitime.testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Actitime.Generic.Baseclass;
import com.Actitime.pom.HomePage;
import com.Actitime.pom.TaskPage;
@Listeners(com.Actitime.Generic.ListenerImplementation.class)
public class CreateCustomer extends Baseclass {
	
	
	@Test
	public void createcustomer() throws InterruptedException, EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.tasklnk();
		TaskPage tp = new TaskPage(driver);
		tp.addnew();
		Thread.sleep(5000);
	}
	

}