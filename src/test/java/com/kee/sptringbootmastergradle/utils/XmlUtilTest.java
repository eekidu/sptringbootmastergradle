package com.kee.sptringbootmastergradle.utils;

import com.kee.sptringbootmastergradle.moudle.wechat.netpojo.ErrorBeanWechatPay;
import com.kee.sptringbootmastergradle.moudle.wechat.netpojo.wechatpay.UnifieddorderNotify;
import com.kee.sptringbootmastergradle.moudle.wechat.netpojo.wechatpay.Unifiedorder;
import com.kee.sptringbootmastergradle.moudle.wechat.netpojo.wechatpay.UnifiedorderResult;
import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import java.io.*;

public class XmlUtilTest {

    /**
     * XMLString 转 Object
     *
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        String xml0="<xml>\n" +
                "   <return_code>SUCCESS</return_code>\n" +
                "   <return_msg>OK</return_msg>\n" +
                "</xml>";


        String xml = "<xml>\n" +
                "   <appid>wx2421b1c4370ec43b</appid>\n" +
                "   <attach>支付测试</attach>\n" +
                "   <body>APP支付测试</body>\n" +
                "   <mch_id>10000100</mch_id>\n" +
                "   <nonce_str>1add1a30ac87aa2db72f57a2375d8fec</nonce_str>\n" +
                "   <notify_url>http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php</notify_url>\n" +
                "   <out_trade_no>1415659990</out_trade_no>\n" +
                "   <spbill_create_ip>14.23.150.211</spbill_create_ip>\n" +
                "   <total_fee>1</total_fee>\n" +
                "   <trade_type>APP</trade_type>\n" +
                "   <sign>0CB01533B8C1EF103065174F50BCA001</sign>\n" +
                "</xml> ";
        Strategy strategy = new AnnotationStrategy();
        Serializer serializer = new Persister(strategy);
        ErrorBeanWechatPay read1 = serializer.read(ErrorBeanWechatPay.class, xml0);
        System.out.println(read1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        serializer.write(read1,byteArrayOutputStream);
        System.out.println(byteArrayOutputStream.toString());

        Unifiedorder read = serializer.read(Unifiedorder.class, xml);
        System.out.println(read.toString());
    }

    @Test
    public void test01() {
        Unifiedorder unifiedorder = new Unifiedorder();
        unifiedorder.setAppid("123456");
        unifiedorder.setAttach("支付测试");
        unifiedorder.setMch_id("1000100");

        Strategy strategy = new AnnotationStrategy();
        Serializer serializer = new Persister(strategy);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            serializer.write(unifiedorder, byteArrayOutputStream);
            System.out.println(byteArrayOutputStream.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02() throws Exception {
        String xml = "<xml><return_code><![CDATA[FAIL]]></return_code>\n" +
                "<return_msg><![CDATA[appid不存在]]></return_msg>\n" +
                "</xml>";

        String xml1 = "<xml>\n" +
                "   <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "   <return_msg><![CDATA[OK]]></return_msg>\n" +
                "   <appid><![CDATA[wx2421b1c4370ec43b]]></appid>\n" +
                "   <mch_id><![CDATA[10000100]]></mch_id>\n" +
                "   <nonce_str><![CDATA[IITRi8Iabbblz1Jc]]></nonce_str>\n" +
                "   <sign><![CDATA[7921E432F65EB8ED0CE9755F0E86D72F]]></sign>\n" +
                "   <result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "   <prepay_id><![CDATA[wx201411101639507cbf6ffd8b0779950874]]></prepay_id>\n" +
                "   <trade_type><![CDATA[APP]]></trade_type>\n" +
                "</xml> ";

        Strategy strategy = new AnnotationStrategy();
        Serializer serializer = new Persister(strategy);
        ErrorBeanWechatPay read11 = serializer.read(ErrorBeanWechatPay.class, xml);
        System.out.println(read11);

        UnifiedorderResult read12 = serializer.read(UnifiedorderResult.class, xml);
        System.out.println(read12);


        ErrorBeanWechatPay read21 = serializer.read(ErrorBeanWechatPay.class, xml1);
        System.out.println(read21);

        UnifiedorderResult read22 = serializer.read(UnifiedorderResult.class, xml1);
        System.out.println(read22);

    }


    @Test
    public void getFiled() throws Exception {
        String temp = "<xml>\n" +
                "  <appid><![CDATA[wx2421b1c4370ec43b]]></appid>\n" +
                "  <attach><![CDATA[支付测试]]></attach>\n" +
                "  <bank_type><![CDATA[CFT]]></bank_type>\n" +
                "  <fee_type><![CDATA[CNY]]></fee_type>\n" +
                "  <is_subscribe><![CDATA[Y]]></is_subscribe>\n" +
                "  <mch_id><![CDATA[10000100]]></mch_id>\n" +
                "  <nonce_str><![CDATA[5d2b6c2a8db53831f7eda20af46e531c]]></nonce_str>\n" +
                "  <openid><![CDATA[oUpF8uMEb4qRXf22hE3X68TekukE]]></openid>\n" +
                "  <out_trade_no><![CDATA[1409811653]]></out_trade_no>\n" +
                "  <result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "  <sign><![CDATA[B552ED6B279343CB493C5DD0D78AB241]]></sign>\n" +
                "  <sub_mch_id><![CDATA[10000100]]></sub_mch_id>\n" +
                "  <time_end><![CDATA[20140903131540]]></time_end>\n" +
                "  <total_fee>1</total_fee>\n" +
                "<coupon_count><![CDATA[1]]></coupon_count>\n" +
                "<coupon_type><![CDATA[CASH]]></coupon_type>\n" +
                "<coupon_id><![CDATA[10000]]></coupon_id>\n" +
                "<coupon_fee><![CDATA[100]]></coupon_fee>\n" +
                "  <trade_type><![CDATA[JSAPI]]></trade_type>\n" +
                "  <transaction_id><![CDATA[1004400740201409030005092168]]></transaction_id>\n" +
                "</xml> ";

        Strategy strategy = new AnnotationStrategy();
        Serializer serializer = new Persister(strategy);
        UnifieddorderNotify read = serializer.read(UnifieddorderNotify.class, temp);
        System.out.println(read);

//        StringReader stringReader = new StringReader(temp);
//        BufferedReader bufferedReader = new BufferedReader(stringReader);
//        String line = null;
//        while ((line = bufferedReader.readLine()) != null) {
//            String substring = line.substring(line.indexOf("<") + 1, line.indexOf(">"));
//            System.out.println(substring);
//        }
    }

}