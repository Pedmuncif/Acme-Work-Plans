package acme.testing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

public class ShoutTest extends AcmeTest{

	@Override
	@BeforeAll
	public void beforeAll() {
		super.beforeAll();

		super.setBaseCamp("http", "localhost", "8080", "/Acme-Planner", "/master/welcome", "?language=en&debug=true");
		super.setAutoPausing(true);
		

	}
	
	// Test cases -------------------------------------------------------------

//		@ParameterizedTest
//		@CsvFileSource(resources = "/shout/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
//		@Order(10)
//		public void positiveCreateShout(final String author, final String text, final String info) {
//			super.clickAndGo(By.linkText("Anonymous"));
//			super.submit(By.linkText("Create Shout"));
//			super.fill(By.id("author"), author);
//			super.fill(By.id("text"), text);
//			super.fill(By.id("info"), info);
//			super.submit(By.className("btn-primary"));
//		}
		
		@ParameterizedTest
		@CsvFileSource(resources = "/shout/negative.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(10)
		public void negativeCreateShout(final String author, final String text, final String info) {
			super.clickAndGo(By.linkText("Anonymous"));
			super.submit(By.linkText("Create Shout"));
			super.fill(By.id("author"), author);
			super.fill(By.id("text"), text);
			super.fill(By.id("info"), info);
			super.submit(By.className("btn-primary"));
			
			super.checkErrorsExist();
		}
	
}

/*		@ParameterizedTest
@CsvFileSource(resources = "/shout/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
@Order(10)
public void positiveCreateShout(final String author, final String text, final String info) {
	super.clickAndGo(By.linkText("Anonymous"));
	super.submit(By.linkText("Create Shout"));
	super.fill(By.id("author"), author);
	super.fill(By.id("text"), text);
	super.fill(By.id("info"), info);
	super.submit(By.className("btn-primary"));
}*/