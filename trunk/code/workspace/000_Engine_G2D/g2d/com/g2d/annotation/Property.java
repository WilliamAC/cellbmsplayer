package com.g2d.annotation;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @since 2009-04-09
 * @author WAZA <br>
 * <font color="#ff0000"> show field in ObjectPropertyPanel </font> <br>
 * can edit field
 */
@Documented
@Target({TYPE, FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Property{
	String[] value();
}
