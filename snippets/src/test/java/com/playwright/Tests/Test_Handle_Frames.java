package com.playwright.Tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Test_Handle_Frames {

	
	final static private String url1 = "https://www.londonfreelance.org/courses/frames/index.html";
	final static private String url2= "https://www.formsite.com/templates/human-resources/employment-application-form/";
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();

		// Launch Options
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		lp.setHeadless(false);

		Browser browser = playwright.chromium().launch(lp);

		//Handle Frame
		BrowserContext browserContext1 = browser.newContext();

		Page page1 = browserContext1.newPage();

		page1.navigate(url1);
		
		//Using FrameLocator
		String header1 = page1.frameLocator("//frame[@name='main']").locator("h2").textContent();
		System.out.println("By Use Of FrameLocator - Header is "+header1);
		
		//Using FrameName
		String header2 = page1.frame("main").locator("h2").textContent();
		System.out.println("By Use of Frame Name - Header is "+header2);
		
		
		//Handle iFrame
		BrowserContext browserContext2 = browser.newContext();
		Page page2 = browserContext2.newPage();
		page2.navigate(url2);

		page2.locator("//div[@id='imageTemplateContainer']").click();
		
		//Using FrameLocator
		page2.frameLocator("//iframe[contains(@id,'frame-one')]").locator("//input[@id='RESULT_TextField-2']").fill("Hello");
		
		
		page1.close();
		browserContext1.close();
		
		page2.close();
		browserContext2.close();
		browser.close();
		playwright.close();
		
	}

}
