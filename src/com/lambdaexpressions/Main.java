package com.lambdaexpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return employee1.getName().compareTo(employee2.getName());
            }
        });

        for (Employee e : employeeList){
            System.out.println(e.getName());
        }

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