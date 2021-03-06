package project;

import java.util.concurrent.TimeUnit;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class InfluxDbLogger implements ITestListener {

    private static final String INFLUX_DB_URL = "http://127.0.0.1:8086";

    @Override
    public void onFinish(ITestContext arg0) {
    }

    @Override
    public void onStart(ITestContext arg0) {
	recordPointOfData(Point.measurement("Test results")
		.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
		.tag("Suite name", arg0.getSuite().getName())
		.addField("Start", arg0.getStartDate().getTime())
		.build());
	recordPointOfData(Point.measurement("TestSuites")
		.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
		.tag("Suite name", arg0.getSuite().getName())
		.addField("Name", arg0.getSuite().getName())
		.addField("Start", arg0.getStartDate().getTime())
		.build());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
    }

    @Override
    public void onTestFailure(ITestResult arg0) {
	recordPointOfData(Point.measurement("Test results")
		.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
		.tag("Class name", arg0.getTestClass().getName())
		.tag("Method name", arg0.getName())
		.tag("Result", "Failure")
		.addField("Start", arg0.getStartMillis())
		.addField("End", arg0.getEndMillis())
		.addField("Duration", arg0.getEndMillis() - arg0.getStartMillis())
		.build());
	recordPointOfData(Point.measurement("TestMethods")
		.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
		.tag("Class name", arg0.getTestClass().getName())
		.tag("Method name", arg0.getName())
		.tag("Result", "Failure")
		.addField("Duration", arg0.getEndMillis() - arg0.getStartMillis())
		.build());
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
	recordPointOfData(Point.measurement("Test results")
		.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
		.tag("Class name", arg0.getTestClass().getName())
		.tag("Method name", arg0.getName())
		.tag("Result", "Skipped")
		.addField("Start", arg0.getStartMillis())
		.addField("End", arg0.getEndMillis())
		.addField("Duration", arg0.getEndMillis() - arg0.getStartMillis())
		.build());
	recordPointOfData(Point.measurement("TestMethods")
		.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
		.tag("Class name", arg0.getTestClass().getName())
		.tag("Method name", arg0.getName())
		.tag("Result", "Skipped")
		.addField("Duration", arg0.getEndMillis() - arg0.getStartMillis())
		.build());
    }

    @Override
    public void onTestStart(ITestResult arg0) {
	recordPointOfData(Point.measurement("Test results")
		.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
		.tag("Class name", arg0.getTestClass().getName())
		.tag("Method name", arg0.getName())
		.addField("Start", arg0.getStartMillis())
		.build());
    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
	recordPointOfData(Point.measurement("Test results")
		.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
		.tag("Class name", arg0.getTestClass().getName())
		.tag("Method name", arg0.getName())
		.tag("Result", "Success")
		.addField("Duration", arg0.getEndMillis() - arg0.getStartMillis())
		.build());
	recordPointOfData(Point.measurement("TestMethods")
		.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
		.tag("Class name", arg0.getTestClass().getName())
		.tag("Method name", arg0.getName())
		.tag("Result", "Success")
		.addField("Duration", arg0.getEndMillis() - arg0.getStartMillis())
		.build());
    }

    private void recordPointOfData(Point point) {
	InfluxDB db = null;
	try {
	    db = InfluxDBFactory.connect(INFLUX_DB_URL);
	    db.setDatabase("mydb");
	    db.write(point);
	} catch (final Exception e) {
	    e.printStackTrace();
	} finally {
	    if (db != null) {
		db.close();
	    }
	}
    }

}
