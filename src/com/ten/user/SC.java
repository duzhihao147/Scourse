// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SC.java

package com.ten.user;


public class SC
{

    public SC()
    {
    }

    public int getSNo()
    {
        return SNo;
    }

    public void setSNo(int sNo)
    {
        SNo = sNo;
    }

    public int getCNo()
    {
        return CNo;
    }

    public void setCNo(int cNo)
    {
        CNo = cNo;
    }

    public String getClassroom()
    {
        return classroom;
    }

    public void setClassroom(String classroom)
    {
        this.classroom = classroom;
    }

    private int SNo;
    private int CNo;
    private String classroom;
}
