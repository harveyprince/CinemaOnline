package com.cinemaonline.action;

import com.cinemaonline.model.Test;
import com.cinemaonline.service.TestService;

public class TestAction extends BaseAction {
	private TestService testService;
	private Test test;
	public TestService getTestService() {
		return testService;
	}
	
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	
	public Test getTest() {
		return test;
	}
	
	public void setTest(Test test) {
		this.test = test;
	}
	
	public String execute() throws Exception{
		String key="";
		try{
			key = this.request().getParameter("key").toString();
		} catch (Exception e){
			e.printStackTrace();
		}
		String name = testService.getName(key);
		this.request().getSession().setAttribute("name", name);
		System.out.println("test action worked!");
		System.out.println(SUCCESS);
		return SUCCESS;
		
	}

	

}
