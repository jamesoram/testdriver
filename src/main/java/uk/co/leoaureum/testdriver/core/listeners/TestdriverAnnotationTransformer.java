package uk.co.leoaureum.testdriver.core.listeners;

import uk.co.leoaureum.testdriver.utils.TestdriverConfig;
import uk.co.leoaureum.testdriver.utils.TestdriverRetry;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Annotation transformer to configure the Test annotation.
 */
public class TestdriverAnnotationTransformer implements IAnnotationTransformer {

    private static final int TIMEOUT = Integer.parseInt(TestdriverConfig.getInstance().getGlobalTimeoutInMillis());

    /**
     * Transform the test annotation.
     * @param iTestAnnotation the annotation to transform.
     * @param aClass not used.
     * @param constructor not used.
     * @param method not used.
     */
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        iTestAnnotation.setRetryAnalyzer(TestdriverRetry.class);
        iTestAnnotation.setTimeOut(TIMEOUT);
    }
}
