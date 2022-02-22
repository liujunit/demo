package udp;

import java.util.Date;

public class OperationInformation {

    private String table;

    private int id;

    private Date operation_log_time;

    private int operation_param_type;

    private String user_id;

    private int user_role;

    private String operation_log_description;

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

    public Date getOperation_log_time() {
        return operation_log_time;
    }

    public void setOperation_log_time(Date operation_log_time) {
        this.operation_log_time = operation_log_time;
    }

    public int getOperation_param_type() {
        return operation_param_type;
    }

    public void setOperation_param_type(int operation_param_type) {
        this.operation_param_type = operation_param_type;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getUser_role() {
        return user_role;
    }

    public void setUser_role(int user_role) {
        this.user_role = user_role;
    }

    public String getOperation_log_description() {
        return operation_log_description;
    }

    public void setOperation_log_description(String operation_log_description) {
        this.operation_log_description = operation_log_description;
    }
}
