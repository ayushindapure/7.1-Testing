<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>STEM Math Game - Question 3</title>
</head>
<body>
    <h1>STEM Math Challenge</h1>
    <h2>Question 3: Multiplication</h2>

    <!-- Show error message if present -->
    <c:if test="${not empty message}">
        <p style="color:red;">${message}</p>
    </c:if>

    <form method="post" action="/q3">
        <p>What is <strong>6 × 7</strong>?</p>
        <input type="hidden" name="number1" value="6" />
        <input type="hidden" name="number2" value="7" />
        <label>Your Answer: <input type="text" name="result" id="result" /></label>
        <br/><br/>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>