package udp;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * udp数据传输，发送mysql中的数据
 */
public class MysqlMessageSend {

    /**
     * CollectBase 数据发送
     */
    @Test
    public void test01() throws InterruptedException, IOException {

        for (int i = 0; i < 100000; i++) {
            CollectBase collectBase = new CollectBase();
            collectBase.setTable("collector_base_information_table");
            collectBase.setId(i);
            collectBase.setCollector_id(String.valueOf(i));
            collectBase.setCollector_name(i + "-防护装置");
            collectBase.setCollector_ip(randomIp());
            collectBase.setCollector_equipment_serial("序列号-" + i);
            collectBase.setCollector_location("位置-" + i);
            collectBase.setCollector_remark("备注-" + i);
            collectBase.setCollector_connect_status(0);
            collectBase.setCollector_used_status(1);
            collectBase.setSyscontrol_dbupdate_flag(0);
            collectBase.setWorker_dbupdate_flag(0);
            collectBase.setUsbend_dbupdate_flag(0);
            String data = JSON.toJSONString(collectBase);
            SyslogSendUtil.sendSyslog(data);
        }

    }


    @Test
    public void test02() throws InterruptedException, IOException {
        for (int i = 0; i < 100000; i++) {
            CollectLog collectLog = new CollectLog();
            collectLog.setTable("collect_log_information_table");
            collectLog.setId(i);
            collectLog.setVideo_log_name("2021-09-02-15-20-00.avi");
            collectLog.setKeyboard_log_size(6000 + i);
            collectLog.setMouse_log_size(6000 + i);
            collectLog.setVideo_log_size(60000 + i);
            collectLog.setCollect_log_save_dir("E:/DCS/dcs3/20210902");
            collectLog.setHost_equipment_serial("093q80lg" + i);
            collectLog.setEmployee_job_number(String.valueOf(i));
            collectLog.setEmployee_name("张三" + i);
            collectLog.setVideo_log_exist(2);
            collectLog.setVideo_remark("备注" + i);
            collectLog.setMark_key_log(0);
            collectLog.setHistory_log(0);
            collectLog.setVideo_ftp_status(0);
            Date now = new Date();
            collectLog.setVideo_ftp_datetime(now);
            collectLog.setVideo_log_begin_time(now);
            collectLog.setVideo_log_end_time(now);
            collectLog.setVideo_audio_time("音频时间");
            String data = JSON.toJSONString(collectLog);
            SyslogSendUtil.sendSyslog(data);
        }
    }



    @Test
    public void test03() throws InterruptedException, IOException {
        for (int i = 0; i < 10000; i++) {
            BaseInformation baseInformation = new BaseInformation();
            baseInformation.setTable("host_base_information_table");
            baseInformation.setId(i);
            baseInformation.setHost_number("装置编号" + i);
            baseInformation.setHost_name("装置名称" + i);
            baseInformation.setHost_location("装置位置" + i);
            baseInformation.setHost_equipment_serial("装置序列号" + i);
            baseInformation.setHost_remark("装置备注" + i);
            baseInformation.setCollector_id("设备id" + i);
            baseInformation.setHost_date_save_path("数据存储位置");
            baseInformation.setHost_isopen(1);
            baseInformation.setCollect_isopen(0);
            baseInformation.setUsbisentry(1);
            baseInformation.setUsbendset("");
            baseInformation.setIsuseentryusb(1);
            baseInformation.setIsuseplainusb(1);
            baseInformation.setFirstgame(1);
            baseInformation.setRootworkercard("308106982" + i);
            String data = JSON.toJSONString(baseInformation);
            SyslogSendUtil.sendSyslog(data);
        }
    }

    @Test
    public void test04() throws InterruptedException, IOException {

        for (int i = 0; i < 10000; i++) {
            OperationInformation operationInformation = new OperationInformation();
            operationInformation.setTable("operation_log_information_table");
            operationInformation.setId(i);
            Date now = new Date();
            operationInformation.setOperation_log_time(now);
            operationInformation.setOperation_param_type(i);
            operationInformation.setUser_id("用户id" + i);
            operationInformation.setUser_role(i);
            operationInformation.setOperation_log_description("日志内容" + i);
            String data = JSON.toJSONString(operationInformation);
            SyslogSendUtil.sendSyslog(data);
        }

    }

    @Test
    public void test05() throws InterruptedException, IOException {
        for (int i = 0; i < 1000; i++) {
            String message = "2021-09-03 07:22:08\t16\t6\t1\t192.168.6.101\t\t\t\tSep 03 15:22:08 RK-Guard RiGuard.exe[5820]: 终端事件日志,2021-09-03 15:22:08,admin,员工上机事件,002号访问人员test1 刷卡下机成功" + i;
            String data = JSON.toJSONString(message);
            SyslogSendUtil.sendSyslog(data);
        }
    }


    @Test
    public void test06() {

    }


    /**
     * 随机IP
     * @return
     */
    public String randomIp() {
        Random random = new Random();
        int i0 = random.nextInt(254) + 1;
        int i1 = random.nextInt(255);
        int i2 = random.nextInt(255);
        int i3 = random.nextInt(255);
        String randomIp = i0 + ":" + i1 + ":" + i2 + ":" + i3;
        return randomIp;
    }

}
