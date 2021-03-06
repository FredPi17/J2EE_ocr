package com.sdzee.bdd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.bdd.TestJDBC;

@WebServlet(name = "com.sdzee.bdd.GestionTestJDBC")
public class GestionTestJDBC extends HttpServlet {
    public static final String ATT_MESSAGES = "messages";
    public static final String VUE = "/WEB-INF/test_jdbc.jsp";

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TestJDBC test = new TestJDBC();
        List<String> messages = test.executerTests(request);

        request.setAttribute(ATT_MESSAGES, messages);

        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

}
