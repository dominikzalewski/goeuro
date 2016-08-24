package com.genijusz.goeuro.devtest.io.parser;

import java.util.List;

import org.json.JSONArray;

import com.genijusz.goeuro.devtest.dto.DevTestRow;

public interface DevTestParser {
	
	List<DevTestRow> extract(String json);

}
