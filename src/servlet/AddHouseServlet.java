package servlet;

import dao.HouseDao;
import entity.House;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.ServletException;

/**
 * 添加房屋信息
 */
public class AddHouseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HouseDao dao = new HouseDao();
        dao.addHouse(new House(Integer.parseInt(request.getParameter("houseId")), request.getParameter("title"),
                Double.parseDouble(request.getParameter("area")), Double.parseDouble(request.getParameter("price")),
                request.getParameter("info"), Integer.parseInt(request.getParameter("type"))));
        request.getRequestDispatcher("QueryAllHousesServlet").forward(request, response);
    }

}
