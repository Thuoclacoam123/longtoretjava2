package com.assigment;

import java.util.Scanner;

public class Student {
    int id ;
    String name;
    String email;
    int level;
    public void inputData(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name:  ");
        this.name = input.nextLine();
        System.out.print("Enter email: ");
        this.email = input.nextLine();
        System.out.print("Enter level: ");
        this.level= input.nextInt();

    }
    public Student(){

    }
    public Student(int id , String name,String email,int level){
        this.id=id;
        this.name = name;
        this.email=email;
        this.level=level;
    }
    @Override
    public  String toString(){
        return this.id+","+
                this.name + ","+
                this.email+","+
                this.level;
    }
    public int getId(){return  id;}
    public void setId(int id){this.id=id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getEmail(){return  email;}
    public void setEmail(String email){this.email=email;}
    public int getLevel(){return level;}
    public void setLevel(int level){this.level=level;}

}
