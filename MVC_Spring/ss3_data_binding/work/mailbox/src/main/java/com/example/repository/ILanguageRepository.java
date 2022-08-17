package com.example.repository;

import com.example.model.Language;

import java.util.List;

public interface ILanguageRepository {
    List<Language> findAll();
}
