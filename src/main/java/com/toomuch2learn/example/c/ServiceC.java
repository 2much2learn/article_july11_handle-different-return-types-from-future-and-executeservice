package com.toomuch2learn.example.c;

public class ServiceC {

    public static C processC() throws IllegalStateException{
        System.out.println("==> ServiceC :: processC :: Begin");
        try {
            Thread.sleep(5000);
        }
        catch (Exception e) {
            // Do Nothing
        }
        System.out.println("==> ServiceC :: processC :: End");
        return new C();
    }
}
