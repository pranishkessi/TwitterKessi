package com.si.twitterkessi.api;


import com.si.twitterkessi.model.ModelSignUpResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBLL {

    boolean isSuccess = false;
  public static   String Token;

    public boolean checkUser(String username, String password) {

        ApiClass usersAPI = new ApiClass();
               // Url.getInstance().create(UsersAPI.class);
        Call<ModelSignUpResponse> usersCall = usersAPI.calls().checkUser(username, password);

        try {
            Response<ModelSignUpResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful() &&
                    loginResponse.body().getStatus().equals("Login success!")) {
                        ModelSignUpResponse signUpResponse=loginResponse.body();
                        Token=signUpResponse.getToken();


                // Url.Cookie = imageResponseResponse.headers().get("Set-Cookie");
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
