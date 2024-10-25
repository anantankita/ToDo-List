package com.accenture.lkm.ui;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.lkm.business.bean.ToDoBean;
import com.accenture.lkm.service.ToDoService;

@SuppressWarnings("resource")
public class UITester {

	public static void main(String[] args) {
		ToDoService todoService=null;
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("com/accenture/lkm/resources/cst-main-config.xml");
			todoService = (ToDoService) ac.getBean("todoServiceImpl");
			
			//1 Add ToDo item
			//addToDoItem(todoService);
			
			//2 Get ToDo item
			//getToDoItem(todoService);
			
			//3 Update ToDo item
			updateToDoItem(todoService);
			
			//4 Delete ToDo item
			//deleteToDo(todoService);
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void addToDoItem(ToDoService serviceImpl) {
		ToDoBean bean= new ToDoBean();
		bean.setInsertTime(new Date());
		bean.setTask("exercise");
		bean.setDescription("yoga, running");
		bean.setDone(false);
		
		try {
			int id= serviceImpl.addToDoItem(bean);
			System.out.println("Task added: "+ id);
			
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public static void getToDoItem(ToDoService serviceImpl) {
		try {
			ToDoBean todoBean = serviceImpl.getToDoItem(3);
			
			if(todoBean==null) {
				System.out.println("Invalid task Id");
			}
			else {
				System.out.println("ToDo List");
				System.out.println("=====================");
				System.out.println("Name: " + todoBean.getTask());
				System.out.println("Salary: "+ todoBean.getDescription());
			} 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public static void getAllToDoItem(ToDoService todoService) {
		try {
			List<ToDoBean> listTodo=todoService.getToDoList();
			for(ToDoBean list:listTodo) {
				System.out.println(list);
			}			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateToDoItem(ToDoService serviceImpl) {
		try {
			ToDoBean foundTodoBean=serviceImpl.getToDoItem(1);
			if(foundTodoBean==null) {
				System.out.println("Invalid Task Id");
			}
			else {
				foundTodoBean.setDone(false);
				ToDoBean updatedBean=serviceImpl.updateToDoItem(foundTodoBean);
				System.out.println("Updated Employee Details");
				System.out.println("=====================");
				System.out.println("Task: "+ updatedBean.getTask());
				System.out.println("Description: "+ updatedBean.getDescription());
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void deleteToDo(ToDoService todoService) {
		try {
			ToDoBean todoBean = todoService.deleteToDoItem(4);
			if (todoBean==null) {
				System.out.println("Invalid task Id");
			}
			else {
				System.out.println("Task Deleted successfully with task id: "+ todoBean.getId());
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

}
