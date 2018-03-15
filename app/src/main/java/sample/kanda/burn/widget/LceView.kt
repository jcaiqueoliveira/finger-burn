package sample.kanda.burn.widget

import android.content.Context
import android.support.annotation.LayoutRes
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout

/**
 * Created by caique on 3/13/18.
 */

typealias layout = Int

class LceContainer @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    fun setUpView(@LayoutRes layout: Int) {
        LayoutInflater.from(context).inflate(layout, null).apply {
            addView(this)
        }
    }
}