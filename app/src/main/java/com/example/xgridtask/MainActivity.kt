package com.example.xgridtask

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.example.xgridtask.data.MainButtonDataModel
import com.example.xgridtask.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding
    private val PREF_NAME = "NIGHT_MODE"
    private val NIGHT_MODE = "NightMode"
    private val getListOfButton =
        arrayListOf(MainButtonDataModel(R.drawable.ic_baseline_privacy_tip_24, "Privacy") {},
            MainButtonDataModel(R.drawable.ic_baseline_history_24, "Purchase History") {},
            MainButtonDataModel(R.drawable.ic_baseline_help_24, "Help & Support") {},
            MainButtonDataModel(R.drawable.ic_baseline_settings_24, "Settings") {},
            MainButtonDataModel(R.drawable.ic_baseline_person_add_24, "Invite a Friend") {})

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        updateAppTheme()
        setButtonData()
    }

    private fun updateAppTheme() {
        if (getFromPrefIsNightMode()) {
            showToast("Night Mode ON")
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            showToast("Night Mode OFF")
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    //TODO Mapping Data From list To button
    private fun setButtonData() {
        dataBinding.apply {
            btnPrivacy.model = getListOfButton[0]
            btnPurchase.model = getListOfButton[1]
            btnHelp.model = getListOfButton[2]
            btnSetting.model = getListOfButton[3]
            btnInvite.model = getListOfButton[4]
            nightmode.setOnClickListener {
                setToPrefIsNightMode(getFromPrefIsNightMode().not())
                if (getFromPrefIsNightMode()) {
                    showToast("Night Mode ON")
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                } else {
                    showToast("Night Mode OFF")
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
            }
        }
    }

    private fun setToPrefIsNightMode(isNightModel: Boolean = false) {
        val editor: SharedPreferences.Editor =
            getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit()
        editor.putBoolean(NIGHT_MODE, isNightModel)
        editor.apply()
    }

    private fun getFromPrefIsNightMode() =
        getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getBoolean(NIGHT_MODE, false)

}

// Binding Adapter for main button list
@BindingAdapter("setImageFromModel")
fun setPaddingLeft(imgView: ImageView, resId: Int) {
    imgView.setImageResource(resId)
}