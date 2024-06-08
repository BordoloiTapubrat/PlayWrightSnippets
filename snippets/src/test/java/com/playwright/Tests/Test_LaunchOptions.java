package com.playwright.Tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Test_LaunchOptions {
	
	// ## Test to use launch options , mention specific browser  and navigate to url with headless set to false.
	
	static final String url = "https://www.amazon.in/";
	
	public static void main(String [] args)
	{

		Playwright playwright = Playwright.create(); // Check and download Binaries. The Start Playwright Node JS server and return Playwright instance
		
		//Launch Options 
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("msedge");
		lp.setHeadless(false);
		
		Browser browser = playwright.chromium().launch(lp); //Launching the Binary and return Browser Instance
		
		Page page = browser.newPage(); //Create a new Page in a new Browser Context
		
		page.navigate(url); //Navigating to URL
		
		String title = page.title();// Get title of the Page
		
		System.out.println("Page Title is "+title); //Print the Page Title
				
		browser.close(); //Close the browser
		
		playwright.close();// Close the Server
	}

}
