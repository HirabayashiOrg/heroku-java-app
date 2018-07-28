package hr.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hr.todo.bean.TodoListBean;
import hr.todo.repository.TodoRepository;

@RestController
public class TodoApiController {
	@Autowired
	private TodoRepository repo;

	@RequestMapping(value = "/todo/api/list")
	public List<TodoListBean> sample() {
		List<TodoListBean> list = null;
		list = repo.findAll();
		return list;
	}

	@PostMapping("/todo/api/add")
	public TodoListBean insert(@RequestParam("title")String title) {
		TodoListBean todo = new TodoListBean();
		todo.setTitle(title);
		todo.setStatus(0);

		return repo.save(todo);
	}
}
