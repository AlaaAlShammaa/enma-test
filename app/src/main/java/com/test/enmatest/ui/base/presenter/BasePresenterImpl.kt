package com.test.enmatest.ui.base.presenter

import com.androidnetworking.error.ANError
import com.google.gson.Gson
import com.test.enmatest.data.network.model.ErrorResponse
import com.test.enmatest.ui.base.interactor.IInteractor
import com.test.enmatest.ui.base.view.IView
import com.test.enmatest.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BasePresenterImpl<V : IView, I : IInteractor> internal constructor(protected var interactor: I?, protected val schedulerProvider: SchedulerProvider, protected val compositeDisposable: CompositeDisposable) : IPresenter<V, I> {

    @Inject
    lateinit var mGson: Gson

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }

    /**
     * Handles the throwable from the requests in the app, hides progress checks if the throwable is
     * ANError parses it, shows the error message appropriate to the error code from the response
     * @param throwable: Throwable object resulting from the error of a sent request
     * @see IView.hideProgress
     * @see IView.showErrorMessage
     */
    override fun handleThrowable(throwable: Throwable) {
        getView()?.hideProgress()
        if (throwable is ANError) {
            try {
                val errorResponse = mGson.fromJson(throwable.errorBody, ErrorResponse::class.java)
//                getView()?.showErrorMessage(errorResponse.code)
            } catch (e: Exception) {
//                getView()?.showErrorMessage(throwable.response?.code())
                e.printStackTrace()
            }
        }
        throwable.printStackTrace()
    }

}