package org.fanyi.fanyibackend.service;

import org.fanyi.fanyibackend.vo.ResponseVO;
import org.fanyi.fanyibackend.vo.WordVO;

import java.util.List;

public interface WordBookService {

    ResponseVO<Boolean> addWord(WordVO wordVO);

    ResponseVO<Boolean> deleteWord(WordVO wordVO);

    ResponseVO<List<WordVO>> getWordList();
}
