package servlet;

import dao.HouseDao;
import entity.House;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;

/**
 * 查询所有房屋信息
 */
public class QueryAllHousesServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HouseDao dao = new HouseDao();
        List<House> houses = dao.queryAllHouses();
        request.setAttribute("houses", houses);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

}
