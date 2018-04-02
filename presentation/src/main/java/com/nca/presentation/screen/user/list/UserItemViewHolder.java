package com.nca.presentation.screen.user.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nca.domain.entity.UserEntity;
import com.nca.presentation.base.BaseItemViewHolder;
import com.nca.presentation.screen.user.UserViewModel;
import com.nca.testandroid.databinding.ItemUserBinding;

/**
 * Created by user on 02.04.2018.
 */

public class UserItemViewHolder extends BaseItemViewHolder<UserEntity,
        UserItemViewModel,
        ItemUserBinding> {

    public UserItemViewHolder(ItemUserBinding buinding, UserItemViewModel viewModel) {
        super(buinding, viewModel);
    }

    public static UserItemViewHolder create(ViewGroup parent, UserItemViewModel viewModel){
        ItemUserBinding binding = ItemUserBinding.inflate(
                LayoutInflater.from(parent.getContext()),parent,false);
        new UserItemViewModel();

        return new UserItemViewHolder(binding, viewModel);
    }
}
