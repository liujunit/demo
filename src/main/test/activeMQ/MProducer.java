package activeMQ;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MProducer {

    public static final String BROKER_URL = "tcp://127.0.0.1:61616";
    public static final String USER_NAME = "admin";
    public static final String PASSWORD = "admin";
    public static final String QUEUE_NO1 = "queue_no1";

    public static void main(String[] args) throws Exception {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(USER_NAME, PASSWORD, BROKER_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(QUEUE_NO1);
        MessageProducer producer = session.createProducer(destination);
        String message = "";
        for (int i = 0; i < 12; i++) {
            message = "消息：" + i;
            TextMessage textMessage = session.createTextMessage(message);
            producer.send(destination, textMessage);
            System.out.println("******发送Message****" + i);
        }
        producer.close();
        session.close();
        connection.close();
    }

}
