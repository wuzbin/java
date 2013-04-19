package com.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 * User: wuzbin
 * Date: 13-3-25
 * Time: 下午4:12
 * To change this template use File | Settings | File Templates.
 */
@Target(ElementType.FIELD)
public @interface Color {
    public enum Colors{RED, GREEN, BLUE}
    Colors value() default Colors.BLUE;
}
