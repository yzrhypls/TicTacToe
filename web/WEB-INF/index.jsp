<%-- 
    Document   : index
    Created on : Jun 1, 2020, 12:13:44 PM
    Author     : Yizrahya Paulus <yizrahya.paulus@gmail.com>
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="InitializeGame" method="POST" name="game_size">
            <table>
                <tr>
                    <td>Row</td>
                    <td>Cols</td>
                </tr>
                <tr>
                   <form action="InitializeGame" method="POST" name="game_size">
                
                       <td>
                           <input type="number" name="rows" min="3" max="15" step="2"/> 
                       </td>
                       <td>
                           <input type="number" name="cols" min="3" max="15" step="2"/> 
                           <input type="submit" value="SUBMIT" />
                       </td>
                       
                    </form>        
                </tr>
                
            </table>
        </form>
    </body>
</html>
