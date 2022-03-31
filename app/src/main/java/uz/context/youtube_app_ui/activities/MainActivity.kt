package uz.context.youtube_app_ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.context.youtube_app_ui.R
import uz.context.youtube_app_ui.adapter.FeedAdapter
import uz.context.youtube_app_ui.adapter.FilterAdapter
import uz.context.youtube_app_ui.model.Feed
import uz.context.youtube_app_ui.model.Filter

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerFeed: RecyclerView
    private lateinit var recyclerFilter: RecyclerView
    private val filters: ArrayList<Filter> = ArrayList()
    private val feeds: ArrayList<Feed> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerFilter = findViewById(R.id.recycler_filter)
        recyclerFeed = findViewById(R.id.recycler_feed)
        recyclerFilter.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerFeed.layoutManager = GridLayoutManager(this, 1)

        refreshStoryAdapter(getAllFilters())
        refreshFeedAdapter(getAllFeeds())
    }

    private fun refreshStoryAdapter(chats: ArrayList<Filter>) {
        val adapter = FilterAdapter(this, chats)
        recyclerFilter.adapter = adapter
    }

    private fun refreshFeedAdapter(feeds: ArrayList<Feed>) {
        val adapter = FeedAdapter(this, feeds)
        recyclerFeed.adapter = adapter
    }

    private fun getAllFilters(): ArrayList<Filter> {
        filters.add(Filter("Computer Programming"))
        filters.add(Filter("Android Native"))
        filters.add(Filter("Mobile Development"))
        return filters
    }

    private fun getAllFeeds(): ArrayList<Feed> {
        feeds.add(Feed(R.drawable.img_youtube,R.drawable.img_back_youtube))
        feeds.add(Feed(R.drawable.img_youtube,R.drawable.img_1))
        feeds.add(Feed(R.drawable.img_youtube,R.drawable.img_2))
        feeds.add(Feed(R.drawable.img_youtube,R.drawable.img_3))
        feeds.add(Feed(R.drawable.img_youtube,R.drawable.img_4))
        feeds.add(Feed(R.drawable.img_youtube,R.drawable.img_5))
        feeds.add(Feed(R.drawable.img_youtube,R.drawable.img_6))
        feeds.add(Feed(R.drawable.img_youtube,R.drawable.img_7))
        return feeds
    }
}