package io.tromba.testdriver.core;

import io.tromba.testdriver.utils.TestdriverRetry;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Annotation transformer to configure the Test annotation.
 */
public class TestdriverAnnotationTransformer implements IAnnotationTransformer {

    private static final int TIMEOUT = 300000;

    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        iTestAnnotation.setRetryAnalyzer(TestdriverRetry.class);
        iTestAnnotation.setTimeOut(TIMEOUT);
    }
}