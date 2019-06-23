// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DaoSc.java

package com.ten.dao;

import com.ten.conn.Conn;
import com.ten.user.SC;
import com.ten.user.SedCou;
import java.io.PrintStream;
import java.sql.*;
import java.util.*;

public class DaoSc
{

    public DaoSc()
    {
    }

    public int[] insertSc(SC sc[])
    {
        int rs[] = null;
        try
        {
            String sql = "insert into sc(SNo,CNo,classroom) values(?,?,?);";
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            SC tem = null;
            rs = new int[sc.length];
            for(int i = 0; i < sc.length; i++)
            {
                tem = sc[i];
                pst.setInt(1, tem.getSNo());
                pst.setInt(2, tem.getCNo());
                pst.setString(3, tem.getClassroom());
                rs[i] = pst.executeUpdate();
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }

    public int deleteSc(int sno, int cno)
    {
        int rs = 0;
        try
        {
            String sql = "delete from sc where SNo=? and CNo=?;";
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, sno);
            pst.setInt(2, cno);
            rs = pst.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }

    public Iterator selectSc(int sno)
    {
        Iterator listall = null;
        SedCou cou = null;
        try
        {
            List list = new ArrayList();
            String sql = "select sc.cno,cname,ccredit,classroom from course,sc where course.cno=sc.cno and sno=?;";
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, sno);
            for(ResultSet rs = pst.executeQuery(); rs.next(); System.out.println("selected course is over!!"))
            {
                cou = new SedCou();
                cou.setCNo(rs.getInt("CNo"));
                cou.setCname(rs.getString("Cname"));
                cou.setClassroom(rs.getString("classroom"));
                cou.setCcredit(rs.getFloat("Ccredit"));
                list.add(cou);
            }

            listall = list.iterator();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return listall;
    }

    public SC selectone(int sno, int cno)
    {
        ResultSet rs = null;
        SC sc = null;
        try
        {
            String sql = "select * from sc where sno=? and cno=?;";
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, sno);
            pst.setInt(2, cno);
            rs = pst.executeQuery();
            if(rs.next())
            {
                System.out.println("classroom select over!!");
                sc = new SC();
                sc.setSNo(rs.getInt("SNo"));
                sc.setCNo(rs.getInt("CNo"));
                sc.setClassroom(rs.getString("Classroom"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return sc;
    }

    public int updateClass(SC sc)
    {
        int rs = 0;
        try
        {
            String sql = "update sc set classroom=? where sno=? and cno=?;";
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, sc.getClassroom());
            pst.setInt(2, sc.getSNo());
            pst.setInt(3, sc.getCNo());
            rs = pst.executeUpdate();
            if(rs != 0)
                System.out.println("classroom update over!!");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
}
