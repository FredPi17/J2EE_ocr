<%--
  Created by IntelliJ IDEA.
  User: fredericpinaud
  Date: 2019-02-13
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="image" enctype="multipart/form-data">
    <p>
        <label for="description">Description du fichier : </label>
        <input type="text" name="description" id="description" />
    </p>
    <p>
        <label for="fichier">Fichier à envoyer : </label>
        <input type="file" name="fichier" id="fichier" />
    </p>

    <p>
        <input type="submit">
    </p>
</form>

</body>
</html>
