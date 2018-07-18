package com.renkai.service;

import com.renkai.domain.Product;

import java.sql.SQLException;
import java.util.List;

import com.renkai.Dao.ProductDao;

public class ProductService {

	public List<Product> FindAll() throws SQLException {
		// TODO Auto-generated method stub
		return new ProductDao().FindAll();
	}

}
