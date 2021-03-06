package sphe.inews.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import sphe.inews.local.repo.BookmarkRepository
import sphe.inews.models.Country
import sphe.inews.ui.main.adapters.ArticleAdapter
import sphe.inews.ui.main.adapters.CountryAdapter
import sphe.inews.util.Constants
import javax.inject.Named

@InstallIn(SingletonComponent::class)
@Module
object MainModule {


    @Provides
    fun provideAdapter(): ArticleAdapter {
        return ArticleAdapter()
    }


    @Provides
    fun provideCountryAdapter(@Named(Constants.NAMED_COUNTRIES) list: List<Country>): CountryAdapter {
        return CountryAdapter(list)
    }

    @Provides
    fun provideBookmarkRepository(application: Application) : BookmarkRepository {
        return BookmarkRepository(application)
    }
}