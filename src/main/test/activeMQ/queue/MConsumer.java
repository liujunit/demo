package activeMQ.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MConsumer {


    public static void main(String[] args) throws JMSException {
        System.out.println("消费者1号：");
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(MProducer.USER_NAME, MProducer.PASSWORD, MProducer.BROKER_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //Session.AUTO_ACKNOWLEDGE自动签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(MProducer.QUEUE_NO1);
        MessageConsumer consumer = session.createConsumer(queue);
        while (true) {
            //使用receive接收消息无参会一直等待 receive(4000)：4秒后没有消息的话为null
            Message message = consumer.receive(4000);
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
