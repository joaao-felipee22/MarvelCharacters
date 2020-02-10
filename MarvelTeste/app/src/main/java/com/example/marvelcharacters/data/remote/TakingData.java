package com.example.marvelcharacters.data.remote;

import com.example.marvelcharacters.model.pojo.character.CharacterResponse;
import com.example.marvelcharacters.model.pojo.hq.HqResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TakingData {

    @GET ("characters?")
    Observable<CharacterResponse> getAllCharacter(
            @Query("offset")int offset,
            @Query("orderBy") String orderBy,
            @Query("ts") String ts,
            @Query("hash") String hash,
            @Query("apikey") String apikey

    );

    @GET("characters/{characterId}/comics?")
    Observable<HqResponse> getComicId(
            @Path("characterId") Long id,
            @Query("offset")int offset,
            @Query("ts") String ts,
            @Query("hash") String hash,
            @Query("apikey") String apikey
    );
}
