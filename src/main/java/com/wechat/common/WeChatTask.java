package com.wechat.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.wechat.start.GlobalConstants;
import com.wechat.utils.HttpUtils;
import net.sf.json.JSONObject;

/**
 * ClassName: WeChatTask
 * @Description: ΢����Сʱ��ʱ������
 * @author dapengniao
 * @date 2016 �� 3 �� 10 �� ���� 1:42:29
 */
public class WeChatTask {
    /**
     * @Description: ����ִ����
     * @param @throws Exception
     * @author dapengniao
     * @date 2016 �� 3 �� 10 �� ���� 2:04:37
     */
    public void getToken_getTicket() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "client_credential");
        params.put("appid", GlobalConstants.getInterfaceUrl("appid"));
        params.put("secret", GlobalConstants.getInterfaceUrl("AppSecret"));
        String jstoken = HttpUtils.sendGet(
                GlobalConstants.getInterfaceUrl("tokenUrl"), params);
        String access_token = JSONObject.fromObject(jstoken).getString(
                "access_token"); // ��ȡ�� token ����ֵ����
        System.out.println("********************************************************");
        System.out.println("********************************************************");
        System.out.println("********************************************************");
        System.out.println("********************************************************");
        System.out.println(access_token);
        System.out.println("********************************************************");
        System.out.println("********************************************************");
        System.out.println("********************************************************");
        GlobalConstants.interfaceUrlProperties.put("access_token", access_token);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"token Ϊ==============================\n"+access_token);
    }

}