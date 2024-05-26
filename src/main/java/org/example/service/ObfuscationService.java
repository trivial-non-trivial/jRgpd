package org.example.service;

import org.example.annotation.rgpd;
import org.example.exception.RgpdException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ObfuscationService<T> implements Obfuscation<T>{

    @Override
    public String obfuscate(T in, rgpd.Style style) {
        switch (style) {
            case SHUFFLE: return obfuscateShuffle(in);
            case STARS: return obfuscateStars(in);
            default: return in.toString();
        }
    }

    @Override
    public T deObfuscate(T in, rgpd.Style style) throws RgpdException {
        return null;
    }

    public String obfuscateShuffle(T in) {
        String[] array = in.toString().split("");
        List<String> list = Arrays.stream(array).collect(Collectors.toList());
        Collections.shuffle(list);
        return String.join("", list);
    }

    public String obfuscateStars(T in) {
        String[] array = in.toString().split("");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || i == array.length -1){
                sb.append(array[i]);
            }
            else {
                sb.append("*");
            }
        }
        return sb.toString();
    }

    public String obfuscateFull(T in) {
        String[] array = in.toString().split("");
        List<String> list = Arrays.stream(array).map(a -> "*").collect(Collectors.toList());
        return String.join("", list);
    }
}
