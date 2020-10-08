package com.facility.rsv.presentation;

import com.facility.rsv.beans.ReservationInfo;
import com.facility.rsv.beans.UserAccount;
import com.facility.rsv.business.ReservationManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/facilityReservation")
public class ReserveFacility extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserAccount userAccount = (UserAccount) session.getAttribute("user");

        String facility = request.getParameter("facilityName");
        String targetDate = request.getParameter("targetDate");
        ReservationManager reservationManager = new ReservationManager();

        List<ReservationInfo> reservationList;

    }
}
