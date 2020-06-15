<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>房屋的分页显示</title>
</head>

<body>
    <table border="1" width="700x">
        <tr>
            <td>房号</td>
            <td>房名</td>
            <td>面积</td>
            <td>房价</td>
            <td>描述</td>
            <td>房型</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${requestScope.houseList}" var="h" >
            <tr>
                <td>${h.houseId}</td>
                <td>${h.title}</td>
                <td>${h.area}</td>
                <td>${h.price}</td>
                <td>${h.info}</td>
                <td>
                    <c:forEach items="${requestScope.houseTypeList}" var="u">
                        <c:if test="${u.typeID==h.typeID}">
                            ${u.typeName}
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <a href="update.jsp?houseId="${h.houseID}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="QueryByPageServlet?page=1">首页</a>
    <c:if test="${requestScope.curPage!=1}">
        <a href="QueryByPageServlet?page=${requestScope.curPage-1}">上一页</a>
    </c:if>
    <c:if test="${requestScope.curPage!=requestScope.totalPage}">
        <a href="QueryByPageServlet?page=${requestScope.curPage+1}">下一页</a>
    </c:if>
    <a href="QueryByPageServlet?page=${requestScope.totalPage}">末页</a>
</body>

</html>
