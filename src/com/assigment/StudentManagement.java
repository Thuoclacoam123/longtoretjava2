package com.assigment;

import util.DBUtil;

import java.sql.*;

public class StudentManagement {
    public void updateStudent(int id )throws Exception{
        try {
            Student updatingStudent = this.getStudentByIdStored(id);
            if(updatingStudent != null) {
                updatingStudent.inputData();
                Connection conn =  DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(
                        "UPDATE Student SET Name = ?, Email = ?, Level = ? WHERE Id = ?");
                pstmt.setString(1, updatingStudent.getName());
                pstmt.setString(2, updatingStudent.getEmail());
                pstmt.setInt(3, updatingStudent.getLevel());
                pstmt.setInt(4, updatingStudent.getId());

                int updated = pstmt.executeUpdate();
                if(updated > 0) {
                    System.out.println("Update Student success!!!");
                }

                pstmt.close();
                conn.close();
            } else  {
                System.out.println("Student not found");
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public void deleteStudent(int id) throws Exception{
        try {
            Student deleteStudent = this.getStudentByIdStored(id);
            if(deleteStudent != null){
                Connection conn = DBUtil.getConnection();
                PreparedStatement pstm = conn.prepareStatement("delete from student where id = ?");
                pstm.setInt(1, deleteStudent.getId());
                if(pstm.executeUpdate() > 0){
                    System.out.println("Student deleted");
                }
                pstm.close();
                conn.close();
            }else {
                System.out.println("Student not found!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public Student getStudentByIdStored(int id) throws Exception {

        Student stu = null;

        try {
            Connection conn =  DBUtil.getConnection();
            PreparedStatement pstm = conn.prepareStatement("SELECT id, name, email, level from student where id = ?");
//            CallableStatement cstmt = conn.prepareCall("{call spGetStudent(?)}");

            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
                stu = new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return stu;
    }
    public Student getStudentById(int id) throws Exception {

        Student stu = null;

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT Id, Name, Email, Level FROM Student WHERE Id = ?");
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                stu = new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return stu;
    }

    public void addNewStudent(Student student) throws Exception {
        try {
            Connection conn =  DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO Student(Name, Email, Level) VALUES (?,?,?)");
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.setInt(3, student.getLevel());

            int updated = pstmt.executeUpdate();
            if(updated > 0) {
                System.out.println("Insert Student success!!!");
            }

            pstmt.close();
            conn.close();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void getAllStudents() {
        try {
            Connection conn = DBUtil.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT Id, Name, Email, Level FROM Student");

            while(rs.next()) {
                Student stu = new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
                System.out.println(stu.toString());
//                stu.toString();
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
