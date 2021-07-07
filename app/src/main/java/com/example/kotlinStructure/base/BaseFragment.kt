package com.example.kotlinStructure.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlinStructure.ui.dialog.CircleLoaderDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
abstract class BaseFragment : Fragment() {

    @Inject
    lateinit var circleLoaderDialogFragment: CircleLoaderDialogFragment

    abstract fun layoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        inflater.inflate(layoutId(), container, false)

    open fun showLoader() {
        circleLoaderDialogFragment.showDialog(parentFragmentManager)
    }

    open fun dismissLoader() {
        circleLoaderDialogFragment.dismissDialog()
    }
}