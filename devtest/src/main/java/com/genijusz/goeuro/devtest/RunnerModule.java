package com.genijusz.goeuro.devtest;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class RunnerModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Runner.class).in(Singleton.class);
	}

}
