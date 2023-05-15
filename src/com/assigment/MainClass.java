package com.assigment;

import javax.swing.plaf.PanelUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collection;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();

        int choose = 0;
        Scanner input = new Scanner(System.in);

        try {
            do {
                System.out.println("1. Add new Student");
                System.out.println("2. view all Student");
                System.out.println("3. Get Student by ID");
                System.out.println("4. Update Student by ID");
                System.out.println("5. Delete Student by ID");
                System.out.println("6. Exit");

                choose = input.nextInt();

                switch (choose) {
                    case 1: {
                        Student stu = new Student();
                        stu.inputData();
                        management.addNewStudent(stu);
                    }
                    break;
                    case 2: {
                        management.getAllStudents();
                    }
                    break;
                    case 3: {
                        System.out.print("Enter id: ");
                        int id = input.nextInt();

                        Student stu = management.getStudentByIdStored( id );
                        if(stu != null) {
                            System.out.println(stu.toString());
                        } else {
                            System.out.println("Not found");
                        }
                    }
                    break;
                    case 4: {
                        System.out.print("Enter Student id to update: ");
                        int id = input.nextInt();

                        management.updateStudent( id );
                    }
                    case 5:{
                        System.out.print("Enter student id to delete: ");
                        int id = input.nextInt();
                        management.deleteStudent(id);
                    }
                    break;
                    case 6: {
                        return;
                    }
                }
            } while(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

