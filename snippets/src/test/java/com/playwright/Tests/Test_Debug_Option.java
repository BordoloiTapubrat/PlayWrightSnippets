package com.playwright.Tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Test_Debug_Option {
	
	
	//Test to use debug option - play.pause()
	
	static final private String url = "https://www.amazon.in/";
	
	public static void main(String args [])
	{
		
		//Create and Start Playwright server
		
		Playwright playwright = Playwright.create();
		
		//Create a browser instance
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
	
		//Create a Page instance
		Page page = browser.newPage();
		
		page.navigate(url);
		
		//Debug Mode
		page.pause();
		
		//or in Run Configuration -> Environment -> Add Variable ->PWDEBUG = 1
		
		browser.close();
		playwright.close();
	}

}
