package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.Helperclass;
import MainBase.baseTest;

public class homepage extends baseTest{

	
	
	//public Helperclass help;
	
	@FindBy(xpath="(//a[@href='/account/login'])[2]")
	
	WebElement loginicon;
	
	@FindBy(xpath="//input[@id='CustomerEmail']")
	WebElement Username;
	
	@FindBy(xpath="//input[@id='CustomerPassword']")
	WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Sign in']")
	WebElement loginbtn;
	
	@FindBy(xpath="(//*[@class='modal__toggle-open icon icon-search'])[1]")
	WebElement searchicon;
	
	@FindBy(xpath="//input[@id='Search-In-Modal-1']")
	WebElement searchbar;
	
	@FindAll({ @FindBy(xpath ="//ul[@class='grid product-grid  grid--2-col-tablet-down grid--4-col-desktop']/li")})
	List<WebElement> results;
	
	@FindBy(xpath="//span[@class='facets__summary-label']")
	WebElement filter;
	
	@FindBy(css="label[for='Filter-filter.v.availability-1'] span[class='facet-checkbox__text']")
	WebElement Instock;
	
	@FindBy(css="label[for='Filter-filter.v.availability-2'] span[class='facet-checkbox__text']")
	WebElement outofstock;
	
	@FindBy(xpath="//a[normalize-space()='Reset']")
	WebElement reset;
	
	@FindBy(xpath="(//a[contains(@id,'CardLink')])[1]")
	WebElement Clickonproduct;
	
	@FindBy(xpath="//button[@name='add']")
	WebElement addtocart;
	
	@FindBy(xpath="//a[@id='cart-icon-bubble']//*[name()='svg']")
	WebElement viewcart;
	
	@FindBy(xpath="//h1[@class='title title--primary']")
	WebElement yourcart;
	
	@FindBy(xpath="//*[@id='Remove-1']/a")
	WebElement remove;
	
	
	public homepage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void login(String username,String Password) {
		
		loginicon.click();
		Username.sendKeys(username);
		password.sendKeys(Password);
		loginbtn.click();
	}
	
	public void Product_Search(String searchitem) {
		
		searchicon.click();
		searchbar.sendKeys(searchitem);
		searchbar.sendKeys(Keys.ENTER);
		
	}

	public void Product_filters() throws InterruptedException, IOException {
		Helperclass help=new Helperclass();
		help.ClickAndWait(filter);
		help.ClickAndWait(Instock);
		help.ClickAndWait(outofstock);
		help.ClickAndWait(reset);
		Thread.sleep(3000);
		
	}
	public int Searched_result_count() throws IOException {
		Helperclass help=new Helperclass();
		int size=help.GetList(results, driver);
          return size;
		}	
	public void AddToproductTocart() throws IOException, InterruptedException {
		
		Helperclass help=new Helperclass();
		help.ClickAndWait(Clickonproduct);
		help.ClickAndWait(addtocart);
		Thread.sleep(5000);
		help.ClickAndWait(viewcart);
		Thread.sleep(3000);
	}
	
	public void removeproductfromcart() throws IOException, InterruptedException {
		Helperclass help=new Helperclass();
		help.ClickAndWait(remove);
		Thread.sleep(3000);
	}
	}
