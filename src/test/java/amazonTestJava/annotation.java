package amazonTestJava; 


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.annotation.en.Given; 
import cucumber.annotation.en.Then; 
import cucumber.annotation.en.When;
import junit.framework.Assert; 

public class annotation { 
	WebDriver driver = null;
	boolean found_result = false;
	String searchResult =null;


	@Given("^I have opened Google search$") 
	public void goToGoogle() { 
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.navigate().to("https://www.google.co.uk/"); 
		driver.manage().window().maximize();
	} 

	@When("^I search for iPhone and click the Amazon link$") 

	public void searchiPhone() {

		String searchTerm = "iPhone";
		searchResult= "www.amazon.co";

		// Next, we'll execute the search
		WebElement searchField = driver.findElement(By.id("lst-ib"));
		searchField.sendKeys(searchTerm);
		searchField.sendKeys(Keys.RETURN);


		List<WebElement> results = driver.findElements(By.tagName("a"));

		System.out.println("Total results are "+results.size());

		for (int i = 0; i < results.size(); i++) {

			String linkURL = results.get(i).getAttribute("href");
			System.out.println("linkURL "+i+". "+linkURL);

			if (linkURL!=null && linkURL.contains(searchResult)) {
				System.out.println("**************** TRUE **************");
				System.out.println("Amazon URL is "+linkURL);
				found_result=true;
				break;

			}
			if (i==results.size()-1) {

				for (int j = 0; j <10; j++) {
					if (!(found_result)) {
						WebElement next_btn= driver.findElement(By.linkText("Next"));
						next_btn.click();
						results = driver.findElements(By.tagName("a"));

						System.out.println("Total results are "+results.size());
						found_result = getSearchDetails(results.size());
						if (found_result) {
							break;
						}


					}
				}

			}}
	}
	@Then("^iPhone details are retrieved$") 
	public void amazonPage() {

		int a=5;


		int ElementsCount = driver.findElements(By.xpath("//div[@id = 'variation_size_name']/ul/li")).size(); 

		String price = driver.findElement(By.xpath("//span[@id = 'priceblock_ourprice']")).getText();

		String model = driver.findElement(By.xpath("//span[@id = 'productTitle']")).getText();



		int thousand = 1000;

		for (int i = 1; i <=ElementsCount;)
		{

			String storage =driver.findElement(By.xpath("(//div[@class='twisterTextDiv text']/span)["+ElementsCount+"]")).getText();

			System.out.println("Model is "+model);
			System.out.println("Highest storage is "+storage);
			System.out.println("Price is "+price);
			break;
		}

		String[] priceArray = price.split("\\.");

//		System.out.println("priceArray[0] "+priceArray[0]);
//		System.out.println("priceArray[1] "+priceArray[1]);


		//		//approach 1
		//		String[] priceArray2 = priceArray[0].split("£");
		//		System.out.println("priceArray2[0] "+priceArray2[0]);
		//		System.out.println("priceArray2[1] "+priceArray2[1]);

		//approach 2
		String priceValue =priceArray[0].substring(1, priceArray[0].length());
		System.out.println("priceValue is "+priceValue);

		if (Integer.parseInt(priceValue)<thousand) {
			Assert.assertTrue("Price is less than 1000", true);
			System.out.println("Price is less than 1000");
		}
		else {
			Assert.assertTrue("Price is not less than 1000", false);
		}
	}





	public boolean getSearchDetails(int resultsSize) {
		boolean result = false;
		List<WebElement> results = driver.findElements(By.tagName("a"));

		System.out.println("Total results are "+results.size());

		for (int i = 0; i < results.size(); i++) {

			String linkURL = results.get(i).getAttribute("href");
			System.out.println("linkURL "+i+". "+linkURL);

			if (linkURL!=null && linkURL.contains(searchResult)) {
				System.out.println("**************** TRUE **************");
				System.out.println("Amazon URL is "+linkURL);
				System.out.println("Amazon link  Text is "+results.get(i).getText());
				results.get(i).click();
				result=true;
				break;

			}


		}

		return result;
	}


}
