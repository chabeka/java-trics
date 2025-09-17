package com.kindia.solia.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Article {
    Integer inceptionYear;
    String number;
    String str;
    List<Authors> authors = new ArrayList<>();
    String title;
    public Article (String line){
        try {
            inceptionYear = Integer.valueOf(line.substring(0, 5).trim());
        } catch (NumberFormatException ex) {
            //
        }
        number = line.substring(5, 9).trim();
        str = line.substring(9,20).trim();
        String authorsAnTitle = line.substring(20).trim();
        String[] tab = authorsAnTitle.split("\\,");
        if(tab.length > 0) {
            String auth = tab[0].trim();
            for (String s : auth.split("&")) {
                authors.add(new Authors(s.trim()));
            }
        }
        if(tab.length > 1) {
            title = tab[1].trim();
        }
    }

}
