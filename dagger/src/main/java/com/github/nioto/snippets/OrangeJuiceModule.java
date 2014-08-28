package com.github.nioto.snippets;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
		injects =   { Main.class}
)
class OrangeJuiceModule {
	
	@Provides Juice provideJuice(){
		return new OrangeJuice();
	}
	@Provides @Singleton MySingleton provideSingle(){
		return new MySingleton();
	}

}
