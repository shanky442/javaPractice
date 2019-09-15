package com.learningsJava;

import java.util.*;

class Student implements Comparable<Student>{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
    public int compareTo(Student s2) {
         if(s2.getCgpa()-this.getCgpa() >0.00) {
            return 1;
        } else if(s2.getCgpa() - this.getCgpa() < 0.00) {
             return  -1;
         } else {
             if(this.getFname().equals(s2.getFname())) {
                 return this.getId()-s2.getId();
             } else {
                 return this.getFname().compareTo(s2.getFname());
             }
         }
    }
}

//Complete the code
public class SortingStudent
{//https://www.hackerrank.com/challenges/java-sort/problem
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }
        Collections.sort(studentList);
        for(Student st: studentList){
            System.out.println(st.getFname());
        }
    }
}




