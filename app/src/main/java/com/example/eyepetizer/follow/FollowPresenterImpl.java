package com.example.eyepetizer.follow;

/**
 * P层
 * @author popeg
 */
public class FollowPresenterImpl implements FollowPresenter {

    private FollowFragment view;

    @Override
    public void bindView(FollowFragment view) {
        this.view = view;
    }
}
