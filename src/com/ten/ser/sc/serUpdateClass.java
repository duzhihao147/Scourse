// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   serUpdateClass.java

package com.ten.ser.sc;

import com.ten.dao.DaoSc;
import com.ten.user.SC;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class serUpdateClass extends HttpServlet
{

    public serUpdateClass()
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
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.println("<HTML>");
            out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
            out.println("  <BODY>");
            try
            {
                int sno = Integer.parseInt(request.getParameter("sno"));
                int cno = Integer.parseInt(request.getParameter("cno"));
                DaoSc update = new DaoSc();
                SC sc = update.selectone(sno, cno);
                if(sc != null)
                {
                    request.setAttribute("room", sc);
                    request.getRequestDispatcher((new StringBuilder("/tea/updateRoom.jsp?type=")).append(request.getParameter("type")).append("&key=").append(request.getParameter("key")).toString()).forward(request, response);
                } else
                {
                    out.println("<h2>\u67E5\u8BE2\u5931\u8D25\uFF0C\u8BF7\u7A0D\u540E\u91CD\u8BD5</h2>");
                    response.setHeader("refresh", "2;url=serQuerySc");
                }
            }
            catch(Exception e)
            {
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
