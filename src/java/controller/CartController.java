/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Booking;
import entity.BusSchedule;
import entity.Order;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.DAOBooking;
import model.DAOBusSchedule;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DAOBus;
import model.DAOOrder;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CartController", urlPatterns = {"/cart"})
public class CartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CartController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String go = request.getParameter("go");
        DAOBooking booking = new DAOBooking();
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Định dạng ngày giờ thành chuỗi theo yêu cầu
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        if (go == null) {
            request.getRequestDispatcher("/listCart.jsp").forward(request, response);
        } else {
            if (go.equals("deleteBus")) {
                String busId = request.getParameter("id");
                DAOBus buS = new DAOBus();
                DAOBooking busBooking = new DAOBooking();
                DAOOrder busOrder = new DAOOrder();
                busBooking.delete(busId);
                busOrder.delete(busId);
                buS.delete(busId);
                request.setAttribute("MS", "Delete Bus sucessfully");
                request.getRequestDispatcher("/Cars.jsp").forward(request, response);
            }
            if (go.equals("addtag")) {
                if (request.getSession().getAttribute("name") != null) {
                    String id = request.getParameter("id");
                    request.setAttribute("id", id);
                    request.getRequestDispatcher("/addCard.jsp").forward(request, response);

                } else  {
                    response.sendRedirect(request.getContextPath() + "/login/login.jsp");
                }
            }
            if (go.equals("add")) {
                String busid = request.getParameter("busId");
                String departureTime_raw = request.getParameter("departureTime");
                String arrivalTime_raw = request.getParameter("arrivalTime");
                String departureLocation = request.getParameter("departureLocation");
                String arrivalLocation = request.getParameter("arrivalLocation");
                boolean timeCheck = false;
                if (departureTime_raw == null || departureTime_raw.length() == 0) {
                    request.setAttribute("der", "Departure time can not be null!");
                    timeCheck = true;
                }
                if (arrivalTime_raw == null || arrivalTime_raw.length() == 0) {
                    request.setAttribute("aer", "Arrival time can not be null!");
                    timeCheck = true;
                }
                if (timeCheck) {
                    request.getRequestDispatcher("/addCard.jsp?id=" + busid).forward(request, response);
                }
                //Convert
                // Định dạng của datetime-local trên JSP
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

                // Định dạng của LocalDateTime
                DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                // Chuyển đổi chuỗi thành LocalDateTime
                LocalDateTime localDateTime = LocalDateTime.parse(departureTime_raw, inputFormatter);
                LocalDateTime localDateTime2 = LocalDateTime.parse(arrivalTime_raw, inputFormatter);

                // Chuyển đổi LocalDateTime thành chuỗi 
                String departureTime = localDateTime.format(outputFormatter);
                String arrivalTime = localDateTime2.format(outputFormatter);

//                String dateString1 = listBooking.get(i).getPickupDate();
//                String dateString2 = listBooking.get(i).getReturnDate();
                LocalDateTime dateTime1 = LocalDateTime.parse(departureTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss[.S]"));
                LocalDateTime dateTime2 = LocalDateTime.parse(arrivalTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss[.S]"));

                LocalDate date1 = dateTime1.toLocalDate();
                LocalDate date2 = dateTime2.toLocalDate();

                boolean check = false;
                long daysDifference = ChronoUnit.DAYS.between(date1, date2);

                int intDifference = (int) daysDifference;
                if (intDifference < 1) {
                    request.setAttribute("error", "Arrival time rather than departure time at least 1 day!");
                    check = true;
                }

                if (check == true) {
                    request.setAttribute("id", busid);
                    request.getRequestDispatcher("/addCard.jsp?id=" + busid).forward(request, response);
                }
                DAOBusSchedule dao = new DAOBusSchedule();
                int scheduleId = dao.insert2(new BusSchedule(busid, busid, departureTime, arrivalTime, departureLocation, arrivalLocation));
                User bookingUser = (User) request.getSession().getAttribute("name");
                DAOBusSchedule bs = new DAOBusSchedule();
                BusSchedule id4 = bs.getBusScheduleById(busid);
                // In ra chuỗi ngày giờ hiện tại
                booking.insert(new Booking(formattedDateTime, departureTime, arrivalTime, busid, bookingUser.getUserID(), id4.getScheduleID()));
                response.sendRedirect(request.getContextPath() + "/Cars.jsp?add=true");
            }
            if (go.equals("pay")) {
                String bookingId = request.getParameter("id");

                Booking order = booking.getBookingById(bookingId);
                User us = (User) request.getSession().getAttribute("name");
                String price = request.getParameter("price");
                DAOOrder o = new DAOOrder();
                o.insert(new Order(bookingId, us.getUserID(), order.getScheduleID(), formattedDateTime, "Paid", price));
                request.getRequestDispatcher("/listCart.jsp?pay=success").forward(request, response);
            }
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
