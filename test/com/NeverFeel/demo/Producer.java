package com.NeverFeel.demo;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * message 生产者V1.0
 * 
 * @author NeverFeel
 *
 */
public class Producer {

	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;// 默认用户名
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;// 默认密码
	private static final String DEFAULT_URL = ActiveMQConnection.DEFAULT_BROKER_URL;// 默认的url
	private ActiveMQConnectionFactory activeMQConnectionFactory = null;// 初始化连接工厂
	private Connection connection = null;// 初始化连接
	private Session session = null;// 初始化会话
	private Destination destination = null;// 消息目的地
	private MessageProducer messageProducer = null;// 消息生产者

	public Producer() {
	}

	public Producer(String msg) throws Exception {
		this.activeMQConnectionFactory = createConnectionFactory();
		this.connection = createConnection();
		this.session = createSession();
		this.destination = createDestination(msg);
		this.messageProducer = createMessageProducer();
	}

	/**
	 * 发送消息
	 */
	public void sendMessage() {

	}

	/**
	 * 启动连接
	 * @param connection
	 * @throws Exception
	 */
	public void connectionStart(Connection connection) throws Exception{
		if(null!=connection){
			try {
				connection.start();
			} catch (JMSException e) {
				e.printStackTrace();
				throw new Exception("start connection exception!");
			}
		}
	}
	
	/**
	 * 创建MessageProducer
	 * 
	 * @return
	 * @throws Exception
	 */
	public MessageProducer createMessageProducer() throws Exception {
		if (null != session) {
			try {
				messageProducer = session.createProducer(destination);
				return messageProducer;
			} catch (JMSException e) {
				e.printStackTrace();
				throw new Exception("create messageProducer exception!");
			}
		}
		return null;
	}

	/**
	 * 创建destination
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Destination createDestination(Object obj) throws Exception {
		String msg = (String) obj;
		if (null != session) {
			try {
				destination = session.createQueue(msg);
				return destination;
			} catch (JMSException e) {
				e.printStackTrace();
				throw new Exception("create destination exception!");
			}
		}
		return null;
	}

	/**
	 * 创建session
	 * 
	 * @return
	 * @throws Exception
	 */
	public Session createSession() throws Exception {
		if (null != connection) {
			try {
				session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
				return session;
			} catch (JMSException e) {
				e.printStackTrace();
				throw new Exception("create session exception");
			}
		}
		return null;
	}

	/**
	 * 创建连接
	 * 
	 * @return
	 * @throws Exception
	 */
	public Connection createConnection() throws Exception {
		if (null != activeMQConnectionFactory) {
			try {
				this.connection = activeMQConnectionFactory.createConnection();
				return connection;
			} catch (JMSException e) {
				e.printStackTrace();
				throw new Exception("create connection exception！");
			}
		}
		return null;
	}

	/**
	 * 创建连接工厂
	 * 
	 * @return
	 */
	public ActiveMQConnectionFactory createConnectionFactory() {
		return new ActiveMQConnectionFactory(USERNAME, PASSWORD, DEFAULT_URL);
	}
//---------------------------------------------------------------------------------------------------------------
	public ActiveMQConnectionFactory getActiveMQConnectionFactory() {
		return activeMQConnectionFactory;
	}

	public void setActiveMQConnectionFactory(ActiveMQConnectionFactory activeMQConnectionFactory) {
		this.activeMQConnectionFactory = activeMQConnectionFactory;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public MessageProducer getMessageProducer() {
		return messageProducer;
	}

	public void setMessageProducer(MessageProducer messageProducer) {
		this.messageProducer = messageProducer;
	}

}
