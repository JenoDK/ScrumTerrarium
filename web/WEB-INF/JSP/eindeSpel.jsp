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
                <audio id="myAudio" autoplay="true">
                    <source src="music/smurf.ogg" type="audio/ogg">
                    <source src="music/smurf.mp3" type="audio/mpeg">
                    Your browser does not support the audio element.
                </audio>
                <button onclick="playAudio()" type="button">Play Audio</button>
                <button onclick="pauseAudio()" type="button">Pause Audio</button> 
            </div>
            <div class="login-bottom">
                <h2>Dit spel is mede mogelijk gemaakt door: </h2>
                <ul>
                    <li><strong>Lorien Van de Roy</strong></li>
                    <li><strong>Jeno De Keyzer</strong></li>
                    <li><strong>Jonas Cromheeke</strong></li>
                    <li><strong>Nils D'hont</strong></li>
                    <li><strong>Christophe Devos</strong></li>
                </ul>
                <img id="eindeSmurf" src="images/welkomsmurf.png" alt="Welkomsmurf">
                <form action="index.htm">
                    <div class='keepme'>
                        <div class="keep-registrerenbutton"><security:csrfInput /> <input
                                type='submit' value='Home'></div>
                        <div class="clear"></div>
                    </div>
                </form>
            </div>
        </div>
                <script>
var x = document.getElementById("myAudio"); 

function playAudio() { 
    x.play(); 
} 

function pauseAudio() { 
    x.pause(); 
} 
</script>
    </body>
</html>