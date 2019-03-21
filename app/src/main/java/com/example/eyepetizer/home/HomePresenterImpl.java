package com.example.eyepetizer.home;

/**
 * P层
 * @author popeg
 */
public class HomePresenterImpl implements HomePresenter {

    private HomeView view;
    private HomeInteractor interactor;

    HomePresenterImpl(HomeInteractor interactor){
        this.interactor = interactor;
    }

    @Override
    public void bindView(HomeView view) {
        this.view = view;
    }

    @Override
    public void getData() {
        interactor.getData(new HomeInteractor.OnDataCallback() {
            @Override
            public void onGetSuccess(String data) {
                view.loadData(data);
            }

            @Override
            public void onGetFailes(String errorMsg) {
            }
        });
    }
}
