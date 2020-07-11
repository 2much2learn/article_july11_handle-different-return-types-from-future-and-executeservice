package com.toomuch2learn.example;

/**
 * Runtime exception class to wrap checked exception caught in lambda expression and handle it accordingly
 */
public class LambdaWrappedException extends RuntimeException{

    public LambdaWrappedException(Throwable cause) {
        super(cause);
    }

    public static LambdaWrappedException throwException(Throwable t) {
        throw new LambdaWrappedException(t);
    }
}
