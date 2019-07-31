package activeMQ.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MProducer {

    public static final String BROKER_URL = "tcp://192.168.1.10:61616";
    public static final String USER_NAME = "admin";
    public static final String PASSWORD = "admin";
    public static final String QUEUE_NO1 = "queue_no1";

    public static void main(String[] args) throws Exception {
        //创建mq连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(USER_NAME, PASSWORD, BROKER_URL);
        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //启动连接
        connection.start();
        //创建Session 首先不启用事务false 设置自动签收 Session.AUTO_ACKNOWLEDGE
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        //创建队列Queue Destination(目的地)是总接口 下面有子接口 Queue(队列) 和 Topic(主题)
        Destination destination = session.createQueue(QUEUE_NO1);
        MessageProducer producer = session.createProducer(destination);
        //设置消息的持久化，保证在mq宕机后消息不丢失
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        String message = "";
        for (int i = 0; i < 12; i++) {
            message = "消息：" + i;
            TextMessage textMessage = session.createTextMessage(message);
            producer.send(destination, textMessage);
            System.out.println("******发送Message****" + i);
        }
        //如果启用了事务 这里必须手动提交 事务开启之后在try catch如有异常可进行事务的回滚操作session.rollback();
        //session.commit();
        producer.close();
        session.close();
        connection.close();
    }

}
