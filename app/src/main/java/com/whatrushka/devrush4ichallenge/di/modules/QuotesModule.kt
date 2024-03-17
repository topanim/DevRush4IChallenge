package com.whatrushka.devrush4ichallenge.di.modules

import com.whatrushka.devrush4ichallenge.quotes.data.QuotesViewModel
import com.whatrushka.devrush4ichallenge.navigation.QuotesNavigation
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val quotesModule = module {
    single<QuotesNavigation> { QuotesNavigation() }
    viewModel { QuotesViewModel(get(), get()) }
}