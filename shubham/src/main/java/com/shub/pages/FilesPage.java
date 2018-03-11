package com.shub.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.shub.base.BaseTest;

public class FilesPage extends BaseTest{

	//Object Reporsitories
	@FindBy(xpath = "//div[@class='fixedDataTableRowLayout_rowWrapper']//a[@class='public_fixedDataTableCell_cellContent']")
	WebElement AllFileNames;
	
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public int getCountOfFiles() {
		List<WebElement> files = driver.findElements(By.xpath("//div[@class='fixedDataTableRowLayout_rowWrapper']//a[@class='public_fixedDataTableCell_cellContent']"));
		
		for(WebElement a:files) {
			System.out.println(a.getText());
		}

		return files.size();
	}
	
}
