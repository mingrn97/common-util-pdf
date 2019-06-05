package vo;

/**
 * 违章记录-VO
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 2019/6/5 18:03
 */
public class IllegalRecordVO {

    /** 日期 */
    private String date;

    /** 违章信息 */
    private String illegalRecord;

    public IllegalRecordVO(){}

    public IllegalRecordVO(String date, String illegalRecord){
        this.date = date;
        this.illegalRecord = illegalRecord;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIllegalRecord() {
        return illegalRecord;
    }

    public void setIllegalRecord(String illegalRecord) {
        this.illegalRecord = illegalRecord;
    }

    @Override
    public String toString() {
        return "IllegalRecordVO{" +
                "date='" + date +
                ", illegalRecord='" + illegalRecord +
                '}';
    }
}
