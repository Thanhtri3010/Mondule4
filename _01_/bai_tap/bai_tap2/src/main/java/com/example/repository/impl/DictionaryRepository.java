package com.example.repository.impl;

import com.example.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String, String> dictionary = new HashMap<>();

    static {

        dictionary.put("Hello", "Xin Chào");
        dictionary.put("Dog", "Con Chó");
        dictionary.put("Cat", "Con Mèo");
        dictionary.put("Fish", "Con Cá");
    }

    @Override
    public Map<String, String> translate() {
        return dictionary;
    }
}
