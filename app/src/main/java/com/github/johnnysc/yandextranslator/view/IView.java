package com.github.johnnysc.yandextranslator.view;

/**
 * @author Asatryan on 02.09.17.
 */

public interface IView {

    void showProgress();

    void hideProgress();

    void showError();

    void showTranslatedText(String translatedText);
}