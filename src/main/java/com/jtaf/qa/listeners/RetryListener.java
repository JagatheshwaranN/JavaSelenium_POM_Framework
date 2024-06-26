package com.jtaf.qa.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import com.jtaf.qa.utilities.RetryUtility;

/**
 * 
 * @author Jaga
 *
 */
public class RetryListener implements IAnnotationTransformer {

	@SuppressWarnings("rawtypes")
	@Override
	public void transform(ITestAnnotation testAnnotation, Class clas, Constructor constructor, Method method) {
		try {
			//IRetryAnalyzer retry = testAnnotation.getRetryAnalyzer();
//			if (retry == null) {
				testAnnotation.setRetryAnalyzer(RetryUtility.class);
//			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
