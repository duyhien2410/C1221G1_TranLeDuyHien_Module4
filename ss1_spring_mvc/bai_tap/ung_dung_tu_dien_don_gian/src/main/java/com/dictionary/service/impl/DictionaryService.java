package com.dictionary.service.impl;

import com.dictionary.service.IDictionaryService;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {

    @Override
    public String translate(String swap) {

        switch (swap){
            case "hello":
                return "Xin chào";
            case "monday":
                return "Thứ hai";
            case "friday":
                return "Thứ ba";
            case "sunday":
                return "Chủ nhật";
        }
        return swap;
    }
}
