package com.gnatienko.reader.service;

import com.gnatienko.reader.repository.InternalDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DictionaryCache {

    @Autowired //депенденси инжекшн анотация
    private InternalDictionary repository;


    @Cacheable("P")
    public Map<String, String> getMap() {
        Map<String, String> hashMap = new HashMap<String, String>();

        for(long i=1;i< repository.findAll().size() ;i++) {
            hashMap.put(repository.findById(i).get().getEnglish(), repository.findById(i).get().getRussian()); //???
        }
        return hashMap;
    }
}