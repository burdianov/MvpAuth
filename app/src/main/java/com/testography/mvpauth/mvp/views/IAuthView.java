package com.testography.mvpauth.mvp.views;

import android.support.annotation.Nullable;

import com.testography.mvpauth.mvp.presenters.IAuthPresenter;
import com.testography.mvpauth.ui.custom_views.AuthPanel;

public interface IAuthView {

    void showMessage(String message);

    void showError(Throwable e);

    void showLoad();

    void hideLoad();

    IAuthPresenter getPresenter();

    void showLoginBtn();

    void hideLoginBtn();

    /**
     * test method which shall be deleted in due course
     */
//    void testShowLoginCard();
    @Nullable
    AuthPanel getAuthPanel();
}

