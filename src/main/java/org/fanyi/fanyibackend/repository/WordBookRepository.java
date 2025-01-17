package org.fanyi.fanyibackend.repository;

import org.fanyi.fanyibackend.po.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordBookRepository extends JpaRepository<Word, Integer> {

    Word findByChinese(String word);

    Word findByChineseAndEnglish(String chinese, String english);
}
