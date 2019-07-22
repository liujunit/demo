package activeMQ;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MConsumer {


    public static void main(String[] args) throws JMSException {
        System.out.println("消费者1号：");
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(MProducer.USER_NAME, MProducer.PASSWORD, MProducer.BROKER_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(MProducer.QUEUE_NO1);
        MessageConsumer consumer = session.createConsumer(queue);
        while (true) {
            Message message = consumer.receive();
            if (null != message && message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                System.out.println("接收：" + textMessage.getText());
            } else {
                break;
            }
        }
        consumer.close();
        session.close();
        connection.close();
    }

}
