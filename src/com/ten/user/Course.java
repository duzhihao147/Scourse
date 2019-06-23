// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Course.java

package com.ten.user;


public class Course
{

    public int getCNo()
    {
        return CNo;
    }

    public void setCNo(int cNo)
    {
        CNo = cNo;
    }

    public String getCname()
    {
        return Cname;
    }

    public void setCname(String cname)
    {
        Cname = cname;
    }

    public String getCcredit()
    {
        return Ccredit;
    }

    public void setClassroom(String Ccredit)
    {
        this.Ccredit = Ccredit;
    }

    public Course(int cNo, String cname, String Ccredit)
    {
        CNo = cNo;
        Cname = cname;
        this.Ccredit = Ccredit;
    }

    public Course(String cname, String Ccredit)
    {
        Cname = cname;
        this.Ccredit = Ccredit;
    }

    private int CNo;
    private String Cname;
    private String Ccredit;
}
