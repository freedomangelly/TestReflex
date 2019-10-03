package com.example.testreflex;

public class Person {
    private int age;
    private String name;
    private byte[] b;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "toString mothed,"+"name="+name+",age="+age;
    }

    private String myToString(){
        return "myToString mothed,"+"name="+name+",age="+age;
    }

    public static String staticToString(){
        return "static.tostring";
    }

    public byte[] getB() {
        return b;
    }

    public void setB(byte[] b) {
        this.b = b;
    }
}
