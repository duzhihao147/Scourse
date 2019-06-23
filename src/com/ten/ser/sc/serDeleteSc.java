// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   serDeleteSc.java

package com.ten.ser.sc;

import com.ten.dao.DaoSc;
import com.ten.user.Student;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class serDeleteSc extends HttpServlet
{

    public serDeleteSc()
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
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        Student stu = null;
        if(session.getAttribute("student") == null)
        {
            response.sendRedirect("../Login.jsp");
        } else
        {
            stu = (Student)session.getAttribute("student");
            out.println((new StringBuilder("Welcome SNO:")).append(stu.getSNo()).toString());
            response.setContentType("text/html;charset=utf-8");
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.println("<HTML>");
            out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
            out.println("  <BODY>");
            try
            {
                int sno = stu.getSNo();
                int cno = Integer.parseInt(request.getParameter("cno"));
                DaoSc delete = new DaoSc();
                int rs = delete.deleteSc(sno, cno);
                if(rs != 0)
                {
                    System.out.println("Sc one delete over!!");
                    out.println("<h2><center>\u6210\u529F\u53D6\u6D88\u9009\u8BFE</center></h2>");
                } else
                {
                    out.println("<h2><center>\u7F51\u7EDC\u6545\u969C\uFF01 \u8BF7\u91CD\u8BD5\uFF01</center></h2>");
                }
                response.sendRedirect("../stu/showCou.jsp");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    public void init()
        throws ServletException
    {
    }
}
