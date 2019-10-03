package com.example.testreflex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
//            reflex1();
//            reflex2();
            NDKReflex reflex=new NDKReflex();
            reflex.reflex1();
            reflex.reflex2();
            reflex.reflex3();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reflex1() throws Exception{
        //获取类对象
        Class calzz=Class.forName("com.example.testreflex.Person");
        //获取无参构造方法
        Constructor constructor1=calzz.getConstructor();
        //获取类中变量
        Field name =calzz.getDeclaredField("name");
        Field age =calzz.getDeclaredField("age");
        //允许方位私有变量
        name.setAccessible(true);
        age.setAccessible(true);
        //用无参构造函数，实例化对象
        Object object1=constructor1.newInstance();
        //反射获得类中方法
        Method method=calzz.getMethod("setAge",age.getType());
        Method method2=calzz.getMethod("setName",name.getType());
        Method method3=calzz.getMethod("toString");
        //执行类中的set方法
        method.invoke(object1,10);
        method2.invoke(object1,"Hello");
        String text2= (String) method3.invoke(object1);
        //进行打印
        Log.i("info","person.tostring="+text2);
    }
    private void reflex2() throws Exception{
        //  获取类对象
        Class calzz=Class.forName("com.example.testreflex.Person");
        Field name =calzz.getDeclaredField("name");
        Field age =calzz.getDeclaredField("age");
        name.setAccessible(true);
        age.setAccessible(true);
        //获取有参的构造方法
        Constructor constructor2=calzz.getConstructor(age.getType(),name.getType());
        //实例化对象
        Object object2=constructor2.newInstance(11,"hello2");
        //获取类中的方法
        Method method3=calzz.getMethod("toString");
        //获取私有方法
        Method method4=calzz.getDeclaredMethod("myToString");
        method4.setAccessible(true);
        String text= (String) method3.invoke(object2);
        String test2= (String) method4.invoke(object2);
        Log.i("info","person2.tostring="+text);
        Log.i("info","person2.tostring="+test2);
        //获取静态方法
        Method method5=calzz.getDeclaredMethod("staticToString");
        String test3= (String) method5.invoke(method5);
        Log.i("info","person2.tostring="+test3);
    }
}
