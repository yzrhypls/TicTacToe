<%-- 
    Document   : tictactoe
    Created on : Jun 1, 2020, 12:22:53 PM
    Author     : Yizrahya Paulus <yizrahya.paulus@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Tic Tac Toe Game </h1>
        <!--for each line/cols loop create table cells and populate-->
        
        <form action="InitializeGame" method="POST" name="game_size">
            <table>
                <tr>
                    <td>Row</td>
                    <td>Cols</td>
                </tr>
                <tr>
                   <form action="InitializeGame" method="POST" name="game_size">
                
                       <td>
                           <input type="number" name="rows" min="3" max="15" step="2" id="row_size" onchange="updateColValue()"/> 
                       </td>
                       <td>
                           <input type="number" name="cols" min="3" max="15" step="2" id="col_size" readonly/> 
                           <input type="submit" value="SUBMIT" />
                       </td>
                       
                    </form>        
                </tr>
                
            </table>
        </form>
        
        
        <table align="center">
            <tr>
                <td width="50%">
                    <table border="1" align="center">
            <c:forEach var="row" items="${gameCells}" varStatus="rowIndex">
            <tr>
                <c:forEach var="cell" items="${row}" varStatus="colIndex">
                <td>
                    <%--<c:out value="${cell}" />--%>
                    <c:choose>
                        <c:when test="${cell == 'X'}">
                            <img src="img/ranger_red.png" alt="X"/>
                        </c:when>
                        <c:when test="${cell == 'O'}">
                            <img src="img/ranger_black.png" alt="O"/>
                        </c:when>
                        <c:otherwise>
                            
                            <c:if test="${winner == null || winner == ''}">
                                <a href="TicTacToeServlet?row=${rowIndex.index}&col=${colIndex.index}">
                            </c:if>
                                <img src="img/null_img.png" alt="null"/>
                            <c:if test="${winner == null || winner == ''}">
                                </a>
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                </td>    
                </c:forEach>
            </tr>
            </c:forEach>
        </table>
                </td>
                <td width="50%">
                           <c:choose> 
                           <c:when test="${isPlayerOne == true && (winner == null || winner == '')}">
                                <h2>PLAYERONE turn....</h1>
                           </c:when>
                           <c:when test="${isPlayerOne == false && (winner == null || winner == '')}">
                                <h2>PLAYERTWO turn....</h1>
                           </c:when>
                           </c:choose>
                                
                           <c:choose> 
                               
                           <c:when test="${winner != null && winner != '' && winner != 'NOWINNER'}">
                                <h2>${winner} Won!</h1>
                                <form action="InitializeGame" method="post">
                                    <input type="submit" name="reset" value="Reset"><br/>
                                </form>
                           </c:when>
                                <c:otherwise>
                                    <c:if test="${winner == 'NOWINNER'}">
                                        <h2>No Empty Cells Remaining Please Reset</h1>
                                        <form action="InitializeGame" method="post">
                                            <input type="submit" name="reset" value="Reset"><br/>
                                        </form>
                                    </c:if>
                                
                                
                                </c:otherwise>
                           </c:choose>
                                
                </td>
                
                
            </tr>
        
        
        </table>

    </body>
    
    <script>
        
        function updateColValue(){
            
            var row = document.getElementById('row_size').value;
            document.getElementById('col_size').value = row;
            
        }
        
    </script>
</html>
