package com.genijusz.goeuro.devtest;

import static java.lang.Math.abs;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.List;

import javax.inject.Inject;

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
	public void shouldParseSingleRowJson() {
		// given
		String jsonString = "[{\"_id\": 376217,\"name\": \"Berlin\",\"type\": \"location\",\"geo_position\": {"
				+ "\"latitude\": 52.52437, \"longitude\": 13.41053 }}]";

		// when
		List<DevTestRow> result = extractor.extract(jsonString);

		// then
		assertThat(result).hasSize(1);
		assertThat(result).extracting(row -> row.getId(), row -> row.getName(), row -> row.getType())
				.containsExactly(tuple(376217l, "Berlin", "location"));
		verifyGeolocation(result.get(0), 52.52437, 13.41053);
	}

	@Test
	public void shouldNotFailOnEmptyArray() {
		// given
		String jsonString = "[]";

		// when
		List<DevTestRow> result = extractor.extract(jsonString);

		// then
		assertThat(result).isEmpty();
	}

	@Test
	public void shouldParseMultiRowJson() {
		// given
		String jsonString = "[{\"_id\": 376217,\"name\": \"Berlin\",\"type\": \"location\",\"geo_position\": {\"latitude\": 52.52437, \"longitude\": 13.41053 }},"
				+ "{\"_id\": 425332,\"name\": \"Berlingerode\" , \"type\": \"location\",\"geo_position\": {\"latitude\": 51.45775, \"longitude\": 10.2384 }}]";

		// when
		List<DevTestRow> result = extractor.extract(jsonString);

		// then
		assertThat(result).hasSize(2);
		assertThat(result).extracting(row -> row.getId(), row -> row.getName(), row -> row.getType())
				.containsExactly(tuple(376217l, "Berlin", "location"), tuple(425332l, "Berlingerode", "location"));
		verifyGeolocation(result.get(0), 52.52437, 13.41053);
		verifyGeolocation(result.get(1), 51.45775, 10.2384);
	}
	
	private void shouldHandleUTF8Chars() {
		//TODO
	}

	private void verifyGeolocation(DevTestRow actual, double expectedLatitude, double expectedLongitude) {
		assertThat(abs(actual.getLatitude() - expectedLatitude)).isLessThan(EPS);
		assertThat(abs(actual.getLongitude() - expectedLongitude)).isLessThan(EPS);
	}

}
