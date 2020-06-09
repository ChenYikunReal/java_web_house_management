<%@ page import="dao.HouseTypeDao" %>
<%@ page import="entity.HouseType" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        HouseTypeDao dao = new HouseTypeDao();
        List<HouseType> types = dao.queryAllTypes();
    %>
    <form action="AddHouseServlet" method="post">
        房号: <input type="text" name="houseId"> <br>
        房名: <input type="text" name="title"> <br>
        面积: <input type="text" name="area"> <br>
        价格: <input type="text" name="price"> <br>
        介绍: <input type="text" name="info"> <br>
        <label>
            <select name="type">
                <%
                    for (HouseType type : types) {
                %>
                <option value="<%=type.getTypeId()%>"><%=type.getTypeName()%></option>
                <%
                    }
                %>
            </select>
        </label>
        <input type="submit" value="提交">
    </form>
    <a href="QueryAllHousesServlet">返回</a>
</body>
</html>
