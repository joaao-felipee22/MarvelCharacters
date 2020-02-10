package com.example.marvelcharacters.repository;


import com.example.marvelcharacters.model.pojo.character.CharacterResponse;
import com.example.marvelcharacters.model.pojo.hq.HqResponse;

import io.reactivex.Observable;

import static com.example.marvelcharacters.data.remote.Retrofit.getApiService;

public class RespositoryApi {
    public Observable<CharacterResponse> getCharacterResponse (int offset,
                                                               String orderBy,
                                                               String ts,
                                                               String hash,
                                                               String apikey){

        return getApiService().getAllCharacter(offset, orderBy, ts, hash, apikey);
    }

    public Observable<HqResponse> getHQResponse (int offset,
                                                 String ts,
                                                 String hash,
                                                 String apikey, Long characterId){

        return getApiService().getComicId(characterId, offset, ts, hash, apikey);
    }
}
