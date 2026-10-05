package com.crm.CustomerManagement.practice;

import org.testng.annotations.Test;


import com.crm.CustomerManagement.GenericLibrary.BaseClass;

import ObjectRepository.Homepage;

public class Demo extends BaseClass{
@Test
public void test() {
	Homepage hp=new Homepage(driver);
	hp.getOrgelement().click();
}
}
