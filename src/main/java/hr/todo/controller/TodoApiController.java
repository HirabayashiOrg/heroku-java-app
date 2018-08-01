package hr.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hr.todo.bean.TodoListBean;
import hr.todo.repository.TodoRepository;

@RestController
public class TodoApiController {
	@Autowired
	private TodoRepository repo;

	@GetMapping(value = "/todo/api/list")
	public List<TodoListBean> sample() {
		List<TodoListBean> list = null;
		list = repo.findAll();
		return list;
	}

	@Transactional(readOnly=false)
	@PostMapping("/todo/api/add")
	public TodoListBean add(@RequestParam("title")String title) {
		TodoListBean todo = new TodoListBean();
		todo.setTitle(title);
		todo.setStatus(0);
		return repo.saveAndFlush(todo);
	}

	@Transactional(readOnly=false)
	@PostMapping("/todo/api/update")
	public TodoListBean update(@RequestParam("id")int id) {
		TodoListBean todo = repo.findById((long)id).get();
		todo.setStatus((todo.getStatus() + 1) % 2);
		return repo.saveAndFlush(todo);
	}
}
