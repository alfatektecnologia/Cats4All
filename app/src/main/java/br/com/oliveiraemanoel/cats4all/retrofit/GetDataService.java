package br.com.oliveiraemanoel.cats4all.retrofit;

import br.com.oliveiraemanoel.cats4all.model.CatCollection;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Header;


public interface GetDataService {

   @GET("gallery/search/?q=cats")

    Call <CatCollection> getAllCollection(@Header ("Authorization") String clientId);

//Credentials.basic("6c0c4345b3a49d3","988206cb25a81c7c5e740fce7db45ed4eb595612");

}
