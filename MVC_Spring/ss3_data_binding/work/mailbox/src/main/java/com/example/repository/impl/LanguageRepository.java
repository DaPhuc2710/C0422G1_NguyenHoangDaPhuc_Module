package com.example.repository.impl;

import com.example.model.Language;
import com.example.repository.ILanguageRepository;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;

import java.util.List;


@Repository
public class LanguageRepository implements ILanguageRepository {
    static public List<Language> languageList = new ArrayList<>();

    static {
        languageList.add(new Language("English"));
        languageList.add(new Language("Vietnamese"));
        languageList.add(new Language("Japanese"));
        languageList.add(new Language("Chinese"));
    }

    @Override
    public List<Language> findAll() {
        return languageList;
    }
}
