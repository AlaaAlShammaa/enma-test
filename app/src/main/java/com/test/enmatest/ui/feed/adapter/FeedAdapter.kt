package com.test.enmatest.ui.feed.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.enmatest.R
import com.test.enmatest.data.network.model.Post
import com.test.enmatest.util.CommonUtil
import com.test.enmatest.util.loadImage
import kotlinx.android.synthetic.main.feed_item.view.*

class FeedAdapter : RecyclerView.Adapter<FeedAdapter.FeedVH>() {

    private val items: ArrayList<Post> = ArrayList()

    private var callback: FeedAdapter.Callback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedVH = FeedVH(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.feed_item, parent, false)
    )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: FeedVH, position: Int) {
        holder.onBind(items[position])
    }

    fun addItems(posts: List<Post>) {
        items.clear()
        items.addAll(posts)
        notifyDataSetChanged()
    }

    interface Callback {
        fun onItemClick(post: Post)
    }

    fun setCallback(callback: FeedAdapter.Callback?) {
        this.callback = callback
    }

    fun removeCallback() {
        this.callback = null
    }

    inner class FeedVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(post: Post) {
            itemView.thumbnailIV.loadImage(post.media?.get(1)?.url, post.media?.get(0)?.url)
            itemView.captionTV.text = post.caption
            itemView.usernameTV.text = post.name
            itemView.thumbUpCountTV.text = CommonUtil.getFormattedCount(post.likeCount)
            itemView.commentCountTV.text = CommonUtil.getFormattedCount(post.commentCount)
        }
        init {
            itemView.setOnClickListener {
                callback?.onItemClick(post = items[adapterPosition])
            }
        }
    }

}