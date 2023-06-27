package com.example.assms.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.assms.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.FirebaseAuthKtxRegistrar
import kotlinx.android.synthetic.main.activity_register.nameEdt
import kotlinx.android.synthetic.main.activity_register.reg_email_edt
import kotlinx.android.synthetic.main.activity_register.reg_passEdt
import kotlinx.android.synthetic.main.activity_register.reg_repassEdt
import kotlinx.android.synthetic.main.activity_register.signUpBtn

class RegisterActivity : AppCompatActivity() {
    lateinit var email:String
    lateinit var password:String
    lateinit var name :String
    lateinit var ReenterPass :String
    lateinit var mAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mAuth= FirebaseAuth.getInstance()


        signUpBtn.setOnClickListener {

            name = nameEdt.text.toString()
            email = reg_email_edt.text.toString()
            password = reg_passEdt.text.toString()
            ReenterPass = reg_repassEdt.text.toString()




            if(TextUtils.isEmpty(name)||TextUtils.isEmpty(email)||TextUtils.isEmpty(password)||TextUtils.isEmpty(ReenterPass)){
                Toast.makeText(this, "Please fill all field", Toast.LENGTH_SHORT).show()
            }else{

                creatingaccount(email,password)
            }




        }



    }

    fun creatingaccount(email: String, password: String) {

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            if(it.isSuccessful){
                Toast.makeText(this, "Your Account Created", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "${it.exception?.localizedMessage.toString()}", Toast.LENGTH_SHORT).show()
            }
        }


    }


}