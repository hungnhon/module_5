package org.example.baitap_2.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepositoryImpl implements DictionaryRepository {

    private static final Map<String, String> dictionary = new HashMap<>();

    static {

        dictionary.put("hello", "xin chào");
        dictionary.put("book", "quyển sách");
        dictionary.put("computer", "máy tính");
        dictionary.put("student", "học sinh");
        dictionary.put("teacher", "giáo viên");
        dictionary.put("school", "trường học");
        dictionary.put("dog", "con chó");
        dictionary.put("cat", "con mèo");
        dictionary.put("car", "xe hơi");
        dictionary.put("bike", "xe đạp");
        dictionary.put("java", "ngôn ngữ java");
        dictionary.put("spring", "framework spring");

    }

    @Override
    public String search(String word) {

        return dictionary.get(word.toLowerCase());

    }
}