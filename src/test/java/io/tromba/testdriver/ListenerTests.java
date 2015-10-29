package io.tromba.testdriver;

import io.tromba.samples.FailureTests;
import io.tromba.testdriver.core.BaseTestdriverTest;
import io.tromba.testdriver.core.TestdriverManager;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

/**
 * Tests to ensure the listeners work.
 */
public class ListenerTests extends BaseTestdriverTest {

    public ListenerTests() {
        super(new TestdriverManager());
    }

    @Test
    public void testRetries() {
        TestNG tng = new TestNG();
        tng.setVerbose(0);
        tng.setTestClasses(new Class[] { FailureTests.class });
//        tng.setAnnotationTransformer(new TestdriverAnnotationTransformer());
        TestListenerAdapter tla = new TestListenerAdapter();
        tng.addListener(tla);
        tng.run();
        Assert.assertEquals(tla.getFailedTests().size(), 1);
        Assert.assertEquals(tla.getSkippedTests().size(), 3);
        Assert.assertEquals(tla.getPassedTests().size(), 0);
    }
}
