package com.github.johnnysc.yandextranslator;

import android.app.Application;

import com.github.johnnysc.yandextranslator.dagger.AppModule;
import com.github.johnnysc.yandextranslator.dagger.DaggerNetComponent;
import com.github.johnnysc.yandextranslator.dagger.NetComponent;
import com.github.johnnysc.yandextranslator.dagger.NetModule;

/**
 * @author Asatryan on 02.09.17.
 */

public class TranslatorApp extends Application {

    private static final String BASE_URL = "https://translate.yandex.net/";
    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(BASE_URL))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}