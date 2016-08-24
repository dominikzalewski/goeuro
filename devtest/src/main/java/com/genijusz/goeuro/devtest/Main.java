package com.genijusz.goeuro.devtest;

import java.io.IOException;
import java.net.MalformedURLException;

import com.genijusz.goeuro.devtest.io.parser.DevTestParserModule;
import com.genijusz.goeuro.devtest.io.serializer.DevTestSerializerModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
	public static void main(String[] args) throws MalformedURLException, IOException {
		Injector injector = Guice.createInjector(new DevTestParserModule(), new DevTestSerializerModule(),
				new RunnerModule());
		Runner runner = injector.getInstance(Runner.class);
		runner.run(args[0]);
	}
}
