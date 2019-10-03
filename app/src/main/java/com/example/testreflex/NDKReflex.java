package com.example.testreflex;

/**
 * description:
 * author: freed on 2019/10/2
 * email: 674919909@qq.com
 * version: 1.0
 */
public class NDKReflex {

    static {
        System.loadLibrary("reflex-lib");
    }

    public native void reflex1();
    public native void reflex2();
    public native void reflex3();


}
