package com.nca.presentation.base;

import dagger.Module;

/**
 * Created by user on 02.04.2018.
 */

public abstract class BaseItemViewModel<Model>  {

    public abstract void setItem(Model model, int position);

    public void init(){

    }

    public void release(){

    }


}
