package com.gmail.tsarukyu;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class QuizServlet extends HttpServlet {

    private static final int question_1_yes = 0;
    private static final int question_1_no = 1;
    private static final int question_2_yes = 2;
    private static final int question_2_no = 3;
    private static final int question_3_yes = 4;
    private static final int question_3_no = 5;
    //private static  int respCounter = 0;

    private static final String TEMPLATE_FORM = "<html>" +
            "<head><title>Prog.kiev.ua<title></head>" +
            "<body><h1>%s</h1></body></html>";

    private final int [] result = {0, 0, 0, 0, 0, 0};

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String q1 = req.getParameter("question1");
        final String q2 = req.getParameter("question2");
        final String q3 = req.getParameter("question3");

        final int index1 = "yes".equals(q1) ? question_1_yes : question_1_no;
        final int index2 = "yes".equals(q2) ? question_2_yes : question_2_no;
        final int index3 = "yes".equals(q3) ? question_3_yes : question_3_no;

        result[index1]++;
        result[index2]++;
        result[index3]++;
        //respCounter++;

        String resp_r = "<p> Question 1: yes = " + result[question_1_yes] + ", no = " + result[question_1_no] + "</p>";
        resp_r += "<p> Question 2: yes = " + result[question_2_yes] + ", no = " + result[question_2_no] + "</p>";
        resp_r += "<p> Question 3: yes = " + result[question_3_yes] + ", no = " + result[question_3_no] + "</p>";

        resp.getWriter().println(String.format(TEMPLATE_FORM, resp_r));
    }

}
