package com.genijusz.goeuro.devtest.dto;

public class DevTestRow {

	private long id;
	private String name;
	private String type;
	private double latitude;
	private double longitude;

	public DevTestRow(long id, String name, String type, double latitude, double longitude) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private long id;
		private String name;
		private String type;
		private double latitude;
		private double longitude;

		public Builder withId(long id) {
			this.id = id;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withType(String type) {
			this.type = type;
			return this;
		}

		public Builder withLatitude(double latitude) {
			this.latitude = latitude;
			return this;
		}

		public Builder withLongitude(double longitude) {
			this.longitude = longitude;
			return this;
		}

		public DevTestRow build() {
			return new DevTestRow(id, name, type, latitude, longitude);
		}
	}
}
