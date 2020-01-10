package com.si.twitterkessi.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.si.twitterkessi.ActivityCamera;
import com.si.twitterkessi.ActivityLogin;
import com.si.twitterkessi.R;
import com.si.twitterkessi.adapter.TweetAdapter;
import com.si.twitterkessi.api.ApiClass;
import com.si.twitterkessi.model.ModelTweet;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    ActivityCamera cm = new ActivityCamera();
    ActivityLogin la = new ActivityLogin();
    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate( R.layout.fragment_home, container, false );
        recyclerView = root.findViewById( R.id.HomeRV );

        loadCurrentUser();


        return root;
    }

    private void loadCurrentUser() {
        String token;
        if (la.Token.isEmpty()) {
            token = cm.token;
            //Toast.makeText(getContext(), "token " +token, Toast.LENGTH_SHORT).show();

        } else {
            token = la.Token;
            // Toast.makeText(getContext(), "token " +token, Toast.LENGTH_SHORT).show();

        }

        ApiClass usersAPI = new ApiClass();

        Call<List<ModelTweet>> userCall = usersAPI.calls().GetTweet( token );
        userCall.enqueue( new Callback<List<ModelTweet>>() {
            @Override
            public void onResponse(Call<List<ModelTweet>> call, Response<List<ModelTweet>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText( getContext(), "Code " + response.code(), Toast.LENGTH_SHORT ).show();
                    return;
                }
                List<ModelTweet> tweetMS = response.body();

                TweetAdapter tweetAdapter = new TweetAdapter( getContext(), tweetMS );
                recyclerView.setAdapter( tweetAdapter );
                recyclerView.setLayoutManager( new LinearLayoutManager( getContext() ) );
            }

            @Override
            public void onFailure(Call<List<ModelTweet>> call, Throwable t) {
                Toast.makeText( getContext(), "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT ).show();

            }
        } );


    }
}