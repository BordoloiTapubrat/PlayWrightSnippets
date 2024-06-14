package com.playwright.Tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Test_Comma_Seperated_CSS {

	final static private String url1= "https://selectorshub.com/xpath-practice-page/";
	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();

		// Launch Options
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);

		Browser browser = playwright.chromium().launch(lp);

		BrowserContext browserContext1 = browser.newContext();

		Page page1 = browserContext1.newPage();

		page1.navigate(url1);
		
		//Comma Seperated Css to manage change in element. If either is found it will work.
		
		page1.locator("div.userform #shub68 , div.userform input[name='email']").fill("hello@world.com");
		
		page1.close();
		browserContext1.close();

		browser.close(); //Close the browser
		playwright.close();// Close the Server

	}

}
