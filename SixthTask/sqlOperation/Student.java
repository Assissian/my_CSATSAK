package com.atcwl.sixthTask;

/**
 * @Description 用于存储学生信息的类
 * @author 陈伟龙
 * @version
 */

public class Student {
    private String SNO;
    private String name;
    private int Age;
    private String College;

    public Student() {
    }

    public Student(String SNO, String name, int age, String college) {
        this.SNO = SNO;
        this.name = name;
        Age = age;
        College = college;
    }

    @Override
    public String toString() {
        return SNO + "\t" + name + "\t\t"
                + Age + "\t" + College;
    }
}
