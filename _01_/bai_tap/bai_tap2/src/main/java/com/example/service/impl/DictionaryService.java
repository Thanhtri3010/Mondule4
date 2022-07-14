package com.example.service.impl;

import com.example.repository.IDictionaryRepository;
import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    private IDictionaryRepository dictionaryRepository;

    @Override
    public String translate(String word) {
        String result = dictionaryRepository.translate().get(word);
        if (result == null) {
            result = "Not found this word in the dictionary";
        }
        return result;
    }
}
