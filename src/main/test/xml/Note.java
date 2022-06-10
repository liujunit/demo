package xml;

public class Note {

    private String from;

    private String to;

    private String heading;

    private String body;

    private int num;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Note{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", heading='" + heading + '\'' +
                ", body='" + body + '\'' +
                ", num=" + num +
                '}';
    }
}
