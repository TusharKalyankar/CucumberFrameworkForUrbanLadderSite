package com.urbanladder.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import com.urbanladder.pageobject.BedroomPage;
import com.urbanladder.pageobject.DiningPage;
import com.urbanladder.pageobject.Header;
import com.urbanladder.pageobject.LivingPage;
import com.urbanladder.pageobject.SalePage;
import com.urbanladder.pageobject.SearchPage;
import com.urbanladder.pageobject.StoragePage;
import com.urbanladder.pageobject.StudyPage;
import com.urbanladder.reusablecomponent.ReusableComponents;
import com.urbanladder.reusablecomponent.ReusableMethods;
import com.urbanladder.utility.dataDriven;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.Logger;
@RunWith(Cucumber.class)
public class stepDefination3 extends abstractpagestepDefination{
	private dataDriven dd;
	//public static Logger log =  (Logger) LogManager.getLogger(Runner.class.getName());
	private Header h;
	private SearchPage s;
	private SalePage sa;
	private LivingPage li;
	private BedroomPage bp;
	private DiningPage dp;
	private StoragePage sp;
	private StudyPage st;
	WebDriver driver=getDriver();
	
	public stepDefination3() throws IOException {
		super();
		dd = new dataDriven();
		h = new Header(driver);
		s = new SearchPage(driver);
		sa = new SalePage(driver);
		li = new LivingPage(driver);
		bp = new BedroomPage(driver);
		dp = new DiningPage(driver);
		sp = new StoragePage(driver);
		st = new StudyPage(driver);
		
	}


	@When("^User hovers over sale icon$")
    public void user_hovers_over_sale_icon() throws Throwable {
		Thread.sleep(7000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Actions a = new Actions(driver);
		WebElement move=h.getSale();//drop down without clicking
		a.moveToElement(move).build().perform();//context click means right click
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 }

    @Then("^Sale dropdown is displayed$")
    public void sale_dropdown_is_displayed() throws Throwable {
        System.out.println("dropdown populated");
    }

    @Then("^User clicks on getsale$")
    public void user_clicks_on_getsale() throws Throwable {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        s.getSale().click();    }

    @And("^It is verified whether sale page is displayed$")
    public void it_is_verified_whether_sale_page_is_displayed() throws Throwable {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println(sa.getSaleResult().getText());
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Thread.sleep(15000);
        //s.getSale().click();
    }


}
