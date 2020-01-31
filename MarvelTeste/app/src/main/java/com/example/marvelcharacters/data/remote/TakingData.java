package com.example.marvelcharacters.data.remote;

import com.example.marvelcharacters.model.pojo.CharacterResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TakingData {

    @GET ("characters?")
    Observable<CharacterResponse> getAllCharacter(
            @Query("offset")int pagina,
            @Query("orderBy") String orderBy,
            @Query("ts") String ts,
            @Query("hash") String hash,
            @Query("apikey") String apikey

    );
}
