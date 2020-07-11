package com.toomuch2learn.example.a;

public class ServiceA {

    public static A processA() throws ClassNotFoundException {
        System.out.println("==> ServiceA :: processA :: Begin");
        try {
            Thread.sleep(2000);
        }
        catch (Exception e) {
            // Do Nothing
        }
        System.out.println("==> ServiceA :: processA :: End");
        return new A();
    }
}
