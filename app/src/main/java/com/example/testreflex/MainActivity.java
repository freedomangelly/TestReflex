package com.example.testreflex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Class calzz=Class.forName("com.example.testreflex.Person");
            Constructor constructor1=calzz.getConstructor();
            Constructor constructor2=calzz.getConstructor(int.class,String.class);
            Field name =calzz.getDeclaredField("name");
            Field age =calzz.getDeclaredField("age");
            Object object1=constructor1.newInstance();
            Object object2=constructor2.newInstance(11,"hello2");
            Method method=calzz.getMethod("setAge",int.class);
            Method method2=calzz.getMethod("setName",String.class);
            Method method3=calzz.getMethod("toString");
            method.invoke(object1,10);
            method2.invoke(object1,"Hello");
            method3.invoke(object1);
            method3.invoke(object2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
