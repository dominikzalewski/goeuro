package com.genijusz.goeuro.devtest.io.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.genijusz.goeuro.devtest.dto.DevTestRow;

public class DevTestParserJSONObjectBased implements DevTestParser {

	public List<DevTestRow> parse(String json) {
		try {
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
		} catch (JSONException ex) {
			throw new DevTestParseException();
		}
	}

}
