package activeMQ;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class MConsumerListener {

    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("消费者2号：");
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(MProducer.USER_NAME, MProducer.PASSWORD, MProducer.BROKER_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(MProducer.QUEUE_NO1);
        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("接收消息：" + textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.in.read();
        session.close();
        connection.close();
    }

}
