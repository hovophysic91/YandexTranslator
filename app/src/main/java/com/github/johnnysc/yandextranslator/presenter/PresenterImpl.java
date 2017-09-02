package com.github.johnnysc.yandextranslator.presenter;

import com.github.johnnysc.yandextranslator.RestManager;
import com.github.johnnysc.yandextranslator.model.Model;
import com.github.johnnysc.yandextranslator.view.IView;

/**
 * @author Asatryan on 02.09.17.
 */

public class PresenterImpl implements Presenter {

    private final IView mView;
    private final Model mModel;

    public PresenterImpl(IView view) {
        mView = view;
        mModel = new Model(this, new RestManager());
    }

    @Override
    public void showProgress() {
        mView.showProgress();
    }

    @Override
    public void hideProgress() {
        mView.hideProgress();
    }

    @Override
    public void showError() {
        mView.showError();
    }

    @Override
    public void showTranslatedText(String translatedText) {
        mView.showTranslatedText(translatedText);
    }

    @Override
    public void translateText(String sourceText) {
        mModel.translateText(sourceText);
    }
}