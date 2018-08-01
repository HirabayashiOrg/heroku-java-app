package hr.github.util;

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
}
