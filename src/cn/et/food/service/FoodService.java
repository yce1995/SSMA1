package cn.et.food.service;

import java.util.List;

import cn.et.food.entity.Foods;

public interface FoodService {

	public abstract List<Foods> queryFood(String foodname);
	
	public abstract void saveFood(String foodname,Double price);
	
	public abstract void updateFood(Integer foodid,String foodname,Double price);
	
	public abstract void deleteFood(Integer foodid);
}