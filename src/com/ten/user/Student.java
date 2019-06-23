// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Student.java

package com.ten.user;


public class Student
{

    public int getSNo()
    {
        return SNo;
    }

    public void setSNo(int sNo)
    {
        SNo = sNo;
    }

    public String getSname()
    {
        return Sname;
    }

    public void setSname(String sname)
    {
        Sname = sname;
    }

    public String getSpassword()
    {
        return Spassword;
    }

    public void setSpassword(String spassword)
    {
        Spassword = spassword;
    }

    public String getSclass()
    {
        return Sclass;
    }

    public void setSclass(String sclass)
    {
        Sclass = sclass;
    }

    public String getSsex()
    {
        return Ssex;
    }

    public void setSsex(String ssex)
    {
        Ssex = ssex;
    }

    public float getScredit()
    {
        return Scredit;
    }

    public void setScredit(float scredit)
    {
        Scredit = scredit;
    }

    public Student(int sNo, String sname, String spassword, String sclass, String ssex, float scredit)
    {
        SNo = sNo;
        Sname = sname;
        Spassword = spassword;
        Sclass = sclass;
        Ssex = ssex;
        Scredit = scredit;
    }

    public Student(String sname, String spassword, String sclass, String ssex, float scredit)
    {
        Sname = sname;
        Spassword = spassword;
        Sclass = sclass;
        Ssex = ssex;
        Scredit = scredit;
    }

    private int SNo;
    private String Sname;
    private String Spassword;
    private String Sclass;
    private String Ssex;
    private float Scredit;
    public static float summary = 7F;
    public static float MAXscore = 10F;

}
