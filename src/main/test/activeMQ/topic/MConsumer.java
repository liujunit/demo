package activeMQ.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class MConsumer {

    public static void main(String[] args) throws JMSException, IOException {
        //创建工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(MProducer.USER_NAME, MProducer.PASSWORD, MProducer.BROKER_URL);
        //获取连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //获取session
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(MProducer.TOPIC);
        MessageConsumer consumer = session.createConsumer(topic);
        consumer.setMessageListener((Message message) -> {
            if (message != null && message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("接收：" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.in.read();
        consumer.close();
        session.close();
        connection.close();
    }

}
