package project;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestBugTest extends AbstractTest {

    @BeforeClass(alwaysRun = true)
    private void setup() {
	takeRandomTime();
    }

    @Test(groups = "bug")
    public void testBugyBehavior() {
	takeRandomTime(500, 1500);
	decideOnResult();
    }

}
