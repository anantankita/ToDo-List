package com.accenture.lkm.dao;
import java.util.List;
import com.accenture.lkm.business.bean.ToDoBean;
public interface ToDoDAO {
	Integer addToDoItem(ToDoBean todoBean) throws Exception;

	ToDoBean getToDoItem(Integer id) throws Exception;

	ToDoBean updateToDoItem(ToDoBean todoBean) throws Exception;

	ToDoBean deleteToDoItem(Integer id) throws Exception;

	List<ToDoBean> getToDoList() throws Exception;	
}
