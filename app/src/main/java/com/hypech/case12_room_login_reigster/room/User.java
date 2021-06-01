package com.hypech.case12_room_login_reigster.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {                 // table name: user
    @PrimaryKey(autoGenerate = true)
    private int id;                 // primary key : id

    private String name;            // column 1: name
    private String password;        // column 2: password
    private String email;           // column 3: email
    private String phonenum;        // column 4: phonenum

    public User(String name, String password, String email, String phonenum){
        this.name     = name;
        this.password = password;
        this.email    = email;
        this.phonenum = phonenum;
    }

    public int  getId()      {        return id;    }
    public void setId(int id){        this.id = id;    }

    public String getName()           {        return name;    }
    public void   setName(String name){        this.name = name;    }

    public String getPassword()               {        return password;    }
    public void   setPassword(String password){        this.password = password;    }

    public String getEmail()            {        return email;    }
    public void   setEmail(String email){        this.email = email;    }

    public String getPhonenum()               {        return phonenum;    }
    public void   setPhonenum(String phonenum){        this.phonenum = phonenum;    }
}
