package project.categoryZ;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.AbstractTest;

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
