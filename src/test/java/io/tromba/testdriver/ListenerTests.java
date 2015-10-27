package io.tromba.testdriver;

import io.tromba.samples.FailureTests;
import io.tromba.testdriver.core.TestdriverAnnotationTransformer;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Tests to ensure the listeners work.
 */
public class ListenerTests {

    @Test
    public void testRetries() {
        TestNG tng = new TestNG();
        tng.setVerbose(0);
        tng.setTestClasses(new Class[] { FailureTests.class });
        tng.setAnnotationTransformer(new TestdriverAnnotationTransformer());
        TestListenerAdapter tla = new TestListenerAdapter();
        tng.addListener(tla);
        tng.run();

        List<ITestResult> results = tla.getFailedTests();
        Assert.assertEquals(results.size(), 3);
        Assert.assertEquals(tla.getPassedTests().size(), 0);
    }
}
