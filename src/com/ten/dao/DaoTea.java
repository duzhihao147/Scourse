// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DaoTea.java

package com.ten.dao;

import com.ten.conn.Conn;
import com.ten.user.Teacher;
import java.sql.*;

public class DaoTea
{

    public DaoTea()
    {
    }

    public Teacher loginTea(Teacher tea)
    {
        Teacher tea1 = null;
        try
        {
            String sql_loginT = "select * from teacher where TNo=? and Tpassword=?;";
            Connection conn = (new Conn()).getConn();
            PreparedStatement pst = conn.prepareStatement(sql_loginT);
            pst.setInt(1, tea.getTNo());
            pst.setString(2, tea.getTpassword());
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                tea1 = new Teacher(rs.getInt("TNo"), rs.getString("Tname"), rs.getString("Tpassword"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return tea1;
    }
}
