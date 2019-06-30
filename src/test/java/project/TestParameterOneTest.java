package project;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterOneTest extends AbstractTest {

    @BeforeClass(alwaysRun = true)
    private void setup() {
	takeRandomTime();
    }

    @DataProvider
    public Object[][] testFixtures() {
	return new Object[][] {
		{ 1 },
		{ 1 },
		{ 1 },
		{ 1 },
		{ 1 },
		{ 1 },
		{ 1 },
		{ 1 },
		{ 1 },
		{ 1 },
		{ 1 },
		{ 1 },
		{ 1 },
		{ 1 },
		{ 1 },
		{ 1 },
		{ 1 },
		{ 1 },
		{ 1 },
		{ 1 },
		{ 1 },

	};
    }

    @Test(dataProvider = "testFixtures")
    public void testSomethingInteresting(int i) {
	takeRandomTime(500, 1500);
	decideOnResult();
    }

}
