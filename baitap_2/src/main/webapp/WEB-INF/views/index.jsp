<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <title>Từ điển Anh Việt</title>

</head>

<body>

<h2>Từ điển Anh - Việt</h2>

<form action="search" method="get">

    <label>Nhập từ:</label>

    <input type="text" name="word">

    <button type="submit">Dịch</button>

</form>

<h3>Kết quả:</h3>

<p>

    ${word} : ${result}

</p>

</body>

</html>