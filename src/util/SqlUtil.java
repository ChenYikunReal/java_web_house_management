package util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SqlUtil {

    private static final QueryRunner queryRunner = new QueryRunner();

    public static void update(String sql, Object... args) {
        Connection connection = DbUtil.getConnection();
        try {
            queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(connection);
        }
    }

    public static <T> T queryForOne(Class<T> clazz, String sql, Object... args) {
        Connection connection = DbUtil.getConnection();
        T resultSets = null;
        try {
            resultSets = queryRunner.query(connection, sql, new BeanHandler<>(clazz), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(connection);
        }
        return resultSets;
    }

    public static <T> List<T> queryForList(Class<T> clazz, String sql, Object... args) {
        Connection connection = DbUtil.getConnection();
        List<T> resultSets = null;
        try {
            resultSets = queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(connection);
        }
        return resultSets;
    }

}
