// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ValidateColorServlet.java

package com.ten.ser;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;

public class ValidateColorServlet extends HttpServlet
{

    public ValidateColorServlet()
    {
        width = 152;
        height = 40;
        codeCount = 6;
        fontHeight = 4;
        codeX = 0;
        codeY = 0;
        codeSequence = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz23456789".toCharArray();
    }

    public void init()
    {
        fontHeight = height - 2;
        codeX = width / (codeCount + 2);
        codeY = height - 4;
    }

    public void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        BufferedImage buffImg = null;
        buffImg = new BufferedImage(width, height, 5);
        Graphics2D graphics = null;
        graphics = buffImg.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);
        Font font = null;
        font = new Font("", 1, fontHeight);
        graphics.setFont(font);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(0, 0, width - 1, height - 1);
        Random random = null;
        random = new Random();
        graphics.setColor(Color.GREEN);
        for(int i = 0; i < 55; i++)
        {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(20);
            int y1 = random.nextInt(20);
            graphics.drawLine(x, y, x + x1, y + y1);
        }

        StringBuffer randomCode = new StringBuffer();
        for(int i = 0; i < codeCount; i++)
        {
            String strRand = null;
            strRand = String.valueOf(codeSequence[random.nextInt(36)]);
            randomCode.append(strRand);
            graphics.setColor(Color.BLUE);
            graphics.drawString(strRand, (i + 1) * codeX, codeY);
        }

        request.getSession().setAttribute("CHECK_CODE_KEY", randomCode.toString());
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0L);
        ServletOutputStream sos = null;
        sos = response.getOutputStream();
        ImageIO.write(buffImg, "jpeg", sos);
        sos.close();
    }

    private static final long serialVersionUID = 1L;
    public static final String CHECK_CODE_KEY = "CHECK_CODE_KEY";
    private int width;
    private int height;
    private int codeCount;
    private int fontHeight;
    private int codeX;
    private int codeY;
    char codeSequence[];
}
