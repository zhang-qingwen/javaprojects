<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style type="text/css"></style>
</head>
<body>
<script type="text/javascript" src="javascript.js">

</script>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello">Hello Servlet</a>
<input type="text" name = "input1" value="22222">
</body>

<script type="text/javascript">
    var input1 = document.getElementById("input1");
    alert("Message" + input1);
</script>
</html>