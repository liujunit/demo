package udp;

public class CollectBase {

    private String table;

    private int id;

    private String collector_id;

    private String collector_name;

    private String collector_ip;

    private String collector_equipment_serial;

    private String collector_location;

    private String collector_remark;

    private int collector_connect_status;

    private int collector_used_status;

    private int worker_dbupdate_flag;

    private int syscontrol_dbupdate_flag;

    private int usbend_dbupdate_flag;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollector_id() {
        return collector_id;
    }

    public void setCollector_id(String collector_id) {
        this.collector_id = collector_id;
    }

    public String getCollector_name() {
        return collector_name;
    }

    public void setCollector_name(String collector_name) {
        this.collector_name = collector_name;
    }

    public String getCollector_ip() {
        return collector_ip;
    }

    public void setCollector_ip(String collector_ip) {
        this.collector_ip = collector_ip;
    }

    public String getCollector_equipment_serial() {
        return collector_equipment_serial;
    }

    public void setCollector_equipment_serial(String collector_equipment_serial) {
        this.collector_equipment_serial = collector_equipment_serial;
    }

    public String getCollector_location() {
        return collector_location;
    }

    public void setCollector_location(String collector_location) {
        this.collector_location = collector_location;
    }

    public String getCollector_remark() {
        return collector_remark;
    }

    public void setCollector_remark(String collector_remark) {
        this.collector_remark = collector_remark;
    }

    public int getCollector_connect_status() {
        return collector_connect_status;
    }

    public void setCollector_connect_status(int collector_connect_status) {
        this.collector_connect_status = collector_connect_status;
    }

    public int getCollector_used_status() {
        return collector_used_status;
    }

    public void setCollector_used_status(int collector_used_status) {
        this.collector_used_status = collector_used_status;
    }

    public int getWorker_dbupdate_flag() {
        return worker_dbupdate_flag;
    }

    public void setWorker_dbupdate_flag(int worker_dbupdate_flag) {
        this.worker_dbupdate_flag = worker_dbupdate_flag;
    }

    public int getSyscontrol_dbupdate_flag() {
        return syscontrol_dbupdate_flag;
    }

    public void setSyscontrol_dbupdate_flag(int syscontrol_dbupdate_flag) {
        this.syscontrol_dbupdate_flag = syscontrol_dbupdate_flag;
    }

    public int getUsbend_dbupdate_flag() {
        return usbend_dbupdate_flag;
    }

    public void setUsbend_dbupdate_flag(int usbend_dbupdate_flag) {
        this.usbend_dbupdate_flag = usbend_dbupdate_flag;
    }
}
