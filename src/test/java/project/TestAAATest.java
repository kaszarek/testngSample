package project;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAAATest extends AbstractTest {

    @BeforeClass(alwaysRun = true)
    private void setup() {
	takeRandomTime();
    }

    @Test
    public void testOne() {
	takeRandomTime(5000, 30000);
	decideOnResult();
    }

    @Test
    public void testTwo() {
	takeRandomTime(5000, 30000);
	decideOnResult();
    }

    @Test
    public void testThree() {
	takeRandomTime(5000, 30000);
	decideOnResult();
    }

    @Test
    public void test4() {
	takeRandomTime(5000, 30000);
	decideOnResult();
    }

    @Test
    public void test5() {
	takeRandomTime(5000, 30000);
	decideOnResult();
    }

    @Test
    public void test6() {
	takeRandomTime(5000, 30000);
	decideOnResult();
    }

    @Test
    public void test7() {
	takeRandomTime(5000, 30000);
	decideOnResult();
    }

    @Test
    public void test8() {
	takeRandomTime(5000, 30000);
	decideOnResult();
    }

    @Test
    public void test9() {
	takeRandomTime(5000, 30000);
	decideOnResult();
    }

    @Test
    public void test10() {
	takeRandomTime(5000, 30000);
	decideOnResult();
    }

    @Test
    public void test11() {
	takeRandomTime(5000, 30000);
	decideOnResult();
    }

    @Test
    public void test12() {
	takeRandomTime(5000, 30000);
	decideOnResult();
    }

    @Test
    public void test14() {
	takeRandomTime(5000, 30000);
	decideOnResult();
    }

    @Test
    public void test15() {
	takeRandomTime(5000, 30000);
	decideOnResult();
    }

    @Test
    public void test16() {
	takeRandomTime(5000, 30000);
	decideOnResult();
    }

}
