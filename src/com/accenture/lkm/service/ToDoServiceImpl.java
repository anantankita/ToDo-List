package com.accenture.lkm.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.ToDoBean;

import com.accenture.lkm.dao.ToDoDAO;
import com.accenture.lkm.exceptions.InvalidUpdateOperationException;

@Service("todoServiceImpl")
public class ToDoServiceImpl implements ToDoService {
	
	@Autowired
	private ToDoDAO todoDAO;
	
	public Integer addToDoItem(ToDoBean todoBean) throws Exception{
		return todoDAO.addToDoItem(todoBean);
	}
	
	public ToDoBean getToDoItem(Integer id) throws Exception{
		ToDoBean todo=todoDAO.getToDoItem(id);
		if(todo==null) {
			throw new InvalidUpdateOperationException();
		}
		return todo;
	}
	
	public ToDoBean updateToDoItem(ToDoBean todoBean) throws Exception{
		ToDoBean todo= todoDAO.updateToDoItem(todoBean);
		return todo;
	}
	
	public ToDoBean deleteToDoItem(Integer id) throws Exception{
		ToDoBean todo= todoDAO.deleteToDoItem(id);
		return todo;
	}
	
	public List<ToDoBean> getToDoList() throws Exception{
		return todoDAO.getToDoList();
	}
}
