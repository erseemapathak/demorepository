package com.cumcumber.MyProject_DemoBlaze;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/com/cumcumber/MyProject_DemoBlaze", glue = "com/cumcumber/MyProject_DemoBlaze", tags = "@smoke",
        plugin = {"pretty", "html:target/reports/httpReport.html", "json:target/reports/jsonReport.json"})
public class TestRunner extends AbstractTestNGCucumberTests {
}

/*@RunWith(Cucumber.class)
@CucumberOptions(
		features ="C:/Users/Pathak/eclipse-workspace-new/MyProject_DemoBlaze/src/test/resources/com/cumcumber/MyProject_DemoBlaze/myproject.feature",
		glue={"Index_stepdefinitions"},
		tags= {"@regression"}
		
		)
public class TestRunner {

}*/