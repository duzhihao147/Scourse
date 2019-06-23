// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   serInsertSc.java

package com.ten.ser.sc;

import com.ten.dao.*;
import com.ten.user.SC;
import com.ten.user.Student;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class serInsertSc extends HttpServlet
{

    public serInsertSc()
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
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.println("<HTML>");
            out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
            out.println("  <BODY>");
            try
            {
                String choiceR[] = request.getParameterValues("choiceCou");
                DaoStu selects = new DaoStu();
                DaoCou selectc = new DaoCou();
                Student stu2 = selects.selectScre(stu);
                float scredit = stu2.getScredit();
                int sno = stu.getSNo();
                if(choiceR.length != 0)
                {
                    SC sc[] = new SC[choiceR.length];
                    for(int i = 0; i < choiceR.length; i++)
                    {
                        sc[i] = new SC();
                        sc[i].setSNo(sno);
                        sc[i].setCNo(Integer.parseInt(choiceR[i]));
                        sc[i].setClassroom("0");
                        scredit += selectc.selectScre(sc[i].getSNo());
                    }

                    if(scredit <= Student.MAXscore)
                    {
                        DaoSc insert = new DaoSc();
                        int rs[] = insert.insertSc(sc);
                        int sum = 0;
                        for(int i = 0; i < rs.length; i++)
                        {
                            if(rs[i] == 0)
                                System.out.println((new StringBuilder("rs")).append(i).append("is null  !!").toString());
                            sum += rs[i];
                        }

                        if(sum != 0)
                        {
                            out.println("<h2><center>\u9009\u8BFE\u6210\u529F</cneter></h2>");
                            response.sendRedirect("../stu/showCou.jsp");
                        }
                    } else
                    {
                        out.println((new StringBuilder("<h2><center>\u4F60\u9009\u62E9\u7684\u8BFE\u7A0B\u8D85\u8FC7\u4E0A\u9650")).append(Student.MAXscore).append("\u5206\uFF01</cneter></h2>").toString());
                        response.setHeader("refresh", "2;url=../stu/choiceCou.jsp");
                    }
                } else
                {
                    out.println("<h2><center>\u9009\u8BFE\u5931\u8D25</cneter></h2>");
                    response.setHeader("refresh", "2;url=../stu/choiceCou.jsp");
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
                out.println("\u9009\u8BFE\u5931\u8D25!");
                response.setHeader("refresh", "2;url=../stu/choiceCou.jsp");
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
