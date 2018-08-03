package hr.line.uril;

import org.springframework.beans.factory.annotation.Value;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;

public class LinePushUtil {
	@Value("${linebot.token}")
	public static String TOKEN;

	public static String TO_RYO = "U4e19ea3aed98d90d540a6448ee11c75b";
	public static String TO_EMI = "U4c6d03a8943e9a4ca2de37de5e9fee32";


	public static void sendMessage(String to, String message) throws Exception {
		LineMessagingClient client = LineMessagingClient.builder(TOKEN)
				.build();
		// 送信するテキストに関する定義
		TextMessage textMessage = new TextMessage(message);
		PushMessage pushMessage = new PushMessage(to, textMessage);
		// テキスト送信
		BotApiResponse botApiResponse = client.pushMessage(pushMessage).get();
	}
}