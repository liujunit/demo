package activeMQ.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class MConsumerListener {

    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("消费者2号：");
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(MProducer.USER_NAME, MProducer.PASSWORD, MProducer.BROKER_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        Queue queue = session.createQueue(MProducer.QUEUE_NO1);
        MessageConsumer consumer = session.createConsumer(queue);
        //监听模式
        consumer.setMessageListener((Message message) -> {
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("接收消息：" + textMessage.getText());
                    //如果是Session.CLIENT_ACKNOWLEDGE 这里必须设置调用签收 程序结束后消息依然是未消费的状态
                    textMessage.acknowledge();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        //防止主程序结束
        System.in.read();
        session.close();
        connection.close();
    }

}
