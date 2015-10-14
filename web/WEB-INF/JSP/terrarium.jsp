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
                <div class="topBar buttons">
                    <form method="GET" action="index.htm">
                        <input type="hidden" value="${terrarium.grootte}" name="grootteOud">
                        <input type="hidden" value="${terrarium.aantalPlanten}" name="plantenOud">
                        <input type="hidden" value="${terrarium.aantalHerbivoren}" name="herbivorenOud">
                        <input type="hidden" value="${terrarium.aantalCarnivoren}" name="carnivorenOud">
                        <input type="hidden" value="${terrarium.aantalOmnivoren}" name="omnivorenOud">
                        <input type="hidden" value="${terrarium.aantalExtraPlantenPerDag}" name="extraPlantenOud">

                        <div class='keepme'>
                            <div class="keep-loginbutton"><security:csrfInput /> <input
                                    type='submit' value='Opnieuw'></div>
                            <div class="clear"></div>
                        </div>
                    </form>
                    <form action="eindeSpel.htm">
                        <div class='keepme'>
                            <div class="keep-loginbutton"><security:csrfInput /> <input
                                    type='submit' value='Stop'></div>
                            <div class="clear"></div>
                        </div>
                    </form></div>
                <div class="topBar titels">
                    <h2>Terrarium</h2>
                    <h3>Spelbord</h3>
                </div>
                        <div class="topBar legende">
                        <strong>Planten: </strong><img class="legendeImg" src="images/besjes.png">
                        <strong>Herbivoor: </strong><img class="legendeImg" src="images/smurf.png">
                        <strong>Carnivoor: </strong><img class="legendeImg" src="images/azreal.png">
                        <strong>Omnivoor: </strong><img class="legendeImg" src="images/gargamel.png">
                        <strong>Lege plaats: </strong><img class="legendeImg" src="images/aarde.png">
                    </div>
            </div>
            <c:if test="${not empty terrarium}">
                <div id="spelbord">
                    <table id="spelbordTable" style="width: ${terrarium.wareGrootte}px">
                        <tr><th>Dag: ${terrarium.dag}</th><th colspan="${terrarium.grootte - 1}"> Levenskracht/<span id="leeftijdPlant">Leeftijd</span>/<span id="dagenTeller">Dagen zonder eten</span></th></tr>
                                <c:forEach begin="0" end="${terrarium.grootte - 1}" varStatus="statusy">
                            <tr>
                                <c:forEach begin="0" end="${terrarium.grootte - 1}" varStatus="statusx">
                                    <td><c:choose><c:when test="${not empty terrarium.array[statusx.index][statusy.index]}">
                                                <c:if test="${terrarium.array[statusx.index][statusy.index]['class'].simpleName == 'Plant'}">
                                                    <img class="smurfenImg" src="images/besjes.png"><br/> <span id="leeftijdPlant">${terrarium.array[statusx.index][statusy.index].leeftijd}</span>
                                                </c:if>
                                                <c:if test="${terrarium.array[statusx.index][statusy.index]['class'].simpleName == 'Herbivoor'}">
                                                    <img class="smurfenImg" src="images/smurf.png"><br/> ${terrarium.array[statusx.index][statusy.index].levenskracht}<span id="dagenTeller">(${terrarium.array[statusx.index][statusy.index].dagenTeller})</span>
                                                </c:if>
                                                <c:if test="${terrarium.array[statusx.index][statusy.index]['class'].simpleName == 'Carnivoor'}">
                                                    <img class="smurfenImg" src="images/azreal.png"><br/> ${terrarium.array[statusx.index][statusy.index].levenskracht}
                                                </c:if>
                                                <c:if test="${terrarium.array[statusx.index][statusy.index]['class'].simpleName == 'Omnivoor'}">
                                                    <img class="smurfenImg" src="images/gargamel.png"><br/> ${terrarium.array[statusx.index][statusy.index].levenskracht}
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
                <div class='keepme volgendeDagButton'>
                    <div class="keep-registrerenbutton"><security:csrfInput /> <input name="terrButton"
                                                                                type='submit' value='Volgende dag'></div>
                    <div class="clear"></div>
                </div>
            </form>
        </div>
    </body>
</html>
