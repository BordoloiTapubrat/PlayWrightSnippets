package com.playwright.Tests;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;

public class Test_Relative_Selectors {

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
		
		// Looking for - input[type='checkbox']
		//which is - :left-of
		//An element recognized by Text as - :text(John.Smith)
		
		
		//left-of
		page.locator("input[type='checkbox']:left-of(:text('John.Smith'))").first().click();
		
		//right-of
		List<String> value = page.locator("td:right-of(:text('John.Smith'))").allTextContents();
		value.forEach(val -> System.out.println("Right of John.Smith is - "+val));
		
		System.out.println("Right  John.Smith is - "+page.locator("td:right-of(:text('John.Smith'))").first().textContent());
		
		//above
		System.out.println("Above  John.Smith is - "+page.locator("a:above(:text('John.Smith'))").first().textContent());
		
		//below
		System.out.println("Below  John.Smith is - "+page.locator("a:below(:text('John.Smith'))").first().textContent());
		
		//near
		List<String> nearExample = page.locator("td:near(:text('John.Smith'))").allTextContents();
		nearExample.forEach(ele -> System.out.println(ele));

		//near with pixels
		List<String> nearExamplepixel = page.locator("td:near(:text('John.Smith'),120)").allTextContents();
		nearExamplepixel.forEach(ele -> System.out.println(ele));
	}
	
	

}
