package com.example.xgridtask

import android.app.Activity
import android.widget.Toast

/**
 * @author Umer Bilal
 * Created 7/23/2022 at 5:35 PM
 */


fun Activity.showToast(msg:String){
    Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
}