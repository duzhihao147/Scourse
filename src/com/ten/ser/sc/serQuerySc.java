// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   serQuerySc.java

package com.ten.ser.sc;

import com.ten.dao.DaoQuery;
import com.ten.user.Teacher;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class serQuerySc extends HttpServlet
{

    public serQuerySc()
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
        HttpSession session = request.getSession();
        if(session.getAttribute("teacher") == null)
        {
            response.sendRedirect("../Login.jsp");
        } else
        {
            Teacher tea = (Teacher)session.getAttribute("teacher");
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.println("<HTML>");
            out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
            out.println("  <BODY>");
            try
            {
                request.setCharacterEncoding("utf-8");
                String queryKey = request.getParameter("queryKey");
                int type = 20;
                if(request.getParameter("type") != null)
                    type = Integer.parseInt(request.getParameter("type"));
                DaoQuery query = new DaoQuery();
                List list = new ArrayList();
                switch(type)
                {
                case 1: // '\001'
                    list = query.selectSno(Integer.parseInt(queryKey));
                    break;

                case 2: // '\002'
                    list = query.selectSname(queryKey);
                    break;

                case 3: // '\003'
                    list = query.selectSclass(queryKey);
                    break;

                case 4: // '\004'
                    list = query.selectCname(queryKey);
                    System.out.println((new StringBuilder("cname")).append(queryKey).toString());
                    break;

                case 5: // '\005'
                    list = query.selectCno(Integer.parseInt(queryKey));
                    break;

                case 6: // '\006'
                    list = query.selectRoom(queryKey);
                    break;

                case 20: // '\024'
                    out.println("<center>\u8BF7\u8F93\u5165\u67E5\u8BE2\u5173\u952E\u5B57\uFF0C\u5E76\u9009\u62E9\u67E5\u8BE2\u7C7B\u578B</center>");
                    break;

                default:
                    out.println("<center>\u9519\u8BEF\uFF0C\u8BF7\u91CD\u8BD5\uFF01\uFF01</center>");
                    break;
                }
                request.setAttribute("queryResult", list);
                request.getRequestDispatcher((new StringBuilder("/tea/Query.jsp?type=")).append(type).append("&key=").append(queryKey).toString()).forward(request, response);
            }
            catch(Exception e)
            {
                response.sendRedirect("/Ten/tea/Query.jsp");
                e.printStackTrace();
            }
            out.println("  </BODY>");
            out.println("</HTML>");
        }
        out.flush();
        out.close();
    }

    public void init()
        throws ServletException
    {
    }
}
