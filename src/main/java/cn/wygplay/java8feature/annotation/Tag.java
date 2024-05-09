package cn.wygplay.java8feature.annotation;

import java.lang.annotation.Repeatable;

@Repeatable(Tags.class)
public @interface Tag {
    String value();
}
