package br.com.oliveiraemanoel.cats4all.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.oliveiraemanoel.cats4all.R;
import br.com.oliveiraemanoel.cats4all.adapters.CatsAdapter;
import br.com.oliveiraemanoel.cats4all.model.CatCollection;
import br.com.oliveiraemanoel.cats4all.model.Data;
import br.com.oliveiraemanoel.cats4all.model.Images;
import br.com.oliveiraemanoel.cats4all.retrofit.GetDataService;
import br.com.oliveiraemanoel.cats4all.retrofit.RetrofitCatInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CatsAdapter catsAdapter;
    private List<Data> dataList = new ArrayList<>();
    private Images images;
    private final List<String> catCollectionListUrl = new ArrayList<>();
    private final List<List<Images>> catImagesList = new ArrayList<>();
    private List<Object> catImages = new ArrayList<>();
    private ProgressDialog progressDialog;

    @Override
    protected void onStart() {
        super.onStart();
       if(!hasInternet()){
           Toast.makeText(getApplicationContext(),"Verifique sua conexão com a internet!",Toast.LENGTH_LONG).show();
       }
    }
    //checking if exist an internet connection
    private boolean hasInternet(){

            ConnectivityManager connectivityManager
                    = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recyclerview instance
        RecyclerView recyclerView = findViewById(R.id.rvCat);

        //retrofit
        GetDataService getDataService =
                RetrofitCatInstance.getRetrofitInstance().create(GetDataService.class);
        //access_token=a87c0eaf0cf72719a3e47a6a762e422c71335c32
        Call<CatCollection> call = getDataService.getAllCollection("Client-ID 6c0c4345b3a49d3");
        call.enqueue(new Callback<CatCollection>() {
            @Override
            public void onResponse(Call<CatCollection> call, Response<CatCollection> response) {

                assert response.body() != null;
                dataList =  response.body().getData();
              //checking is exist a valid response
             if(dataList!=null){
                 int i=0;
                 do {
                    try {
                        catImagesList.add(dataList.get(i).getImages());
                    }catch (Exception e){
                        Log.d("TRY_CATCHING_CAT_IMAGES",e.toString());
                    }
                     i++;
                 }while (i < dataList.size());
                 //populating urlList used in recyclerview
                 for ( int t=0;t<catImagesList.size();t++){

                     try {
                        //only images file is added to the list of imageUrl
                        if (catImagesList.get(t).get(0).getType().contains("jpeg")) {
                             catCollectionListUrl.add(catImagesList.get(t).get(0).getLink());
                         }
                      //todo recognation images avoiding all images other than cats
                     }catch (Exception e){
                         Log.d("TRY_POPULATING_URL_IMAGES",e.toString());
                     }
                 }

             }
             //refreshing adapter
                catsAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<CatCollection> call, Throwable t) {
                Log.d("GETTING_IMAGES",t.toString());

                Toast.makeText(MainActivity.this,
                        "Something went wrong...Please try later!",
                        Toast.LENGTH_SHORT).show();

            }


        });

        //setting adapter and recyclerview
        catsAdapter = new CatsAdapter(getApplicationContext(),catCollectionListUrl);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),4));
        recyclerView.setAdapter(catsAdapter);


    }

}