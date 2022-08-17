package com.example.repository.impl;

import com.example.repository.IDictionaryRepository;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@org.springframework.stereotype.Repository
public class DictionaryRepository implements IDictionaryRepository {
    static Map<String, String> dictionaryList = new HashMap<>();

    static {
        dictionaryList.put("tiger", "Hổ");
        dictionaryList.put("cat", "Mèo");
        dictionaryList.put("lion", "Sư tử");
    }

    @Override
    public String dictionary(String word) {
        return dictionaryList.get(word.toLowerCase(Locale.ROOT));
    }
}
