

package sphe.inews.ui.main.dialogfragments

import android.app.Activity
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.google.android.material.transition.MaterialElevationScale
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_view_article.*
import sphe.inews.R
import sphe.inews.local.viewmodel.BookMarkViewModel
import sphe.inews.models.Bookmark
import sphe.inews.util.Constants
import sphe.inews.util.notNull

@AndroidEntryPoint
class ArticlePreviewFragment : Fragment() {

    private lateinit var articleUrl: String

    companion object{
        const val BOOKMARK_OBJ = "bookmarkObject"
    }


    private val viewModel by viewModels<BookMarkViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialElevationScale(/* growing= */ true)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_view_article, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_exit.setOnClickListener {
            findNavController().navigateUp()
        }

        txt_read_more.setOnClickListener {
            Constants.launchCustomTabIntent(activity as Activity,articleUrl)
        }

        setUpUIData()
    }

    @Suppress("RedundantOverride")
    override fun onStart() {
        super.onStart()
    }

    @Suppress("RedundantOverride")
    override fun onActivityCreated(args: Bundle?) {
        super.onActivityCreated(args)
    }

    private fun setUpUIData(){
        requireArguments().apply {
            val article = requireArguments().getParcelable(BOOKMARK_OBJ) as? Bookmark

            txt_title.text = if(article?.title == "" || article?.title == null){
                "No Title"
            }else{
                article.title
            }
            txt_content.text = if(article?.content == "" || article?.content == null){
                "No Article content available. Please click on read more to view the article."
            }else{
                article.content
            }
            txt_date.text = if(article?.publishedAt == "" || article?.publishedAt==null){
                "Date Unknown"
            }else{
                article.publishedAt.let {
                    Constants.appDateFormatArticle(it!!).toString()
                }
            }
            txt_source.text = if(article?.sourceName == "" || article?.sourceName == null){
                "No Source"
            }else{
                article.sourceName
            }

            val imageUrl = if (article?.urlToImage == "" || article?.urlToImage == null){
                "null"
            }else{
                article.urlToImage
            }
            Glide.with(header_image)
                .load(Uri.parse(imageUrl))
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(header_image)

            articleUrl = article?.url!!

            val bookmark = viewModel.getBooMark(articleUrl)

            checkBookmark.isChecked = bookmark.notNull()

            checkBookmark.setOnCheckedChangeListener { _, checked ->
                if(checked){
                    viewModel.insert(article)
                    return@setOnCheckedChangeListener
                }
                viewModel.delete(bookmark!!)
            }

        }

    }
}