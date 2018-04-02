package com.nca.presentation.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nca.testandroid.BR;

public abstract class BaseItemViewHolder<Model,
        ViewModel extends BaseItemViewModel, Binding extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private Binding binding;
    private ViewModel viewModel;

    public BaseItemViewHolder(Binding buinding, ViewModel viewModel) {
        super(buinding.getRoot());
        this.binding = buinding;
        this.viewModel = viewModel;
        this.viewModel.init();
    }

    protected void initViewModel(){
        binding.setVariable(BR.viewModel,viewModel);
    }

    public void bindTo(Model model, int position) {
        viewModel.setItem(model,position);
        binding.executePendingBindings();
    }

    public void release(){
        this.viewModel.release();
    }
}
