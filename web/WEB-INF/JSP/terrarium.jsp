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
                    Dag: ${terrarium.dag}
                    <table id="spelbordTable" style="width: ${terrarium.wareGrootte}">
                        <c:forEach begin="0" end="${terrarium.grootte - 1}" varStatus="statusy">
                            <tr>
                              <c:forEach begin="0" end="${terrarium.grootte - 1}" varStatus="statusx">
                                    <td><c:choose><c:when test="${not empty terrarium.array[statusx.index][statusy.index]}">
                                                <c:if test="${terrarium.array[statusx.index][statusy.index]['class'].simpleName == 'Plant'}">
                                                    <img src="images/besjes.png"> ${terrarium.array[statusx.index][statusy.index].leeftijd}
                                                </c:if>
                                                <c:if test="${terrarium.array[statusx.index][statusy.index]['class'].simpleName == 'Herbivoor'}">
                                                    <img src="images/smurf.png"> ${terrarium.array[statusx.index][statusy.index].levenskracht}(${terrarium.array[statusx.index][statusy.index].dagenTeller})
                                                </c:if>
                                                    <c:if test="${terrarium.array[statusx.index][statusy.index]['class'].simpleName == 'Carnivoor'}">
                                                    <img src="images/azreal.png"> ${terrarium.array[statusx.index][statusy.index].levenskracht}
                                                </c:if>
                                                    <c:if test="${terrarium.array[statusx.index][statusy.index]['class'].simpleName == 'Omnivoor'}">
                                                    <img src="images/gargamel.png"> ${terrarium.array[statusx.index][statusy.index].levenskracht}
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
