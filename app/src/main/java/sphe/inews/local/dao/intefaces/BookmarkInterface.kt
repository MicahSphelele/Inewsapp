package sphe.inews.local.dao.intefaces

import androidx.lifecycle.LiveData
import sphe.inews.models.Bookmark

interface BookmarkInterface {

  suspend fun insert(bookmark: Bookmark) : Long

  suspend fun delete(bookmark: Bookmark) : Int

  suspend fun getBooMarks() : List<Bookmark>

  fun getBooMarksObserved() : LiveData<List<Bookmark>>

  suspend fun getBooMark(url : String) : Bookmark?
}