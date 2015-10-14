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
            <div class="login-bottom"></div>
            <div class='keepme'>
                <div class="keep-loginbutton"><security:csrfInput /> <input
                        type='submit' value='Opnieuw'></div>
                <div class="clear"></div>
            </div>
            <div class='keepme'>
                <div class="keep-loginbutton"><security:csrfInput /> <input
                        type='submit' value='Stop'></div>
                <div class="clear"></div>
            </div>
            <c:if test="${not empty terrarium}">
                <div id="spelbord">
                    <table style="width: ${terrarium.grootte}"></table>
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
