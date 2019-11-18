package com.tutorialsbuzz.recylerviewswipetodelete

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView


//abstract class SwipeToDeleteCallback constructor(internal var context: Context) : ItemTouchHelper.Callback() {
abstract class SwipeToDeleteCallback : ItemTouchHelper.SimpleCallback {

    var leftBG: Int = Color.LTGRAY
    var leftLabel: String = ""
    var leftIcon: Drawable? = null

    var rightBG: Int = Color.LTGRAY;
    var rightLabel: String = ""
    var rightIcon: Drawable? = null

    var context: Context;

    constructor(context: Context, dragDir: Int, swipeDir: Int) : super(dragDir, swipeDir) {
        this.context = context
    }

    private lateinit var background: Drawable

    var initiated: Boolean = false
    //Setting Swipe Text
    val paint = Paint()

    fun initSwipeView(): Unit {
        paint.setColor(Color.WHITE)
        paint.setTextSize(48f)
        paint.setTextAlign(Paint.Align.CENTER)
        background = ColorDrawable();
        initiated = true;
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }


    override fun onChildDraw(
        c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
        dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean
    ) {

        Log.d("onChildDraw", "dx: " + dX)

        val itemView = viewHolder.itemView
        if (!initiated) {
            initSwipeView()
        }


//        val intrinsicHeight = rightIcon!!.getIntrinsicWidth()
//        val xMarkTop = itemView.top + ((itemView.bottom - itemView.top) - intrinsicHeight) / 2
//        val xMarkBottom = xMarkTop + intrinsicHeight

        if (dX != 0.0f) {

            if (dX > 0) {
                //right swipe
                val intrinsicHeight = rightIcon!!.getIntrinsicWidth()
                val xMarkTop = itemView.top + ((itemView.bottom - itemView.top) - intrinsicHeight) / 2
                val xMarkBottom = xMarkTop + intrinsicHeight

                colorCanavas(c, rightBG, itemView.left + dX.toInt(), itemView.top, itemView.left, itemView.bottom)
                drawTextOnCanvas(c, rightLabel, (itemView.left + 150).toFloat(), (xMarkTop + 10).toFloat())
                drawIconOnCanVas(
                    c, rightIcon, itemView.left + rightIcon!!.intrinsicWidth,
                    xMarkTop + 20,
                    itemView.left + 2 * rightIcon!!.intrinsicWidth,
                    xMarkBottom + 20
                )

            } else {
                //left swipe
                val intrinsicHeight = leftIcon!!.getIntrinsicWidth()
                val xMarkTop = itemView.top + ((itemView.bottom - itemView.top) - intrinsicHeight) / 2
                val xMarkBottom = xMarkTop + intrinsicHeight


                colorCanavas(c, leftBG, itemView.right + dX.toInt(), itemView.top, itemView.right, itemView.bottom)
                drawTextOnCanvas(c, leftLabel, (itemView.right - 150).toFloat(), (xMarkTop + 10).toFloat())
                drawIconOnCanVas(
                    c, leftIcon, itemView.right - 2 * leftIcon!!.getIntrinsicWidth(),
                    xMarkTop + 20,
                    itemView.right - leftIcon!!.getIntrinsicWidth(),
                    xMarkBottom + 20
                )
            }


        }

        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }


    fun colorCanavas(canvas: Canvas, canvasColor: Int, left: Int, top: Int, right: Int, bottom: Int): Unit {

        (background as ColorDrawable).color = canvasColor
        background.setBounds(left, top, right, bottom)
        background.draw(canvas)

    }


    fun drawTextOnCanvas(canvas: Canvas, label: String, x: Float, y: Float) {
        canvas.drawText(label, x, y, paint)
    }

    fun drawIconOnCanVas(
        canvas: Canvas, icon: Drawable?, left: Int, top: Int, right: Int, bottom: Int
    ): Unit {
        icon!!.setBounds(
            left,
            top,
            right,
            bottom
        )
        icon.draw(canvas)

    }

}