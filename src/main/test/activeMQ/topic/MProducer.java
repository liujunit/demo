package activeMQ.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MProducer {

    public static final String BROKER_URL = "tcp://192.168.1.10:61616";
    public static final String USER_NAME = "admin";
    public static final String PASSWORD = "admin";
    public static final String TOPIC = "topic_no1";

    public static void main(String[] args) throws JMSException {
        //创建工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(USER_NAME, PASSWORD, BROKER_URL);
        //获取连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //获取session
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC);
        MessageProducer producer = session.createProducer(topic);
        for (int i = 0; i < 10; i++) {
            TextMessage textMessage = session.createTextMessage("主题消息：" + i);
            System.out.println("发送主题消息：" + textMessage.getText());
            producer.send(textMessage);
        }
        producer.close();
        session.close();
        connection.close();
    }

}
