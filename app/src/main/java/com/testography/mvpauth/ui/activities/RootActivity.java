package com.testography.mvpauth.ui.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.testography.mvpauth.BuildConfig;
import com.testography.mvpauth.R;
import com.testography.mvpauth.mvp.presenters.AuthPresenter;
import com.testography.mvpauth.mvp.presenters.IAuthPresenter;
import com.testography.mvpauth.mvp.views.IAuthView;
import com.testography.mvpauth.ui.custom_views.AuthPanel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RootActivity extends AppCompatActivity implements IAuthView, View.OnClickListener {

    AuthPresenter mPresenter = AuthPresenter.getInstance();

    @BindView(R.id.coordinator_container)
    CoordinatorLayout mCoordinatorLayout;

    @BindView(R.id.auth_wrapper)
    AuthPanel mAuthPanel;

    @BindView(R.id.show_catalog_btn)
    Button mShowCatalogBtn;

    @BindView(R.id.login_btn)
    Button mLoginBtn;

//    @BindView(R.id.auth_card)
//    CardView mAuthCard;

    //region ==================== Life cycle ================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
        ButterKnife.bind(this);
        mPresenter.takeView(this);
        mPresenter.initView();

        mLoginBtn.setOnClickListener(this);
        mShowCatalogBtn.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.dropView();
        super.onDestroy();
    }

    //endregion

    //region ==================== IAuthView ===============

    @Override
    public void showMessage(String message) {
        Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showError(Throwable e) {
        if (BuildConfig.DEBUG) {
            showMessage(e.getMessage());
            e.printStackTrace();
        } else {
            showMessage("Sorry, something went wrong! Try again later");
            // TODO: 21-Oct-16 send error stacktrace to crashlist
        }
    }

    @Override
    public void showLoad() {
        // TODO: 21-Oct-16 show load progress
    }

    @Override
    public void hideLoad() {
        // TODO: 21-Oct-16 hide load progress
    }

    @Override
    public IAuthPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void showLoginBtn() {
        mLoginBtn.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoginBtn() {
        mLoginBtn.setVisibility(View.GONE);
    }

//    @Override
//    public void testShowLoginCard() {
//        mAuthCard.setVisibility(View.VISIBLE);
//    }

    @Override
    public AuthPanel getAuthPanel() {
        return mAuthPanel;
    }

    //endregion


    @Override
    public void onBackPressed() {
        if (!mAuthPanel.isIdle()) {
            mAuthPanel.setCustomState(AuthPanel.IDLE_STATE);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.show_catalog_btn:
                mPresenter.clickOnShowCatalog();
                break;
            case R.id.login_btn:
                mPresenter.clickOnLogin();
                break;
        }
    }
}
