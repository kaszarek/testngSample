package project.categoryA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.AbstractTest;
import project.beans.ZzzBean;

@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class TestZZZTest extends AbstractTest {

    @Autowired
    ZzzBean zzzBean;

    @BeforeClass(alwaysRun = true)
    private void setup() {
	takeRandomTime();
    }

    @Test
    public void testOne() {
	takeRandomTime();
	decideOnResult();
    }

    @Test
    public void testTwo() {
	takeRandomTime();
	decideOnResult();
    }
}
