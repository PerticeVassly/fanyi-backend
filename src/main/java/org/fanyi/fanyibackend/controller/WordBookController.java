package org.fanyi.fanyibackend.controller;


import org.fanyi.fanyibackend.service.WordBookService;
import org.fanyi.fanyibackend.vo.ResponseVO;
import org.fanyi.fanyibackend.vo.WordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wordbook")
public class WordBookController {

    @Autowired
    private WordBookService wordBookServiceImpl;

    @PostMapping("/add")
    public ResponseVO<Boolean> addWord(@RequestBody WordVO wordVO) {
        return wordBookServiceImpl.addWord(wordVO);
    }

    @DeleteMapping()
    public ResponseVO<Boolean> deleteWord(@RequestBody WordVO wordVO) {
        return wordBookServiceImpl.deleteWord(wordVO);
    }

    @GetMapping()
    public ResponseVO<List<WordVO>> getWordList() {
        return wordBookServiceImpl.getWordList();
    }
}
