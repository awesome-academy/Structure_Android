package com.sun.android.utils.extension

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.sun.android.R

fun Fragment.addFragment(
    @IdRes containerId: Int,
    fragment: Fragment,
    addToBackStack: Boolean = false,
    tag: String? = fragment::class.java.simpleName
) {
    activity?.supportFragmentManager?.apply {
        beginTransaction().apply {
            if (addToBackStack) {
                addToBackStack(tag)
            }
            setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_in_right,
                R.anim.slide_out_right,
                R.anim.slide_out_right
            )
            add(containerId, fragment, tag)
        }.commit()
    }
}

fun Fragment.replaceFragment(
    @IdRes containerId: Int,
    fragment: Fragment,
    addToBackStack: Boolean,
    tag: String? = fragment::class.java.simpleName
) {
    activity?.supportFragmentManager?.apply {
        beginTransaction().apply {
            if (addToBackStack) {
                addToBackStack(tag)
            }
            replace(containerId, fragment, tag)
        }.commit()
    }
}

fun Fragment.goBackFragment(): Boolean {
    activity?.supportFragmentManager?.notNull {
        val isShowPreviousPage = it.backStackEntryCount > 0
        if (isShowPreviousPage) {
            it.popBackStackImmediate()
        }
        return isShowPreviousPage
    }
    return false
}
