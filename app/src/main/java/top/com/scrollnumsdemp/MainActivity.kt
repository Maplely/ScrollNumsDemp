package top.com.scrollnumsdemp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val COUNT = 10
        val PER_DURINGTON = 3000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //获取当前屏幕的宽度
        val manager = windowManager
        val width = manager.defaultDisplay.width
        val height = manager.defaultDisplay.height
        val set = AnimationSet(true)
        val animation = ScaleAnimation(0.0F, 5F, 0.0F, 5.0F,
                Animation.ABSOLUTE, show.width/2F, Animation.ABSOLUTE, show.height/2F)
        val alphaAnimation = AlphaAnimation(1.0F, 0.0F)
        set.duration = PER_DURINGTON.toLong()
        animation.repeatCount = COUNT-1
        animation.fillAfter=true
        animation.interpolator= AccelerateInterpolator()
        var num = COUNT
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {
                --num
                show.text = "" + num
            }

            override fun onAnimationEnd(animation: Animation?) {

            }

            override fun onAnimationStart(animation: Animation?) {
                show.text = "" + num
            }

        })
        alphaAnimation.repeatCount = COUNT
        alphaAnimation.fillAfter=true
        alphaAnimation.interpolator=AccelerateInterpolator()
        set.addAnimation(animation)
        set.addAnimation(alphaAnimation)

        //确定按钮
        bt.setOnClickListener({
            show.startAnimation(set)
        })
        //取消按钮
        cancel.setOnClickListener({
            show.clearAnimation()
        })
        //重置按钮
        reset.setOnClickListener {
            num= COUNT
            show.text=""+10
        }
    }
}
