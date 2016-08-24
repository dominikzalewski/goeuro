package com.genijusz.goeuro.devtest.io.serializer;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.carlosbecker.guice.GuiceModules;
import com.carlosbecker.guice.GuiceTestRunner;
import com.genijusz.goeuro.devtest.dto.DevTestRow;

@RunWith(GuiceTestRunner.class)
@GuiceModules(DevTestSerializerModule.class)
public class DevTestSerializerTest {

	@Inject
	private DevTestSerializer serializer;

	@Test
	public void shouldSerializeEmptyListToEmptyFile() throws IOException {
		// given
		ArrayList<DevTestRow> rows = new ArrayList<>();
		StringWriter writer = new StringWriter();

		// when
		serializer.serialize(rows, writer);

		// then
		String result = writer.toString();
		assertThat(result).isEqualTo("");
	}

	@Test
	public void shouldSerializeSingleRowArrayToOneLineFile() throws IOException {
		// given
		ArrayList<DevTestRow> rows = new ArrayList<>();
		rows.add(DevTestRow.builder().withId(1l).withName("Berlin").withType("location").withLatitude(1.0)
				.withLongitude(1.0).build());
		StringWriter writer = new StringWriter();

		// when
		serializer.serialize(rows, writer);

		// then
		String result = writer.toString();
		assertThat(result).isEqualTo("1,Berlin,location,1.0,1.0\n");
	}

	@Test
	public void shouldSerializeMultiRowArrayToMultiLineFile() throws IOException {
		// given
		ArrayList<DevTestRow> rows = new ArrayList<>();
		rows.add(DevTestRow.builder().withId(1l).withName("Berlin").withType("location").withLatitude(1.0)
				.withLongitude(1.0).build());
		rows.add(DevTestRow.builder().withId(1l).withName("Berliner").withType("location").withLatitude(2.0)
				.withLongitude(2.0).build());
		StringWriter writer = new StringWriter();

		// when
		serializer.serialize(rows, writer);

		// then
		String result = writer.toString();
		assertThat(result).isEqualTo("1,Berlin,location,1.0,1.0\n1,Berliner,location,2.0,2.0\n");
	}
}
