package com.my.blog.website;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Test_main {
	@SuppressWarnings("static-access")
	public static void main(String[] args)throws Exception {

		//1、加密encode
//		final Base64.Decoder decoder = Base64.getDecoder();
//		final Base64.Encoder encoder = Base64.getEncoder();
//		final String text = "1805231825000001,1529549002,554433221100001,1";
//		final byte[] textByte = text.getBytes("UTF-8");
//		//编码
//		final String encodedText = encoder.encodeToString(textByte);
//		System.out.println("编码为："+encodedText);
//		//解码
//		System.out.println("解码为："+new String(decoder.decode(encodedText), "UTF-8"));
//
//		//2、验证正则表达式
//		String phoneNum = "16634567890";
//		String match = "^1[3|4|5|7|8][0-9]\\d{4,8}$";
//		if(!phoneNum.matches(match)){
//			System.out.println("该用户的手机号码格式有误，不能重置密码，请联系管理员！");
//		}else{
//			System.out.println("手机格式正确："+phoneNum);
//		}
//
//		//3、获取系统当前时间（毫秒）
//		long currentTime = new Date().getTime();
//		System.out.println("当前时间："+currentTime);
//
//		//4、加密方式，默认MD5，可选SHA
//		String hashAlgorithmName = "MD5";
//		int hashIterations = 1024;
//		String username = "412828";
//		String credentials = "abc111111";
//		ByteSource credentialsSalt = ByteSource.Util.bytes(username);
//		Object obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
//		System.out.println("USERNAME："+credentialsSalt);
//		System.out.println("加密后的用户和密码："+obj);
//		System.out.println("加密后的用户和密码str："+obj.toString());
//		Map pa = new HashMap();
//		String url = "https://www.baidu.com";
//		String res = HttpClientUtil.httpPostRequest(url,pa);
//		System.out.println("请求获取的数据："+res);
//
		//5、生成二维码
//		String imgPath = "d:/qrCode.png";
//		String encoderContent = "http://www.baidu.com";
//		CreateQRCode.encoderQRCode(encoderContent, imgPath, "png");
//		System.out.println("encoder success!!!");
//
//		String json = "{\"2\":\"efg\",\"1\":\"abc\"}";
//		JSONObject json_test = JSONObject.parseObject(json);
//		System.out.print("json_test:"+json_test);
//		System.out.print("\n");
//		String dj = "";
//		String hsbz = "1";
//		String je = "4.555";
//		String sl = "0.17";
//		Float djNew = null;
//		Float jeNew = null;
//		//含税标志 1为含税，0不含税
//		if("1".equals(hsbz)){
//			hsbz = "0";
//			if(!("".equals(dj)) && dj != null){
//				djNew = (Float.parseFloat(dj))/(1+Float.parseFloat(sl));
//			}else{
//				djNew = Float.valueOf(0);
//			}
//			jeNew = (Float.parseFloat(je))/(1+Float.parseFloat(sl));
//		}
//		System.out.println("单价："+ String.format("%.6f",djNew));
//		System.out.println("金额："+ String.format("%.2f",jeNew));

		//6、生成二维码功能测试
//		JSONObject kpxxJson = new JSONObject();
//		Map kpxx = new HashMap();
//		kpxx.put("order_id","499000143605111");
//		Map kpmx = new HashMap();
//		kpmx.put("spmc","油菜籽");
//		kpmx.put("spsl","100");
//		kpmx.put("dj","1.340000");
//		kpmx.put("je","134.00");
//		kpmx.put("jldw","斤");
//		kpmx.put("ggxh","斤");
//		kpmx.put("fphxz","0");
//		kpmx.put("hsbz","0");
//		List<Map> pmmx = new ArrayList();
//		pmmx.add(kpmx);
//		Map pmmxMap = new HashMap();
//		kpxx.put("detail", pmmx);
//		pmmxMap.putAll(kpxx);
//		kpxxJson = (JSONObject) JSONObject.toJSON(pmmxMap);
//		String kpxxJs = kpxxJson.toString();
//		String key = "abcdefgh";
//		byte[] result = DES.encrypt(kpxxJs.getBytes(), key);
//		System.out.println("Des加密后：" + new String(result));
//		byte[] kpxxJsByte = result;
//		String kpxxJsText = encoder.encodeToString(kpxxJsByte);
//		System.out.println("base64加密后json对象："+kpxxJsText);
////		//解码
//		byte[] kpxxJsDe = decoder.decode(kpxxJsText);
//		System.out.println("base64解码为："+kpxxJsDe);
//		byte[] decryResult = DES.decrypt(kpxxJsDe, key);
//		String dec = new String(decryResult);
//		System.out.println("Des解密后：" + dec);
//		//生成二维码
//		String imgPath = "D:/scewm_gfxx.png";
//		String token = "jfLMQQBlm6kRK8v03514";
//		String encoderContent = "http://173n2f1936.iask.in:44694/pos/ewm?token="+token;
////		CreateQRCode.encoderQRCode(encoderContent, imgPath, "png");
////		System.out.println("二维码生成成功");
//		//ZXing生成二维码
////		CreateZXingQRCode.Encode_QR_CODE(encoderContent, imgPath, "png");
////		System.out.println("二维码生成成功");
//		System.out.println(("二维码生成成功\t\n\rfdsfdsfdsfdsf"));
//		System.out.println(("二维码生成成功\t\n\rfdsfdsfdsfdsf").replaceAll("[\\s*\t\n\r]", ""));

//		7、请求获取发票抬头
//		String nsrsbh = "554433221100001";
//		String sksbbh = "33498201137581";
//		StringBuffer buff = new StringBuffer();
//		buff.append("<?xml version=\"1.0\" encoding=\"gbk\"?>");
//		buff.append("<business comment=\"发票抬头申请列表\" id=\"FPTTSQLB\">");
//		buff.append("<body yylxdm=\"1\">");
//		buff.append("<input>");
//		buff.append("<NSRSBH>"+nsrsbh+"</NSRSBH>");
//		buff.append("<SKSBBH>"+sksbbh+"</SKSBBH>");
//		buff.append("<SQYXQ>"+5+"</SQYXQ>");
//		buff.append("</input>");
//		buff.append("</body>");
//		buff.append("</business>");
//		String buffxml = buff.toString();
//		System.out.println("请求获取发票抬头报文："+buffxml);
//		final byte[] textByte = buffxml.getBytes("UTF-8");
//		//编码
//		final String encodedXml = encoder.encodeToString(textByte);
//		System.out.println("报文编码为："+encodedXml);
//		//解码
//		System.out.println("报文解码为："+new String(decoder.decode(encodedXml), "UTF-8"));
//
//		System.out.println("请求获取发票抬头报文："+encodedXml);
//		String url = "http://kp.gdfapiao.com/is/wxinvoice/getTitle";
//		String result = HttpRequestUtils.httpRequest(url, "POST", encodedXml);
//		System.out.println("请求获取发票抬头返回结果："+result);
//		System.out.println("请求获取发票抬头返回结果解密为："+new String(decoder.decode(result), "UTF-8"));



		//8、请求获取生成的企业二维码信息链接 554433221100001  33498201137590  33498201137581(广州百望测试2)
//		String nsrsbh_ewm = "554433221100001";
//		String sksbbh_ewm = "33498201137581";
//		StringBuffer buff_ewm = new StringBuffer();
//		buff_ewm.append("<?xml version=\"1.0\" encoding=\"gbk\"?>");
//		buff_ewm.append("<business comment=\"企业二维码信息\" id=\"QYEWMXX\">");
//		buff_ewm.append("<body yylxdm=\"1\">");
//		buff_ewm.append("<input>");
//		buff_ewm.append("<NSRSBH>"+nsrsbh_ewm+"</NSRSBH>");
//		buff_ewm.append("<SKSBBH>"+sksbbh_ewm+"</SKSBBH>");
//		buff_ewm.append("</input>");
//		buff_ewm.append("</body>");
//		buff_ewm.append("</business>");
//		String buffEwmXml = buff_ewm.toString();
//		System.out.println("请求获取生成的企业二维码信息报文："+buffEwmXml);
//		final byte[] textByteEwm = buffEwmXml.getBytes("UTF-8");
//		//编码
//		final String encodedEwmXml = encoder.encodeToString(textByteEwm);
//		System.out.println("报文编码为："+encodedEwmXml);
//		System.out.println("请求获取生成的企业二维码信息报文："+encodedEwmXml);
//		String urlEwm = "http://kp.gdfapiao.com/is/wxinvoice/getCodeUrl";
//		String resultEwm = HttpRequestUtils.httpRequest(urlEwm, "POST", encodedEwmXml);
//		System.out.println("请求获取生成的企业二维码信息返回结果："+resultEwm);
//		String ewmResult = new String(decoder.decode(resultEwm), "UTF-8");
//		System.out.println("请求获取生成的企业二维码信息结果解密为："+ewmResult);

//		String ewmResult = "<?xml version=\"1.0\" encoding=\"gbk\"?><business comment=\"企业二维码信息\" id=\"QYEWMXX\"><body yylxdm=\"1\"><output><EWMXX>https://mp.weixin.qq.com/intp/invoice/usertitle?action=select_title&select_title_key=GJIMgA8R6Cr0qjTk0v63gYVYaLSXwnJGBmynQ8gDkJo.#wechat_redirect</EWMXX><NSRSBH>410811888888883461</NSRSBH><RETURNCODE>0</RETURNCODE><RETURNMSG>成功</RETURNMSG><SKSBBH>499000143605</SKSBBH></output></body></business>";
//		String ewmResult = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
//				"<business comment=\"发票抬头申请列表\" id=\"FPTTSQLB\">" +
//				"  <body yylxdm=\"1\">" +
//				"    <output>" +
//				"      <FPSQLIST COUNT=\"2\">" +
//				"        <FPSQ XH=\"1\">" +
//				"          <FPSQLSH>18052410034724</FPSQLSH>" +
//				"          <NSRDZDH>郑州市管城区东明路南41号1号</NSRDZDH>" +
//				"          <NSRMC>河南航天金穗电子有限公司</NSRMC>" +
//				"          <NSRSBH>91410104712644904A</NSRSBH>" +
//				"          <NSRYHZH/>" +
//				"        </FPSQ>" +
//				"		 <FPSQ XH=\"2\">" +
//				"          <FPSQLSH>18052410034725</FPSQLSH>" +
//				"          <NSRDZDH>郑州市管城区东明路南</NSRDZDH>" +
//				"          <NSRMC>河南航天金穗</NSRMC>" +
//				"          <NSRSBH>914101047126449011</NSRSBH>" +
//				"          <NSRYHZH/>" +
//				"        </FPSQ>"+
//				"		 <FPSQ XH=\"3\">" +
//				"          <FPSQLSH>18052410034725</FPSQLSH>" +
//				"          <NSRDZDH>郑州市管城区东明路南</NSRDZDH>" +
//				"          <NSRMC>河南航天金穗</NSRMC>" +
//				"          <NSRSBH>914101047126449011</NSRSBH>" +
//				"          <NSRYHZH/>" +
//				"        </FPSQ>"+
//				"      </FPSQLIST>" +
//				"      <NSRSBH>410811888888883461</NSRSBH>" +
//				"      <RETURNCODE>0</RETURNCODE>" +
//				"      <RETURNMSG>成功</RETURNMSG>" +
//				"      <SKSBBH>499000143605</SKSBBH>" +
//				"    </output>" +
//				"  </body>" +
//				"</business>";
//		String ewm = ewmResult.replace("&","%26");
//		Document doc = DocumentHelper.parseText(ewm);
//		Element rootElt = doc.getRootElement();
//		System.out.println("根节点：" + rootElt.getName()); // 拿到根节点的名称
//		Element body = rootElt.element("body");
//		Element output = body.element("output");
//		Element fpsqlist = output.element("FPSQLIST");
//		String count = fpsqlist.attributeValue("COUNT");
//		String returncode = output.elementTextTrim("RETURNCODE");
//		String returnmsg = output.elementTextTrim("RETURNMSG");
//		List<Map> titleList = new ArrayList<>();
//		// 递归遍历当前节点所有的子节点
//		List<Element> listElement = fpsqlist.elements();
//		if(listElement.size() > 0){
//			for (int i = 0;i < listElement.size();i++) {
//				Map titleMap = new HashMap();
//				Element fpsqlsList = listElement.get(i);
//				String xh = fpsqlsList.attributeValue("XH");
//				String fpsqlsh = fpsqlsList.elementTextTrim("FPSQLSH");
//				String gmf_nsrdzdh = fpsqlsList.elementTextTrim("NSRDZDH");
//				String gmf_nsrmc = fpsqlsList.elementTextTrim("NSRMC");
//				String gmf_nsrsbh = fpsqlsList.elementTextTrim("NSRSBH");
//				String gmf_nsryhzh = fpsqlsList.elementTextTrim("NSRYHZH");
//				titleMap.put("XH",xh);
//				titleMap.put("FPSQLSH",fpsqlsh);
//				titleMap.put("GMF_NSRDZDH",gmf_nsrdzdh);
//				titleMap.put("GMF_NSRMC",gmf_nsrmc);
//				titleMap.put("GMF_NSRSBH",gmf_nsrsbh);
//				titleMap.put("GMF_NSRYHZH",gmf_nsryhzh);
//				titleList.add(titleMap);
//			}
//		}
//		Map title = new HashMap();
//		title.put("FPSQLIST",titleList);
//		JSONObject titleJson = (JSONObject) JSONObject.toJSON(title);
////		String ewmxx1 = java.net.URLDecoder.decode(ewmxx);//访问链接中被替换的&符号（%26）还原为&
//		System.out.println("测试结果："+titleJson);

		//9、测试查询数组中相同值的数据，并转化为不同的数据
		// val = aa01，val = bb01，val = cc01，val = dd01，val = bb02，val = ee01，val = dd02，val = ff01，
		// val = aa02，val = bb03，val = cc02，val = dd03，val = bb04，val = ee02，val = dd04，val = ff02
//		List<String> list = new ArrayList<String>();
//		list.add("aa");
//		list.add("bb");
//		list.add("cc");
//		list.add("dd");
//		list.add("bb");
//		list.add("ee");
//		list.add("dd");
//		list.add("ff");
//		list.add("aa");
//		list.add("bb");
//		list.add("cc");
//		list.add("dd");
//		list.add("bb");
//		list.add("ee");
//		list.add("dd");
//		list.add("ff");
//		String [] indexArr ;
//		Map<String, String> map = new HashMap<String, String>();
//		for (int i = 0; i < list.size(); i++) {
//			String key = list.get(i);
//			String old = map.get(key);
//			if (old != null) {
//				map.put(key, old + "," + (i + 1));
//			} else {
//				map.put(key, "" + (i + 1));
//			}
//		}
//		Iterator<String> it = map.keySet().iterator();
//		int index = -1;
//		while (it.hasNext()) {
//			String key = it.next();
//			String value = map.get(key);
//			if (value.indexOf(",") != -1) {
//				System.out.println(key + " 重复,行： " + value);
//				indexArr = value.split(",");
//
//				for (int i = 0; i < indexArr.length; i++) {
//					index = Integer.parseInt(indexArr[i])-1;
//					list.set(index, list.get(index)+"0"+(1+i));
//				}
//			}else{
//				list.set(Integer.parseInt(value)-1,key+"01");
//			}
//		}
//
//		for (String val : list) {
//			System.out.println("val = "+val);
//		}
//		System.out.println("..................");

		//10、DES加密解密测试
//		DES enDe = new DES();
//		//密码，长度要是8的倍数
//		String password = "QbUntHpD";
////		String sh = "1806221059570001,1530936510,554433221100001,1";
//		String sh = "14100000000,1529549002,410811888888883461,1";
//		String shnsr = (new Date().getTime()+3600000)+",554433221100001";//3VUZWPfirpzY/CHnzC4ceHoKQIQBnucfC37Q9FGhzuc=
//		byte[] result = enDe.encrypt(sh.getBytes(), password);
//		byte[] resultNsr = enDe.encrypt(shnsr.getBytes(), password);
//		String reStr = Base64Util.base64encode(result);
//		String reNsrStr = Base64Util.base64encode(resultNsr);
//		System.out.println("token加密后：" + reStr + "/长度:"+reStr.length());
//		System.out.println("纳税人识别号加密后：" + reNsrStr + "/长度:"+reNsrStr.length());
//		//直接将如上内容解密
//		try {
//			byte[] decryResult = enDe.decrypt(Base64Util.base64decode(reNsrStr), password);
//			String[] de =  new String(decryResult).split(",");
//			System.out.println("解密后：" + de[0] +"--"+ Long.parseLong(de[1])+"--"+"----"+de.length);
//			long detime = Long.parseLong(de[1]);
//			//毫秒转化为时间
//			Date date2 = new Date();
//			date2.setTime(detime*1000);
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			System.out.println(simpleDateFormat.format(date2));
//			long currentTime = (new Date().getTime());
//			System.out.println("当前时间："+currentTime+"----"+detime);
//			if("1".equals(de[1]) && currentTime <= detime){
//				System.out.println("当前时间："+currentTime+"----"+detime);
//			}
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}

		//11、获取当前日期后一年后每个月的天数
//		Date nowTime=new Date();//获取当前时间
//		SimpleDateFormat yearPattern=new SimpleDateFormat("yyyy");//获取字符串型年份的对象
//		SimpleDateFormat monthPattern=new SimpleDateFormat("MM");//获取字符串型月份的对象
//		int inty=Integer.parseInt(yearPattern.format(nowTime));//将当前年份转化为整型
//		int intm=Integer.parseInt(monthPattern.format(nowTime));//将当前月份转化为整型
//		int a[]=new int[13];//定义一个整型数组
//		a[0]=intm;
//		System.out.println("当月之后半年内每月的天数：");
//		for(int i=1;i<13;i++) {
//			if(a[i-1]==12) {
//				a[i]=1;
//				inty=inty+1;
//				calculate(a[i],inty);
//			} else {
//				a[i]=a[i-1]+1;
//				calculate(a[i],inty);
//			}
//		}
//
//		//12、获取两日期之间的天数
//		Calendar calendar = new GregorianCalendar();
//		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = new Date();
//		System.out.println("今天："+sm.format(date));
//		calendar.setTime(date);
//		calendar.add(calendar.YEAR, 1);//把日期往后增加一年.整数往后推,负数往前移动
////		calendar.add(calendar.DAY_OF_MONTH, 1);//把日期往后增加一个月.整数往后推,负数往前移动
////		calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
////		calendar.add(calendar.WEEK_OF_MONTH, 1);//把日期往后增加一个月.整数往后推,负数往前移动
//		Date dateAfter=calendar.getTime();
//		System.out.println("一年后："+sm.format(dateAfter));
//		int days = (int) ((dateAfter.getTime() - date.getTime()) / (1000*3600*24));
//		System.out.println("间隔天数："+days);

		//13、测试点下户回调接口
//		Map kpxxMap = new HashMap();
//		kpxxMap.put("FPQQLSH","m7PgzbuWEE4iH4x03154");
//		kpxxMap.put("STATUS","0");
//		kpxxMap.put("KPRQ","2018-04-16");
//		kpxxMap.put("DZFPPDF","http://www.bwfapiao.com/api/dl.do?id=699D16AEA9D4026EE0530A0A0D337697");
//		//调用工具类发报文
//		SendYwptMessage smypt = new SendYwptMessage();
//		YwptXmlUtil xmlUtil = new YwptXmlUtil();
//		String resultYpt = smypt.sendMsgFpStatus(xmlUtil.getKjcgXml(kpxxMap));
//		System.out.println("测试点下户回调接口返回结果："+resultYpt);

		//14、测试发票查询接口
//		String responseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><header><TOKEN>ZjAyZDY4Y2ZkMjY5NDkxYThlNTk4MmEyNmJmNGMwNDI=</TOKEN><topicName>发票查询</topicName><topicCode>30011</topicCode></header><body><data><KPJGCX class=\"REQUEST_COMMON_KPJGCX\" size=\"1\"><KPSJ><FPQQLSH>A2N7q9iv3Vlegw4v1287</FPQQLSH></KPSJ></KPJGCX></data></body></root>";
//		String url = "http://10.3.254.91:7001/connect/oauth2/invoice/xml/query.jspx";
//		SendMessage sm = new SendMessage();
//		String result = sm.sendKpztxx(responseXml);
//		System.out.println("电子发票服务云发票查询结果："+result);

		//15、判断json字符串格式是否正确
		ScriptEngineManager sem = new ScriptEngineManager ();
		ScriptEngine se = sem.getEngineByName ("js");
		String jsonstr = "({name: 1, obj: 3,[dd]})";
		try {
			System.out.println (se.eval (jsonstr));
		} catch (Exception e) {
			System.out.println ("json格式有误");
		}
	}

	//11.1、知月份年份求月份天数的方法caluculate
	public static void calculate(int m,int y) {
		if(m==1||m==3||m==5||m==7||m==8||m==10||m==12){
			System.out.println(y+"年"+m+"月："+"31天");
		} else if(m!=2){
			System.out.println(y+"年"+m+"月："+"30天");
		} else if((y%4==0&&y%100!=0)||(y%400==0)){
			System.out.println(y+"年"+m+"月："+"29天");
		} else{
			System.out.println(y+"年"+m+"月："+"28天");
		}

	}
}
