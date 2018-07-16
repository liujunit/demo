package pdf;

public class Paragh {
    //顺序号
    int Id;
    //段落样式，几级标题、正文
    public String clss;
    //字体大小
    public int fontSize;
    //字体
    public String fontFamily;
    //原始的xml标签
    public String raw;
    //段落文本
    public String text;

    @Override
    public boolean equals(Object obj) {
        if(((Paragh)obj).fontSize == this.fontSize && ((Paragh)obj).fontFamily.equalsIgnoreCase(this.fontFamily)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return new String(fontSize + fontFamily).hashCode();
    }
    @Override
    public String toString() {
        return "fontSize:" + fontSize + ",fontFamily:" + fontFamily;
    }
}
