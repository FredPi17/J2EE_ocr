<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Test</title>
</head>
<body>
<%@ include file="menu.jsp"
%>
<p>
    ${ message }
    ${ empty name ? '' : name}

</p>
</body>
</html>