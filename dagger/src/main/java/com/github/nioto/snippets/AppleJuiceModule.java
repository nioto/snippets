package com.github.nioto.snippets;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
		injects =   { Main.class}
)
class AppleJuiceModule {
	
	@Provides Juice provideJuice(){
		return new AppleJuice();
	}
	@Provides @Singleton MySingleton provideSingle(){
		return new MySingleton();
	}

}
