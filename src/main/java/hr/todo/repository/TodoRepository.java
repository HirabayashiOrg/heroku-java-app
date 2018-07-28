package hr.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.todo.bean.TodoListBean;

@Repository
public interface  TodoRepository extends JpaRepository<TodoListBean, Long>{

}
