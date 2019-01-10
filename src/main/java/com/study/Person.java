package com.study;

import java.util.Comparator;

public class Person implements Comparable {
    private String name;
    private String CPF;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    /*public static Comparator<Person> COMPARE_BY_AGE_ASC = new Comparator<Person>()  {

        public int compare(Person p1, Person p2) {
            //return b1.getPageNumbers()>b2.getPageNumbers()?1:b2.getPageNumbers()>b1.getPageNumbers()?-1:0;
            return Integer.parseInt(p1.getAge()) - Integer.parseInt(p2.getAge());
        }
    };*/

    public int compareTo(Object o) {
        Person p = (Person) o;

        return Integer.parseInt(getAge()) - Integer.parseInt(p.getAge());
    }
}
