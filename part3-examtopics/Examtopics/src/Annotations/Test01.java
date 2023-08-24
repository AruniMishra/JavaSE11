package Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @Target is not Repeatable annotation, therefore it can appear only once
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
// @Target(ElementType.MODULE)
// @Target(ElementType.METHOD)
@interface Fast21 {
}

public class Test01 {
}