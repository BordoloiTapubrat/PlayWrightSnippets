package com.playwright.Tests;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;

public class Test_dynamic_Web_Table {

	final static private String url = "https://primeng.org/";

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

		// Locate the row
		Locator table = page.locator("//table[@id='pn_id_1-table']/tbody/tr");

		// Using Scope in Dynamic table to get all the data in the page
		// Click on the checkbox next to Art Venere
		System.out.println("Clicking on the Checkbox");
		table.locator(":scope", new Locator.LocatorOptions().setHasText("Art Venere")).locator(".p-checkbox-box")
				.click();

		System.out.println("Print the Specific Row");
		// print the row for James Butt
		System.out.println(
				table.locator(":scope", new Locator.LocatorOptions().setHasText("Art Venere")).allTextContents());

		System.out.println("Printing all the Rows");
		// Print all the rows
		List<String> tableContents = table.locator(":scope").allTextContents();
		tableContents.forEach(row -> System.out.println(row));

		page.close();

		browserContext.close();

		browser.close();

		playwright.close();

	}

}
