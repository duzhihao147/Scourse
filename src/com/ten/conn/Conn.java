// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Conn.java

package com.ten.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn
{

    public Conn()
    {
        conn = null;
    }

    public Connection getConn()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_select_course?useUnicode=true&characterEncoding=utf8", "root", "");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }

    Connection conn;
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/db_select_course?useUnicode=true&characterEncoding=utf8";
    public static final String DBUSER = "root";
    public static final String DBPASS = "";
}
