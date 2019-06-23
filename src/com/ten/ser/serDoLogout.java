// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   serDoLogout.java

package com.ten.ser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class serDoLogout extends HttpServlet
{

    public serDoLogout()
    {
    }

    public void destroy()
    {
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        try
        {
            session.removeAttribute("teacher");
            session.removeAttribute("student");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        response.sendRedirect("/Ten/Login.jsp");
    }

    public void init()
        throws ServletException
    {
    }
}
