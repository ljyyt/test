package com.le.springboot.exception;

/**
 * @ClassName UserNotExistException
 * @Description TODO
 * @Author lijunyi
 * @Date 2020/2/12 0:08
 * @Version 1.0
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException(){
        super("用户不存在！");
    }
}
