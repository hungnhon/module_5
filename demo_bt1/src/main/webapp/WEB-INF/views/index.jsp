<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>


<html>
<head>
    <title>Currency Converter</title>
</head>

<body>

<h2>Chuyển đổi USD sang VND</h2>

<form action="convert" method="get">

    USD:
    <input type="text" name="usd">

    <br><br>

    Tỷ giá:
    <input type="text" name="rate" value="25000">

    <br><br>

    <button type="submit">Convert</button>

</form>

<h3>Kết quả:</h3>

<p>
    ${usd} USD = ${vnd} VND
</p>

</body>
</html>