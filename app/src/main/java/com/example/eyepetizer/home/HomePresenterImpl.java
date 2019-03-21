package com.example.eyepetizer.home;

/**
 * P层
 * @author popeg
 */
public class HomePresenterImpl implements HomePresenter {

    private HomeFragment view;

    @Override
    public void bindView(HomeFragment view) {
        this.view = view;
    }
}
