package siarhei.luskanau.kmm.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import siarhei.luskanau.kmm.shared.JsonParser
import siarhei.luskanau.kmm.shared.data.ProjectService

fun initKoin(appModule: Module): KoinApplication =
    startKoin {
        modules(
            appModule,
            sharedCommonModule,
            platformModule
        )
    }

val sharedCommonModule = module {
    single {
        JsonParser()
    }

    single {
        ProjectService(
            resourceReader = get(),
            jsonParser = get()
        )
    }
}

expect val platformModule: Module
