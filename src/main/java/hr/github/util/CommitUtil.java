package hr.github.util;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class CommitUtil{
	public static List<String> getCimmitIdList(String json) throws Exception {
		List<String> list = new ArrayList<String>();
		JSONObject obj = new JSONObject(json);
		JSONArray json_ary = obj.getJSONArray("commits");
		for(int i=0; i < json_ary.length(); i++) {
			JSONObject json_obj = json_ary.getJSONObject(i);
			list.add(json_obj.getString("id"));
		}

		return list;
	}

	public static URL getCommitUrl(String json) throws Exception {
		JSONObject obj = new JSONObject(json);
		String url_string = obj.getJSONObject("repository").getString("commits_url");
		URL url = new URL(url_string);
		return url;
	}
}
