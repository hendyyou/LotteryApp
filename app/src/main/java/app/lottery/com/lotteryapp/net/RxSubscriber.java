package app.lottery.com.lotteryapp.net;

import android.content.Context;
import android.widget.Toast;

import java.io.IOException;

import app.lottery.com.lotteryapp.App;
import rx.Subscriber;

/**
 * Author: Othershe
 * Time:  2016/8/11 17:45
 */
public abstract class RxSubscriber<T> extends Subscriber<T> {
    private Context mContext;

    public RxSubscriber() {
        mContext = App.getContext();
    }

    @Override
    public void onCompleted() {
        cancelLoading();
    }

    @Override
    public void onError(Throwable e) {
        //统一处理请求异常的情况
        if (e instanceof IOException) {
            Toast.makeText(mContext, "网络链接异常", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        _onError();

        cancelLoading();
    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    private void cancelLoading() {

    }

    protected abstract void _onNext(T t);

    protected abstract void _onError();

}
