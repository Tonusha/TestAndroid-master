package com.nca.presentation.screen.user.list;

import android.databinding.ObservableField;

import com.nca.data.entity.User;
import com.nca.presentation.base.BaseItemViewModel;

/**
 * Created by user on 02.04.2018.
 */

public class UserItemViewModel extends BaseItemViewModel<User> {

    @Override
    public void setItem(User user, int position) {
        name.set(user.getUsername());
        age.set(String.valueOf(user.getAge()));
    }

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> age = new ObservableField<>("");
}
