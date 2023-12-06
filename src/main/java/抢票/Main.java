package 抢票;/*
 *author：yangyu
 *creation time：2023/10/3 17:08
 */

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson2.JSONObject;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory(), SSLSocketClient.getX509TrustManager())
                .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                .build();
        String url = "https://kyfw.12306.cn/passport/web/create-qr64";

        FormBody.Builder form = new FormBody.Builder();
        form.add("appid", "otn");
        FormBody body = form.build();

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        String result = response.body().string();
        System.out.println(response.headers().get("Set-Cookie").toString());


/*        JSONObject jsonObject = JSONObject.parseObject(result);
        String image = jsonObject.get("image").toString();
        String uuid = jsonObject.get("uuid").toString();

        FileUtil.writeBytes(Base64.decode(image), "D:\\dl.png");



        String url2 = "https://kyfw.12306.cn/passport/web/auth/uamtk";
        new Request.Builder()*/
    }
}
