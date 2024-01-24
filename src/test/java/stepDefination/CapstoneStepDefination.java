package stepDefination;


import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import BasePackage.BaseCase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CapstoneStepDefination extends BaseCase{
	

	ChromeDriver driver;
	String title;
	
    @Test
	@Given("Launch a  URL")
	public void launch_a_url() {
    
    	
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("http://the-internet.herokuapp.com/");
		 title = driver.getTitle();
		System.out.println(title);
		
		
		
	}
	@Test 
	@Given("verify the title of the Page")
	public void verify_the_title_of_the_page() {
	    
     Assert.assertEquals("The Internet", title);
		
	    
	}
	
	@Test 
	@When("Click on A\\/B Testing link")
	public void click_on_a_b_testing_link() {
	    
		driver.findElement(By.xpath("//a[contains(text(),'A/B Testing')]")).click();
		System.out.println("clicked on A/B");
		
	}
	@Test
	@When("verify the text on the page as “A\\/B Test Variation {int}” using TestNG Assertions")
	public void verify_the_text_on_the_page_as_a_b_test_variation_using_test_ng_assertions(Integer int1) {
	   try {
		   String text = driver.findElement(By.xpath("//h3[contains(text(),'A/B Test Variation 1')]")).getText();
			System.out.println(text);
			 Assert.assertEquals("A/B Test Variation 1", text);
	   }catch(Exception e){
		   String text = driver.findElement(By.xpath("//h3[contains(text(),'A/B Test Control')]")).getText();
			System.out.println(text);
			 Assert.assertEquals("A/B Test Control", text);
	   }
		
		
		
	}
	
	@Test 
	@When("Navigate back to Home page and click on dropdown link")
	public void navigate_back_to_home_page_and_click_on_dropdown_link() {
	    
		driver.navigate().back();
		driver.findElement(By.xpath("//a[contains(text(),'Dropdown')]")).click();
		System.out.println("clicked on DropDown");
		
	}
	@Test
	@When("Select Option1 value form drop down and confirm if its selected or not")
	public void select_option1_value_form_drop_down_and_confirm_if_its_selected_or_not() {
	    
		Select select =	new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
		select.selectByVisibleText("Option 1");
		
		WebElement option = select.getFirstSelectedOption();
	      String selectedoption = option.getText();
	      System.out.println("Selected element: " + selectedoption);
		
	      Assert.assertEquals("Option 1", selectedoption);
	}
	
	@Test 
	@Then("Navigate back to Home Page and Click on Frames")
	public void navigate_back_to_home_page_and_click_on_frames() {
		
		driver.navigate().back();
		driver.findElement(By.xpath("//body/div[2]/div[1]/ul[1]/li[22]/a[1]")).click();
		System.out.println("clicked on Frames");
	    
	}
	
	@Test 
	@Then("Verify the hyperlinks are presented on the Frames Page i.e. Nested Frames and iFrame")
	public void verify_the_hyperlinks_are_presented_on_the_frames_page_i_e_nested_frames_and_i_frame() {
	 
		boolean flag = false;
		
		boolean NFrame = driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).isEnabled();
		boolean iFrame =driver.findElement(By.xpath("//a[contains(text(),'iFrame')]")).isEnabled();
		
		if(NFrame && iFrame) {
			
			System.out.println("Element/Elements visible");
			
			flag = true;
			
		}else {
			System.out.println("Element/Elements not visible");
		}
		
		Assert.assertTrue(flag);
		driver.quit();
	}



}
