package app.lottery.com.lotteryapp.api;
import java.util.Map;

import app.lottery.com.lotteryapp.constant.Apis;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Author: Othershe
 * Time: 2017/6/12 20:56
 */

public interface ResultService {
    String BASE_URL = Apis.URL_RESULT_ITEM;

    @GET("50")
    Observable<String> getResultsItemData(@QueryMap Map<String, String> map);
}
