<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<!doctype html>
<html lang='nl'>
    <head>
        <vdab:head title='Einde spel'/>
         <link rel='stylesheet' href='<c:url value="/styles/einde.css"/>'>
    </head>
    <body>
        <div class="login">
            <div class="login-top">

                <h2>Bedankt om ons spelletje te spelen</h2>
            </div>
            <div class="login-bottom">
                <h2>Dit spel is mede mogelijk gemaakt door: </h2>
                <ul>
                    <li>Lorien Van de Roy</li>
                    <li>Jeno De Keyser</li>
                    <li>Jonas Crombeke</li>
                    <li>Nils D'hont</li>
                    <li>Christophe Devos</li>
                </ul>
                <form action="index.htm">
                    <div class='keepme'>
                        <div class="keep-loginbutton"><security:csrfInput /> <input
                                type='submit' value='Home'></div>
                        <div class="clear"></div>
                    </div>
                </form>
                <img id="eindeSmurf" src="images/welkomsmurf.png" alt="Welkomsmurf">
            </div>
        </div>
    </body>
</html>