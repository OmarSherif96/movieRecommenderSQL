package com.ibm.rmovie.servlet;
import com.ibm.rmovie.ejb.RmovieStoreService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/","/ejbServlet"})
public class EJBServlet  extends HttpServlet {

@EJB
RmovieStoreService storeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String message = storeService.version();
        writer.println(message);
    }
}
