package dao;

import entity.HouseType;
import util.SqlUtil;

import java.util.List;

/**
 * HouseType对应DAO
 */
public class HouseTypeDao {

    public HouseType queryTypeById(int id) {
        return SqlUtil.queryForOne(HouseType.class, "select * from housetype where typeid = ?", id);
    }

    public List<HouseType> queryAllTypes() {
        return SqlUtil.queryForList(HouseType.class, "select * from housetype");
    }

}
