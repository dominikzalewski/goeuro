package com.genijusz.goeuro.devtest.io;

import java.util.List;

import org.json.JSONArray;

public interface DevTestExtractor {
	
	List<DevTestRow> extract(String json);

}
