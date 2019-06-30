package project;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestExcludedTest extends AbstractTest {

    @BeforeClass(alwaysRun = true)
    private void setup() {
	takeRandomTime();
    }

    @Test(groups = "anotherexcluded")
    public void testBugyBehavior() {
	takeRandomTime(500, 1500);
	decideOnResult();
    }

}
