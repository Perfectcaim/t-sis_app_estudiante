package pe.edu.upc.t_sis_app_estudiante.viewcontrollers.Interface;

import pe.edu.upc.t_sis_app_estudiante.models.Student;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Query;
import android.content.Context;
import android.content.SharedPreferences;

public interface StudentInterface {
    @Headers("Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==")
    @POST("/V2/api/student")
    void RegisterStudent(@Body Student student, Callback<Student> callback);

    @Headers("Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==")
    @POST("/V2/api/login/student")
    void LoginUser(@Body Student student, Callback<Student> callback);
}
