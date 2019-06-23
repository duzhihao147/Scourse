// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DaoQuery.java

package com.ten.dao;

import com.ten.conn.Conn;
import com.ten.user.QueryResult;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoQuery
{

    public DaoQuery()
    {
    }

    public List selectSno(int sno)
    {
        List list = null;
        try
        {
            list = new ArrayList();
            String sql = "select student.sno,sname,sclass,course.cno,cname,classroom from student,sc,course where student.sno=sc.sno and sc.cno=course.cno and student.sno=?;";
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, sno);
            QueryResult qrs;
            for(ResultSet rs = pst.executeQuery(); rs.next(); list.add(qrs))
            {
                qrs = new QueryResult();
                qrs.setSNo(rs.getInt("sno"));
                qrs.setCNo(rs.getInt("cno"));
                qrs.setSname(rs.getString("sname"));
                qrs.setCname(rs.getString("cname"));
                qrs.setSclass(rs.getString("sclass"));
                qrs.setClassroom(rs.getString("classroom"));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public List selectSname(String name)
    {
        List list = null;
        try
        {
            list = new ArrayList();
            String sql = "select student.sno,sname,sclass,course.cno,cname,classroom from student,sc,course where student.sno=sc.sno and sc.cno=course.cno and student.sname=?;";
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            QueryResult qrs;
            for(ResultSet rs = pst.executeQuery(); rs.next(); list.add(qrs))
            {
                qrs = new QueryResult();
                qrs.setSNo(rs.getInt("sno"));
                qrs.setCNo(rs.getInt("cno"));
                qrs.setSname(rs.getString("sname"));
                qrs.setCname(rs.getString("cname"));
                qrs.setSclass(rs.getString("sclass"));
                qrs.setClassroom(rs.getString("classroom"));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public List selectSclass(String _class)
    {
        List list = null;
        try
        {
            list = new ArrayList();
            String sql = "select student.sno,sname,sclass,course.cno,cname,classroom from student,sc,course where student.sno=sc.sno and sc.cno=course.cno and student.sclass=?;";
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, _class);
            QueryResult qrs;
            for(ResultSet rs = pst.executeQuery(); rs.next(); list.add(qrs))
            {
                qrs = new QueryResult();
                qrs.setSNo(rs.getInt("sno"));
                qrs.setCNo(rs.getInt("cno"));
                qrs.setSname(rs.getString("sname"));
                qrs.setCname(rs.getString("cname"));
                qrs.setSclass(rs.getString("sclass"));
                qrs.setClassroom(rs.getString("classroom"));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public List selectCno(int cno)
    {
        List list = null;
        try
        {
            list = new ArrayList();
            String sql = "select student.sno,sname,sclass,course.cno,cname,classroom from student,sc,course where student.sno=sc.sno and sc.cno=course.cno and course.cno=?;";
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, cno);
            QueryResult qrs;
            for(ResultSet rs = pst.executeQuery(); rs.next(); list.add(qrs))
            {
                qrs = new QueryResult();
                qrs.setSNo(rs.getInt("sno"));
                qrs.setCNo(rs.getInt("cno"));
                qrs.setSname(rs.getString("sname"));
                qrs.setCname(rs.getString("cname"));
                qrs.setSclass(rs.getString("sclass"));
                qrs.setClassroom(rs.getString("classroom"));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public List selectCname(String cname)
    {
        List list = null;
        try
        {
            list = new ArrayList();
            String sql = "select student.sno,sname,sclass,course.cno,cname,classroom from student,sc,course where student.sno=sc.sno and sc.cno=course.cno and course.cname=?;";
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, cname);
            QueryResult qrs;
            for(ResultSet rs = pst.executeQuery(); rs.next(); list.add(qrs))
            {
                qrs = new QueryResult();
                qrs.setSNo(rs.getInt("sno"));
                qrs.setCNo(rs.getInt("cno"));
                qrs.setSname(rs.getString("sname"));
                qrs.setCname(rs.getString("cname"));
                qrs.setSclass(rs.getString("sclass"));
                qrs.setClassroom(rs.getString("classroom"));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public List selectRoom(String room)
    {
        List list = null;
        try
        {
            list = new ArrayList();
            String sql = "select student.sno,sname,sclass,course.cno,cname,classroom from student,sc,course where student.sno=sc.sno and sc.cno=course.cno and classroom=?;";
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, room);
            QueryResult qrs;
            for(ResultSet rs = pst.executeQuery(); rs.next(); list.add(qrs))
            {
                qrs = new QueryResult();
                qrs.setSNo(rs.getInt("sno"));
                qrs.setCNo(rs.getInt("cno"));
                qrs.setSname(rs.getString("sname"));
                qrs.setCname(rs.getString("cname"));
                qrs.setSclass(rs.getString("sclass"));
                qrs.setClassroom(rs.getString("classroom"));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
}
