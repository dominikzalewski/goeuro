package com.genijusz.goeuro.devtest;

import static java.lang.Math.abs;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.List;

import javax.inject.Inject;

import org.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.carlosbecker.guice.GuiceModules;
import com.carlosbecker.guice.GuiceTestRunner;
import com.genijusz.goeuro.devtest.io.DevTestExtractor;
import com.genijusz.goeuro.devtest.io.DevTestIOModule;
import com.genijusz.goeuro.devtest.io.DevTestRow;

@RunWith(GuiceTestRunner.class)
@GuiceModules(DevTestIOModule.class)
public class DevTestExtractorTest {

	private static final double EPS = .00001;

	@Inject
	private DevTestExtractor extractor;

	@Test
	public void shouldCorrectlyParseSingleRowJson() {
		// given
		String jsonString = "[{\"_id\": 376217,\"name\": \"Berlin\",\"type\": \"location\",\"geo_position\": {"
				+ "\"latitude\": 52.52437, \"longitude\": 13.41053 }}]";

		// when
		JSONArray json = new JSONArray(jsonString);
		List<DevTestRow> result = extractor.extract(json);

		// then
		assertThat(result).hasSize(1);
		assertThat(result).extracting(row -> row.getId(), row -> row.getName(), row -> row.getType())
				.containsExactly(tuple(376217l, "Berlin", "location"));
		assertThat(abs(result.get(0).getLatitude() - 52.52437)).isLessThan(EPS);
		assertThat(abs(result.get(0).getLongitude() - 13.41053)).isLessThan(EPS);
	}
}
