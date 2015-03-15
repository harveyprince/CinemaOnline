package com.cinemaonline.action;


import com.cinemaonline.model.Activity;
import com.cinemaonline.model.Test;
import com.cinemaonline.service.TestService;

public class TestAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		this.request().getSession().setAttribute("name", "name");
		Activity act = new Activity();
		act.setContent("what");
		act.setTitle("yes");
		testService.setAct(act);
		System.out.println("test action worked!");
		System.out.println(SUCCESS);
		return SUCCESS;
		
	}

	

}
