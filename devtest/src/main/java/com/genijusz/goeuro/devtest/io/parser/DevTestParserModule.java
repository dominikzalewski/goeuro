package com.genijusz.goeuro.devtest.io.parser;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class DevTestParserModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(DevTestParser.class).to(DevTestParserJSONObjectBased.class).in(Singleton.class);
		
	}

}
