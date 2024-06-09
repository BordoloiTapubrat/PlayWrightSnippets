package com.playwright.Tests;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Test_Locator {
	
	
	// ## Test to use locator for single element and multiple elements such as Select drop down.

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

		// Locators are the central piece of Playwright's auto-waiting and
		// retry-ability.
		// In a nutshell, locators represent a way to find element(s) on the page at any
		// moment.

		// Locator as Single Element
		Locator webElement = page.locator("text = Checkout here");
		webElement.click();
		System.out.println(webElement.textContent()); // Checkout here

		// Locator as List
		Locator webElements = page.locator("select#cars option"); // CSS Selector
		System.out.println("Total Number of Elements - " + webElements.count()); // 4

		// Looping all the Elements
		List<String> listOfElements = webElements.allTextContents(); // Returns a List of String elements

		listOfElements.forEach(ele -> System.out.println(ele)); // Print all the Elements

		/*
		 * Volvo Saab Opel Audi
		 */

		page.close();
		browser.close();
		playwright.close();

	}

}
