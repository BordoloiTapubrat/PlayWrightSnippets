package com.playwright.Tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Test_Text_Selectors {

	final static private String url1 = "https://demo.opencart.com/index.php?route=account/login&language=en-gb";

	final static private String url2 = "https://www.orangehrm.com/en/30-day-free-trial/";

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

		// Using has-text method
		Locator webElement1 = page1.locator("div.card-body h2:has-text('New Customer')");
		System.out.println(webElement1.textContent()); // New Customer

		BrowserContext browserContext2 = browser.newContext();
		Page page2 = browserContext2.newPage();
		page2.navigate(url2);

		// Using text method
		Locator webElement2 = page2.locator("text = Contact Sales").first();
		System.out.println(webElement2.textContent()); // Contact Sales

		// Using CSS
		Locator webElement3 = page2.locator("div.d-flex.web-menu-btn .btn.btn-ohrm.btn-free-demo").first();
		System.out.println(webElement3.textContent()); // Contact Sales
		webElement3.click();

		page1.close();
		browserContext1.close();

		page2.close();
		browserContext2.close();

		browser.close();
		playwright.close();

	}

}
