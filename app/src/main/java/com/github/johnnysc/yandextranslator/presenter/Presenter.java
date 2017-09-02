package com.github.johnnysc.yandextranslator.presenter;

/**
 * @author Asatryan on 02.09.17.
 */

public interface Presenter {

    void showProgress();

    void hideProgress();

    void showError();

    void showTranslatedText(String translatedText);

    void translateText(String sourceText);
}