package com.example.eyepetizer.community;

/**
 * P层
 * @author popeg
 */
public class CommunityPresenterImpl implements CommunityPresenter {

    private CommunityFragment view;
    private CommunityInteractor interactor;

    CommunityPresenterImpl(CommunityInteractor interactor){
        this.interactor = interactor;
    }

    @Override
    public void bindView(CommunityFragment view) {
        this.view = view;
    }
}
