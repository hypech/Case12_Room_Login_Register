/*
 * Copyright 2021 The Learning Android with Cases Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hypech.case12_room_login_reigster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.hypech.case12_room_login_reigster.room.User;
import com.hypech.case12_room_login_reigster.room.UserDao;
import com.hypech.case12_room_login_reigster.room.UserDatabase;

public class Login extends AppCompatActivity {

    // DBOpenHelper mDBOpenHelper;
    private EditText etUser, etPWD;
    private CheckBox cb_rmbPsw;

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // mDBOpenHelper = new DBOpenHelper(this);

        etUser    = findViewById(R.id.et_User);
        etPWD     = findViewById(R.id.et_Psw);
        cb_rmbPsw = findViewById(R.id.cb_rmbPsw);

        sp     = getSharedPreferences("rememberLogin", MODE_PRIVATE);
        editor = sp.edit();

        if(sp.getBoolean("rememberLogin",false)){
            Intent intent = new Intent(this, BusinessLogic.class);//Jump to Register Activity
            startActivity(intent);
        }
    }

    public void clickLogin(View view) {
        UserDatabase userDb = UserDatabase.getDatabase(this);
        UserDao userDao = userDb.userDao();

        //get the information from input
        String name = etUser.getText().toString().trim();
        String password = etPWD.getText().toString().trim();
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)) {

            // Cursor cursor = mDBOpenHelper.getOneUser(name, password); sqlite
            User user = userDao.getOneUser(name, password);

            if (user != null) {
                if(cb_rmbPsw.isChecked()){
                    editor.putBoolean("rememberLogin",true);
                    editor.apply();
                }
                Intent intent = new Intent(this, BusinessLogic.class);//Jump to Register Activity
                startActivity(intent);
            } else {
                Toast.makeText(this, "user name or pwd wrong.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void clickBack(View view) {
        finish();
    }
}