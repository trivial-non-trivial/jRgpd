package org.example.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface rgpd {
    String role();
    Style style();

    public enum Style {
        SHUFFLE,
        LIGHT,
        FULL,
        STARS,
        TOTAL,
        REVERSEABLE,
        NONE;
    }
}
