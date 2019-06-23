// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   serDoUpdateClass.java

package com.ten.ser.sc;

import com.ten.dao.DaoSc;
import com.ten.user.SC;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class serDoUpdateClass extends HttpServlet
{

    public serDoUpdateClass()
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
                String classroom = request.getParameter("classroom");
                DaoSc update = new DaoSc();
                SC sc = new SC();
                sc.setSNo(sno);
                sc.setCNo(cno);
                sc.setClassroom(classroom);
                int rs = update.updateClass(sc);
                if(rs != 0)
                {
                    System.out.println("classroom update over!!");
                    out.println("<center><h2>\u6559\u5BA4\u4FEE\u6539\u6210\u529F</h2></center>");
                } else
                {
                    out.println("<center><h2>\u6559\u5BA4\u4FEE\u6539\u5931\u8D25</h2></center>");
                }
                response.setHeader("refresh", (new StringBuilder("2;url=/Ten/tea/Query.jsp?type=")).append(request.getParameter("type")).append("&query=").append(request.getParameter("key")).toString());
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

    private static final long serialVersionUID = 1L;
}
