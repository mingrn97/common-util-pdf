package vo;

/**
 * 故障码-VO
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 2019/6/5 18:03
 */
public class FaultCodeVO {

    /** 日期 */
    private String date;

    /** 故障码 */
    private String faultCode;

    public FaultCodeVO(){}

    public FaultCodeVO(String date, String faultCode){
        this.date = date;
        this.faultCode = faultCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode;
    }

    @Override
    public String toString() {
        return "FaultCodeVO{" +
                "date='" + date +
                ", faultCode='" + faultCode +
                '}';
    }
}
