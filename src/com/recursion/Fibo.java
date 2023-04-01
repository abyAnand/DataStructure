package com.recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibo {



    static int fiboOptimized(int n){
        //base condition
        if(n<2){
            return n;
        }
        return fiboOptimized(n-1)+ fiboOptimized(n-2);
    }

    static final Map<Integer, Long> map = new HashMap<>();

    public static long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }

        if (n == 0 || n == 1) {
            return n;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        long fib = fibonacci(n-1) + fibonacci(n-2);
        map.put(n, fib);
        return fib;
    }


}
