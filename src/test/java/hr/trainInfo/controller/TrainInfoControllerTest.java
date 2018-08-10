package hr.trainInfo.controller;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest
public class TrainInfoControllerTest extends Assert {
	@Rule
	public ExpectedException exprctException = ExpectedException.none();

	@Autowired
	TrainInfoController trainInfoController;

}
