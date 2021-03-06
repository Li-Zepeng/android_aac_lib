package com.aac.base.widget

import android.content.Context
import android.view.Gravity
import com.aac.base.R
import com.aac.base.databinding.PageLoadingBinding
import com.aac.base.helper.ImageHelper
import com.aac.base.helper.network.NetRequestHelper
import com.aac.base.mvvm.EmptyVM
import com.aac.base.mvvm.widget.CommonDlg

class PageLoadDlg(private val mContext: Context, private val Tag: String = "") {

    companion object {
        lateinit var mImgRes: Any
        fun init(imgRes: Any) {
            mImgRes = imgRes
        }
    }

    lateinit var mDlg: CommonDlg<PageLoadingBinding, EmptyVM>

    init {
        initView()
    }

    private fun initView() {
        mDlg = CommonDlg.Builder<PageLoadingBinding, EmptyVM>(mContext)
            .setStyle(R.style.loading_dialog)
            .setLayout(R.layout.page_loading)
            .setViewModel(EmptyVM::class.java)
            .setCanTouchout(false)
            .setCanBack(true)
            .setGravity(Gravity.CENTER)
            .build()
//        app:imgRes="@{@drawable/loading}"
        ImageHelper.loadImg(mDlg.mBinding.gif1, mImgRes)
    }

    fun showOrDismiss(isShow: Boolean) {
        if (isShow) {
            mDlg.show()
        } else {
            NetRequestHelper.cancleRequest(Tag)
            mDlg.dismiss()
        }
    }
}
