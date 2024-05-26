package org.example.service;

import org.example.annotation.rgpd;
import org.example.annotation.rgpd.Style;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RgpdService {

    public <T> Style getStyle(Class<T> clazz, String fieldName) {

        try {
            Field field = clazz.getDeclaredField(fieldName);
            rgpd annotation =  field.getAnnotation(rgpd.class);
            Style style = annotation.style();
            String role = annotation.role();
            return style;
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> String obfuscate(T in, Style style) {

        ObfuscationService<T> obfuscationService = new ObfuscationService<>();
        return obfuscationService.obfuscate(in, style);
    }
}
