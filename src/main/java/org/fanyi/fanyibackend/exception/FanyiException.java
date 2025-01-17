package org.fanyi.fanyibackend.exception;

public class FanyiException extends RuntimeException {

    public FanyiException(String message) {
            super(message);
    }

    public static FanyiException notLogin() {
        return new FanyiException("未登录!");
    }

    public static FanyiException WrongPwd() {
        return new FanyiException("密码错误！");
    }

//    public static FanyiException notRegister() {
//        return new FanyiException("未注册!");
//    }

//    public static FanyiException hasRegistered() {
//        return new FanyiException("重复注册!");
//    }

    public static FanyiException TencentCloudRequestError() {
        return new FanyiException("腾讯云接口请求错误！");
    }

    public static FanyiException WordNotExist() {
        return new FanyiException("单词不存在！");
    }
    public static FanyiException WordAlreadyExist() {
        return new FanyiException("单词已经存在！");
    }
}

