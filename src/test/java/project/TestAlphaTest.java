package project;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAlphaTest extends AbstractTest {

    @BeforeClass(alwaysRun = true)
    private void setup() {
	takeRandomTime();
    }

    @Test
    public void testOne() {
	takeRandomTime();
	decideOnResult();
    }

    @Test(dependsOnMethods = "testOne")
    public void testAuthorize() {
	takeRandomTime();
	decideOnResult();
    }

    @Test(dependsOnMethods = "testAuthorize")
    public void testUseToken() {
	takeRandomTime();
	decideOnResult();
    }

    @Test(dependsOnMethods = "testOne")
    public void testAuthorizeAgain() {
	takeRandomTime();
	decideOnResult();
    }

    @Test(dependsOnMethods = "testAuthorize", priority = 0)
    public void testUseSometingElse() {
	takeRandomTime();
	decideOnResult();
    }

    @Test(dependsOnMethods = "testAuthorize", priority = 1)
    public void testUseYetAnotherThing() {
	takeRandomTime();
	decideOnResult();
    }

}
