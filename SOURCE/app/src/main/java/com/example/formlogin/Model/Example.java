package com.example.formlogin.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Example implements Serializable {

@SerializedName("username")
@Expose
private String username;
@SerializedName("password")
@Expose
private String password;
@SerializedName("store_code")
@Expose
private String storeCode;
@SerializedName("api_name")
@Expose
private String apiName;

public String getUsername() {
return username;
}

public void setUsername(String username) {
this.username = username;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}

public String getStoreCode() {
return storeCode;
}

public void setStoreCode(String storeCode) {
this.storeCode = storeCode;
}

public String getApiName() {
return apiName;
}

public void setApiName(String apiName) {
this.apiName = apiName;
}

}