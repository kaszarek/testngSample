package project;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestLogger implements ITestListener {

    @Override
    public void onFinish(ITestContext arg0) {
	// TODO Auto-generated method stub
    }

    @Override
    public void onStart(ITestContext arg0) {
	// TODO Auto-generated method stub
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	// TODO Auto-generated method stub
    }

    @Override
    public void onTestFailure(ITestResult arg0) {
	System.err.println(arg0.getTestClass().getName() + "." + arg0.getName() + " FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
	System.out.println(arg0.getTestClass().getName() + "." + arg0.getName() + " SKIPPED");
    }

    @Override
    public void onTestStart(ITestResult arg0) {
	System.out.println(arg0.getTestClass().getName() + "." + arg0.getName() + " STARTED");
    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
	System.out.println(arg0.getTestClass().getName() + "." + arg0.getName() + " PASSED");
    }
}
