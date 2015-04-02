package com.jclt.server;

import java.util.ArrayList;
import java.util.List;

import com.jclt.server.entry.Dir;
import com.jclt.server.entry.Orderform;
import com.jclt.server.entry.Product;
import com.jclt.server.entry.Smalldir;
import com.jclt.server.entry.User;

public class ResultData {
	public static List<Dir> mainDirs = new ArrayList<Dir>();
	public static List<Dir> dirs = new ArrayList<Dir>();
	public static List<Smalldir> smalldirs = new ArrayList<Smalldir>();
	public static List<Smalldir> selectSmalldirs = new ArrayList<Smalldir>();
	public static List<Product> products = new ArrayList<Product>();
	public static List<Orderform> orderforms = new ArrayList<Orderform>();
	public static User user = new User();
	
	public static Long getDirIdByName(String name){
		for (Dir dir : dirs) {
			if(dir.getName().equals(name)){
				return dir.getId();
			}
		}
		return 0L;
	}

	
	public static List<Smalldir> getSelectSmalldirs() {
		return selectSmalldirs;
	}
	public static void setSelectSmalldirs(List<Smalldir> selectSmalldirs) {
		ResultData.selectSmalldirs = selectSmalldirs;
	}
	public static List<Dir> getMainDirs() {
		return mainDirs;
	}
	public static void setMainDirs(List<Dir> mainDirs) {
		ResultData.mainDirs = mainDirs;
	}
	public static List<Dir> getDirs() {
		return dirs;
	}
	public static void setDirs(List<Dir> dirs) {
		ResultData.dirs = dirs;
	}
	public static List<Smalldir> getSmalldirs() {
		return smalldirs;
	}
	public static void setSmalldirs(List<Smalldir> smalldirs) {
		ResultData.smalldirs = smalldirs;
	}
	public static List<Product> getProducts() {
		return products;
	}
	public static void setProducts(List<Product> products) {
		ResultData.products = products;
	}
	public static List<Orderform> getOrderforms() {
		return orderforms;
	}
	public static void setOrderforms(List<Orderform> orderforms) {
		ResultData.orderforms = orderforms;
	}
	public static User getUser() {
		return user;
	}
	public static void setUser(User user) {
		ResultData.user = user;
	}
	
}
