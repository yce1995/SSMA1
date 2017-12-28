package cn.et.food.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.food.dao.FoodsMapper;
import cn.et.food.entity.Foods;
import cn.et.food.entity.FoodsExample;
import cn.et.food.entity.FoodsExample.Criteria;
import cn.et.food.service.FoodService;
@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	FoodsMapper fm;
	/* (non-Javadoc)
	 * @see cn.et.food.service.impl.FoodService#queryFood(java.lang.String)
	 */
	public List<Foods> queryFood(String foodname){
		FoodsExample fd = new FoodsExample();
		Criteria c = fd.createCriteria();
		c.andFoodnameLike("%"+foodname+"%");
		return fm.selectByExample(fd);
	}
	
	public void saveFood(String foodname,Double price){
		Foods f = new Foods();
		f.setFoodname(foodname);
		f.setPrice(price);
		fm.insertSelective(f);
	}
	
	public void updateFood(Integer foodid,String foodname,Double price){
		Foods f = new Foods();
		f.setFoodid(foodid);
		f.setFoodname(foodname);
		f.setPrice(price);
		fm.updateByPrimaryKey(f);
	}

	public void deleteFood(Integer foodid) {
		fm.deleteByPrimaryKey(foodid);
	}
}
