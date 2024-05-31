/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Bus;
import entity.Order;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.DAOOrder;
import model.DAOUser;
import java.sql.ResultSet;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.nio.file.Paths;
import model.DAOBus;
import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AdminController", urlPatterns = {"/admin"})
@MultipartConfig
public class AdminController extends HttpServlet {

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
            out.println("<title>Servlet AdminController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminController at " + request.getContextPath() + "</h1>");
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
        DAOUser u = new DAOUser();
        DAOOrder o = new DAOOrder();
        DAOBus a = new DAOBus();
        String go = request.getParameter("go");
        String id = request.getParameter("id");
        if (go.equals("updateUser")) {
            DAOUser dao = new DAOUser();
            ResultSet rsUs = dao.getResultSet("select LocationID, LocationName from Locations");
            request.setAttribute("rsUs", rsUs);
            request.setAttribute("id", id);
            request.getRequestDispatcher("/updateUser.jsp").forward(request, response);
        }
        if (go.equals("deleteUser")) {
            int n = u.delete(id);
            if (n != 0) {
                request.setAttribute("msUs", "Delete user " + id + " successfully");
            } else {
                request.setAttribute("msUs", "Can not delete!");
            }
            request.getRequestDispatcher("/admin.jsp").forward(request, response);
        }
        if (go.equals("updateOrder")) {
            request.setAttribute("id", id);
            request.getRequestDispatcher("/updateOrder.jsp").forward(request, response);
        }
        if (go.equals("deleteBus")) {
            int n = a.delete1(id);
            if (n != 0) {
                request.setAttribute("msBus", "Delete bus " + id + " successfully");
            } else {
                request.setAttribute("msBus", "Can not delete!");
            }
            request.getRequestDispatcher("/admin.jsp").forward(request, response);
        }
        if (go.equals("updateBus")) {
            request.setAttribute("id", id);
            request.getRequestDispatcher("/updateBus.jsp").forward(request, response);
        }
        if (go.equals("deleteOrder")) {
            int n = o.delete(id);
            if (n != 0) {
                request.setAttribute("msOr", "Delete order " + id + " successfully");
            } else {
                request.setAttribute("msOr", "Can not delete!");
            }
            request.getRequestDispatcher("/admin.jsp").forward(request, response);
        }
        if (go.equals("logout")) {
            // Lấy session từ request
            HttpSession session = request.getSession();

            // Xóa hết các thuộc tính của session
            session.invalidate();
            response.sendRedirect("/ASM_PRJ/login/login.jsp?error=logout");
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
        String go = request.getParameter("go");
        if (go.equals("order")) {
            String orderID = request.getParameter("orderID");
            String userID = request.getParameter("userID");
            String scheduleID = request.getParameter("scheduleID");
            String orderDate_raw = request.getParameter("orderDate");
            String status = request.getParameter("status");
            String price = request.getParameter("price");
            String pricecart = request.getParameter("pricecart");
            

            //Convert 
            // Định dạng của datetime-local trên JSP
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

            // Định dạng của LocalDateTime
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            // Chuyển đổi chuỗi thành LocalDateTime
            LocalDateTime localDateTime = LocalDateTime.parse(orderDate_raw, inputFormatter);

            // Chuyển đổi LocalDateTime thành chuỗi 
            String orderDate = localDateTime.format(outputFormatter);
            DAOOrder dao = new DAOOrder();
            int n = dao.update2(new Order(orderID, userID, scheduleID, orderDate, status, price));
            if (n != 0) {
                request.setAttribute("msOr", "Update order " + orderID + " successfully");
            } else {
                request.setAttribute("msOr", "Can not update!");
            }
            request.getRequestDispatcher("/admin.jsp").forward(request, response);
        }
        if (go.equals("bus")) {
            String busid = request.getParameter("busID");
            String busNumber = request.getParameter("busNumber");
            String capacity = request.getParameter("capacity");
            String type = request.getParameter("type");
            String driver = request.getParameter("driver");
            String imageUrl = request.getParameter("imageUrl");
            String price = request.getParameter("price");
            String pricecart = request.getParameter("pricecart");

            
            DAOBus dao = new DAOBus();
            int n = dao.update2(new Bus(busNumber, type, driver, busid, capacity, imageUrl, price,pricecart));
            if (n != 0) {
                request.setAttribute("msBus", "Update Bus " + busid + " successfully");
            } else {
                request.setAttribute("msBus", "Can not update!");
            }
            request.getRequestDispatcher("/admin.jsp").forward(request, response);
        }
        if (go.equals("user")) {
            String userId = request.getParameter("userId");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String role = request.getParameter("role");
            String phoneNumber = request.getParameter("phoneNumber");
            String locationId = request.getParameter("locationId");
            DAOUser u = new DAOUser();
            int n = u.update2(new User(username, role, password, phoneNumber, userId, locationId));
            if (n != 0) {
                request.setAttribute("msUs", "Update user " + userId + " successfully");
            } else {
                request.setAttribute("msUs", "Can not update!");
            }
            request.getRequestDispatcher("/admin.jsp").forward(request, response);
        }
        if (go.equals("addbus")) {
            Part filePart = request.getPart("imageUrl");
            boolean check = false;
            // Kiểm tra kích thước của tệp
            if (filePart.getSize() == 0) {
                request.setAttribute("ier", "File can not be empty!");
                check = true;
            }

            // Đường dẫn tới thư mục lưu trữ tệp tin trên máy chủ
            String savePath = "C:\\Users\\Admin\\OneDrive\\Documents\\Subjects\\Teach\\Nghia\\ASM_PRJ\\build\\web\\images\\CarImages"; // Thay đổi đường dẫn này theo cài đặt của bạn

            // Lấy tên tệp
            String fileName = getFileName(filePart);

            // Tạo đường dẫn đến tệp
            String filePath = savePath + File.separator + fileName;

            // Lưu tệp
            try (InputStream input = filePart.getInputStream(); OutputStream output = new FileOutputStream(filePath)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) != -1) {
                    output.write(buffer, 0, bytesRead);
                }
            } catch (FileNotFoundException fne) {
                request.setAttribute("ier", "Can not save file!");
                check = true;
            }

            String busNumber = request.getParameter("busNumber");
            if (busNumber == null|| busNumber.length()==0) {
                request.setAttribute("ber", "Bus number can not be empty!");
                check = true;
            }
            String capacity = request.getParameter("capacity");
            if (capacity == null||capacity.length()==0) {
                request.setAttribute("cer", "Capacity can not be empty!");
                check = true;
            }
            String type = request.getParameter("type");
            if (type == null || type.length()==0) {
                request.setAttribute("ter", "Type can not be empty!");
                check = true;
            }
            String driver = request.getParameter("driver");
            if (driver == null||driver.length()==0) {
                request.setAttribute("der", "Driver can not be empty!");
                check = true;
            }
            String price = request.getParameter("price");
            if (price == null||price.length()==0) {
                request.setAttribute("per", "Price number can not be empty!");
                check = true;
            }
            String pricecart = request.getParameter("pricecart");
            if (pricecart == null||pricecart.length()==0) {
                request.setAttribute("per", "Pricecart number can not be empty!");
                check = true;
            }
            if (check) {
                request.getRequestDispatcher("/addBus.jsp").forward(request, response);
            }
            String ImageURL = "/images/CarImages/" + fileName;

            DAOBus dao = new DAOBus();
            int n = dao.insert2(new Bus(busNumber, type, driver, "1", capacity, ImageURL, price,pricecart));
            if (n != 0) {
                request.setAttribute("msBu", "Add successfully");
                request.getRequestDispatcher("/admin.jsp").forward(request, response);
            } else {
                request.setAttribute("msBu", "Can not add Bus");
                request.getRequestDispatcher("/admin.jsp").forward(request, response);
            }
        }
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
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
