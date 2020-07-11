package com.toomuch2learn.example;

import com.toomuch2learn.example.a.A;
import com.toomuch2learn.example.a.ServiceA;
import com.toomuch2learn.example.b.B;
import com.toomuch2learn.example.b.ServiceB;
import com.toomuch2learn.example.c.C;
import com.toomuch2learn.example.c.ServiceC;

import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Processor {

    public static void main(String[] args) {
        try {
            Processor processor = new Processor();
            ProcessorVO vo = processor.processRequest();

            System.out.println(vo);
        }
        catch (Exception e) {
            e.printStackTrace();;
        }
    }

    public ProcessorVO processRequest() throws Exception {
        ProcessorVO vo = null;
        try {

            // List of callable objects to handle different service calls
            List<Callable<Object>> servicesToCall = servicesToCall();

            // Prepare Executor service with fixed thread pool. Lets set to 2, as we have three services to call
            ExecutorService executorService = Executors.newFixedThreadPool(2);

            // Invoke all callable objects to process them in independent threads asynchronously
            List<Future<Object>> futures = executorService.invokeAll(servicesToCall);

            // Shutdown the executor service
            executorService.shutdown();

            // Loop through the future objects and have the details added to VO based upon the type of instance in future object
            vo = new ProcessorVO();
            for (Future<Object> future : futures) {
                if(future.get() instanceof A) {
                    vo.setValueFromA(((A)future.get()).valueFromA());
                }
                else if(future.get() instanceof B) {
                    vo.setValueFromB(((B)future.get()).valueFromB());
                }
                else if(future.get() instanceof C) {
                    vo.setValueFromC(((C)future.get()).valueFromC());
                }
            }
        }
        catch (LambdaWrappedException e) {
            throw new Exception(e);
        }

        return vo;
    }

    /**
     * List of callable objects to handle different service calls
     *
     * @return List<Callable<Object>>
     */
    private List<Callable<Object>> servicesToCall() {
        List<Callable<Object>> servicesToCall = new ArrayList<>();

        // Request to handle ServiceA
        servicesToCall.add(() -> {
            A a = null;
            try {
                a = ServiceA.processA();
            }
            catch (ClassNotFoundException e) {
                LambdaWrappedException.throwException(e);
            }
            return a;
        });

        // Request to handle ServiceB
        servicesToCall.add(() -> {
            B b = null;
            try {
                b = ServiceB.processB();
            }
            catch (InvalidKeyException e) {
                LambdaWrappedException.throwException(e);
            }
            return b;
        });

        // Request to handle ServiceC
        servicesToCall.add(() -> {
            C c = null;
            try {
                c = ServiceC.processC();
            }
            catch (IllegalStateException e) {
                LambdaWrappedException.throwException(e);
            }
            return c;
        });

        return servicesToCall;
    }
}