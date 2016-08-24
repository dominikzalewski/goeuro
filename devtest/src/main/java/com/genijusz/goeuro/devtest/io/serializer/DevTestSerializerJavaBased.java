package com.genijusz.goeuro.devtest.io.serializer;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import com.genijusz.goeuro.devtest.dto.DevTestRow;

public class DevTestSerializerJavaBased implements DevTestSerializer {

	private static final String NEW_LINE = System.getProperty("line.separator");
	private static final char CSV_SEPARATOR = ',';

	@Override
	public void serialize(List<DevTestRow> rows, Writer writer) throws IOException {
		for (DevTestRow row : rows) {
			writer.write(String.valueOf(row.getId()));
			writer.write(CSV_SEPARATOR);
			writer.write(row.getName());
			writer.write(CSV_SEPARATOR);
			writer.write(row.getType());
			writer.write(CSV_SEPARATOR);
			writer.write(String.valueOf(row.getLatitude()));
			writer.write(CSV_SEPARATOR);
			writer.write(String.valueOf(row.getLongitude()));
			writer.write(NEW_LINE);
		}
	}

}
