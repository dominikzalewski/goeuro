package com.genijusz.goeuro.devtest.io.serializer;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import com.genijusz.goeuro.devtest.dto.DevTestRow;

public interface DevTestSerializer {
	void serialize(List<DevTestRow> rows, Writer writer) throws IOException;
}
