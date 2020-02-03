package com.springboot.chapter6.service.impl;

import com.springboot.chapter6.pojo.User;
import com.springboot.chapter6.service.JdbcService;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/1/27 23:34
 */
@Service
public class JdbcServiceImpl implements JdbcService {
    @Autowired
    private DataSource dataSource;


    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public List<User> findUser(String userName, String note) {
        return null;
    }

    @Override
    public int insertUser(String userName, String note) {
        Connection conn = null;
        int result = 0;
        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(TransactionIsolationLevel.READ_COMMITTED.getLevel());

            //业务代码
            PreparedStatement ps =
                    conn.prepareStatement("insert into t_user(user_name,note) values (?,?)");
            ps.setString(1, userName);
            ps.setString(2, note);
            result = ps.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int deleteUser(Long id) {
        return 0;
    }
}
