package dao;

import entity.House;
import util.SqlUtil;

import java.util.List;

/**
 * House对应DAO
 */
public class HouseDao {

    public House queryHouseById(int id) {
        return SqlUtil.queryForOne(House.class, "select * from house where houseid = ?", id);
    }

    public List<House> queryAllHouses() {
        return SqlUtil.queryForList(House.class, "select * from house");
    }

    public void updateHouse(House h) {
        SqlUtil.update("update house set title = ?, area = ?, price = ?, info = ?, typeid = ? where houseid = ?",
                h.getTitle(), h.getArea(), h.getPrice(), h.getInfo(), h.getTypeId(), h.getHouseId());
    }

    public void addHouse(House h) {
        SqlUtil.update("insert into house (title, area, price, info ,typeid) values (?, ?, ?, ?, ?)", h.getTitle(),
                h.getArea(), h.getPrice(), h.getInfo(), h.getTypeId());
    }

}
