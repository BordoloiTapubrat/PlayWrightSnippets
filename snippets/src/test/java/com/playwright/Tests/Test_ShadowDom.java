package com.playwright.Tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Test_ShadowDom {

	final static private String url1 = "https://books-pwakit.appspot.com/";
	final static private String url2= "https://selectorshub.com/shadow-dom-in-iframe/";
	
	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();

		// Launch Options
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);

		Browser browser = playwright.chromium().launch(lp);

		//Page -> Dom -> Shadow DOM -> Element
		//Page -> iframe -> DOM -> Shadow DOM -> Element
		
		//Handle ShadowDom - //Page -> Dom -> Shadow DOM -> Element
		BrowserContext browserContext1 = browser.newContext();

		Page page1 = browserContext1.newPage();

		page1.navigate(url1);
		
		page1.locator("book-app[apptitle='BOOKS'] input[id='input']").fill("Books");
		
		
		
		//Handle ShadowDom - //Page -> iframe -> DOM -> Shadow DOM -> Element
		BrowserContext browserContext2 = browser.newContext();
		Page page2 = browserContext2.newPage();
		page2.navigate(url2);
		page2.frameLocator("iframe[id='pact']").locator("input[id='tea']").fill("Red Tea");
		
		page1.close();
		browserContext1.close();
		
		page2.close();
		browserContext2.close();

		browser.close(); //Close the browser
		playwright.close();// Close the Server
		

	}

}
