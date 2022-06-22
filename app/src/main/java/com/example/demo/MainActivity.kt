package com.example.demo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var name = ""
    protected var content = ""

    private var demoData: Demo? = null
    private var demoData2: Demo? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Test2(name = "Son", nickName = "ANh")

        Demo(object : Demo.Listener {
            override fun showName() {

            }
        })


        val demo = Demo(listener = object : Demo.Listener {
            override fun showName() {


            }

        })

        demo.showName(name = "", nickName = "", old = 4)
        demo.showName("", 5, "3232")

        findViewById<View>(R.id.btn_replace)?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {


                v?.accessibilityClassName

            }
        })

        findViewById<View>(R.id.btn_replace)?.setOnClickListener {

            demoData?.let {
                it.test1()
                it.test2()
            }

            val result = demoData?.let { entity ->
                entity.test1()
                entity.test2()
                entity.content
            }


            val newDemo1 = demoData?.run {
                this.test2()
                this.test1()

            }

            demoData?.apply {
                this.content = "abs"
            }

            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)



            startActivity(Intent(this, MainActivity::class.java).apply {
                this.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                this.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                this.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            })

            val isEmpty = (demoData?.run {
                this.content?.isEmpty()
            }) ?: false


            demoData?.let { entity1 ->
                demoData2?.let { entity2 ->


                    entity1.test1()
                    entity1.test2()

                    entity2.test2()
                    entity2.test2()

                    entity1.content = entity2.content
                }
            }

            demoData?.let {
                demoData2?.let {
                    demoData!!.test1()
                    demoData!!.test2()

                    demoData2!!.test2()
                    demoData2!!.test2()

                    demoData?.content = demoData2!!.content ?: ""
                }
            }


            demoData?.run {
                demoData2?.run {


                    this.test1()
                    this.test2()

                    this@run.test2()
                    this@run.test2()

                }
            }



            demoData?.takeIf { it.content?.isNotEmpty() == true }?.run {

                Toast.makeText(this@MainActivity, "content = "+ content, Toast.LENGTH_LONG).show()
            } ?: run{
                // ko thoar man du lieu
                // demoData == null || ko thoar man dieu kien takeIF

            }

            if (demoData!=null && demoData?.content?.isNotEmpty() == true ){

            }

            when(demoData?.content){
                "son"->{

                }
                "abs"->{

                }
                "abc"->{

                }
                else ->{

                }
            }

            val objectDemo: Any?=null

            when(objectDemo){
                is Demo->{
                    objectDemo.test1()
                    objectDemo.test2()
                }
                is String->{
                    objectDemo.substring(3)
                }
                is Boolean->{

                }
            }


            when{
                demoData?.content?.equals("abc") == true ->{

                }
                demoData?.content?.isEmpty() == true ->{

                }

                demoData?.content == null ->{

                }
                else ->{

                }
            }

            // if else
            // when
            // for
        }
    }

    private fun getCurrentDemo(): Demo? {
        return demoData?.apply {
//            this.content = findViewById<TextView>(R.id.tv_count)?.text?.toString() ?: "Empty"
        }
    }

    class Demo(private val listener: Listener? = null) {

        var content: String? = ""

        interface Listener {
            fun showName()
        }

        fun showName(name: String, old: Int = 6, nickName: String) {
            if (old > 18) {
                "người lớn: " + name + " with nickName " + nickName
            } else {
                "tre em " + name + " with nickName " + nickName
            }
        }

        fun test1() {

        }

        fun test2() {

        }
    }


}