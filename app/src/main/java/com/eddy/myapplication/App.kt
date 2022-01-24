package com.eddy.myapplication

import android.app.Application
import com.eddy.myapplication.viewModel.MainViewModel

import org.koin.android.ext.koin.androidContext

import org.koin.androidx.viewmodel.dsl.viewModel


import org.koin.core.context.startKoin
import org.koin.dsl.module


/**
 * Created by Eddy MiGoder on 1/22/2022
 */
class App:Application() {

    override fun onCreate() {
        super.onCreate()

        val myModule = module {
            viewModel {
                MainViewModel(repository = get())
            }
            single<Repository> {
                ResponseListModelImpl(context = get())
            }
        }


        startKoin{
            androidContext(applicationContext)
            modules(myModule)
        }
    }
}