package com.kotdev99.android.c34

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat

class DriveAdapter(
	cxt: Context,
	val resId: Int,
	val datas: MutableList<DriveVO>
) : // 상속 받은 ArrayAdapter와 동일하게 매개변수를 선언
	ArrayAdapter<DriveVO>(cxt, resId) {

	override fun getCount(): Int {
		return datas.size
	}

	override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
		var convertView = convertView
		if (convertView == null) {  // 사용할 뷰 객체가 null 이면 뷰 객체 생성
			val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
					as LayoutInflater
			convertView = inflater.inflate(resId, null)

			val holder = DriveHolder(convertView)
			convertView!!.tag = holder  // 뷰 객체에 태그를 붙여 이 후에도 사용 가능
		}

		val holder = convertView.tag as DriveHolder
		val typeImageView = holder.typeImageView
		val titleView = holder.titleView
		val dateView = holder.dateView
		val menuImageView = holder.menuImageView

		// 데이터 클래스에서 한꺼번에 3개의 데이터를 얻음
		val (title, date, type) = datas[position]
		titleView.text = date
		dateView.text = date
		if (type == "doc") {
			typeImageView.setImageDrawable(
				ResourcesCompat.getDrawable(
					context.resources,
					R.drawable.ic_type_doc, null
				)
			)
		} else if (type == "img") {
			typeImageView.setImageDrawable(
				ResourcesCompat.getDrawable(
					context.resources,
					R.drawable.ic_type_image, null
				)
			)
		} else if (type == "file") {
			typeImageView.setImageDrawable(
				ResourcesCompat.getDrawable(
					context.resources,
					R.drawable.ic_type_file, null
				)
			)
		}
		menuImageView.setOnClickListener {
			Toast.makeText(context, "$date menu click", Toast.LENGTH_SHORT)
				.show()
		}
		return convertView
	}
}