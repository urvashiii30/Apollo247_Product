package ApolloRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "resources\\Features", glue = "ApolloStepDefinition", 
tags = "@ApolloProduct", plugin = {"pretty",
		"html:target/HTMLReports/ProductCategory.html", "json:target/JSONReports/ProductCategory.json",
		"junit:target/JUNITReports/ProductCategory.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class TestRunner extends AbstractTestNGCucumberTests {

}