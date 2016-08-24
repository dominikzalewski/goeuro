package com.genijusz.goeuro.devtest.io;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class DevTestExtractorStraightforward implements DevTestExtractor {

	public List<DevTestRow> extract(String json) {
		JSONArray inArray = new JSONArray(json);
		ArrayList<DevTestRow> result = new ArrayList<>();
		for (Object o : inArray) {
			if (o instanceof JSONObject) {
				JSONObject jObject = (JSONObject) o;
				JSONObject geolocation = jObject.getJSONObject("geo_position");

				result.add(DevTestRow.builder().withId(jObject.getLong("_id")).withName(jObject.getString("name"))
						.withType(jObject.getString("type")).withLatitude(geolocation.getDouble("latitude"))
						.withLongitude(geolocation.getDouble("longitude")).build());
			}
		}
		return result;
	}

}
