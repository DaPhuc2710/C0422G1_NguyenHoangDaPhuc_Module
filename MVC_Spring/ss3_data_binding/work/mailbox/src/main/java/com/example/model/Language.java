package com.example.model;

public class Language {
    String nameLang;

    public Language() {
    }

    public Language(String nameLang) {

        this.nameLang = nameLang;
    }

    public String getNameLang() {
        return nameLang;
    }

    public void setNameLang(String nameLang) {
        this.nameLang = nameLang;
    }

    @Override
    public String toString() {
        return nameLang;
    }
}
