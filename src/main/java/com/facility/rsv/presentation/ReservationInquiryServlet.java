package com.facility.rsv.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facility.rsv.beans.UserAccount;
import com.facility.rsv.business.FacilityManager;
import com.facility.rsv.beans.Facility;

@WebServlet("/reservationInquiry")
public class ReservationInquiryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ReservationInquiryServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Facility> facilityList;
        FacilityManager facilityManager = new FacilityManager();
        HttpSession session = request.getSession();
        UserAccount user = (UserAccount) session.getAttribute("user");

        try {
            facilityList = facilityManager.showAllFacilities();
            session.setAttribute("facilityList", facilityList);
            RequestDispatcher rd = request.getRequestDispatcher("./reservationInquiry.jsp");
            rd.forward(request, response);

        } catch( Exception e) {
            e.getMessage();
        }
    }

}
