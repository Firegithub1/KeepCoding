package com.renkai.Dao;

import com.renkai.domain.Product;
import com.renkai.utils.DataSourceUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.renkai.domain.Product;

public class ProductDao {

	public List<Product> FindAll() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qRunner=new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="select * from product";
		
		return qRunner.query(sql, new BeanListHandler<>(Product.class));
	}

}
