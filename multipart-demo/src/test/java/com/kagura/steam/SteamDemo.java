package com.kagura.steam;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2020/5/4 20:02
 * @since 1.0.0
 */
public class SteamDemo {

    private static PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Test
    public void test01() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        System.out.println(list.stream().distinct().count());

    }

    @Test
    public void test02() {

    }

    public static void main(String[] args) {
        String salt = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 22);
        long start = System.currentTimeMillis();
        String s = BCrypt.gensalt();
        System.out.println("salt : " + s);
        String hashPw = BCrypt.hashpw("Phantom0928!", s);
        long end = System.currentTimeMillis();
        System.out.println(hashPw + " : " + (end - start));

        start = System.currentTimeMillis();
        String md5Pw = new MessageDigestPasswordEncoder("MD5").encode("Phantom0928!");
        end = System.currentTimeMillis();
        System.out.println(md5Pw + " : " + (end - start));

    }



}
