package com.playwright.Tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Test_BrowserContext {
	
	
	// ## Test to initiate different browser context.
	
		static final String url1 = "https://www.amazon.in/";
		
		static final String url2 = "https://www.google.com/";
		
		static final String url3 = "https://www.flipkart.com/";
		
		public static void main(String [] args)
		{
			Playwright playwright = Playwright.create(); // Check and download Binaries. The Start Playwright Node JS server and return Playwright instance
			
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); //Launching the Binary and return Browser Instance
			
			
			//Browser Context is an environment in which a browser displays a document. It is tab or a window.
			//Browser Context doesn't share cookies or cache.
			//Browser Context is totally isolated
			
			//1st Browser Context
			BrowserContext brcx1 = browser.newContext();//Create a new Browser Context
			Page page_1 = brcx1.newPage(); //Create a new Page in a new Browser Context
			page_1.navigate(url1); //Navigating to URL
			String title1 = page_1.title();// Get title of the Page
			System.out.println("Page Title for Browser Context 1 "+title1); //Print the Page Title
			
			//2nd Browser Context
			BrowserContext brcx2 = browser.newContext();//Create a new Browser Context
			Page page_2 = brcx2.newPage(); //Create a new Page in a new Browser Context
			page_2.navigate(url2); //Navigating to URL
			String title2 = page_2.title();// Get title of the Page
			System.out.println("Page Title for Browser Context 2 "+title2); //Print the Page Title
			
			//3rd Browser Context
			BrowserContext brcx3 = browser.newContext();//Create a new Browser Context
			Page page_3 = brcx3.newPage(); //Create a new Page in a new Browser Context
			page_3.navigate(url3); //Navigating to URL
			String title3 = page_3.title();// Get title of the Page
			System.out.println("Page Title for Browser Context 3 "+title3); //Print the Page Title
			
			
			page_1.close();
			brcx1.close();
			
			page_2.close();
			brcx2.close();
			
			page_3.close();
			brcx3.close();
					
			browser.close(); //Close the browser
			playwright.close();// Close the Server
			
			
			
		}

}
