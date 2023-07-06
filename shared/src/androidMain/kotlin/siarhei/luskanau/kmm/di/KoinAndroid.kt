package siarhei.luskanau.kmm.di

import org.koin.core.module.Module
import org.koin.dsl.module
import siarhei.luskanau.kmm.shared.ResourceReader

actual val platformModule: Module = module {
    single {
        ResourceReader(
            context = get(),
        )
    }
}
