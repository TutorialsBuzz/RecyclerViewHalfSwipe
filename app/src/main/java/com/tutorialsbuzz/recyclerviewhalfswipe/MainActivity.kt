package com.tutorialsbuzz.recyclerviewhalfswipe

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tutorialsbuzz.halfswipe.SwipeHelper
import com.tutorialsbuzz.halfswipe.SwipeHelper.UnderlayButtonClickListener
import com.tutorialsbuzz.recyclerview.CustomAdapter
import com.tutorialsbuzz.recyclerview.Model
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val modelList = readFromAsset();

        val adapter = CustomAdapter(modelList, this)
        rcv.addItemDecoration(SimpleDividerItemDecoration(this))
        rcv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rcv.adapter = adapter;

        val swipeHelper = object : SwipeHelper(this, rcv, false) {

            override fun instantiateUnderlayButton(
                viewHolder: RecyclerView.ViewHolder?,
                underlayButtons: MutableList<UnderlayButton>?
            ) {
                underlayButtons?.add(SwipeHelper.UnderlayButton(
                    "Archive",
                    AppCompatResources.getDrawable(
                        this@MainActivity,
                        R.drawable.ic_archive_black_24dp
                    ),
                    Color.parseColor("#000000"),
                    UnderlayButtonClickListener { pos: Int ->

                        Toast.makeText(
                            this@MainActivity,
                            "Delete clicked at " + pos,
                            Toast.LENGTH_SHORT
                        ).show()
                        adapter.modelList.removeAt(pos);
                        adapter.notifyItemRemoved(pos)

                    }

                ))

                underlayButtons?.add(SwipeHelper.UnderlayButton(
                    "Flag",
                    AppCompatResources.getDrawable(
                        this@MainActivity,
                        R.drawable.ic_flag_black_24dp
                    ),
                    Color.parseColor("#FF0000"),
                    UnderlayButtonClickListener { pos: Int ->

                        Toast.makeText(
                            this@MainActivity,
                            "Delete clicked at " + pos,
                            Toast.LENGTH_SHORT
                        ).show()
                        adapter.modelList.removeAt(pos);
                        adapter.notifyItemRemoved(pos)

                    }

                ))

                underlayButtons?.add(SwipeHelper.UnderlayButton(
                    "More",
                    AppCompatResources.getDrawable(
                        this@MainActivity,
                        R.drawable.ic_more_horiz_black_24dp
                    ),
                    Color.parseColor("#00FF00"),
                    UnderlayButtonClickListener { pos: Int ->

                        Toast.makeText(
                            this@MainActivity,
                            "Delete clicked at " + pos,
                            Toast.LENGTH_SHORT
                        ).show()
                        adapter.modelList.removeAt(pos);
                        adapter.notifyItemRemoved(pos)

                    }

                ))


            }
        }


        val icon = AppCompatResources.getDrawable(this, R.mipmap.ic_launcher)


//        object : SwipeHelper1(this@MainActivity, rcv) {
//
//            override fun instantiateUnderlayButton(
//                viewHolder: RecyclerView.ViewHolder,
//                underlayButtons: MutableList<UnderlayButton>?
//            ) {
//                underlayButtons?.add(SwipeHelper1.UnderlayButton(
//                    "Archive",
//                    AppCompatResources.getDrawable(
//                        this@MainActivity,
//                        R.drawable.ic_archive_black_24dp
//                    ),
//                    Color.parseColor("#000000"),
//                    object : UnderlayButtonClickListener {
//                        override fun onClick(pos: Int) {
//                            Toast.makeText(
//                                this@MainActivity,
//                                "Delete clicked at " + pos,
//                                Toast.LENGTH_SHORT
//                            ).show()
//                            adapter.modelList.removeAt(pos);
//                            adapter.notifyItemRemoved(pos)
//                        }
//                    }
//
//                ))
//
//                underlayButtons?.add(SwipeHelper1.UnderlayButton(
//                    "Flag",
//                    AppCompatResources.getDrawable(
//                        this@MainActivity,
//                        R.drawable.ic_flag_black_24dp
//                    ),
//                    Color.parseColor("#FF0000"),
//                    object : UnderlayButtonClickListener {
//                        override fun onClick(pos: Int) {
//                            Toast.makeText(
//                                this@MainActivity,
//                                "Delete clicked at " + pos,
//                                Toast.LENGTH_SHORT
//                            ).show()
//                            adapter.modelList.removeAt(pos);
//                            adapter.notifyItemRemoved(pos)
//                        }
//                    }
//
//                ))
//
//
//                underlayButtons?.add(SwipeHelper1.UnderlayButton(
//                    "More",
//                    AppCompatResources.getDrawable(
//                        this@MainActivity,
//                        R.drawable.ic_more_horiz_black_24dp
//                    ),
//                    Color.parseColor("#00FF00"),
//                    object : UnderlayButtonClickListener {
//                        override fun onClick(pos: Int) {
//                            Toast.makeText(
//                                this@MainActivity,
//                                "Delete clicked at " + pos,
//                                Toast.LENGTH_SHORT
//                            ).show()
//                            adapter.modelList.removeAt(pos);
//                            adapter.notifyItemRemoved(pos)
//                        }
//                    }
//
//                ))
//
//            }
//
//        }

    }

    private fun readFromAsset(): MutableList<Model> {
        val modeList = mutableListOf<Model>()
        val bufferReader = application.assets.open("android_version.json").bufferedReader()
        val json_string = bufferReader.use {
            it.readText()
        }
        val jsonArray = JSONArray(json_string);

        for (i in 0..jsonArray.length() - 1) {
            val jsonObject: JSONObject = jsonArray.getJSONObject(i)

            val model = Model(jsonObject.getString("name"), jsonObject.getString("version"))
            modeList.add(model)
        }

        return modeList
    }


}
