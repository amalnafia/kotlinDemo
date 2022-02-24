package com.example.kotlinStructure.base

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.kotlinStructure.R
import com.example.kotlinStructure.`interface`.Test
import com.example.kotlinStructure.ui.dialog.CircleLoaderDialogFragment
import com.example.kotlinStructure.util.Constants.REQUEST_CODE_LOCATION
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
        savedInstanceState: Bundle?,
    ): View =
        inflater.inflate(layoutId(), container, false)

    open fun showLoader() {
        circleLoaderDialogFragment.showDialog(parentFragmentManager)
    }

    open fun dismissLoader() {
        circleLoaderDialogFragment.dismissDialog()
    }

    open fun navigateTo(destination: Int) {
        NavHostFragment.findNavController(this)
            .navigate(destination)
    }

    open fun navigateToNoInternet() {
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_global_noInternetDialogFragment)
    }

    open fun popBack() {
        try {
            NavHostFragment.findNavController(this).popBackStack()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    open fun checkPermission(requestCode: Int, permission: String): Boolean {
        return if (!isPermissionGranted(requestCode, permission)) {
            ActivityCompat.requestPermissions(this.requireActivity(),
                arrayOf(permission), requestCode)
            false
        } else
            true
    }


    open fun isPermissionGranted(requestCode: Int, permission: String): Boolean {
        return ContextCompat.checkSelfPermission(requireContext(),
            permission) == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray,
    ) {
        if (requestCode == REQUEST_CODE_LOCATION) {
            if (grantResults.isNotEmpty() && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                test?.test(REQUEST_CODE_LOCATION)
            }
        }
    }

    private var test: Test? = null
    open fun setOnPermissionRequestGranted(test: Test?) {
        this.test = test
    }
}