package hr.trainInfo.controller;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import hr.trainInfo.service.TrainInfoRegisterService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class TrainInfoRestControllerTest extends Assert {
	@Rule
	public ExpectedException exprctException = ExpectedException.none();

	@Autowired
	private MockMvc mockServer;

	@Mock
	TrainInfoRegisterService registerService;

	@InjectMocks
	TrainInfoRestController testInfoRestController;

	@Test
	@Rollback(true)
	public void 運行情報登録API() throws Exception {
		String line = "南武線";

		ResultActions result = mockServer.perform(MockMvcRequestBuilders.post("/trainInfo/info/notice/reg")
				.param("line", line));

		result.andExpect(MockMvcResultMatchers.status().is(200));
	}

	@Test
	public void Line通知() throws Exception {
		ResultActions result = mockServer.perform(MockMvcRequestBuilders.get("/trainInfo/line/notice/all"));

		result.andExpect(MockMvcResultMatchers.status().is(200));
	}

	@Test
	@Rollback(true)
	public void 路線削除API() throws Exception {
		mockServer.perform(MockMvcRequestBuilders.post("/trainInfo/api/notice/del")
				.param("line", "テスト"))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
}
