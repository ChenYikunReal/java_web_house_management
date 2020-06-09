<%@ page import="dao.HouseTypeDao" %>
<%@ page import="entity.HouseType" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.HouseDao" %>
<%@ page import="entity.House" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    HouseTypeDao typeDao = new HouseTypeDao();
    HouseDao houseDao = new HouseDao();
    List<HouseType> types = typeDao.queryAllTypes();
    int id = (int) request.getAttribute("houseId");
    House h = houseDao.queryHouseById(id);
%>
<form action="UpdateHouseServlet" method="post">
    房号: <input type="text" name="houseId" value="<%=id%>" readonly="readonly"> <br>
    房名: <input type="text" name="title" value="<%=h.getTitle()%>"> <br>
    面积: <input type="text" name="area" value="<%=h.getArea()%>"> <br>
    价格: <input type="text" name="price" value="<%=h.getPrice()%>"> <br>
    介绍: <input type="text" name="info" value="<%=h.getInfo()%>"> <br>
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
