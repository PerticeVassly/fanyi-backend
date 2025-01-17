package org.fanyi.fanyibackend.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.fanyi.fanyibackend.po.Word;

@Getter
@Setter
@NoArgsConstructor
public class WordVO {
    private String chinese;
    private String english;

    public WordVO(String chinese, String english) {
        this.chinese = chinese;
        this.english = english;
    }

    public Word toPO() {
        return new Word(chinese, english);
    }
}
