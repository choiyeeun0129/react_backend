package kr.co.seoulit.account.sys.common.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import kr.co.seoulit.account.sys.base.to.BaseBean;

/*자바빈즈의 세터 게터의 자동화. 여기서는 세터만해줌*/
public class BeanCreator {
    private static BeanCreator ourInstance = new BeanCreator();
    private BeanCreator() {
    }
    public static BeanCreator getInstance() {
        return ourInstance;
    }

    public <T extends BaseBean> T create(JSONObject jsonObject, Class<T> beanClass) { // json, slipBean.class or JournalBean.class
        T instance = null; //slipBean
        try {
            instance = beanClass.newInstance(); //slipBean 객체생성 
            Method[] methods=beanClass.getDeclaredMethods(); //클래스에 있는 메서드 다 불러옴 배열이니까 []
            for(Method method:methods) {//for문으로 메서드 불러옴
            	String mName=method.getName(); //메서드 name
            	if(mName.contains("set")){
            		System.out.println("메서드명: "+mName); //setBalanceDivision
            		String s1=mName.replace("set","").substring(0,1).toLowerCase();  //b 첫번째글자만가지고와서 소문자로 바꿈
            		String field=s1+mName.substring(4); //b alanceDivision 4번째자리로 가져옴 멤버변수 이름으로 바뀜
            		System.out.println("필드명: "+field);
            		System.out.println("파라미터값: "+jsonObject.get(field));
            		System.out.println("파라미터값: "+jsonObject.get("accountControlCode"));
            		System.out.println("instance of "+instance);
					if(jsonObject.get(field)!=null) //필요한정보만 넣는 if문 nullpoint 때문에 확인
						if(!jsonObject.get(field).equals("")) //같은 의미임 빈값이 아니면
							if(jsonObject.get(field) instanceof List) {//instanceof 자료형검사를 함 자료형이 list 이면... 저널에는 리스트가 있음
								if(((JSONArray)jsonObject.get(field)).size()==0) continue; //continue해당 for문을 빠져나감 값이 있으면 아래 실행 //list에 해당이 되면 무조건 빠져나감
								
								//제너릭클래스가 먼지를 찾아줌
								System.out.println("리스트의 타입: "+method.getGenericParameterTypes()[0].getTypeName());// getTypeName 지우자 헤깔리지않게(dong)
								System.out.println(method.getGenericParameterTypes()[0]);
								ParameterizedType type =(ParameterizedType)method.getGenericParameterTypes()[0]; //타입가져옴
								Type actual = type.getActualTypeArguments()[0]; //타입가져옴 주소값전부포함
								System.out.println(actual);
								System.out.println("리스트 요소의 타입: "+actual.getTypeName());
								Class<? extends BaseBean> beanOfList=(Class<? extends BaseBean>) Class.forName(actual.getTypeName()); //Class.forName 객체생성
								//<? extends BaseBean> basebean의 자식이면 모든게 와도 됨
								System.out.println("요소의 클래스 타입 객체: "+beanOfList);
								
								List<BaseBean> list=new ArrayList<>();
								for(Object jsonObj:JSONArray.fromObject(jsonObject.get(field))) { //분개상새는 여러개이기 때문에 array <JournalDetailBean>이 걸림
									list.add(this.create(JSONObject.fromObject(jsonObj), beanOfList)); //create 자기의 값을 다시 호출함
									
								}
								method.invoke(instance, list);
								System.out.println(jsonObject);
							}else {
								System.out.println("파라미터가 공백?: "+jsonObject.get(field).equals(""));
								try {
				
									System.out.println("메서드 리턴 타입");
									System.out.println(method.getReturnType().getName());
									method.invoke(instance,jsonObject.get(field)); //setter 에 값주입
								}catch(IllegalArgumentException e) {
									System.out.println("필드 타입 불일치");
									continue;
								}
							}
            	}
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        
        catch (InvocationTargetException e) {
            e.printStackTrace();
        
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
        
        System.out.println("instance: "+instance);
		return instance;

    }
    
}
