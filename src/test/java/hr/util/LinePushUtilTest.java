package hr.util;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import hr.line.uril.LinePushUtil;

public class LinePushUtilTest {
	@Rule
	public ExpectedException exceptedException = ExpectedException.none();

	@Test
	public void 設定値の取得() throws Exception {
		String token = System.getenv("linebot.token");
		// System.out.println(token);
		if(token == null || token.length() == 0) {
			throw new Exception();
		}
	}

	@Test
	public void トークン取得() throws Exception {
		String token = LinePushUtil.getToken();
		if(token == null || token.length() == 0) {
			throw new Exception();
		}
	}

	@Test
	public void LINE通知() throws Exception {
		LinePushUtil.sendMessage(LinePushUtil.TO_RYO, "テスト");
	}
}
