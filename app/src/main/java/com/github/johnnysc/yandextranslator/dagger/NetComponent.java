package com.github.johnnysc.yandextranslator.dagger;

import com.github.johnnysc.yandextranslator.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Asatryan on 02.09.17.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

    void inject(MainActivity activity);
}