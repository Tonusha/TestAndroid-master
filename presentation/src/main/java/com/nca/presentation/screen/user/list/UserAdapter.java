package com.nca.presentation.screen.user.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nca.domain.entity.UserEntity;
import com.nca.presentation.base.BaseAdapter;
import com.nca.presentation.base.BaseItemViewHolder;
import com.nca.testandroid.databinding.ItemUserBinding;

/**
 * Created by user on 02.04.2018.
 */

public class UserAdapter extends BaseAdapter<UserEntity, UserItemViewModel{

    @Override
    public BaseItemViewHolder<UserEntity, UserItemViewModel, ?> onCreateViewHolder(ViewGroup parent, int viewType) {

        return UserItemViewHolder.create(parent, new UserItemViewModel());
    }
}
