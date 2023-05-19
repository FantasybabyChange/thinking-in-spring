package com.fantasybaby.spring.ioc.inject.selection;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * Created on 5/19/2023.
 *
 * @author Fantasy Baby
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier
public @interface FantasyGroup {
}
