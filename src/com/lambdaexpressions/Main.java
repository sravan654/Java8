package com.lambdaexpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by apuris on 21/01/18.
 */
public class Main {
    public static void main(String[] args){
//        new Thread(new CodeToRun()).start();

        //Incase of Anonymous class
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Printing from Anonymous class");
//            }
//        }).start();

        //Incase of Lambda expression
//        new Thread(()-> System.out.println("Printing from Lamba expression")).start();

        //Incase of multiple lines for Lambda expressions
        new Thread(()->{
            System.out.println("first line from lamda");
            System.out.println("2nd line from lamda");
            System.out.println("3rd line from lamda");
        }).start();

        Employee employee1 = new Employee("ram",12);
        Employee employee2 = new Employee("lax", 10);
        Employee employee = new Employee("krish",8);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee);

//        Collections.sort(employeeList, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });

        //Sorting employees using lambda expression
        Collections.sort(employeeList, (e1, e2)->
        e1.getName().compareTo(e2.getName()));

        for (Employee e : employeeList){
            System.out.println(e.getName());
        }

//        String s = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, employeeList.get(0).getName(), employeeList.get(1).getName());


        //Using lambda
        UpperConcat uc = (s1, s2) -> s1.toUpperCase()+s2.toUpperCase();
        String s = doStringStuff(uc,employeeList.get(0).getName(), employeeList.get(1).getName());
        System.out.println(s);

    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2){
        return uc.upperAndConcat(s1,s2);
    }
}

class CodeToRun implements Runnable{

    @Override
    public void run() {
        System.out.println("Running from runnable");
    }
}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
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
}

interface UpperConcat{
    public String upperAndConcat(String s1, String s2);
}