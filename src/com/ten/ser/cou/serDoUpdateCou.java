// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   serDoUpdateCou.java

package com.ten.ser.cou;

import com.ten.dao.DaoCou;
import com.ten.user.Course;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class serDoUpdateCou extends HttpServlet
{

    public serDoUpdateCou()
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
            Course cou = new Course(Integer.parseInt(request.getParameter("CNo")), request.getParameter("Cname"), request.getParameter("Ccredit"));
            DaoCou update = new DaoCou();
            int rs = update.updateCou(cou);
            if(rs != 0)
                out.println((new StringBuilder("\u4FEE\u6539\u6210\u529F\uFF1A")).append(cou.getCNo()).toString());
            else
                out.println((new StringBuilder("\u4FEE\u6539\u5931\u8D25")).append(cou.getCNo()).toString());
            response.sendRedirect("/Ten/tea/selectCou.jsp");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        out.println("</center></BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    public void init()
        throws ServletException
    {
    }
}
