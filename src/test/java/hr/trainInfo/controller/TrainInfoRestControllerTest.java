package hr.trainInfo.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest
public class TrainInfoRestControllerTest extends Assert {
	@Rule
	public ExpectedException exprctException = ExpectedException.none();

	private MockMvc mvc;

	@Before
	public void before() {
		mvc = MockMvcBuilders.standaloneSetup(new TrainInfoRestController()).build();
	}

	@Test
	public void 運行情報Line通知() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/trainInfo/line/notice/all"));
	}
}
