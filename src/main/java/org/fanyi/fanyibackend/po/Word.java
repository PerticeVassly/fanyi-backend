package org.fanyi.fanyibackend.po;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.fanyi.fanyibackend.vo.WordVO;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "chinese")
    private String chinese;

    @Column(name = "english")
    private String english;

    public Word(String chinese, String english) {
        this.chinese = chinese;
        this.english = english;
    }
    public WordVO toVO(){
        return new WordVO(this.chinese, this.english);
    }

}
