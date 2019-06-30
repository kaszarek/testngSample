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
	recordPointOfData(Point.measurement("Test results")
		.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
		.tag("Class name", arg0.getTestClass().getName())
		.tag("Method name", arg0.getName())
		.addField("Start", arg0.getStartMillis())
		.addField("End", arg0.getEndMillis())
		.addField("Duration", arg0.getEndMillis() - arg0.getStartMillis())
		.tag("Result", "Failure")
		.build());
	recordPointOfData(Point.measurement("TestMethods")
		.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
		.tag("Class name", arg0.getTestClass().getName())
		.tag("Method name", arg0.getName())
		.addField("Duration", arg0.getEndMillis() - arg0.getStartMillis())
		.tag("Result", "Failure")
		.build());
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
	recordPointOfData(Point.measurement("Test results")
		.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
		.tag("Class name", arg0.getTestClass().getName())
		.tag("Method name", arg0.getName())
		.addField("Start", arg0.getStartMillis())
		.addField("End", arg0.getEndMillis())
		.addField("Duration", arg0.getEndMillis() - arg0.getStartMillis())
		.tag("Result", "Skipped")
		.build());
	recordPointOfData(Point.measurement("TestMethods")
		.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
		.tag("Class name", arg0.getTestClass().getName())
		.tag("Method name", arg0.getName())
		.addField("Duration", arg0.getEndMillis() - arg0.getStartMillis())
		.tag("Result", "Skipped")
		.build());
    }

    @Override
    public void onTestStart(ITestResult arg0) {
	recordPointOfData(Point.measurement("Test results")
		.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
		.tag("Class name", arg0.getTestClass().getName())
		.tag("Method name", arg0.getName())
		.addField("Duration", arg0.getEndMillis() - arg0.getStartMillis())
		.build());
    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
	recordPointOfData(Point.measurement("Test results")
		.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
		.tag("Class name", arg0.getTestClass().getName())
		.tag("Method name", arg0.getName())
		.addField("Duration", arg0.getEndMillis() - arg0.getStartMillis())
		.tag("Result", "Success")
		.build());
	recordPointOfData(Point.measurement("TestMethods")
		.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
		.tag("Class name", arg0.getTestClass().getName())
		.tag("Method name", arg0.getName())
		.addField("Duration", arg0.getEndMillis() - arg0.getStartMillis())
		.tag("Result", "Success")
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
