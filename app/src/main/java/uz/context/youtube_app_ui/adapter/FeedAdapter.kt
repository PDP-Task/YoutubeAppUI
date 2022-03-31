package uz.context.youtube_app_ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import uz.context.youtube_app_ui.R
import uz.context.youtube_app_ui.model.Feed

class FeedAdapter(
    context: Context,
    private val items: ArrayList<Feed>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_video, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val video = items[position]
        if (holder is FeedViewHolder) {
            holder.ivProfile.setImageResource(video.profileImg)
            holder.ivVideo.setImageResource(video.photo)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivProfile: ImageView = view.findViewById(R.id.iv_profile_feed)
        val ivVideo: ImageView = view.findViewById(R.id.iv_video)
    }
}