package com.nca.presentation.screen.user;

import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.graphics.Color;
import android.util.Log;
import android.widget.ImageView;

import com.nca.app.App;
import com.nca.data.repository.UserRepositoryImpl;
import com.nca.domain.entity.UserEntity;
import com.nca.domain.interactors.GetUserByIdUseCase;
import com.nca.executor.UIThread;
import com.nca.presentation.base.BaseViewModel;
import com.nca.testandroid.utils.MyAppGlideModule;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserViewModel extends BaseViewModel {

    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    @Inject
    public GetUserByIdUseCase getUserByIdUseCase;


    //GetUserByIdUseCase getUserByIdUseCase = new GetUserByIdUseCase(new UIThread(), new UserRepositoryImpl());

    public ObservableInt background = new ObservableInt(Color.WHITE);

    public ObservableField<String> firstName = new ObservableField<>("");
    public ObservableField<String> lastName = new ObservableField<>("");
    public ObservableField<String> fatherName = new ObservableField<>("");
    public ObservableInt age = new ObservableInt();
    public ObservableBoolean isMan = new ObservableBoolean();
    public ObservableField<String> imageUrl = new ObservableField<>("");
    public ObservableBoolean progressVisible = new ObservableBoolean(false);

//    private ArrayList<UserEntity> users = new ArrayList<>();

    public CompositeDisposable compositeDisposable = new CompositeDisposable();

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String url) {
        MyAppGlideModule.showImage(view.getContext(), url, view);
    }

    public UserViewModel() {

//            users.add(new UserEntity("Никита", "Кожемяка", "из богатырей", 33, true, "http://oldtale.ru/images/nikita-kojemyaka.jpg"));
//            users.add(new UserEntity("Варвара", "Краса", "длинная коса", 18, false, "http://tv.akado.ru/images/data/akadotv/picture/imgbig/468702/1.jpg"));
//            users.add(new UserEntity("Словей", "Разбойник", "бандит", 100, true, "http://www.bestiary.us/files/images/solovey-by-orlova.250x250.jpg"));

        getUserByIdUseCase.get("F2DEB8C5-C0FE-30C1-FF5E-F52C286FFF00").subscribe(new Observer<UserEntity>() {
                @Override
                public void onSubscribe(Disposable d) {
                    Log.e("AAA", "onSubscribe");
                    compositeDisposable.add(d);
                }

            @Override
            public void onNext(UserEntity userEntity) {
                Log.e("AAA", "onNext");
                firstName.set(userEntity.getFirstName());
                lastName.set(userEntity.getLastName());
                fatherName.set(userEntity.getFatherName());
                age.set(userEntity.getAge());
//                isMan.set(userEntity.get(3).isMan());
//                imageUrl.set(userEntity.getImageUrl());
                imageUrl.set(userEntity.getImageUrl());
            }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("AAA", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("AAA", "onComplete");
                        progressVisible.set(false);
                    }

    });
//        getUserByIdUseCase.get().subscribe(new Observer<List<UserEntity>>() {
//                @Override
//                public void onSubscribe(Disposable d) {
//                    Log.e("AAA", "onSubscribe");
//                    compositeDisposable.add(d);
//                }
//
//            @Override
//            public void onNext(List<UserEntity> userEntity) {
//                Log.e("AAA", "onNext");
//                firstName.set(userEntity.get(0).getFirstName());
//                lastName.set(userEntity.get(0).getLastName());
//                fatherName.set(userEntity.get(0).getFatherName());
//                age.set(userEntity.get(0).getAge());
////                isMan.set(userEntity.get(3).isMan());
////                imageUrl.set(userEntity.getImageUrl());
//                imageUrl.set(userEntity.get(0).getImageUrl());
//            }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("AAA", "onError");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.e("AAA", "onComplete");
//                        progressVisible.set(false);
//                    }
//
//        });

    }

}
