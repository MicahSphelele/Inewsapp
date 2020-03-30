package sphe.inews.di.main

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import sphe.inews.di.ViewModelKey
import sphe.inews.ui.main.news.business.BusinessViewModel
import sphe.inews.ui.main.news.entertainment.EntertainmentViewModel
import sphe.inews.ui.main.news.health.HealthViewModel
import sphe.inews.ui.main.news.sport.SportViewModel
import sphe.inews.ui.main.news.technology.TechnologyViewModel

@Module
abstract class MainViewModelsModule {


    @Binds
    @IntoMap
    @ViewModelKey(BusinessViewModel::class)
    abstract fun bindBusinessViewModel(viewModel: BusinessViewModel?): ViewModel?

    @Binds
    @IntoMap
    @ViewModelKey(EntertainmentViewModel::class)
    abstract fun bindEntertainmentViewModel(viewModel: EntertainmentViewModel?): ViewModel?

    @Binds
    @IntoMap
    @ViewModelKey(HealthViewModel::class)
    abstract fun bindHealthViewModel(viewModel: HealthViewModel?): ViewModel?

    @Binds
    @IntoMap
    @ViewModelKey(SportViewModel::class)
    abstract fun bindSportViewModel(viewModel: SportViewModel?): ViewModel?

    @Binds
    @IntoMap
    @ViewModelKey(TechnologyViewModel::class)
    abstract fun bindTechnologyViewModel(viewModel: TechnologyViewModel?): ViewModel?
}