package kr.co.seoulit.account.sys.common.sl;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@Slf4j
public class ServiceLocator {

    private Map<String, DataSource> cache;

    private Context envCtx;
    private static ServiceLocator instance;

    static {
        try {
            instance = new ServiceLocator();
            System.out.println("		@ ServiceLocator접근");
        } catch (ServiceLocatorException e) {
            e.printStackTrace();
        }

    }

    private ServiceLocator() {
        try {
        	// javax.naming.InitialContext; public InitialContext()
            envCtx = new InitialContext();
            // 지정된 맵이 지원하는 동기화된 맵을 반환
            // public static <K,V> Map<K,V> synchronizedMap(Map<K,V> m)
            cache = Collections.synchronizedMap(new HashMap<String, DataSource>());

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceLocatorException(e.getMessage());
        }
    }

    public static ServiceLocator getInstance() {
        return instance;
    }

    public DataSource getDataSource(String jndiName) {

        DataSource dataSource;
        System.out.println("		@ 데이터 소스 객체를 얻기 위한 메서드 getDataSource");
        try {
            if (cache.containsKey(jndiName)) {
                dataSource = cache.get(jndiName);
            } else {
            	// java:comp/env : 응용 프로그램 환경 항목
            	// JNDI(Java Naming and Directory Interface API)
            	// InitialContext 의 lookup() 메서드를 이용하면 JNDI 이름으로 등록된 서버 자원을 찾을 수 있다
                dataSource = (DataSource) envCtx.lookup("java:comp/env/" + jndiName); 
                // cache : a synchronized view of the specified map.
                // "jdbc/ac2", Collections.synchronizedMap(new HashMap<String, DataSource>()).get("jdbc/ac2")
                cache.put(jndiName, dataSource);
            }
            System.out.println("		@ jndi로 server.xml에 있는 계정 정보를 찾는다");
            System.out.println("		@ jndi: " + jndiName);
        } catch (NamingException e) {
            throw new ServiceLocatorException(e.getMessage());

        }
        return dataSource;
    }

}

