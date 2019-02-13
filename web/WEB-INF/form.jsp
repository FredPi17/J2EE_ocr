<%--
  Created by IntelliJ IDEA.
  User: fredericpinaud
  Date: 2019-02-13
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Test</title>
</head>
<body>
<%@ include file="menu.jsp"
%>

<ul>
    <c:if test="${ !empty auteur}"><p>
        <c:forEach items="${ auteur }" var="auteur" varStatus="status">
            <li>
                <p><c:out value="Bonjour, vous vous appelez ${ auteur.getNom() } ${ auteur.getPrenom() } et votre mail est ${ auteur.getEmail() }" /></p>
            </li>
        </c:forEach>
    </c:if>
</ul>


<form method="post" action="form">
    <label for="nom">Nom: </label>
    <input type="text" name="nom" id="nom" />
    <br>

    <label for="prenom">Prenom: </label>
    <input type="text" name="prenom" id="prenom" />
    <br>

    <label for="email">Email: </label>
    <input type="email" name="email" id="email" />
    <br>

    <input type="submit" />
</form>

</body>
</html>