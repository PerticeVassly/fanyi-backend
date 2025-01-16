package org.fanyi.fanyibackend.serviceImpl;

import org.fanyi.fanyibackend.exception.FanyiException;
import org.fanyi.fanyibackend.po.User;
import org.fanyi.fanyibackend.repository.UserRepository;
import org.fanyi.fanyibackend.service.UserService;
import org.fanyi.fanyibackend.util.TokenUtil;
import org.fanyi.fanyibackend.vo.ResponseVO;
import org.fanyi.fanyibackend.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenUtil tokenUtil;


    @Override
    public ResponseVO<String> login(String phone, String pwd) {
        User user = userRepository.findByPhoneAndPwd(phone, pwd).orElseThrow(FanyiException::notRegister);
        return ResponseVO.buildSuccessResponse("登录成功", tokenUtil.getToken(user));
    }

    @Override
    public ResponseVO<Boolean> register(String phone, String pwd) {
        if (userRepository.findByPhoneAndPwd(phone, pwd).isPresent()) throw FanyiException.hasRegistered();
        User newUser = new User(phone, pwd);
        userRepository.save(newUser);
        return ResponseVO.buildSuccessResponse("注册成功", true);
    }

    @Override
    public ResponseVO<UserVO> info(User currentUser) {
        return ResponseVO.buildSuccessResponse("获取成功", new UserVO(currentUser));
    }
}
