package com.genijusz.goeuro.devtest;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;

import com.genijusz.goeuro.devtest.dto.DevTestRow;
import com.genijusz.goeuro.devtest.io.parser.DevTestParser;
import com.genijusz.goeuro.devtest.io.serializer.DevTestSerializer;

public class Runner {

	private static final String BASE_URL = "http://api.goeuro.com/api/v2/position/suggest/en/";

	@Inject
	private DevTestParser parser;
	@Inject
	private DevTestSerializer serializer;

	public void run(String query) throws MalformedURLException, IOException {
		String jsonString = IOUtils.toString(new URL(BASE_URL + query), (Charset) null);
		List<DevTestRow> rows = parser.parse(jsonString);
		Writer writer = new OutputStreamWriter(System.out);
		serializer.serialize(rows, writer);
		writer.flush();
	}

}
