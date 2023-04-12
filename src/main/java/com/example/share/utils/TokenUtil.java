package com.example.share.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class TokenUtil {
    public String generationToken(String text) {
        return RandomStringUtils.randomAlphabetic(text.length()+250);
    }

    public boolean checkToken(String inputToken, String tokenFromDB){
        return prepareToken(inputToken).equals(tokenFromDB);
    }

    public String prepareToken(String tokenFromRequest){
        return tokenFromRequest.substring(tokenFromRequest.indexOf(" ")).trim();
    }
}
