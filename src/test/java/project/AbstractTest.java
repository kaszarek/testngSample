package project;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;

import project.beans.SomeBeanFromFactory;
import project.external.SomeBean;

@Listeners(value = { InfluxDbLogger.class, TestLogger.class })
@ContextConfiguration(classes = SampleContextConfig.class)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
public class AbstractTest extends AbstractTestNGSpringContextTests {

    @Autowired
    SomeBean someBean;

    @Autowired
    SomeBeanFromFactory someBeanFromFactory;

    protected void takeRandomTime() {
	final int randomTimeToSleep = getRandomValue(3000) + 100;
	try {
	    Thread.sleep(randomTimeToSleep);
	} catch (final InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    protected void decideOnResult() {
	final int randomValue = getRandomValue(100);
	if (randomValue < 2) {
	    throw new SkipException("Skip");
	} else if (randomValue < 25) {
	    Assert.fail("Test failed");
	}
	// test passes
    }

    private int getRandomValue(int i) {
	final Random r = new Random();
	return r.nextInt(i);
    }

    protected void takeRandomTime(int i, int j) {
	final int randomValue = getRandomValue(j - i) + i;
	try {
	    Thread.sleep(randomValue);
	} catch (final InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

}
