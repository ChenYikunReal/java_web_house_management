package servlet;

import dao.HouseDao;
import dao.HouseTypeDao;
import entity.House;
import entity.HouseType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 分页查询网页信息
 */
public class QueryByPageServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        String pageStr=request.getParameter("page");
        if(pageStr != null){
            page = Integer.parseInt(pageStr);
        }
        int size = 2;
        HouseDao houseDao = new HouseDao();
        HouseTypeDao houseTypeDao = new HouseTypeDao();
        try {
            int count = houseDao.count();
            int total = count/size;
            if(count % size != 0) {
                total++;
            }
            List<House> houseList = houseDao.queryAllByPage(page,size);
            List<HouseType> houseTypeList = houseTypeDao.queryAllTypes();
            request.setAttribute("houseTypeList", houseTypeList);
            request.setAttribute("totalPage", total);
            request.setAttribute("houseList", houseList);
            request.setAttribute("curPage", page);
            request.getRequestDispatcher("houses.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
