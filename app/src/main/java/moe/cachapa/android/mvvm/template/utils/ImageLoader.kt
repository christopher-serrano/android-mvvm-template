package moe.cachapa.android.mvvm.template.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import org.koin.core.component.KoinComponent

class ImageLoader(private val context: Context) : KoinComponent {

    fun loadWithUrl(url: String?, targetView: ImageView, placeholder: Int) {
        Glide.with(context)
            .load(url)
            .placeholder(placeholder)
            .error(placeholder)
            .fallback(placeholder)
            .into(targetView)
    }

    fun loadUrlWithCrossFade(url: String?, targetView: ImageView, duration: Int = 5000) {
        Glide.with(context)
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade(duration))
            .into(targetView)
    }

    fun loadWithUrlAsBitmap(url: String, placeholder: Int, function: ((Bitmap) -> Unit)?) {
        Glide.with(context)
            .asBitmap()
            .load(url)
            .fitCenter()
            .placeholder(placeholder)
            .into(object : CustomTarget<Bitmap?>() {

                override fun onResourceReady(
                    resource: Bitmap,
                    transition: Transition<in Bitmap?>?
                ) {
                    resource.let {
                        function?.invoke(it)
                    }
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    TODO("Not yet implemented")
                }
            })
    }
}
