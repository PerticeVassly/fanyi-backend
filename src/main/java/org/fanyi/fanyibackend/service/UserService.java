package org.fanyi.fanyibackend.service;

import org.fanyi.fanyibackend.po.User;
import org.fanyi.fanyibackend.vo.ResponseVO;
import org.fanyi.fanyibackend.vo.UserVO;

import java.sql.Struct;

public interface UserService {

    ResponseVO<String> login(String phone, String pwd);

    ResponseVO<Boolean> register(String phone, String pwd);

    ResponseVO<UserVO> info(User currentUser);

    ResponseVO<Boolean> update(User currentUser, UserVO userVO);
}
