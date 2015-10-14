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
            <form method="GET" action="index.htm">
                <input type="hidden" value="${terrarium.grootte}" name="grootte">
                <input type="hidden" value="${terrarium.aantalPlanten}" name="planten">
                <input type="hidden" value="${terrarium.aantalHerbivoren}" name="herbivoren">
                <input type="hidden" value="${terrarium.aantalCarnivoren}" name="carnivoren">
                <input type="hidden" value="${terrarium.aantalOmnivoren}" name="omnivoren">
                <input type="hidden" value="${terrarium.aantalExtraPlantenPerDag}" name="extraPlanten">
                
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
                    <table style="width: ${terrarium.wareGrootte}">
                        <c:forEach var="rij" items="${terrarium.array}">
                            <tr>
                                <c:forEach var="kolom" items="${rij}">
                                    <td><c:choose><c:when test="${not empty kolom}">${kolom['class'].simpleName}</c:when><c:otherwise>NULL</c:otherwise></c:choose></td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </c:if>
            <div class='keepme'>
                <div class="keep-loginbutton"><security:csrfInput /> <input
                        type='submit' value='Volgende dag'></div>
                <div class="clear"></div>
            </div>
        </div>
    </body>
</html>
