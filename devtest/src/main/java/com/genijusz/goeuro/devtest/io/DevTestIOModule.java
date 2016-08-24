package com.genijusz.goeuro.devtest.io;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class DevTestIOModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(DevTestExtractor.class).to(DevTestExtractorStraightforward.class).in(Singleton.class);
		
	}

}
