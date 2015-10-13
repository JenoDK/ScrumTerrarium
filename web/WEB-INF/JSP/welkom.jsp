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
        <h1>Terrarium</h1>
        <h2>Welkom</h2>
        <form method="post" action="${pageContext.servletContext.contextPath}">
            <ul>       
                <li>grootte:   
                <input type="number" name= "grootte" value="${grootte}" autofocus min='6' max='20'  required/></li>
                <li>planten:
                    <input type="number" name= "planten" value="${planten}" autofocus min='6' max='20'  required/></li>
                <li>Herbivoren:<input type="number" name= "herbivoren" value="${herbivoren}" autofocus min='6' max='20'  required/></li>
                <li>Carnivoren:<input type="number" name= "carnivoren" value="${carnivoren}" autofocus min='6' max='20'  required/></li>
                <li>Omnivoren:<input type="number" name= "omnivoren" value="${omnivoren}" autofocus min='6' max='20'  required/></li>
                <li>Extra planten per dag:<input type="number" name= "extraPlanten" value="${extraPlanten}" autofocus min='6' max='20'  required/></li>
                 <input type="submit" value="Start"/>
            </ul>
        </form>
    </body>
</html>