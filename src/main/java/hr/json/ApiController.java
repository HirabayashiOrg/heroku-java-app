package hr.json;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	@RequestMapping(value = "/json/sample")
	public List<Sample> sample() {
		List<Sample> list = new ArrayList<>();
		list.add(new Sample());
		list.add(new Sample());
		list.add(new Sample());
		return list;
	}

	class Sample{
		private String name = "ryo";
		private int    age  = 25;
		public void setName(String name) {
			this.name = name;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getName() {
			return this.name;
		}
		public int getAge() {
			return this.age;
		}
	}
}
