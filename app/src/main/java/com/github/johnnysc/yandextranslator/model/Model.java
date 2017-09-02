package com.github.johnnysc.yandextranslator.model;

import com.github.johnnysc.yandextranslator.RestManager;
import com.github.johnnysc.yandextranslator.TranslatedText;
import com.github.johnnysc.yandextranslator.presenter.Presenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Asatryan on 02.09.17.
 */

public class Model {

    private static final String KEY = "trnsl.1.1.20170426T135336Z.48d648f8f882d563.d40bb959b17363f2bee9e4a816f36ca997ce55c2";
    private static final String LANG = "en-ru";
    private static final String FORMAT = "plain";
    private static final String OPTIONS = "1";

    private final RestManager mRestManager;
    private final Presenter mPresenter;

    public Model(Presenter presenter, RestManager restManager) {
        mPresenter = presenter;
        mRestManager = restManager;
    }

    public void translateText(String sourceText) {
        mPresenter.showProgress();

        Call<TranslatedText> textCall = mRestManager.getService().getText(KEY, sourceText, LANG, FORMAT, OPTIONS);
        textCall.enqueue(new Callback<TranslatedText>() {
            @Override
            public void onResponse(Call<TranslatedText> call, Response<TranslatedText> response) {
                mPresenter.hideProgress();
                if (response.isSuccessful()) {
                    TranslatedText finalText = response.body();
                    String result = finalText.getText().get(0);
                    mPresenter.showTranslatedText(result);
                } else {
                    mPresenter.showError();
                }
            }

            @Override
            public void onFailure(Call<TranslatedText> call, Throwable t) {
                mPresenter.hideProgress();
                mPresenter.showError();
            }
        });
    }
}