package OrganizationTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.CustomerManagement.GenericLibrary.BaseClass;
import com.crm.CustomerManagement.GenericLibrary.FileUtillity;
import com.crm.CustomerManagement.GenericLibrary.JavaUtillity;
import com.crm.CustomerManagement.GenericLibrary.SeleniumUtillity;

import ObjectRepository.Homepage;

import ObjectRepository.OrganizationPage;

public class Createorg extends BaseClass {
	@Test
	public void createOrg() throws EncryptedDocumentException, IOException, InterruptedException {
		SeleniumUtillity s=new SeleniumUtillity();
		Homepage hp=new Homepage(driver);
		hp.getOrgelement().click();
		OrganizationPage op=new OrganizationPage(driver);
		op.getPlusicon().click();
		FileUtillity f=new FileUtillity();
		String Orgname = f.readDataFromExcelStringData("OrgData", 2, 1);
		JavaUtillity j=new JavaUtillity();
		int number = j.generateRandomNumber(50);
		op.getOrgnamebx().sendKeys(Orgname+number);
		String email = f.readDataFromExcelStringData("OrgData", 2, 2);
		op.getEmailbx().sendKeys(email);
		WebElement address = op.getIndustrybx();
		s.selectOptionByContainsVisibleText(address, "Technology");
		WebElement type = op.getTypebx();
		s.selectOptionByContainsVisibleText(type, "Customer");
		String billingaddress = f.readDataFromExcelStringData("OrgData", 2, 3);
		op.getBillingAddressbx().sendKeys(billingaddress);
		String shippingaddress = f.readDataFromExcelStringData("OrgData", 2, 4);
		op.getShippingAddressbx().sendKeys(shippingaddress);
		String billingcity = f.readDataFromExcelStringData("OrgData", 2, 5);
		op.getBillingcitybx().sendKeys(billingcity);
		String shippingcity = f.readDataFromExcelStringData("OrgData", 2, 6);
		op.getShippingcitybx().sendKeys(shippingcity);
		String billingstate = f.readDataFromExcelStringData("OrgData", 2, 7);
		op.getBillingstate().sendKeys(billingstate);
		String shippingstate = f.readDataFromExcelStringData("OrgData", 2, 8);
		op.getShippingstate().sendKeys(shippingstate);
		String billingcountry= f.readDataFromExcelStringData("OrgData", 2, 9);
		op.getBillingcountry().sendKeys(billingcountry);
		String shippingcountry = f.readDataFromExcelStringData("OrgData", 2, 10);
		op.getShippingcountry().sendKeys(shippingcountry);
		String desc = f.readDataFromExcelStringData("OrgData", 2, 11);
		op.getDescriptionbx().sendKeys(desc);
		op.getSavebtn().click();;
		Thread.sleep(5000);
	}

}
