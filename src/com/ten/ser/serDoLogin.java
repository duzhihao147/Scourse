// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   serDoLogin.java

package com.ten.ser;

import com.ten.dao.DaoStu;
import com.ten.dao.DaoTea;
import com.ten.user.Student;
import com.ten.user.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class serDoLogin extends HttpServlet
{

    public serDoLogin()
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
        try
        {
            int username = Integer.parseInt(request.getParameter("username"));
            String password = request.getParameter("password");
            String sessionCode = (String)request.getSession().getAttribute("CHECK_CODE_KEY");
            String paramCode = request.getParameter("CHECK_CODE_PARAM_NAME");
            String type = null;
            if(paramCode != null && paramCode.equals(sessionCode))
            {
                if(request.getParameter("type") != null)
                    type = request.getParameter("type");
                if(type.equals("tea"))
                {
                    Teacher tea = new Teacher(username, null, password);
                    DaoTea logint = new DaoTea();
                    tea = logint.loginTea(tea);
                    if(tea != null)
                    {
                        session.setAttribute("teacher", tea);
                        response.sendRedirect("/Ten/tea/teacher.jsp");
                    } else
                    {
                        out.println("T\u7528\u6237\u540D\u6216\u5BC6\u7801\u4E0D\u6B63\u786E\uFF0C\u8BF7\u6838\u5BF9\u540E\u91CD\u8BD5!!");
                        response.setHeader("refresh", "2;url=/Ten/tea/teaLogin.jsp");
                    }
                } else
                if(type.equals("stu"))
                {
                    Student stu = new Student(username, null, password, null, null, 0.0F);
                    out.println((new StringBuilder(String.valueOf(stu.getSname()))).append("::").append(stu.getSpassword()).append("<br>").toString());
                    out.println((new StringBuilder(String.valueOf(stu.getSname()))).append("::").append(stu.getSpassword()).append("<br>").toString());
                    DaoStu logins = new DaoStu();
                    stu = logins.loginStu(stu);
                    if(stu != null)
                    {
                        session.setAttribute("student", stu);
                        response.sendRedirect("/Ten/stu/student.jsp");
                    } else
                    {
                        out.println("S\u7528\u6237\u540D\u6216\u5BC6\u7801\u4E0D\u6B63\u786E\uFF0C\u8BF7\u6838\u5BF9\u540E\u91CD\u8BD5!!");
                        response.setHeader("refresh", "2;url=/Ten/Login.jsp");
                    }
                } else
                {
                    out.println("\u9519\u8BEF\uFF01\u8BF7\u767B\u5F55\uFF01");
                    response.setHeader("refresh", "2;url=/Ten/Login.jsp");
                }
            } else
            {
                request.getSession().setAttribute("message", "\u9A8C\u8BC1\u7801\u4E0D\u4E00\u81F4\uFF01");
                response.sendRedirect((new StringBuilder(String.valueOf(request.getContextPath()))).append("/Login.jsp").toString());
                return;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            response.sendRedirect("/Ten/Login.jsp");
        }
        out.flush();
        out.close();
    }

    public void init()
        throws ServletException
    {
    }
}
