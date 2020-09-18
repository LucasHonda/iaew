package sttsoft.com.br.iaew.Models.retrofit;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface service {

    @POST("authentication")
    Call<ResponseBody> login(@Body RequestBody body);
}
