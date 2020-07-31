package com.aungpyaesone.firebasetest.padcx_movieapp_aps.views.viewholders

import android.view.View
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.delegate.PopularMovieItemDelegate
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.delegate.TopRatedMovieItemDelegate
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.utils.BASE_URL
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.utils.IMAGE_BASE_URL
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_poster_item_view.view.*

class BestPopularFilmViewHolder(itemView: View,val mDelegate:TopRatedMovieItemDelegate) : BaseViewHolder<PopularMovieVO>(itemView) {

    init {
        itemView.setOnClickListener {
            mData?.let {
                mDelegate.onTouchRatedMovie(it.id)
            }
        }
    }
    override fun bindData(data: PopularMovieVO) {
        mData = data

        Glide.with(itemView.context)
            .load(IMAGE_BASE_URL + data.poster_path)
            .into(itemView.ivPoster)
        itemView.tvMovieTitle.text = data.title
        itemView.ivMovieRate.text = data.vote_average.toString()
        itemView.ratingBar.rating = data.vote_average
    }
}