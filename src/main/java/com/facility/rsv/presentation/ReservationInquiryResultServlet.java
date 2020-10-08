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

import com.facility.rsv.beans.Facility;
import com.facility.rsv.beans.Reservation;
import com.facility.rsv.business.FacilityManager;
import com.facility.rsv.beans.ReservationInfo;
import com.facility.rsv.beans.UserAccount;
import com.facility.rsv.business.ReservationManager;

@WebServlet("/searchReservation")
public class ReservationInquiryResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReservationInquiryResultServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserAccount userAccount = (UserAccount) session.getAttribute("user");
        List<Facility> facilityList = (List<Facility>) session.getAttribute("facilityList");

        String facilityName = request.getParameter("facilityName");

        ReservationManager reservationManager = new ReservationManager();
        List<ReservationInfo> reservationInfoList;

        try {
            reservationInfoList = reservationManager.findReservation(facilityName);
            request.setAttribute("reservationInfoList", reservationInfoList);
            RequestDispatcher rd = request.getRequestDispatcher("/reservationList.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            String message = e.getMessage().toString();
            request.setAttribute("exception", message);
            RequestDispatcher rd = request.getRequestDispatcher("/reservationList.jsp");
            rd.forward(request, response);

        }
    }
}
