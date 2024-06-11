package com.playwright.Tests;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Test_Visible_Elements {

	final static String url = "https://www.amazon.in/";
	
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
		
		//a:visible
		//a >> visible=true
		
		List<String> visibleImages = page.locator("a >> visible=true").allInnerTexts();
		
		//List<String> visibleImages = page.locator("a:visible").allInnerTexts();
		
		visibleImages.forEach(ele -> System.out.println(ele));
		
		
		int total = page.locator("xpath = //img >> visible=true").count();
		
		System.out.println("Total Images - "+total);
		
		page.close();
		browserContext.close();
		browser.close();
		playwright.close();

	}

}
