package com.GenericUtilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class iTransform implements org.testng.internal.annotations.IAnnotationTransformer {

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod,
			Class<?> occurringClazz) {
		//fetching the testclass from retryanalyzer class where we created in generic 
		annotation.setRetryAnalyzer(com.GenericUtilities.RetryAnlyzer.class);
		int ic = annotation.getInvocationCount();
		if (ic>3) {
			annotation.setInvocationCount(0);
		}
	}
	

}
