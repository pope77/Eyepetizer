package com.example.eyepetizer.notice;

/**
 * P层
 * @author popeg
 */
public class NoticePresenterImpl implements NoticePresenter {

    private NoticeFragment view;

    @Override
    public void bindView(NoticeFragment view) {
        this.view = view;
    }
}
