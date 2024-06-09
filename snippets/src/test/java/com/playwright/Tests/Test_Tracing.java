package com.playwright.Tests;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class Test_Tracing {
	
	//Test to use Tracing option
	
		static final private String url = "https://www.amazon.in/";
		
		public static void main(String args [])
		{
			
			//Create and Start Playwright server
			
			Playwright playwright = Playwright.create();
			
			//Create a browser instance
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		
			
			BrowserContext browsercontext = browser.newContext();
			
			// Start tracing before creating / navigating a page.
			browsercontext.tracing().start(new Tracing.StartOptions()
			  .setScreenshots(true)
			  .setSnapshots(true)
			  .setSources(true));
			
			//Create a Page instance
			Page page = browsercontext.newPage();
			
			page.navigate(url);
			
			// Stop tracing and export it into a zip archive.
			browsercontext.tracing().stop(new Tracing.StopOptions()
			  .setPath(Paths.get("trace.zip")));
			
			browser.close();
			playwright.close();
		}

}
