package com.test.annotation;

import java.lang.annotation.Annotation;

/**
 * Created with IntelliJ IDEA.
 * User: wuzbin
 * Date: 13-3-25
 * Time: 下午3:54
 * To change this template use File | Settings | File Templates.
 */
@MyAnnotation(name = "wuzbin")
public class MyAnnotationTest {
    public static void main(String[] args) {
        Class clazz = MyAnnotationTest.class;
        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation annotation : annotations) {
            if (annotation instanceof  MyAnnotation) {
                MyAnnotation myAnnotation = (MyAnnotation)annotation;
                System.out.println(myAnnotation.name());
            }
        }
    }
}
