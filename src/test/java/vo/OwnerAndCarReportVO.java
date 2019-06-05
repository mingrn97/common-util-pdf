package vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 车主及车辆数据报告-VO
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 2019/6/5 18:05
 */
public class OwnerAndCarReportVO {

    /** 保单号 */
    private String orderNum;

    /** 报告时间 */
    private String reportTime;

    /** 数据时间 */
    private String dateTime;

    /** 姓名 */
    private String ownerName;

    /** 性别 */
    private String gender;

    /** 年龄 */
    private Number age;

    /** 手机号 */
    private String phone;

    /** 身份证 */
    private String idCard;

    /** 车架号 */
    private String frameNum;

    /** 车牌号 */
    private String plateNum;

    /** 年数 */
    private Number carAge;

    /** 品牌 */
    private String trademark;

    /** 型号 */
    private String model;

    /** 颜色 */
    private String color;

    /** 刹车过猛 */
    private Integer brakeOut;

    /** 加油过猛 */
    private Integer oilOut;

    /** 平均驾驶时长 */
    private Number avgDriverDurable;

    /** 平均单次里程 */
    private Number avgMileage;

    /** 总里程 */
    private Number totalMileage;

    /** 平均油耗 */
    private Number avgOil;

    /** 救援次数 */
    private Number rescue;

    /** 洗车 */
    private Number washCar;

    /** 代驾 */
    private Number designatedDriver;

    /** 事故代步 */
    private Number accidentDriver;

    /** 保养 */
    private Number maintain;

    /** 安全检查 */
    private Number inspect;

    /** 故障码 */
    private List<FaultCodeVO> faultCodeVOList = new ArrayList<>();
    /** 违章记录 */
    private List<IllegalRecordVO> illegalRecordVOList = new ArrayList<>();

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Number getAge() {
        return age;
    }

    public void setAge(Number age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getFrameNum() {
        return frameNum;
    }

    public void setFrameNum(String frameNum) {
        this.frameNum = frameNum;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public Number getCarAge() {
        return carAge;
    }

    public void setCarAge(Number carAge) {
        this.carAge = carAge;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getBrakeOut() {
        return brakeOut;
    }

    public void setBrakeOut(Integer brakeOut) {
        this.brakeOut = brakeOut;
    }

    public Integer getOilOut() {
        return oilOut;
    }

    public void setOilOut(Integer oilOut) {
        this.oilOut = oilOut;
    }

    public Number getAvgDriverDurable() {
        return avgDriverDurable;
    }

    public void setAvgDriverDurable(Number avgDriverDurable) {
        this.avgDriverDurable = avgDriverDurable;
    }

    public Number getAvgMileage() {
        return avgMileage;
    }

    public void setAvgMileage(Number avgMileage) {
        this.avgMileage = avgMileage;
    }

    public Number getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(Number totalMileage) {
        this.totalMileage = totalMileage;
    }

    public Number getAvgOil() {
        return avgOil;
    }

    public void setAvgOil(Number avgOil) {
        this.avgOil = avgOil;
    }

    public Number getRescue() {
        return rescue;
    }

    public void setRescue(Number rescue) {
        this.rescue = rescue;
    }

    public Number getWashCar() {
        return washCar;
    }

    public void setWashCar(Number washCar) {
        this.washCar = washCar;
    }

    public Number getDesignatedDriver() {
        return designatedDriver;
    }

    public void setDesignatedDriver(Number designatedDriver) {
        this.designatedDriver = designatedDriver;
    }

    public Number getAccidentDriver() {
        return accidentDriver;
    }

    public void setAccidentDriver(Number accidentDriver) {
        this.accidentDriver = accidentDriver;
    }

    public Number getMaintain() {
        return maintain;
    }

    public void setMaintain(Number maintain) {
        this.maintain = maintain;
    }

    public Number getInspect() {
        return inspect;
    }

    public void setInspect(Number inspect) {
        this.inspect = inspect;
    }

    public List<FaultCodeVO> getFaultCodeVOList() {
        return faultCodeVOList;
    }

    public void setFaultCodeVOList(List<FaultCodeVO> faultCodeVOList) {
        this.faultCodeVOList = faultCodeVOList;
    }

    public List<IllegalRecordVO> getIllegalRecordVOList() {
        return illegalRecordVOList;
    }

    public void setIllegalRecordVOList(List<IllegalRecordVO> illegalRecordVOList) {
        this.illegalRecordVOList = illegalRecordVOList;
    }

    public void addFaultCodeVO(FaultCodeVO faultCodeVO){
        this.faultCodeVOList.add(faultCodeVO);
    }

    public void addIllegalRecordVO(IllegalRecordVO illegalRecordVO){
        this.illegalRecordVOList.add(illegalRecordVO);
    }


    @Override
    public String toString() {
        return "OwnerAndCarReportVO{" +
                "orderNum='" + orderNum +
                ", reportTime='" + reportTime +
                ", dateTime='" + dateTime +
                ", ownerName='" + ownerName +
                ", gender='" + gender +
                ", age=" + age +
                ", phone='" + phone +
                ", idCard='" + idCard +
                ", frameNum='" + frameNum +
                ", plateNum='" + plateNum +
                ", carAge=" + carAge +
                ", trademark='" + trademark +
                ", model='" + model +
                ", color='" + color +
                ", brakeOut=" + brakeOut +
                ", oilOut=" + oilOut +
                ", avgDriverDurable=" + avgDriverDurable +
                ", avgMileage=" + avgMileage +
                ", totalMileage=" + totalMileage +
                ", avgOil=" + avgOil +
                ", rescue=" + rescue +
                ", washCar=" + washCar +
                ", designatedDriver=" + designatedDriver +
                ", accidentDriver=" + accidentDriver +
                ", maintain=" + maintain +
                ", inspect=" + inspect +
                ", faultCodeVOList=" + faultCodeVOList +
                ", illegalRecordVOList=" + illegalRecordVOList +
                '}';
    }
}
