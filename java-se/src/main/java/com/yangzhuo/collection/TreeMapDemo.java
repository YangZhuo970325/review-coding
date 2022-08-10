package com.yangzhuo.collection;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {

    public static void main(String[] args) {

        // 方式1:让key值存放的对象实现Comparable接口，并重写compareTo方法
        Map<Student, String> treeMap = new TreeMap<>();

        treeMap.put(new Student("kk", 17), "this is a boy");
        treeMap.put(new Student("ss", 16), "this is a girl");
        treeMap.put(new Student("qq", 20), "this is a man");
        treeMap.put(new Student("ww", 25), "this is a women");
        treeMap.put(new Student("bb", 3), "this is a baby");

        Set<Student> studentSet = treeMap.keySet();
        for (Student student : studentSet) {
            System.out.println(student.toString());
        }


        // 方式2:直接在new一个TreeMap的时候自定义比较器
        Map<Teacher, String> teacherMap = new TreeMap<>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                if (o1.getLevel() > o2.getLevel()) return -1;
                if (o1.getLevel() < o2.getLevel()) return 1;
                return 1;
            }
        });

        teacherMap.put(new Teacher("ww", 1), "普通教师");
        teacherMap.put(new Teacher("rr", 4), "中高级教师");
        teacherMap.put(new Teacher("uu", 1), "普通教师");
        teacherMap.put(new Teacher("tt", 6), "副教授");
        teacherMap.put(new Teacher("qq", 1), "普通教师");
        teacherMap.put(new Teacher("tt", 5), "高级教师");
        teacherMap.put(new Teacher("ee", 3), "中级教师");
        teacherMap.put(new Teacher("aa", 7), "教授");

        Set<Teacher> teacherSet = teacherMap.keySet();
        for (Teacher teacher : teacherSet) {
            System.out.println(teacher.toString());
        }

    }
}

class Student implements Comparable<Student>{

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        if (age > o.age) return 1;
        if (age < o.age) return -1;
        return 1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


class Teacher {

    private String name;
    private int level;

    public Teacher(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}