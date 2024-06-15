package com.playwright.Tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Test_nth_element_selector {

	final static String url = "https://selectorshub.com/xpath-practice-page/";
	
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
		
		System.out.println(page.locator("div[data-id='b4836c7'] ul li >> nth=1").textContent());
		System.out.println(page.locator("div[data-id='b4836c7'] ul li  >> nth=5").textContent());
	}

}
