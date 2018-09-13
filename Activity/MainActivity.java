package com.example.karanc.daggerexample.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.karanc.daggerexample.Adapter.RandomUserAdapter;
import com.example.karanc.daggerexample.Interfaces.MainActivityComponent;
import com.example.karanc.daggerexample.Interfaces.DaggerMainActivityComponent;
import com.example.karanc.daggerexample.Modules.MainActivityModule;
import com.example.karanc.daggerexample.POJO.RandomUsers;
import com.example.karanc.daggerexample.R;
import com.example.karanc.daggerexample.Application.RandomUserApplication;
import com.example.karanc.daggerexample.Interfaces.RandomUsersApi;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();


    RecyclerView recyclerView;
   @Inject
   RandomUserAdapter randomUserAdapter;
   @Inject
   RandomUsersApi randomUsersApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        afterActivityLevelCompo();
        populateUsers();
    }


    private void initViews() {
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void afterActivityLevelCompo() {
    MainActivityComponent mainActivityComponent = DaggerMainActivityComponent.builder()
            .mainActivityModule(new MainActivityModule(this))
            .randomUserComponent(RandomUserApplication.get(this).getRandomUserComponent())
            .build();
    mainActivityComponent.inject(this);
    }

    private void populateUsers() {
        Call<RandomUsers> randomUsersCall = getRandomUserService().getRandomUsers(10);
        randomUsersCall.enqueue(new Callback<RandomUsers>() {
            @Override
            public void onResponse(Call<RandomUsers> call, Response<RandomUsers> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    randomUserAdapter.setItems(response.body().getResults());
                    recyclerView.setAdapter(randomUserAdapter);
                }
            }

            @Override
            public void onFailure(Call<RandomUsers> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    public RandomUsersApi getRandomUserService() {
        return randomUsersApi;
    }
}
