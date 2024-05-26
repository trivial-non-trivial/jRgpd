package org.example.service;

import org.example.annotation.rgpd;
import org.example.exception.RgpdException;

public interface Obfuscation<T> {

    public String obfuscate(T in, rgpd.Style style);
    public T deObfuscate(T in, rgpd.Style style) throws RgpdException;

}
