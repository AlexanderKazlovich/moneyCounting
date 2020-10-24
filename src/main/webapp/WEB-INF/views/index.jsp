<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h2>Accounts</h2>
<c:forEach items="${accounts}" var="acc">
    <table border="1" style="display: inline-block">
        <tr>
            <td colspan="3">${acc.name}</td>
        </tr>
        <tr>
            <td colspan="3">${acc.balance}</td>
        </tr>
        <tr>
            <td>
                <form action="/expense" method="post">
                    <input type="hidden" id="id" name="id" value="${acc.id}">
                    <label for="expense" style="display: block">expense:</label>
                    <input type="text" id="expense" name="expense" style="display: block; width: 100px">
                    <input type="submit" value="EXPENSE">
                </form>
            </td>
            <td>
                <form action="/income" method="post">
                    <input type="hidden" name="id" value="${acc.id}">
                    <label for="income" style="display: block">income:</label>
                    <input type="text" id="income" name="income" style="display: block; width: 100px">
                    <input type="submit" value="INCOME">
                </form>
            </td>
            <td>
                <form action="/transfer" method="post">
                    <input type="hidden" name="fromAcc" value="${acc.name}">
                    <p>Transfer</p>
                    <p>To:</p>
                    <select name="toAcc">
                        <c:forEach items="${accounts}" var="acc">
                            <option>${acc.name}</option>
                        </c:forEach>
                    </select>
                    <br>
                    <label for="how_much">How much:</label>
                    <input type="text" id="how_much" name="how_much" style="display: block; width: 100px">

                    <input type="submit" value="TRANSFER">
                </form>
            </td>
        </tr>
        <tr>
            <td>
                <form action="" method="post">
                    <input type="hidden" name="deleteAcc" id="deleteAcc" value="${acc.id}">
                    <input type="submit"  value="delete account" onclick="return confirm('sure?')"  >
                </form>
            </td>
        </tr>
    </table>
</c:forEach>

<h2>Transactions</h2>

<c:forEach items="${transactions}" var="transaction">
    <p>When: ${transaction.date}  From: ${transaction.fromAcc}  To: ${transaction.toAcc}  How much: ${transaction.quantity}</p>
</c:forEach>

</body>
</html>
