<%-- 
Document   : tictactoe
Created on : Jun 2, 2020, 4:10:10 PM
Author     : Yizrahya Paulus <yizrahya.paulus@gmail.com>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Paulus Tic Tac Toe</title>


        <link rel="stylesheet" href="css/tictactoe.css">


    </head>
    <body>
        <h1>Tic Tac Toe</h1>

        <div class="init">
            <table>
                <tr>
                <form action="InitializeGame" method="POST" name="game_size">

                    <td>
                        Row: <input class="grid-size" type="number" name="rows" min="3" max="15" step="2" id="row_size" onchange="updateColValue()"/> 
                    </td>
                    <td>
                        Col: <input class="grid-size" type="number" name="cols" min="3" max="15" step="2" id="col_size" readonly/> 
                        <!--<input type="submit" value="SUBMIT" />-->
                        <button>Reset</button>
                    </td>

                </form>        
                </tr>

            </table>
        </div>

        <div class="grid">

            <c:choose> 
                <c:when test="${isPlayerOne == true && (winner == null || winner == '')}">
                    <h2  class="grid" align="center" >PLAYERONE turn....</h1>
                </c:when>
                <c:when test="${isPlayerOne == false && (winner == null || winner == '')}">
                    <h2  class="grid" align="center" >PLAYERTWO turn....</h1>
                </c:when>
            </c:choose>

            <c:choose> 
                <c:when test="${winner != null && winner != '' && winner != 'NOWINNER'}">
                    <h2  class="grid" align="center" >${winner} Won!</h1>
                </c:when>
                <c:otherwise>
                    <c:if test="${winner == 'NOWINNER'}">
                        <h2  class="grid" align="center">It's a Draw!</h1>
                    </c:if>
                </c:otherwise>
            </c:choose>

            <table border="1">
                <c:forEach var="row" items="${gameCells}" varStatus="rowIndex">
                    <tr>
                        <c:forEach var="cell" items="${row}" varStatus="colIndex">
                            <td>
                                <c:choose>
                                    <c:when test="${cell == 'X'}">
                                        <img src="img/ranger_red.png" alt="X"/>
                                    </c:when>
                                    <c:when test="${cell == 'O'}">
                                        <img src="img/ranger_black.png" alt="O"/>
                                    </c:when>
                                    <c:otherwise>

                                        <c:if test="${winner == null || winner == ''}">
                                            <a href="TicTacToe?row=${rowIndex.index}&col=${colIndex.index}">
                                            </c:if>
                                            <img src="img/null_bg.png" alt="null"/>
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
        </div>
    </body>

    <script>

        function updateColValue() {

            var row = document.getElementById('row_size').value;
            document.getElementById('col_size').value = row;

        }

    </script>

</html>
