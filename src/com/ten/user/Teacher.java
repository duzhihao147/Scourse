// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Teacher.java

package com.ten.user;


public class Teacher
{

    public int getTNo()
    {
        return TNo;
    }

    public void setTNo(int tNo)
    {
        TNo = tNo;
    }

    public String getTname()
    {
        return Tname;
    }

    public void setTname(String tname)
    {
        Tname = tname;
    }

    public String getTpassword()
    {
        return Tpassword;
    }

    public void setTpassword(String tpassword)
    {
        Tpassword = tpassword;
    }

    public Teacher(int tNo, String tname, String tpassword)
    {
        TNo = tNo;
        Tname = tname;
        Tpassword = tpassword;
    }

    public Teacher(String tname, String tpassword)
    {
        Tname = tname;
        Tpassword = tpassword;
    }

    private int TNo;
    private String Tname;
    private String Tpassword;
}
