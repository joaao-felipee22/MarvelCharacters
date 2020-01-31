package com.example.marvelcharacters.repository;


import com.example.marvelcharacters.model.pojo.CharacterResponse;

import io.reactivex.Observable;

import static com.example.marvelcharacters.data.remote.Retrofit.getApiService;

public class CharacterRespository {
    public Observable<CharacterResponse> getCharacterResponse (int pagina,
                                                               String orderBy,
                                                               String ts,
                                                               String hash,
                                                               String apikey){

        return getApiService().getAllCharacter(pagina, orderBy, ts, hash, apikey);
    }
}
