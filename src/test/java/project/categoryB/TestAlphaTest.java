package project.categoryB;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.AbstractTest;
import project.beans.AlphaBean;

public class TestAlphaTest extends AbstractTest {

    @Autowired
    AlphaBean alphaBean;

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
