package _09_furniture.model;

import java.util.ArrayList;
import java.util.List;

import _09_furniture.model.dao.FurnitureDAO;
import _09_furniture.model.dao.FurnitureDAOJdbc;


public class FurnitureService {
	private FurnitureDAO productDao = new FurnitureDAOJdbc();
	public static void main(String[] args) {
		FurnitureService service = new FurnitureService();
		FurnitureBean f=new FurnitureBean();
		f.setFurniture_id(1000);
		f.setUser_account("Alex123");
		List<FurnitureBean> beans = service.select(f);
		System.out.println("beans="+beans);
	}
	public List<FurnitureBean> select(FurnitureBean bean) {
		List<FurnitureBean> result = null;
	
	 if((bean!=null && bean.getFurniture_id()!=0) ||(bean!=null && bean.getUser_account()!="")
			 ||(bean!=null && bean.getFurniture_neme()!="")) {
			FurnitureBean temp = productDao.select(bean.getFurniture_id());
			String temp1= bean.getUser_account();
			String temp2= bean.getFurniture_neme();
			if(temp!=null) {
				result = new ArrayList<FurnitureBean>();
				result.add(temp);
			}
			else if(temp1!=""){
				result =productDao.select(temp1);
			}else if(temp2!="") {
				result =productDao.selectKeyWord(temp2);
			}
		} else {
			result = productDao.selectAllFurniture(); 
		}
		return result;
	}
	
	public FurnitureBean insert(FurnitureBean bean) {
		FurnitureBean result = null;
		if(bean!=null) {
			result = productDao.insert(bean);
		}
		return result;
	}
	public FurnitureBean update(FurnitureBean bean) {
		FurnitureBean result = null;
		if(bean!=null) {
			result = productDao.update(bean);
		}
		return result;
	}
	public boolean delete(FurnitureBean bean) {
		boolean result = false;
		if(bean!=null) {
			result = productDao.delete(bean.getFurniture_id());
		}
		return result;
	}
}