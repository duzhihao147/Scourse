// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   serDeleteCou.java

package com.ten.ser.cou;

import com.ten.dao.DaoCou;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class serDeleteCou extends HttpServlet
{

    public serDeleteCou()
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
        out.println("  <BODY>");
        try
        {
            DaoCou delete = new DaoCou();
            int rs = delete.deleteCou(Integer.parseInt(request.getParameter("id")));
            if(rs == 0)
            {
                out.println("<center>\u5220\u9664\u5931\u8D25\uFF01</center>");
                response.sendRedirect("/Ten/tea/selectCou.jsp");
            } else
            {
                out.println("<center>\u5220\u9664\u6210\u529F\uFF01</center>");
                response.sendRedirect("/Ten/tea/selectCou.jsp");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        out.println("</BODY>");
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
