package com.testCases;

import org.testng.annotations.Test;

import com.utils.BaseTest;

public class ExampleTC2 extends BaseTest {
	
	@Test(groups = {"functional"})
	public void test1() {
		System.out.println("ExampleTC2 : test1");
	}
	@Test(groups = {"regression"})
	public void test2() {
		System.out.println("ExampleTC2 : test2");
	}

}
