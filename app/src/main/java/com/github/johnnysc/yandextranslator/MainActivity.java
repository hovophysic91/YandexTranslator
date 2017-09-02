package com.github.johnnysc.yandextranslator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.johnnysc.yandextranslator.model.Model;
import com.github.johnnysc.yandextranslator.presenter.PresenterImpl;
import com.github.johnnysc.yandextranslator.view.IView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements IView, View.OnClickListener {

    @Inject
    Model mModel;

    private PresenterImpl mPresenter;

    private ProgressBar mProgressBar;
    private EditText mEditText;
    private TextView mTextView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TranslatorApp) getApplication())
                .getNetComponent()
                .inject(this);
        initUI();
        mPresenter = new PresenterImpl(this, mModel);
    }

    @Override
    public void onClick(View v) {
        String text = mEditText.getText().toString();
        if (text.length() > 0) {
            mPresenter.translateText(text);
        }
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        Toast.makeText(this, R.string.error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showTranslatedText(String translatedText) {
        mTextView.setText(translatedText);
    }

    private void initUI() {
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mEditText = (EditText) findViewById(R.id.input_edit_text);
        mTextView = (TextView) findViewById(R.id.result_text_view);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }
}