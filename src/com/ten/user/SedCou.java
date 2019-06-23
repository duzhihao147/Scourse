// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SedCou.java

package com.ten.user;


public class SedCou
{

    public SedCou()
    {
    }

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

    public String getClassroom()
    {
        return classroom;
    }

    public void setClassroom(String classroom)
    {
        this.classroom = classroom;
    }

    public float getCcredit()
    {
        return Ccredit;
    }

    public void setCcredit(float ccredit)
    {
        Ccredit = ccredit;
    }

    private int CNo;
    private String Cname;
    private String classroom;
    private float Ccredit;
}
