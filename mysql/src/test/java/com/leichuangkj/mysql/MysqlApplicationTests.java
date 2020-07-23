package com.leichuangkj.mysql;

import com.leichuangkj.dao.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class MysqlApplicationTests {
	@Resource
	private JdbcTemplate jdbcTemplate;

	/**
	 * @description SpringBoot集成Mysql单元测试
	 * @author steven
	 * @date 2020-06-14
	 */
	@Test
	public void mySqlTest(){
		String sql = "select id,name,email from user";
		List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				return user;
			}
		});
		for(User user:userList){
			System.out.println("【id】:" + user.getId() + ";【name】:" + user.getName()+ ";【email】:" + user.getEmail());
		}
	}
}
