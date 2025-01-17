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
        User user = userRepository.findByPhoneAndPwd(phone, pwd).orElse(null);
        if(user != null) {
            //手机号和密码都存在
            return ResponseVO.buildSuccessResponse("登录成功", tokenUtil.getToken(user));
        }else if(userRepository.findByPhone(phone).isPresent()){
            //手机号存在，但密码不正确
            throw FanyiException.WrongPwd();
        }else{
            //手机号和密码都不存在，则自动注册
            User newUser = new User(phone, pwd);
            newUser.setName("用户");
            userRepository.save(newUser);
            return ResponseVO.buildSuccessResponse("注册并登录成功", tokenUtil.getToken(newUser));
        }
    }

//    @Override
//    public ResponseVO<Boolean> register(String phone, String pwd) {
//        if (userRepository.findByPhone(phone).isPresent()) throw FanyiException.hasRegistered();
//        User newUser = new User(phone, pwd);
//        userRepository.save(newUser);
//        return ResponseVO.buildSuccessResponse("注册成功", true);
//    }

    @Override
    public ResponseVO<UserVO> info(User currentUser) {
        return ResponseVO.buildSuccessResponse("获取成功", currentUser.toVO());
    }

    @Override
    public ResponseVO<Boolean> update(User currentUser, UserVO userVO) {
        if (userVO.getName() != null) currentUser.setName(userVO.getName());
        if (userVO.getPhone() != null) currentUser.setPhone(userVO.getPhone());
        if (userVO.getPwd() != null) currentUser.setPwd(userVO.getPwd());
        userRepository.save(currentUser);
        return ResponseVO.buildSuccessResponse("更新成功", true);
    }
}
