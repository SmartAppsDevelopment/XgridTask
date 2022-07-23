package com.example.xgridtask.data

import androidx.annotation.DrawableRes

/**
 * @author Umer Bilal
 * Created 7/23/2022 at 4:23 PM
 */
data class MainButtonDataModel(@DrawableRes val mainIcon:Int,val title:String,val click:()->Unit)