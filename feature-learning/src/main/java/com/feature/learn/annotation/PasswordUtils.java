package com.feature.learn.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: wangxc
 * @GitHub: https://github.com/vector4wang
 * @CSDN: http://blog.csdn.net/qqhjqs?viewmode=contents
 * @BLOG: http://vector4wang.tk
 * @wxid: BMHJQS
 */
public class PasswordUtils {

    @UseCase(id = 1,description = "Passwords must contain at least one numeric")
    public boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    public static void main(String[] args)
			throws IllegalAccessException, InvocationTargetException, InstantiationException {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases, PasswordUtils.class);
    }

    public static void trackUseCases(List<Integer> useCases, Class<?> cl)
			throws IllegalAccessException, InstantiationException, InvocationTargetException {
        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Found Use Case:" + uc.id() + " "
                        + uc.description());
                useCases.remove(new Integer(uc.id()));
//				Object invoke = m.invoke(cl.newInstance(), "123");
//				System.out.println(invoke.toString());
			}
        }
        for (int i : useCases) {
            System.out.println("Warning: Missing use case-" + i);
        }
    }
}
