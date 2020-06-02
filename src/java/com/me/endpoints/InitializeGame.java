/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.endpoints;

import com.me.objects.GameEngine;
import com.me.objects.Cell;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yizrahya Paulus <yizrahya.paulus@gmail.com>
 */
@WebServlet(name = "InitializeGame", urlPatterns = {"/InitializeGame"})
public class InitializeGame extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private HttpSession session;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            session = request.getSession();
            int rows = 0;
            int cols = 0;
                    
            String rowString = request.getParameter("rows");
            String colString = request.getParameter("cols");
            
            if(rowString != null && colString != null && !rowString.isEmpty() && !colString.isEmpty()){
                rows = Integer.parseInt(request.getParameter("rows"));
                cols = Integer.parseInt(request.getParameter("cols"));
            }else{
                rows = 3;
                cols = 3;
            }
            
            
            GameEngine gameEngine = new GameEngine(rows,cols);
            Cell.CellTypes[][] cellDatas = gameEngine.initializeGame(rows, cols);
            boolean isPlayerOne = true;
            
            session.setAttribute("winner", null);
            session.setAttribute("isPlayerOne", isPlayerOne);
            session.setAttribute("gameEngine", gameEngine);
            session.setAttribute("gameCells", cellDatas);
            
            request.getRequestDispatcher("tictactoe.jsp").forward(request, response);
            
            
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
        processRequest(request, response);
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
