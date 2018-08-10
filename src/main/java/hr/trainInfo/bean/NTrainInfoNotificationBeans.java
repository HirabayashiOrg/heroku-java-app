package hr.trainInfo.bean;

import java.util.List;
import java.util.stream.Collectors;

public class NTrainInfoNotificationBeans {
	private static final String LF = "\n";

	// 路線と運行情報が同じかチェックする
	public static boolean isSameInfo(NTrainInfoNotificationBean bean1, NTrainInfoNotificationBean bean2) {
		boolean diff_line = bean1.getLine().equals(bean2.getLine());
		boolean diff_info = false;
		// どちらか片方でもNULLだったら違うと見なす
		if(bean1.getInfo()==null || bean2.getInfo() == null) {
			diff_info = false;
		} else {
			diff_info = bean1.getInfo().equals(bean2.getInfo());
		}

		return diff_line && diff_info;
	}
	// 路線が同じで違う運行情報かどうかチェックする
	public static boolean isSameLineDiffInfo(NTrainInfoNotificationBean bean1, NTrainInfoNotificationBean bean2) {
		boolean same_line = bean1.getLine().equals(bean2.getLine());
		boolean diff_info = false;
		// どちらか片方でもNULLだったら違うと見なす
		if(bean1.getInfo()==null || bean2.getInfo() == null) {
			diff_info = true;
		} else {
			diff_info = !bean1.getInfo().equals(bean2.getInfo());
		}

		return same_line && diff_info;
	}
	// ライン通知用にメッセージを作成する
	public static String createMessage(List<NTrainInfoNotificationBean> list) {
		String url = "https://hr-heroku-java-app.herokuapp.com/trainInfo/info/list";
		String message = list.stream()
			.map(bean -> createMessage(bean))
			.collect(Collectors.joining(LF));
		message += LF + "▼運行情報一覧" + LF + url;
		return message;
	}
	public static String createMessage(NTrainInfoNotificationBean bean) {
		String message = "";
		message += bean.getLine() + LF;
		message += "▷ " + bean.getInfo();
		return message;
	}
}
