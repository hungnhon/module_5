<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Personal Calculator</title>
</head>
<body>

<h1>Personal Calculator</h1>

<form action="calculator" method="post">

    <input type="number"
           step="any"
           name="num1"
           value="${num1}"
           placeholder="First Number"
           required>

    <input type="number"
           step="any"
           name="num2"
           value="${num2}"
           placeholder="Second Number"
           required>

    <br><br>

    <button type="submit" name="action" value="add">
        Addition (+)
    </button>

    <button type="submit" name="action" value="sub">
        Subtraction (-)
    </button>

    <button type="submit" name="action" value="mul">
        Multiplication (*)
    </button>

    <button type="submit" name="action" value="div">
        Division (/)
    </button>

</form>

<hr>

<h2>${result}</h2>

</body>
</html>