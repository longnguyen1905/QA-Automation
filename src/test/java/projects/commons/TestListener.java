package projects.commons;


import constants.ConstantGlobal;
import helpers.CaptureHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.AllureManager;
import utils.LogUtils;

public class TestListener implements ITestListener {

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onStart(ITestContext result) {
        LogUtils.info("Starting Suite: " + result.getStartDate());
        if (ConstantGlobal.RECORD_VIDEO.equals("yes")) {
            CaptureHelper.startRecord(result.getName());
        }
    }

    @Override
    public void onFinish(ITestContext result) {
        LogUtils.info("Finish Suite: " + result.getEndDate());
        if (ConstantGlobal.RECORD_VIDEO.equals("yes")) {
            CaptureHelper.stopRecord();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (ConstantGlobal.SCREENSHOT_PASS.equals("yes")) {
            CaptureHelper.takeScreenshot(result);
        }

        LogUtils.info(result.getName() + " is pass.");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        if (ConstantGlobal.SCREENSHOT_FAIL.equals("yes")) {
            CaptureHelper.takeScreenshot(result);
        }
        LogUtils.error(result.getThrowable().toString());
        LogUtils.error(result.getName() + " is fail.");
        AllureManager.saveTextLog(result.getName() + " is failed.");
        AllureManager.saveScreenshotPNG();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        if (ConstantGlobal.SCREENSHOT_FAIL.equals("yes")) {
            CaptureHelper.takeScreenshot(result);
        }
        LogUtils.warn(result.getName() + " is skipped.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }
}
