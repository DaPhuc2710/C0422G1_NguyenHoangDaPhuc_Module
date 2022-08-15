package com.example.service.impl;

import com.example.service.IService;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
@org.springframework.stereotype.Service
public class Service implements IService {
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
