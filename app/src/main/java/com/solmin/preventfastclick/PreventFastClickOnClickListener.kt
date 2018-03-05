package com.solmin.preventfastclick

import android.os.Handler
import android.view.View

/**
 * onClickListener that can prevent fast click.
 * Created by h_sol on 2018/03/05.
 */
abstract class PreventFastClickOnClickListener(private val time: Int = 500): View.OnClickListener {
    override fun onClick(view: View?) {
        if (view == null) return
        view.isEnabled = false

        Handler().postDelayed(
                { view.isEnabled = true },
                this.time.toLong()
        )

        onClicked(view)
    }

    abstract fun onClicked(view: View)
}