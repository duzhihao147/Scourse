// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DaoCou.java

package com.ten.dao;

import com.ten.conn.Conn;
import com.ten.user.Course;
import java.io.PrintStream;
import java.sql.*;
import java.util.*;

public class DaoCou
{

    public DaoCou()
    {
    }

    public Iterator selectCou()
    {
        List list = null;
        Iterator listall = null;
        try
        {
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement("select * from course;");
            ResultSet rs = pst.executeQuery();
            list = new ArrayList();
            Course cou;
            for(; rs.next(); list.add(cou))
                cou = new Course(rs.getInt("CNo"), rs.getString("Cname"), rs.getString("Ccredit"));

            listall = list.iterator();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return listall;
    }

    public Course selectCou(int id)
    {
        Course cou = null;
        try
        {
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement("select * from course where CNo=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                cou = new Course(rs.getInt("CNo"), rs.getString("Cname"), rs.getString("Ccredit"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return cou;
    }

    public Iterator selectCou(String aa)
    {
        List list = null;
        Iterator listall = null;
        try
        {
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement("select * from course where CNo=?");
            ResultSet rs = pst.executeQuery();
            list = new ArrayList();
            Course cou;
            for(; rs.next(); list.add(cou))
                cou = new Course(rs.getInt("CNo"), rs.getString("Cname"), rs.getString("Ccredit"));

            listall = list.iterator();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return listall;
    }

    public int updateCou(Course cou)
    {
        int rs = 0;
        try
        {
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement("update course set Cname=?,Ccredit=? where CNo=?;");
            pst.setString(1, cou.getCname());
            pst.setString(2, cou.getCcredit());
            pst.setInt(3, cou.getCNo());
            rs = pst.executeUpdate();
            if(rs != 0)
                System.out.println((new StringBuilder("course_id")).append(cou.getCNo()).append("update over!").toString());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }

    public int deleteCou(int id)
    {
        int rs = 0;
        try
        {
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement("delete from course where Cno=?;");
            pst.setInt(1, id);
            rs = pst.executeUpdate();
            if(rs != 0)
                System.out.println((new StringBuilder("course_id")).append(id).append("delete over!").toString());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }

    public int insertCou(Course cou)
    {
        int rs = 0;
        try
        {
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement("insert into course(Cname,Ccredit) values(?,?);");
            pst.setString(1, cou.getCname());
            pst.setString(2, cou.getCcredit());
            rs = pst.executeUpdate();
            if(rs != 0)
                System.out.println((new StringBuilder("course_id")).append(cou.getCname()).append("insert over!").toString());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }

    public float selectScre(int sno)
    {
        float sum = 0.0F;
        try
        {
            String sql = "select sc.sno,sum(ccredit) as scredit from sc,course where sc.cno=course.cno and sno=?;";
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, sno);
            ResultSet rs = null;
            rs = pst.executeQuery();
            if(rs.next())
                sum = rs.getFloat("scredit");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return sum;
    }

    public static final String sql_select = "select * from course;";
    public static final String sql_selectfuz = "select * from course where CNo=? or....";
    public static final String sql_selectone = "select * from course where CNo=?";
    public static final String sql_update = "update course set Cname=?,Ccredit=? where CNo=?;";
    public static final String sql_delete = "delete from course where Cno=?;";
    public static final String sql_insert = "insert into course(Cname,Ccredit) values(?,?);";
}
