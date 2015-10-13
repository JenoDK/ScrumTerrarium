<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<!doctype html>
<html lang='nl'>
    <head>
        <vdab:head title='Welkom'/>
    </head>

    <body>
        <div class="login">
            <div class="login-top">
                <h2>Terrarium</h2>
                <h3>Welkom</h3>
            </div>
            <div class="login-bottom">
                <form method="post">
                    Grootte:</br><div class="user"><input type="number" name= "grootte" value="${grootte}" autofocus min='6' max='20'  required /></div>
                    Planten:<div class="user"><input type="number" name= "planten" value="${planten}" autofocus min='1' required /></div>
                    Herbivoren:<div class="user"><input type="number" name= "herbivoren" value="${herbivoren}" autofocus min='1' required /></div>
                    Carnivoren:<div class="user"><input type="number" name= "carnivoren" value="${carnivoren}" autofocus min='0' required /></div>
                    Omnivoren:<div class="user"><input type="number" name= "omnivoren" value="${omnivoren}" autofocus min='0' required /></div>
                    Extra planten per dag:<div class="user"><input type="number" name= "extraPlanten" value="${extraPlanten}" autofocus min='1' required /></div>
                    <div class="clear"></div>
                    <div class='keepme'>
                        <div class="keep-registrerenbutton"><security:csrfInput /> <input
                                type='submit' value='Start'></div>
                        <div class="clear"></div>
                    </div>
                </form>
                <c:forEach var='fout' items='${fouten}'>
                    ${fout}
                    <br>

                </c:forEach>
                <img id="welkomSmurf" src="images/welkomsmurf.png" alt="Welkomsmurf">
            </div>
        </div>
    </body>
</html>
