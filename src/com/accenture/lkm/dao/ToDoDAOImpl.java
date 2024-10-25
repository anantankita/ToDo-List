package com.accenture.lkm.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.business.bean.ToDoBean;
import com.accenture.lkm.entity.ToDoEntity;

@Repository
@SuppressWarnings("unchecked")
public class ToDoDAOImpl implements ToDoDAO{
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	public Integer addToDoItem(ToDoBean todoBean) throws Exception{
		// TODO Auto-generated method stub
		Integer todoID=0;
		EntityManager entityManager=null;
		
		ToDoEntity todoEntityBean= convertBeanToEntity(todoBean);
		try {
			entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(todoEntityBean);
			entityManager.getTransaction().commit();
			todoID=todoEntityBean.getId();
		
		} catch (Exception exception) {
			throw exception;
		}finally{
			if(entityManager!=null){
				entityManager.close();
			}
		}
		
		return todoID;
	}
	
	public ToDoBean getToDoItem(Integer id) throws Exception{
		ToDoBean todoBean = null;
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			ToDoEntity todoEntity = (ToDoEntity) entityManager.find(ToDoEntity.class, id);
			if(todoEntity!=null) {
				todoBean=convertEntityToBean(todoEntity);
			}
			
		} catch (Exception exception) {

			throw exception;
		}finally{
			if(entityManager!=null){
				entityManager.close();
			}
		}
		
		return todoBean;
	}	
	
	public ToDoBean updateToDoItem(ToDoBean todoBean) throws Exception{
		ToDoBean todoBean2 = null;
		EntityManager entityManager = null;
		try {
			entityManager=entityManagerFactory.createEntityManager();
			ToDoEntity todoEntityBean2=(ToDoEntity) entityManager.find(ToDoEntity.class, todoBean.getId());
			if(todoEntityBean2!=null) {
				entityManager.getTransaction().begin();
				todoEntityBean2.setInsertTime(todoBean.getInsertTime());
				todoEntityBean2.setTask(todoBean.getTask());
				todoEntityBean2.setDescription(todoBean.getDescription());
				
				todoBean2=convertEntityToBean(todoEntityBean2);
				entityManager.getTransaction().commit();
			}
			
			
			

		} catch (Exception exception) {

			throw exception;
		}finally{
			if(entityManager!=null){
				entityManager.close();
			}
		}
		

		return todoBean2;
	}

	public ToDoBean deleteToDoItem(Integer id) throws Exception{
		ToDoBean todoBean = null;
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			ToDoEntity todoEntity=(ToDoEntity) entityManager.find(ToDoEntity.class, id);
			
			if(todoEntity!=null) {
				entityManager.getTransaction().begin();
				entityManager.remove(todoEntity);
				entityManager.getTransaction().commit();
				todoBean=convertEntityToBean(todoEntity);
			}

		} catch (Exception exception) {

			throw exception;
		}finally{
			if(entityManager!=null){
				entityManager.close();
			}
		}
		

		return todoBean;
	}
	
	
	public List<ToDoBean> getToDoList() throws Exception{
		List<ToDoBean> listEmployeeBean = null;
		EntityManager entityManager = null;
		try {
			entityManager=entityManagerFactory.createEntityManager();
			listEmployeeBean=new ArrayList<ToDoBean>();
			
	        // Suppressing warning here due to unchecked cast from raw type
			List<ToDoEntity> listEmployeeEntity = (List<ToDoEntity>) entityManager.createQuery("from EmployeeEntity").getResultList();
			for(ToDoEntity entity:listEmployeeEntity) {
				ToDoBean emp = convertEntityToBean(entity);
				listEmployeeBean.add(emp);
			}
			
			

		} catch (Exception exception) {

			throw exception;
		}finally{
			if(entityManager!=null){
				entityManager.close();
			}
		}
		
		//return employeeEntityBean2;
		return (listEmployeeBean);
	}
	
	public static ToDoBean convertEntityToBean(ToDoEntity entity){
		ToDoBean employee = new ToDoBean();
		BeanUtils.copyProperties(entity, employee);
		return employee;
	}
	public static ToDoEntity convertBeanToEntity(ToDoBean bean){
		ToDoEntity employeeEntityBean = new ToDoEntity();
		BeanUtils.copyProperties(bean,employeeEntityBean);
		return employeeEntityBean;
	}
	
	
}
