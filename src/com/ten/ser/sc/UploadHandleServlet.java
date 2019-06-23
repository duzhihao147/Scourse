// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UploadHandleServlet.java

package com.ten.ser.sc;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadHandleServlet extends HttpServlet
{

    public UploadHandleServlet()
    {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String savePath = getServletContext().getRealPath("/WEB-INF/upload");
        File file = new File(savePath);
        if(!file.exists() && !file.isDirectory())
        {
            System.out.println((new StringBuilder(String.valueOf(savePath))).append("\u76EE\u5F55\u4E0D\u5B58\u5728\uFF0C\u9700\u8981\u521B\u5EFA").toString());
            file.mkdir();
        }
        String message = "";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        if(!ServletFileUpload.isMultipartContent(request))
            return;
        try
        {
            List list = upload.parseRequest(request);
            for(Iterator iterator = list.iterator(); iterator.hasNext();)
            {
                FileItem item = (FileItem)iterator.next();
                if(item.isFormField())
                {
                    String name = item.getFieldName();
                    String value = item.getString("UTF-8");
                    System.out.println((new StringBuilder(String.valueOf(name))).append("=").append(value).toString());
                } else
                {
                    String filename = item.getName();
                    System.out.println(filename);
                    if(filename != null && !filename.trim().equals(""))
                    {
                        filename = filename.substring(filename.lastIndexOf("\\") + 1);
                        InputStream in = item.getInputStream();
                        FileOutputStream out = new FileOutputStream((new StringBuilder(String.valueOf(savePath))).append("\\").append(filename).toString());
                        byte buffer[] = new byte[1024];
                        for(int len = 0; (len = in.read(buffer)) > 0;)
                            out.write(buffer, 0, len);

                        in.close();
                        out.close();
                        item.delete();
                        message = "\u6587\u4EF6\u4E0A\u4F20\u6210\u529F\uFF01";
                    }
                }
            }

        }
        catch(Exception e)
        {
            message = "\u6587\u4EF6\u4E0A\u4F20\u5931\u8D25\uFF01";
            e.printStackTrace();
        }
        request.setAttribute("message", message);
        request.getRequestDispatcher("/tea/message.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        doGet(request, response);
    }

    private static final long serialVersionUID = 1L;
}
