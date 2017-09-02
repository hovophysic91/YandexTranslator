package com.github.johnnysc.yandextranslator.presenter;

import com.github.johnnysc.yandextranslator.TranslatorService;
import com.github.johnnysc.yandextranslator.model.Model;
import com.github.johnnysc.yandextranslator.view.IView;

import javax.inject.Inject;

/**
 * @author Asatryan on 02.09.17.
 */

public class PresenterImpl implements Presenter {

    private IView mView;
    private Model mModel;

    @Inject
    public PresenterImpl(TranslatorService service) {
        mModel = new Model(service, this);
    }

    public void setView(IView view) {
        mView = view;
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