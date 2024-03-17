package com.whatrushka.devrush4ichallenge

import android.app.Application
import android.util.Log
import com.whatrushka.devrush4ichallenge.di.commonModule
import com.whatrushka.devrush4ichallenge.di.modules.quotesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()

        Log.d("m", "app started")

        startKoin {
            androidContext(this@MainApp)
            androidLogger(Level.DEBUG)
            modules(
                commonModule,
                quotesModule
            )
        }
    }
}