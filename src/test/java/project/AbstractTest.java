package project;

import java.util.Random;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;

@Listeners(value = { InfluxDbLogger.class, TestLogger.class })
public class AbstractTest {

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
