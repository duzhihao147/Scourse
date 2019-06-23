// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   QueryResult.java

package com.ten.user;


public class QueryResult
{

    public QueryResult()
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

    public String getSname()
    {
        return Sname;
    }

    public void setSname(String sname)
    {
        Sname = sname;
    }

    public String getSclass()
    {
        return Sclass;
    }

    public void setSclass(String sclass)
    {
        Sclass = sclass;
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

    private int SNo;
    private int CNo;
    private String Sname;
    private String Sclass;
    private String Cname;
    private String classroom;
}
