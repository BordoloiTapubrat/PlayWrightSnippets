package com.playwright.Tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Test_React_Components {

	final static String url = "https://www.netflix.com/in/";
	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();

		// Launch Options
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);

		Browser browser = playwright.chromium().launch(lp);

		BrowserContext browserContext = browser.newContext();

		Page page = browserContext.newPage();

		page.navigate(url);
		
		page.locator("_react = input[name='email']").first().fill("hello@gmail.com");
		
		page.close();
		browser.close();
		playwright.close();

	}

}
