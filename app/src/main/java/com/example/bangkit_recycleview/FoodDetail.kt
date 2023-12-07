package com.example.bangkit_recycleview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FoodDetail(var titleArticle: Int, var heading: String, var desc: String ) : Parcelable
