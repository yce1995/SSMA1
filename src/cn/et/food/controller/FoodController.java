package cn.et.food.controller;

import java.io.OutputStream;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.food.entity.Foods;
import cn.et.food.service.FoodService;

@Controller
public class FoodController {
	@Autowired
	FoodService fs;
	@ResponseBody
	@RequestMapping("/queryFoods")
	public List<Foods> queryFood(String foodname){
		List<Foods> queryFood = fs.queryFood(foodname);
		return queryFood;
	}
	
	/*@ResponseBody
	@RequestMapping("/saveFood")
	public void saveFood(String foodname,Double price){
		fs.saveFood("你好",130.0);
	}*/
	
	@RequestMapping(value="/defood/{foodId}",method=RequestMethod.DELETE)
	public String deleteFood(@PathVariable Integer foodId,OutputStream os) throws Exception{
		try {
			fs.deleteFood(foodId);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	/**
	 * 修改food
	 * @param foodId 菜品id
	 * @param foodName 菜品名
	 * @param price 菜品价格
	 * @param os
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateFood/{foodId}",method={RequestMethod.PUT})
	public String updataFood(@PathVariable String foodId,String foodName,Double price,OutputStream os) throws Exception{
		try {
			fs.updateFood(Integer.parseInt(foodId), foodName, price);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
	/**
	 * 现在菜品
	 * @param foodName 菜品名称
	 * @param price 价格
	 * @param os
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/food",method={RequestMethod.POST})
	public String saveFood(String foodName,Double price,OutputStream os) throws Exception{
		try {
			fs.saveFood(foodName, price);
			os.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			os.write("0".getBytes("UTF-8"));
		}
		return null;
	}
}
