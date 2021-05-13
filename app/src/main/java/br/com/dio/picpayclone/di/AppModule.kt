package br.com.dio.picpayclone.di

import br.com.dio.picpayclone.ui.dashboard.DashboardViewModel
import br.com.dio.picpayclone.ui.home.HomeViewModel
import br.com.dio.picpayclone.ui.notifications.NotificationsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel() }
    viewModel { DashboardViewModel() }
    viewModel { NotificationsViewModel() }
}