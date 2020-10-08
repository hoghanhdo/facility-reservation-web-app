package com.facility.rsv.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facility.rsv.beans.UserAccount;
import com.facility.rsv.business.UserManager;
import com.facility.rsv.business.exception.NotMatchDataException;
import com.facility.rsv.business.exception.SystemErrorException;
import com.facility.rsv.utils.ValidationException;
import com.facility.rsv.utils.Validator;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        UserManager userManager = new UserManager();
        UserAccount userAccount;

        try {
            Validator.validateLoginName(loginName);
            Validator.validatePassword(password);

            userAccount = userManager.findUserAccount(loginName, password);

            if (userAccount.getAuthority() == 1) {
                HttpSession session = request.getSession();
                session.setAttribute("user", userAccount);
                response.sendRedirect("./userMenu.jsp");

            }

            if (userAccount.getAuthority() == 0) {
                HttpSession session = request.getSession();
                session.setAttribute("admin", userAccount);
                response.sendRedirect("./adminMenu.jsp");
            }

        } catch (ValidationException | NotMatchDataException | SystemErrorException e) {
            String message = e.getMessage().toString();
            request.setAttribute("exception", message);
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);

        }
    }

    public static void main(String[] args){
        UserManager userManager = new UserManager();
        try{
            UserAccount user = userManager.findUserAccount("skylar", "password");
            System.out.println("Hello, " + user.getRealName());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
