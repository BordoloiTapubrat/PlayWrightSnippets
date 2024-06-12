package com.playwright.Tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;

public class Test_Dropdowns {

	final static String url = "https://www.orangehrm.com/en/30-day-free-trial/";
	
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
		
		Locator loc = page.locator("Select#Form_getForm_Country:has(option[value = 'India'])");

		loc.allInnerTexts().forEach(ele -> System.out.println(ele));
		
		page.close();
		browserContext.close();
		browser.close();
		playwright.close();

	}

}
