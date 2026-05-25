<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/25/2026
  Time: 5:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
  <title>Result</title>
</head>
<body>

<h2>Gia vị đã chọn:</h2>

<c:choose>

  <c:when test="${not empty selectedCondiment}">

    <ul>

      <c:forEach var="item" items="${selectedCondiment}">
        <li>${item}</li>
      </c:forEach>

    </ul>

  </c:when>

  <c:otherwise>

    <p>Không chọn gia vị nào</p>

  </c:otherwise>

</c:choose>

<a href="${pageContext.request.contextPath}/">Quay lại</a>

</body>
</html>