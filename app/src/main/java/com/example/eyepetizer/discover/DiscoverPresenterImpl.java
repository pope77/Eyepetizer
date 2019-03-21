package com.example.eyepetizer.discover;

/**
 * P层
 * @author popeg
 */
public class DiscoverPresenterImpl implements DiscoverPresenter {

    private DiscoverFragment view;
    private DiscoverInteractor interactor;

    DiscoverPresenterImpl(DiscoverInteractor interactor){
        this.interactor = interactor;
    }

    @Override
    public void bindView(DiscoverFragment view) {
        this.view = view;
    }
}
