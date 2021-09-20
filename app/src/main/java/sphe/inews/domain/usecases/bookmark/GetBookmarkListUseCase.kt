package sphe.inews.domain.usecases.bookmark

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import sphe.inews.domain.models.bookmark.Bookmark
import sphe.inews.domain.repository.BookmarkRepository
import javax.inject.Inject

class GetBookmarkListUseCase @Inject constructor(private val bookmarkRepository: BookmarkRepository) {

    operator fun invoke(scope: CoroutineScope, onBookmarks: (List<Bookmark>?) -> Unit) {
        scope.launch {
            val bookmarks = bookmarkRepository.getBooMarks()
            onBookmarks(bookmarks)
        }
    }
}