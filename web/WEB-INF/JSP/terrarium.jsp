<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<!doctype html>
<html lang='nl'>
    <head>
        <vdab:head title='Terrarium'/>
        <link rel='stylesheet' href='<c:url value="/styles/terrarium.css"/>'>
    </head>
    <body>
        <div class="login">

            <div class="login-top">
                <h2>Terrarium</h2>
                <h3>Spelbord</h3>
            </div>
            <form action="index.htm">
                <input type="hidden" value="${terrarium}" name="terrarium">
                <div class='keepme'>
                    <div class="keep-loginbutton"><security:csrfInput /> <input
                            type='submit' value='Opnieuw'></div>
                    <div class="clear"></div>
                </div>
            </form>
            <div class='keepme'>
                <div class="keep-loginbutton"><security:csrfInput /> <input
                        type='submit' value='Stop'></div>
                <div class="clear"></div>
            </div>
            <c:if test="${not empty terrarium}">
                <div id="spelbord">
                    Dag: ${terrarium.dag}
                    <table style="width: ${terrarium.wareGrootte}">
                        <c:forEach var="rij" items="${terrarium.array}">
                            <tr>
                                <c:forEach var="kolom" items="${rij}">
                                    <td><c:choose><c:when test="${not empty kolom}">
                                                <c:if test="${kolom['class'].simpleName == 'Plant'}">
                                                    <img src="images/besjes.png">
                                                </c:if>
                                                <c:if test="${kolom['class'].simpleName == 'Herbivoor'}">
                                                    <img src="images/smurf.png">
                                                </c:if>
                                                    <c:if test="${kolom['class'].simpleName == 'Carnivoor'}">
                                                    <img src="images/azreal.png">
                                                </c:if>
                                                    <c:if test="${kolom['class'].simpleName == 'Omnivoor'}">
                                                    <img src="images/gargamel.png">
                                                </c:if>
                                            </c:when>
                                                    <c:otherwise><img src="images/aarde.png"></c:otherwise>
                                        </c:choose></td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </c:if>
            <form method="post">
                <div class='keepme'>
                    <div class="keep-loginbutton"><security:csrfInput /> <input name="terrButton"
                            type='submit' value='Volgende dag'></div>
                    <div class="clear"></div>
                </div>
            </form>
        </div>
    </body>
</html>
