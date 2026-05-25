package org.example.baitap_2.service;

import org.example.baitap_2.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Override
    public String search(String word) {

        return dictionaryRepository.search(word);

    }
}