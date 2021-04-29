package siarhei.luskanau.kmm.android

import android.app.Application
import android.content.Context
import org.koin.dsl.module
import siarhei.luskanau.kmm.di.initKoin

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(
            module {
                single<Context> { this@MainApp }
            }
        )
    }
}
