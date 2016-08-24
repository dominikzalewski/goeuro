package com.genijusz.goeuro.devtest.io;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class DevTestExtractorStraightforward implements DevTestExtractor {

	public List<DevTestRow> extract(JSONArray inArray) {
		ArrayList<DevTestRow> result = new ArrayList<>();
		for (Object o : inArray) {
			if (o instanceof JSONObject) {
				JSONObject jObject = (JSONObject) o;
				result.add(DevTestRow.builder().withId(1).withName("").withType("").withLatitude(2.0).withLongitude(2.0)
						.build());
			}
		}
		return result;
	}

}
