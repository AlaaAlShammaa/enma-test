package com.test.enmatest.ui.base.presenter

import com.test.enmatest.ui.base.interactor.IInteractor
import com.test.enmatest.ui.base.view.IView

interface IPresenter<V : IView, I : IInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

    fun handleThrowable(throwable: Throwable)


}