package com.example.formlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.formlogin.Model.Example;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button btnDangNhap;
    EditText edtUserName, edtPassWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        dangnhap();
    }

    private void dangnhap() {
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = edtUserName.getText().toString();
                final String password = edtPassWord.getText().toString();
                //laydulieu
                GetLogin getLogin = new GetLogin("ktson", "KTSON", "ktson", "api.v1.oauth");
                Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("http://ktson.apos.vn:8443/api/")
                        .build();
                retrofit.create(API.class).GetLogin(getLogin).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        String strJson = null;
                        try {
                            strJson = response.body().string();
                            Gson gson = new Gson();
                            Example example = gson.fromJson(strJson, Example.class);
                            //laydulieu
                            String ten_user = example.getUsername();
                            String ten_pass = example.getPassword();
                            //kiemtra
                            if (username.equals(ten_user)){
                                Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

                            }else {
                                Toast.makeText(MainActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Vui lòng kiểm tra lại kết nối mạng", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }

    private void init(){
        btnDangNhap = findViewById(R.id.btn_dang_nhap);
        edtUserName = findViewById(R.id.edt_UserName);
        edtPassWord = findViewById(R.id.edt_PassWord);
    }
    class GetLogin{
        String UserName, PassWord, Storecode, Apiname;
        public GetLogin(String username, String password, String store_code, String api_name ){
            UserName = username;
            PassWord = password;
            Storecode = store_code;
            Apiname = api_name;
        }
    }
}
