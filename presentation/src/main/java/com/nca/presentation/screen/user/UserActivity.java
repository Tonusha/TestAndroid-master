package com.nca.presentation.screen.user;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.nca.presentation.base.BaseMvvActivity;
import com.nca.testandroid.R;
import com.nca.testandroid.databinding.ActivityUserBinding;

import io.reactivex.annotations.Nullable;

public class UserActivity extends BaseMvvActivity<ActivityUserBinding, UserViewModel> {

    @Override
    public int provideLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    public UserViewModel provideViewModel() {
        return ViewModelProviders.of(this).get(UserViewModel.class);
    }

    @Override
    public void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(viewModel.userAdapter);
    }

}

// android google github sample architecture