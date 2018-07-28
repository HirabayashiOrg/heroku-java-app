package hr.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import hr.todo.bean.TodoListBean;
import hr.todo.repository.TodoRepository;

@Controller
public class TodoController {
	@Autowired
	private TodoRepository repo;

	@GetMapping("/todo")
	public ModelAndView todo(ModelAndView mav) {
		List<TodoListBean> list = repo.findAll();
		mav.addObject("list", list);
		mav.setViewName("todo/index");
		return mav;
	}
}
