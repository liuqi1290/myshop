package com.liuqi.rabbit.task.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.liuqi.rabbit.task.autoconfigure.JobParserAutoConfigurartion;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(JobParserAutoConfigurartion.class)
public @interface EnableElasticJob {

}
