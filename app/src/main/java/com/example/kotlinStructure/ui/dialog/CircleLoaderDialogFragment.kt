package com.example.kotlinStructure.ui.dialog

import android.os.Bundle
import android.view.View
import com.example.kotlinStructure.R
import com.example.kotlinStructure.base.BaseDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_circle_loader.*

@AndroidEntryPoint
class CircleLoaderDialogFragment : BaseDialogFragment() {
    override val layoutId: Int = R.layout.fragment_circle_loader

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        circleLoader!!.showContextMenu()
    }
}