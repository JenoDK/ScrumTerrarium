<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<!doctype html>
<html lang='nl'>
    <head>
        <vdab:head title='Pagina niet gevonden'/>
    </head>
<body>
    
<h1>Pagina niet gevonden</h1>

<img src='<c:url value="/images/fout.jpg"/>' alt='fout'>
<p>De pagina die u zocht bestaat niet op onze website.</p>
<c:import url='/WEB-INF/JSP/menu.jsp'/>
</body>
</html>