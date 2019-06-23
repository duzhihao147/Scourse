// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   serInsertStu.java

package com.ten.ser.stu;

import com.ten.dao.DaoStu;
import com.ten.user.Student;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class serInsertStu extends HttpServlet
{

    public serInsertStu()
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
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY><center>");
        try
        {
            request.setCharacterEncoding("utf-8");
            Student stu = new Student(request.getParameter("Sname"), request.getParameter("Spassword"), request.getParameter("Sclass"), request.getParameter("Ssex"), 0.0F);
            DaoStu insert = new DaoStu();
            int rs = insert.insertStu(stu);
            if(rs != 0)
                out.println((new StringBuilder("\u6DFB\u52A0\u6210\u529F\uFF1A")).append(stu.getSNo()).toString());
            else
                out.println((new StringBuilder("\u6DFB\u52A0\u5931\u8D25")).append(stu.getSNo()).toString());
            response.sendRedirect("Ten/tea/selectStu.jsp");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        out.println("  </center></BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    public void init()
        throws ServletException
    {
    }

    private static final long serialVersionUID = 1L;
}
