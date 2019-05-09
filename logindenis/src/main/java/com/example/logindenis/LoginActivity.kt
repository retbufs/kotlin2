package com.example.logindenis

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.text.InputType
import android.view.View
import android.widget.EditText
import com.example.logindenis.utils.DateUtils
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.toast
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {
    private var mVerifyCode: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        current_time.text = DateUtils.getFormatTiem()
        //登入的方式
        check_login_method.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.code_method -> {
                    ed_pass.setText("")
                    tv_pass.text = "验证码"
                    ed_pass.hint = "请输入验证码"
                    //自动完成文本类型
                    ed_pass.inputType=InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE
                    forget_pass.text = "获取验证码"
                    save_pass.visibility = View.INVISIBLE
                }
                R.id.pass_method -> {
                    ed_pass.setText("")
                    tv_pass.text = "输入密码"
                    ed_pass.hint = "请输入密码"
                    forget_pass.text = "忘记密码"
                    ed_pass.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
                    save_pass.visibility = View.VISIBLE
                }
                else -> ""
            }
        }
        //获取验证码
        forget_pass.setOnClickListener { doForget() }
        login_btn.setOnClickListener { doLogin() }
    }

    //忘记密码or 获取验证码
    fun doForget(){
        //
        val phone = ed_phone.text.toString()
        println(phone)
        if(phone.isBlank()||phone.length<11||phone.length>11){
            toast("手机号不正确:请重新输入手机号")
            return
        }
        //单选是否选中
        if(pass_method.isChecked){
            //TODO 跳转到找回密码界面
        }else if (code_method.isChecked){
            //获取验证码  //随机生成6位数的验证码
            mVerifyCode = String.format("%06d", (Math.random() * 100_0000 % 100_0000).toInt())
            alert("手机号：${phone},本次获取的验证码为：${mVerifyCode},请不要将验证码告诉其他人","请记住验证码"){
                positiveButton("好的"){}
            }.show()
        }
    }
    //登录
    fun doLogin(){
        val phone = ed_phone.text.toString()
        if(phone.isBlank() || phone.length <11||phone.length>11){
            toast("当前输入的手机不正确")
            return
        }
        if(pass_method.isChecked){
         //校验密码是否正确
            val def_pass = "abc"
            val password = ed_pass.text.toString()
            //校验密码
            if(password.equals(def_pass)){
                //TODO 进入首页
                toast("登入成功")

                val builder = AlertDialog.Builder(this)
                builder.setTitle("尊敬的用户${phone}")
                builder.setMessage("success")
                builder.setNegativeButton("取消"){dialog, which ->
                    dialog.dismiss()
                }
                builder.setPositiveButton("确定"){
                    dialog, which ->  dialog.dismiss()
                }
                builder.create().show()
            }else{
                toast("密码错误,登入失败！")
                return
            }
        }
        if(code_method.isChecked){
            val code = ed_pass.text.toString()
            if(code.isBlank()){
                toast("验证码未输入")
                return
            }
            if(code.length>6||code.length<6){
                toast("验证码错误")
            }
            if(mVerifyCode.equals(code)){
                //TODO 进入登入成功页面 149945
                toast("登入成功")
            }else{
                toast("验证码错误，登录失败！")
            }
        }
    }
}
