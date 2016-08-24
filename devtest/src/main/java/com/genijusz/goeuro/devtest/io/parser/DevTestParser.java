package com.genijusz.goeuro.devtest.io.parser;

import java.util.List;

import com.genijusz.goeuro.devtest.dto.DevTestRow;

public interface DevTestParser {
	
	List<DevTestRow> parse(String json);

}
