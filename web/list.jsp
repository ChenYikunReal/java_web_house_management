<%@ page import="entity.House" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.HouseTypeDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>房屋的列表显示</title>
</head>
<body>
    <%
        List<House> houses = (List<House>) request.getAttribute("houses");
        HouseTypeDao dao = new HouseTypeDao();
    %>

    <table border="1">
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
            for (House house : houses) {
        %>
        <tr>
            <td><%=house.getHouseId()%></td>
            <td><%=house.getTitle()%></td>
            <td><%=house.getArea()%></td>
            <td><%=house.getPrice()%></td>
            <td><%=house.getInfo()%></td>
            <td><%=dao.queryTypeById(house.getTypeId()).getTypeName()%></td>
            <td><a href="update.jsp?houseId=<%=house.getHouseId()%>">修改</a></td>
        </tr>
        <%
            }
        %>
    </table>
    <a href="add.jsp">添加</a>
</body>
</html>
