package com.genijusz.goeuro.devtest.io.serializer;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import com.genijusz.goeuro.devtest.dto.DevTestRow;

public class DevTestSerializerJavaBased implements DevTestSerializer {

	@Override
	public void serialize(List<DevTestRow> rows, Writer writer) throws IOException {
		for (DevTestRow row : rows) {
			writer.write(String.valueOf(row.getId()));
			writer.write(',');
			writer.write(row.getName());
			writer.write(',');
			writer.write(row.getType());
			writer.write(',');
			writer.write(String.valueOf(row.getLatitude()));
			writer.write(',');
			writer.write(String.valueOf(row.getLongitude()));
			writer.write("\n");
		}
	}

}
