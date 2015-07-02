package com.gx303.framedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.gx303.fastandroid.http.FastHttp;
import com.gx303.fastandroid.http.FastHttpCallback;
import com.gx303.framedemo.listviewdemo.LvActivity;
import com.gx303.framedemo.pulllistview.LoadMoreActivity;

import org.json.JSONObject;


public class MainActivity extends com.gx303.fastandroid.BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        e("aaaaaaaaaaaaaaaaaaaaa");



//        StringRequest stringRequest = new StringRequest("http://www.baidu.com",
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                       e( response);
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//             e(error.getMessage());
//            }
//        });
//        RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());
//        mQueue.add(stringRequest);
//        stringRequest.


//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://m.weather.com.cn/data/101010100.html", null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                       e(response.toString());
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//               e("error"+error.getMessage());
//            }
//        });
//        mQueue.add(jsonObjectRequest);

//        FastHttp.getJson("http://www.weather.com.cn/data/sk/101010100.html", null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                t(response.toString());
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                e("error"+error.toString());
//            }
//        });

        FastHttp.getJson("http://www.weather.com.cn/data/sk/101010100.html", null, new FastHttpCallback() {
            @Override
            public void onStart() {
                e("开始");
            }

            @Override
            public void onEnd() {
                e("结束");
            }

            @Override
            public void onResponse(JSONObject response) {
                e(response.toString());
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                e("error"+error.toString());
            }
        });
    }

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void findViews() {

    }

    @Override
    public void getData() {

    }

    @Override
    public void showContent() {

    }

    public void openlistview(View v)
    {
        Intent it_lv=new Intent();
        it_lv.setClass(getApplicationContext(), LvActivity.class);
        startActivity(it_lv);
    }
    public void openpulllistview(View v)
    {
        Intent it_pull=new Intent();
        it_pull.setClass(getApplicationContext(),com.gx303.framedemo.pulllistview.PullRefreshActivity.class);
//        it_pull.setClass(getApplicationContext(), LvActivity.class);
        startActivity(it_pull);
    }
    public void openloadmore(View v)
    {
        Intent it_loadmore=new Intent();
        it_loadmore.setClass(getApplicationContext(), LoadMoreActivity.class);
        startActivity(it_loadmore);
    }
    public void openfragment(View v)
    {
        Intent it_fra=new Intent();
        it_fra.setClass(getApplicationContext(),testFragmentActivity.class);
        startActivity(it_fra);
    }

}