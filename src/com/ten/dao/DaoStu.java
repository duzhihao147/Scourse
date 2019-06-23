// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DaoStu.java

package com.ten.dao;

import com.ten.conn.Conn;
import com.ten.user.Student;
import java.io.PrintStream;
import java.sql.*;
import java.util.*;

// Referenced classes of package com.ten.dao:
//            DaoCou

public class DaoStu
{

    public DaoStu()
    {
    }

    public Student loginStu(Student stu)
    {
        Student stu1 = null;
        String sql_loginS = "select * from student where SNo=? and Spassword=?;";
        try
        {
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql_loginS);
            pst.setInt(1, stu.getSNo());
            pst.setString(2, stu.getSpassword());
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                stu1 = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 0.0F);
                System.out.println("student login select over");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return stu1;
    }

    public List selectStu1()
    {
        List list = null;
        try
        {
            String sql_select = "select student.sno as SNo,Sname,Spassword,Sclass,Ssex,sum(course.ccredit) as Scredit from student,sc,course\twhere student.sno=sc.sno\t\tand sc.cno=course.cno\t\t group by student.sno;";
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql_select);
            ResultSet rs = pst.executeQuery();
            list = new ArrayList();
            Student stu;
            for(; rs.next(); list.add(stu))
                stu = new Student(rs.getInt("SNo"), rs.getString("Sname"), rs.getString("Spassword"), rs.getString("Sclass"), rs.getString("Ssex"), rs.getFloat("Scredit"));

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public List selectStu()
    {
        List list = null;
        try
        {
            String sql_select = "select SNo,Sname,Spassword,Sclass,Ssex from student;";
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql_select);
            ResultSet rs = pst.executeQuery();
            list = new ArrayList();
            DaoCou scredit = new DaoCou();
            Student stu;
            for(; rs.next(); list.add(stu))
                stu = new Student(rs.getInt("SNo"), rs.getString("Sname"), rs.getString("Spassword"), rs.getString("Sclass"), rs.getString("Ssex"), scredit.selectScre(rs.getInt("SNo")));

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public Iterator selectSum()
    {
        List list = null;
        Iterator listall = null;
        try
        {
            String sql_select = "select student.sno as SNo,Sname,Spassword,Sclass,Ssex,sum(course.ccredit) as Scredit from student,sc,course\twhere student.sno=sc.sno\t\tand sc.cno=course.cno\t\t group by student.sno;";
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql_select);
            ResultSet rs = pst.executeQuery();
            list = new ArrayList();
            Student stu;
            for(; rs.next(); list.add(stu))
                stu = new Student(rs.getInt("SNo"), rs.getString("Sname"), rs.getString("Spassword"), rs.getString("Sclass"), rs.getString("Ssex"), rs.getFloat("Scredit"));

            listall = list.iterator();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return listall;
    }

    public Student selectScre(Student stu)
    {
        ResultSet rs = null;
        try
        {
            String sql_insert = "select student.sno as sno,sum(course.ccredit) as scredit from student,sc,course\twhere student.sno=sc.sno\t\tand sc.cno=course.cno\t\t and student.sno=?";
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql_insert);
            pst.setInt(1, stu.getSNo());
            rs = pst.executeQuery();
            if(rs.next())
            {
                System.out.println((new StringBuilder("Student_id")).append(stu.getSNo()).append("select one over!").toString());
                stu = new Student(rs.getInt("sno"), null, null, null, null, rs.getFloat("scredit"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return stu;
    }

    public Student selectStu(int id)
    {
        Student Stu = null;
        try
        {
            String sql_selectone = "select * from student where SNo=?";
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql_selectone);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                Stu = new Student(rs.getInt("SNo"), rs.getString("Sname"), rs.getString("Spassword"), rs.getString("Sclass"), rs.getString("Ssex"), 0.0F);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return Stu;
    }

    public Iterator selectStu(String aa)
    {
        List list = null;
        Iterator listall = null;
        try
        {
            String sql_selectfuz = "select * from student where CNo=? or....";
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql_selectfuz);
            ResultSet rs = pst.executeQuery();
            list = new ArrayList();
            Student stu;
            for(; rs.next(); list.add(stu))
                stu = new Student(rs.getInt("SNo"), rs.getString("Sname"), rs.getString("Spassword"), rs.getString("Sclass"), rs.getString("Ssex"), 0.0F);

            listall = list.iterator();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return listall;
    }

    public int updateStu(Student stu)
    {
        int rs = 0;
        try
        {
            String sql_update = "update Student set Sname=?,Spassword=?,Sclass=?,Ssex=? where SNo=?;";
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql_update);
            pst.setString(1, stu.getSname());
            pst.setString(2, stu.getSpassword());
            pst.setString(3, stu.getSclass());
            pst.setString(4, stu.getSsex());
            pst.setInt(5, stu.getSNo());
            rs = pst.executeUpdate();
            if(rs != 0)
                System.out.println((new StringBuilder("Student_id")).append(stu.getSNo()).append("update over!").toString());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }

    public int deleteStu(int id)
    {
        int rs = 0;
        try
        {
            String sql_delete = "delete from student where SNo=?;";
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql_delete);
            pst.setInt(1, id);
            rs = pst.executeUpdate();
            if(rs != 0)
                System.out.println((new StringBuilder("Student_id")).append(id).append("delete over!").toString());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }

    public int insertStu(Student stu)
    {
        int rs = 0;
        try
        {
            String sql_insert = "insert into student(Sname,Spassword,Sclass,Ssex) values(?,?,?,?);";
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql_insert);
            pst.setString(1, stu.getSname());
            pst.setString(2, stu.getSpassword());
            pst.setString(3, stu.getSclass());
            pst.setString(4, stu.getSsex());
            rs = pst.executeUpdate();
            if(rs != 0)
                System.out.println((new StringBuilder("Student_id")).append(stu.getSNo()).append("insert over!").toString());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
}
