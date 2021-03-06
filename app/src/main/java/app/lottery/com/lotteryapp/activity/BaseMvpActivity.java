package app.lottery.com.lotteryapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import app.lottery.com.lotteryapp.presenter.BasePresenter;

/**
 * Author: Othershe
 * Time:  2016/8/11 11:14
 */
public abstract class BaseMvpActivity extends BaseActivity {

    protected List<BasePresenter> mPresenters = new ArrayList<>();

    protected abstract void fetchData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fetchData();
    }

    protected void addPresenter(BasePresenter presenter) {
        mPresenters.add(presenter);
    }

    @Override
    protected void onDestroy() {
        for (BasePresenter p : mPresenters) {
            p.detach();
        }
        super.onDestroy();
    }
}
