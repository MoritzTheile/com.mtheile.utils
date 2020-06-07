package com.mtheile.utils.simpleetl.util;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
public class CustomIdGenerator implements IdentifierGenerator, Configurable {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		if(object instanceof WithCustomId) {

			return ((WithCustomId) object).getCustomId();

		}
		
		return null;

	}

	@Override
	public void configure(Type type, Properties properties, ServiceRegistry serviceRegistry) throws MappingException {
		// prefix = properties.getProperty("prefix");
	}

}

//	@Override
//	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
//
//		try {
//			
//			Integer id =  getId(object);
//			
//			if(id != null) {
//				
//				System.out.println("CustomIdSequenceStyleGenerator returns " + id);
//				
//				return id.longValue();
//				
//			}else {
//				
//				System.out.println("CustomIdSequenceStyleGenerator didn't find custom id.");
//				
//			}
//			
//		}catch(Exception e) {
//			
//			e.printStackTrace();
//			
//		}
//
//		return super.generate(session, object);
//
//	}
//
//	@Override
//	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
//
//		super.configure(LongType.INSTANCE, params, serviceRegistry);
//
//	}
//
//protected Integer getId(Object entity) {
//
//	try {
//
//		Method method = entity.getClass().getDeclaredMethod("getId");
//		return (Integer) method.invoke(entity);
//
//	} catch (Exception e) {
//
//		throw new RuntimeException("no ID found (codemarker=766brjk)", e);
//
//	}
//
//}
//}