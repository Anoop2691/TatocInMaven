package com.qait.automation.TatocAutomation;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class NewTest extends TatocFunctionsForAutomation{
	
  @Test
  public void connectToChromeAndRunFirstPage() {
	  tatocPage1();
	  Assert.assertEquals("Grid Gate - Basic Course - T.A.T.O.C", driver.getTitle());
  }
  @Test(dependsOnMethods= {"connectToChromeAndRunFirstPage"})
  public void RunSecondPage() {
	  tatocPage2();
	  Assert.assertEquals("Frame Dungeon - Basic Course - T.A.T.O.C", driver.getTitle());
  }
  @Test(dependsOnMethods= {"RunSecondPage"})
  public void RunThirdPage() {
	  tatocPage3();
	  Assert.assertEquals("Drag - Basic Course - T.A.T.O.C", driver.getTitle());
  }
  @Test(dependsOnMethods= {"RunThirdPage"})
  public void RunFourthPage() {
	  tatocPage4();
	  Assert.assertEquals("Windows - Basic Course - T.A.T.O.C", driver.getTitle());
  }
  @Test(dependsOnMethods= {"RunFourthPage"})
  public void RunFifthPage() {
	  tatocPage5();
	  Assert.assertEquals("Cookie Handling - Basic Course - T.A.T.O.C", driver.getTitle());
  }
  @Test(dependsOnMethods= {"RunFifthPage"})
  public void RunLastPage() {
	  tatocPage6();
  }
}
