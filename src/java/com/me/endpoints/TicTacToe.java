/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.endpoints;

import com.me.objects.GameEngine;
import com.me.objects.Cell;
import com.me.objects.Player;
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
@WebServlet(name = "TicTacToe", urlPatterns = {"/TicTacToe"})
public class TicTacToe extends HttpServlet {

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
            
            int rowIndex = Integer.parseInt(request.getParameter("row"));
            int colIndex = Integer.parseInt(request.getParameter("col"));
            
            
            GameEngine gameEngine = (GameEngine) session.getAttribute("gameEngine");
            boolean isPlayerOne = (boolean) session.getAttribute("isPlayerOne");
            Player player = new Player();
            
            //set selected cells
            if(isPlayerOne){
                gameEngine.setSelectedCell(player.getPLAYERONENAME(), rowIndex, colIndex);
                isPlayerOne = false;
            }else{
                gameEngine.setSelectedCell(player.getPLAYERTWONAME(), rowIndex, colIndex);
                isPlayerOne = true;
            }
            
            Cell.CellTypes[][] cellDatas = gameEngine.getGameGrid();
            
            
            //check winner
            String winner = gameEngine.getWinner();
            
            
            //reload tictactoe.jsp
            session.setAttribute("winner", winner);
            session.setAttribute("isPlayerOne", isPlayerOne);
            session.setAttribute("gameCells", cellDatas);
            request.getRequestDispatcher("/tictactoe.jsp").forward(request, response);
            
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
