package Runner;

	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	import cucumber.api.CucumberOptions;
	import cucumber.api.testng.CucumberFeatureWrapper;
	import cucumber.api.testng.TestNGCucumberRunner;

	@CucumberOptions(
	        features = "Features/Login_TestNG.feature",
	        //features = "Features/Customers_TestNG.feature",
	        glue = {"StepDefinitions"},
	        tags = {"@sanity"},
			/*
			 * format = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
			 * "json:target/cucumber-reports/CucumberTestReport.json",
			 * "rerun:target/cucumber-reports/rerun.txt" },
			 */
	        monochrome = true,
	        plugin = "json:target/cucumber-reports/CucumberTestReport.json")

	public class MyRunner {
	    private TestNGCucumberRunner testNGCucumberRunner;
	 
	    @BeforeClass(alwaysRun = true)
	    public void setUpClass() throws Exception {
	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	    }
	 
	    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	    public void feature(CucumberFeatureWrapper cucumberFeature) {
	        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	    }
	 
	    @DataProvider
	    public Object[][] features() {
	        return testNGCucumberRunner.provideFeatures();
	    }
	 
	    @AfterClass(alwaysRun = true)
	    public void tearDownClass() throws Exception {
	        testNGCucumberRunner.finish();
	    }
	}


