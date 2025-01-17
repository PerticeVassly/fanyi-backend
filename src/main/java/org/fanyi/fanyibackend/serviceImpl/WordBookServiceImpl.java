package org.fanyi.fanyibackend.serviceImpl;

import org.fanyi.fanyibackend.exception.FanyiException;
import org.fanyi.fanyibackend.po.Word;
import org.fanyi.fanyibackend.repository.WordBookRepository;
import org.fanyi.fanyibackend.service.WordBookService;
import org.fanyi.fanyibackend.util.Translator;
import org.fanyi.fanyibackend.vo.ResponseVO;
import org.fanyi.fanyibackend.vo.WordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordBookServiceImpl implements WordBookService {

    @Autowired
    WordBookRepository wordBookRepository;
    @Override
    public ResponseVO<Boolean> addWord(WordVO wordVO) {
        if(wordBookRepository.findByChineseAndEnglish(wordVO.getChinese(), wordVO.getEnglish()) != null){
            throw FanyiException.WordAlreadyExist();
        }
        wordBookRepository.save(wordVO.toPO());
        return ResponseVO.buildSuccessResponse("添加成功", true);
    }

    @Override
    public ResponseVO<Boolean> deleteWord(WordVO wordVO) {
        Word word_db = wordBookRepository.findByChineseAndEnglish(wordVO.getChinese(), wordVO.getEnglish());
        if(word_db == null){
            throw FanyiException.WordNotExist();
        }
        wordBookRepository.delete(word_db);
        return ResponseVO.buildSuccessResponse("删除成功", true);
    }

    @Override
    public ResponseVO<List<WordVO>> getWordList() {
        List<Word> wordList = wordBookRepository.findAll();
        List<WordVO> ans = wordList.stream().map(Word::toVO).collect(Collectors.toList());
        return ResponseVO.buildSuccessResponse("查询成功", ans);
    }
}
