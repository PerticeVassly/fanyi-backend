package org.fanyi.fanyibackend.controller;

import org.fanyi.fanyibackend.po.User;
import org.fanyi.fanyibackend.service.UserService;
import org.fanyi.fanyibackend.vo.ResponseVO;
import org.fanyi.fanyibackend.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @PostMapping("/login")
    public ResponseVO<String> login(@RequestBody Map<String, String> requestData) {
        String phone = requestData.get("phone");
        String pwd = requestData.get("pwd");
        return userServiceImpl.login(phone, pwd);
    }

//    @PostMapping("/register")
//    public ResponseVO<Boolean> register(@RequestBody Map<String, String> requestData) {
//        String phone = requestData.get("phone");
//        String pwd = requestData.get("pwd");
//        return userServiceImpl.register(phone, pwd);
//    }


    @GetMapping("/info")
    public ResponseVO<UserVO> info(HttpServletRequest request) {
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        return userServiceImpl.info(currentUser);
    }

    @PostMapping("/update")
    public ResponseVO<Boolean> update(@RequestBody UserVO userVO, HttpServletRequest request) {
        User currentUser = (User) request.getSession().getAttribute("currentUser");
        return userServiceImpl.update(currentUser, userVO);
    }

}
