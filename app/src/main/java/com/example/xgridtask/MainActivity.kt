package com.example.xgridtask

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.example.xgridtask.data.MainButtonDataModel
import com.example.xgridtask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding

    private val getListOfButton =
        arrayListOf(MainButtonDataModel(R.drawable.ic_baseline_privacy_tip_24, "Privacy") {},
            MainButtonDataModel(R.drawable.ic_baseline_history_24, "Purchase History") {},
            MainButtonDataModel(R.drawable.ic_baseline_help_24, "Help & Support") {},
            MainButtonDataModel(R.drawable.ic_baseline_settings_24, "Settings") {},
            MainButtonDataModel(R.drawable.ic_baseline_person_add_24, "Invite a Friend") {})

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setButtonData()
    }

    //TODO Mapping Data From list To button
    private fun setButtonData() {
        dataBinding.apply {
            btnPrivacy.model = getListOfButton[0]
            btnPurchase.model = getListOfButton[1]
            btnHelp.model = getListOfButton[2]
            btnSetting.model = getListOfButton[3]
            btnInvite.model = getListOfButton[4]
        }
    }
}

// Binding Adapter for main button list
@BindingAdapter("setImageFromModel")
fun setPaddingLeft(imgView: ImageView, resId: Int) {
imgView.setImageResource(resId)
}