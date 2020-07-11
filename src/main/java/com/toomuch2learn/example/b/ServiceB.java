package com.toomuch2learn.example.b;

import java.security.InvalidKeyException;

public class ServiceB {

    public static B processB() throws InvalidKeyException {
        System.out.println("==> ServiceB :: processB :: Begin");
        try {
            Thread.sleep(1000);
        }
        catch (Exception e) {
            // Do Nothing
        }
        System.out.println("==> ServiceB :: processB :: End");
        return new B();
    }
}
