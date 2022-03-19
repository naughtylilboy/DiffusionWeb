
//package Fastjson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.time.*;
import java.util.*;
//import net.sf.json.JSONObject;
//import net.sf.json.JSONArray;
//import net.sf.json.JSON;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public HttpServletResponse response1,responsecalc,responseclient;
	int number=0;String iscalcserver="1";String iscustomer="0";String isinit="0";
	String isresult="1";String issubmit="2"; String isreturn="3";
//	int iscalcserver=1;int iscustomer=0;int isinit=0;
//	int isresult=1;int issubmit=2; int isreturn=3;
	//json js,result;
    /**
     * Default constructor. 
     */
    public ServletTest() {
        // TODO Auto-generated constructor stub
    	//ServletContext sc=getServletConfig().getServletContext();
    	//this.getServletContext().setAttribute("name",0);
    }

	/**
	 * @param name 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.getWriter().append("Served at: ").append(request.getContextPath()+"\n");
		PrintWriter out=response.getWriter();
		out.println("this is just a test \n");
		response1=response;
		sleep(1000);
		response.getWriter().append("global response \n");
		number+=1;
		response.getWriter().append("this is No."+number+" visitor \n");
		int temp=0;
		/*while(number==2) {
			while(number>2) {if(number==7) {response1.getWriter().append("this is No."+number+" visitor \n");break;}
			break;}
		}*/
		ServletContext sc=this.getServletContext();
		
		//temp=(int)sc.getAttribute("name");
		//temp++;
/*		if(sc.getAttribute("name")==null) {temp=0;sc.setAttribute("name",temp);}
		else {temp=(int)sc.getAttribute("name");
		sc.setAttribute("name",temp+1);}
		while((int)sc.getAttribute("name")==2) {
			while((int)sc.getAttribute("name")<6) {//sc.setAttribute("name",temp+1);
			    if((int)sc.getAttribute("name")==5) {response.getWriter().append("this is global obj. "+sc.getAttribute("name")+"\n");break;}
			sleep(100);
			}
			sleep(100);
		
		}
	*/	
		//response.getWriter().append("this is global obj. "+sc.getAttribute("name")+"\n");
		
		sleep(1000);
/*		
		int salesVolume=10;
		double bussinessVolume=100;
		char[] months={'1'};
		Map<String, Object>map= new HashMap<>();
		map.put("salesVolume",salesVolume);
		map.put("bussinessVolume", bussinessVolume);
		map.put("months", months);
		response.getWriter().println(JSON.toJSONString(map));
		//response.getWriter().println(
*/
		
		/*销量*/
		Integer[] salesVolume = {10,100,20,56,35,80};
		/*营业额*/
		double[] bussinessVolume = {10*10,100*8.5,20*9.5,56*9,35*9.5,80*9};
		/*横轴, 月份数据*/
		String[] months = {"1","2","3","4","5","6"};
		//String[] months = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93"};
		Map<String, Object> map = new HashMap<>();
		map.put("salesVolume", salesVolume);
		map.put("bussinessVolume",bussinessVolume);
		map.put("months", months);
		//double[] result= {3.33972e+020,2.39221e+020,1.79675e+020,1.4394e+020,1.20735e+020,1.04426e+020,9.22397e+019,8.27052e+019,7.4977e+019,6.85369e+019,6.30499e+019,5.82894e+019,5.4097e+019,5.03582e+019,4.69884e+019,4.39236e+019,4.11146e+019,3.85231e+019,3.61186e+019,3.38767e+019,3.17781e+019,2.98066e+019,2.79493e+019,2.61956e+019,2.45367e+019,2.29653e+019,2.14754e+019,2.00618e+019,1.87205e+019,1.74476e+019,1.62401e+019,1.50953e+019,1.40105e+019,1.29836e+019,1.20124e+019,1.10947e+019,1.02285e+019,9.41187e+018,8.64265e+018,7.91888e+018,7.23854e+018,6.59963e+018,6.00021e+018,5.4384e+018,4.91242e+018,4.42062e+018,3.96152e+018,3.53383e+018,3.13644e+018,2.76846e+018,2.42916e+018,2.11791e+018,1.83415e+018,1.57729e+018,1.34663e+018,1.1413e+018,9.6017e+017,8.01908e+017,6.64934e+017,5.47493e+017,4.47707e+017,3.63651e+017,2.93419e+017,2.35177e+017,1.87215e+017,1.47971e+017,1.16049e+017,9.02234e+016,6.94331e+016,5.27727e+016,3.94776e+016,2.89092e+016,2.05381e+016,1.39292e+016,8.72721e+015,4.6439e+015,1.4466e+015,-1.05148e+015,-2.9996e+015,-4.51649e+015,-5.69624e+015,-6.61311e+015,-7.32549e+015,-7.87914e+015,-8.30983e+015,-8.64539e+015,-8.90745e+015,-9.11275e+015,-9.27423e+015,-9.40187e+015,-9.50335e+015,-9.58456e+015,-9.65003e+015,-9.70324e+015,-9.74683e+015,-9.78286e+015,-9.81289e+015,-9.83813e+015,-9.85952e+015,-9.87776e+015,-9.89343e+015,-9.90697e+015,-9.91872e+015,-9.92897e+015,-9.93794e+015,-9.9458e+015,-9.95272e+015,-9.95881e+015,-9.96418e+015,-9.96891e+015,-9.97309e+015,-9.97678e+015,-9.98003e+015,-9.9829e+015,-9.98542e+015,-9.98765e+015,-9.98961e+015,-9.99133e+015,-9.99284e+015,-9.99417e+015,-9.99533e+015,-9.99635e+015,-9.99724e+015,-9.99801e+015,-9.99869e+015,-9.99928e+015,-9.99979e+015,-1.00002e+016,-1.00006e+016,-1.0001e+016,-1.00013e+016,-1.00015e+016,-1.00017e+016,-1.00019e+016,-1.00021e+016,-1.00022e+016,-1.00023e+016,-1.00024e+016,-1.00025e+016,-1.00026e+016,-1.00027e+016,-1.00027e+016,-1.00028e+016,-1.00028e+016,-1.00028e+016,-1.00029e+016,-1.00029e+016,-1.00029e+016,-1.00029e+016,-1.00029e+016,-1.00029e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016,-1.0003e+016};
		//double[] result= {333972000000000000000,239221000000000000000,179675000000000000000,143940000000000000000,120735000000000000000,104426000000000000000,92239700000000000000,82705200000000000000,74977000000000000000,68536900000000000000,63049900000000000000,58289400000000000000,54097000000000000000,50358200000000000000,46988400000000000000,43923600000000000000,41114600000000000000,38523100000000000000,36118600000000000000,33876700000000000000,31778100000000000000,29806600000000000000,27949300000000000000,26195600000000000000,24536700000000000000,22965300000000000000,21475400000000000000,20061800000000000000,18720500000000000000,17447600000000000000,16240100000000000000,15095300000000000000,14010500000000000000,12983600000000000000,12012400000000000000,11094700000000000000,10228500000000000000,9411870000000000000,8642650000000000000,7918880000000000000,7238540000000000000,6599630000000000000,6000210000000000000,5438400000000000000,4912420000000000000,4420620000000000000,3961520000000000000,3533830000000000000,3136440000000000000,2768460000000000000,2429160000000000000,2117910000000000000,1834150000000000000,1577290000000000000,1346630000000000000,1141300000000000000,960170000000000000,801908000000000000,664934000000000000,547493000000000000,447707000000000000,363651000000000000,293419000000000000,235177000000000000,187215000000000000,147971000000000000,116049000000000000,90223400000000000,69433100000000000,52772700000000000,39477600000000000,28909200000000000,20538100000000000,13929200000000000,8727210000000000,4643900000000000,1446600000000000,1051480000000000,2999600000000000,4516490000000000,5696240000000000,6613110000000000,7325490000000000,7879140000000000,8309830000000000,8645390000000000,8907450000000000,9112750000000000,9274230000000000,9401870000000000,9503350000000000,9584560000000000,9650030000000000,9703240000000000,9746830000000000,9782860000000000,9812890000000000,9838130000000000,9859520000000000,9877760000000000,9893430000000000,9906970000000000,9918720000000000,9928970000000000,9937940000000000,9945800000000000,9952720000000000,9958810000000000,9964180000000000,9968910000000000,9973090000000000,9976780000000000,9980030000000000,9982900000000000,9985420000000000,9987650000000000,9989610000000000,9991330000000000,9992840000000000,9994170000000000,9995330000000000,9996350000000000,9997240000000000,9998010000000000,9998690000000000,9999280000000000,9999790000000000,10000200000000000,10000600000000000,10001000000000000,10001300000000000,10001500000000000,10001700000000000,10001900000000000,10002100000000000,10002200000000000,10002300000000000,10002400000000000,10002500000000000,10002600000000000,10002700000000000,10002700000000000,10002800000000000,10002800000000000,10002800000000000,10002900000000000,10002900000000000,10002900000000000,10002900000000000,10002900000000000,10002900000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000,10003000000000000};

		//map.put("profile", result);
		//response.getWriter().println(JSON.toJSONString(map));
		//response.getWriter().println(JSON.toJSONString(map));
		//response.getWriter().println(request.getParameter("resultinfo"));
		//	"Strsheet":"",  "StrProfile":[
		
		//response.getWriter().println(request.getParameter("x"));
		
		//response.setContentType("application/json;charset=gb2312");
      /*  JSONObject jsonObject = new JSONObject();  
        jsonObject.put("username", "lwc");  
        jsonObject.put("password", "123"); 
        //response.getWriter().println(jsonObject);
        String st=request.getParameter("x");
        //JSONObject jsonObject2=JSONObject.fromObject(st);
        //JSONObject jsonObject1 = new JSONObject(); 
        //jsonObject1.fromObject(st);
        response.getWriter().println(jsonObject2);
        //response.getWriter().println("AAA");
        //response.getWriter().println("<html><head><title>test</title></head><body>");
        //response.getWriter().println("<p id=\"demo\">ppp</p></body></html>");
        response.getWriter().close();
        //response.getWriter().println(jsonObject.toJSONString);
        //jsonObject.clear();*/
		//response.getWriter().println(JSON.toJSONString(map));iscalcserver==request.getParameter("host")
		//String rq=request.getParameter("host");
		if(request.getParameter("host").equals(iscalcserver))
		{
			//response.getWriter().println(JSON.toJSONString(request.getParameter("host")));//response.getWriter().println(rq);
			if(request.getParameter("hostact").equals(isinit))
			{
		while(sc.getAttribute("process")==null) {
			//while((int)sc.getAttribute("name")<6) {//sc.setAttribute("name",temp+1);
			    //if((int)sc.getAttribute("name")==5) 
			    {sleep(100);}
			
			//}
			//sleep(100);
		}
		response.getWriter().println(sc.getAttribute("process"));
			}
			if(request.getParameter("hostact").equals(isresult)) {
				sc.setAttribute("result",request.getParameter("resultinfo"));
				//response.getWriter().println("ok");
				//response.getWriter().println("")
				//response.getWriter().println(sc.getAttribute("result"));
				
			}
		}
		
		if(request.getParameter("host").equals(iscustomer)) {
			//response.getWriter().println(JSON.toJSONString(request.getParameter("host")));
			//pinfo=request.getParameter("processinfo");
			if(sc.getAttribute("process")==null) {
				sc.setAttribute("process",request.getParameter("processinfo"));}
            
			while(sc.getAttribute("result")==null) {
				//while((int)sc.getAttribute("name")<6) {//sc.setAttribute("name",temp+1);
				    //if((int)sc.getAttribute("name")==5) 
				    {sleep(100);}
				//}
				//sleep(100);
			}
			//sc.setAttribute("result","aaaaaaaaa");
			response.getWriter().println(sc.getAttribute("result"));
			//response.getWriter().println("OK");//sc.getAttribute("process"));
		    sc.setAttribute("result",null);
		    sc.setAttribute("process",null);
		} 
		/*if(request.getParameter((String) name)=="calcserver") {
			responsecalc=response;
			boolean iscalculated;String jason,calcresult;
			calcresult=request.getParameter((String) jason );
			if(iscalculated==true) {responseclient.getWriter().println(calcparam)
            
		};
		
		if(request.getParameter((String) name)=="client") {
			responseclient=response;
			String jason,calcparam;
			calcparam=request.getParameter((String) jason );
			responsecalc.getWriter().println(calcparam);
			
			
		};*/
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
//		response.getWriter().append("global response doPost");
	}
	
	protected void sleep(int numberMillis) { 
		Date now = new Date(); 
		var exitTime = now.getTime() + numberMillis; 
		while (true) { 
		now = new Date(); 
		if (now.getTime() > exitTime) 
		return; 
		} 
		}

}
© 2022 GitHub, Inc.
Terms
Privacy
Security
Status
Docs
Contact GitHub
Pricing
API
Training
Blog
About
