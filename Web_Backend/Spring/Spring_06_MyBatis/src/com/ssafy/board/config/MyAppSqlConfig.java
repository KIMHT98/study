package com.ssafy.board.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyAppSqlConfig {
	// 공장 세워서 불러다 쓸 예정

	private static SqlSessionFactory factory;

	static {
		// 공장 세워야 하는데 설정파일 위치
		String resource = "config/MyBatis-config.xml";
		try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("공장 건설 완료");
		} catch (IOException e) {
			System.out.println("공장 건설 실패");
		}

	}

	public static SqlSessionFactory getFactory() {
		return factory;
	}

}
