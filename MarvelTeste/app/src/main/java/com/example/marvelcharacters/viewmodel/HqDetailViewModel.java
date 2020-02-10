package com.example.marvelcharacters.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.marvelcharacters.model.pojo.hq.ResultHQ;
import com.example.marvelcharacters.repository.RespositoryApi;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.example.marvelcharacters.useful.AppUseful.md5;

public class HqDetailViewModel extends AndroidViewModel {
    private MutableLiveData<List<ResultHQ>> resultMutableLiveData = new MutableLiveData<>();
    private RespositoryApi respositoryApi = new RespositoryApi();
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private MutableLiveData<String> liveDataError = new MutableLiveData<>();
    public static final String PUBLIC_KEY = "fe81c0a4bd6c7f00e3df25d68d8d8a92";
    public static final String PRIVATE_KEY = "ceac13aef2089eaf3c704ba9da60cf2156b60912";
    String ts = Long.toString(System.currentTimeMillis() / 1000);
    String hash = md5(ts + PRIVATE_KEY + PUBLIC_KEY);
    private int offset = 1;

    public HqDetailViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<List<ResultHQ>> getMutable(){
        return this.resultMutableLiveData;
    }
    public LiveData<Boolean> getLoading(){
        return this.loading;
    }
    public LiveData<String> getError(){
        return this.liveDataError;
    }

    public void getHqApi(Long characterId){
        disposable.add(
                respositoryApi.getHQResponse(offset, ts, hash, PUBLIC_KEY, characterId)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loading.setValue(true))
                        .doOnTerminate(() -> loading.setValue(false))
                        .subscribe(hqResponse -> resultMutableLiveData.setValue(hqResponse.getData().getResults())
                                ,throwable -> Log.i("LOG", "ERROR: " + throwable.getMessage())
        ));
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
