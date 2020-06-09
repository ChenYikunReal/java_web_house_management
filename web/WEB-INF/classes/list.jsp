<%@ page import="entity.House" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.HouseTypeDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List<House> houses = (List<House>) request.getAttribute("houses");
        HouseTypeDao dao = new HouseTypeDao();
    %>

    <table border="1px">
        <tr>
            <td>房号</td>
            <td>房名</td>
            <td>面积</td>
            <td>房价</td>
            <td>描述</td>
            <td>房型</td>
            <td>操作</td>
        </tr>
        <%
            for (House h : houses) {
        %>
        <tr>
            <td><%=h.getHouseId()%></td>
            <td><%=h.getTitle()%></td>
            <td><%=h.getArea()%></td>
            <td><%=h.getPrice()%></td>
            <td><%=h.getInfo()%></td>
            <td><%=dao.queryTypeById(h.getTypeId()).getTypeName()%></td>
            <td><a href="update.jsp?houseId=<%=h.getHouseId()%>">修改</a></td>
        </tr>
        <%
            }
        %>
    </table>
    <a href="add.jsp">添加</a>
</body>
</html>
