package com.genijusz.goeuro.devtest.io.serializer;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class DevTestSerializerModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(DevTestSerializer.class).to(DevTestSerializerJavaBased.class).in(Singleton.class);
	}

}
