package org.fanyi.fanyibackend.exception;

public class FanyiException extends RuntimeException {

    public FanyiException(String message) {
            super(message);
    }

    public static FanyiException notLogin() {
        return new FanyiException("未登录!");
    }

    public static FanyiException notRegister() {
        return new FanyiException("未注册!");
    }

    public static FanyiException hasRegistered() {
        return new FanyiException("重复注册!");
    }
}

