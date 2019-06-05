<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title></title>
    <style type="text/css">

        @page  {
            size: A4;
        }

        h3 {
            text-align: center;
        }
        .all {
            width: 100%;
            border: 1px black;
            border-collapse: collapse;
            border-spacing: 0;
        }

        .half {
            width: 40%;
            border: 1px black;
            border-collapse: collapse;
            border-spacing: 0;
            margin: 50px 0;
        }

        .line {
            width: 100%;
            border: 0;
            border-collapse: collapse;
            border-spacing: 0;
            margin: 50px 0;
        }

        .all .no-border td{
            border-bottom: 0;
            border-left: solid 0.2px;
            border-right: solid 0.2px;
        }

        .border td{
            border: solid 0.2px #333;
        }

        tr, td {
            font-size: 14px;
        }

        td {
            height: 24px;
        }
    </style>
</head>
<body>
<table class="all">
    <tr class="border"><td rowspan="2" colspan="6"><h3>车主及车辆数据报告</h3></td></tr>
    <tr class="no-border"><td colspan="6"></td></tr>
    <tr class="border">
        <td width="15%">保单号</td>
        <td width="20%">${reportVO.orderNum!""}</td>
        <td width="10%">报告时间	</td>
        <td width="15%">${reportVO.reportTime}!""</td>
        <td width="10%">数据时间</td>
        <td width="20%">${reportVO.dateTime!""}</td>
    </tr>
    <tr class="no-border"><td colspan="6"></td></tr>
    <tr class="no-border"><td colspan="6"><strong>车主信息</strong></td></tr>
    <tr class="border">
        <td>姓名</td>
        <td>${reportVO.ownerName!""}</td>
        <td>性别</td>
        <td>${reportVO.gender!""}</td>
        <td>年龄</td>
        <td>${reportVO.age!""}</td>
    </tr>
    <tr class="border">
        <td>手机号</td>
        <td>${reportVO.phone!""}</td>
        <td>身份证</td>
        <td>${reportVO.idCard!""}</td>
        <td></td>
        <td></td>
    </tr>
    <tr class="no-border"><td colspan="6"></td></tr>
    <tr class="no-border"><td colspan="6"><strong>车辆信息</strong></td></tr>
    <tr class="border">
        <td>车架号</td>
        <td>${reportVO.frameNum!""}</td>
        <td>车牌</td>
        <td>${reportVO.plateNum!""}</td>
        <td>年数</td>
        <td>${reportVO.carAge!""}</td>
    </tr>
    <tr class="border">
        <td>品牌</td>
        <td>${reportVO.trademark!""}</td>
        <td>型号</td>
        <td>${reportVO.model!""}</td>
        <td>颜色</td>
        <td>${reportVO.color!""}</td>
    </tr>
    <tr class="border">
        <td>故障码</td>
        <td>见附1</td>
        <td>违章记录</td>
        <td>见附2</td>
        <td></td>
        <td></td>
    </tr>
    <tr class="no-border"><td colspan="6"></td></tr>
    <tr class="no-border"><td colspan="6"><strong>驾驶行为</strong></td></tr>
    <tr class="border">
        <td>刹车过猛</td>
        <td>${reportVO.brakeOut!""}次</td>
        <td>加油过猛</td>
        <td>${reportVO.oilOut!""}次</td>
        <td></td>
        <td></td>
    </tr>
    <tr class="border">
        <td>平均驾驶时长</td>
        <td>${reportVO.avgDriverDurable!""}h</td>
        <td>平均单次里程</td>
        <td>${reportVO.avgMileage!""}km</td>
        <td></td>
        <td></td>
    </tr>
    <tr class="border">
        <td>总里程</td>
        <td>${reportVO.totalMileage!""}km</td>
        <td>平均油耗</td>
        <td>${reportVO.avgOil!""}L/100km</td>
        <td></td>
        <td></td>
    </tr>
    <tr class="no-border"><td colspan="6"></td></tr>
    <tr class="no-border"><td colspan="6">车辆时速统计表</td></tr>
    <tr class="no-border"><td colspan="6"><img type="image/jpeg" src="${lineChartImgUrl!""}" /></td></tr>
    <tr class="no-border"><td colspan="6"></td></tr>
    <tr class="no-border"><td colspan="6">驾驶时间分布</td></tr>
    <tr class="no-border"><td colspan="6"><img type="image/jpeg" src="${barChartImgUrl!""}" /></td></tr>
    <tr class="no-border"><td colspan="6"></td></tr>
    <tr class="no-border"><td colspan="6"><strong>车辆服务信息</strong></td></tr>
    <tr class="border">
        <td>救援</td>
        <td>${reportVO.rescue!""}</td>
        <td>洗车</td>
        <td>${reportVO.washCar!""}</td>
        <td>代驾</td>
        <td>${reportVO.designatedDriver!""}</td>
    </tr>
    <tr class="border">
        <td>事故代步</td>
        <td>${reportVO.accidentDriver!""}</td>
        <td>保养</td>
        <td>${reportVO.maintain!""}</td>
        <td>安全检查</td>
        <td>${reportVO.inspect!""}</td>
        <td></td>
    </tr>
</table>
<br/>
<table class="line"><tr class="no-border"><td></td></tr></table>
<table class="half">
    <tr class="no-border"><td colspan="2">附1</td></tr>
    <tr class="no-border"><td colspan="2"><strong>故障码</strong></td></tr>
    <tr class="border">
        <td>日期</td>
        <td>故障码</td>
    </tr>
    <#list reportVO.faultCodeVOList as faultCodeVO>
    <tr class="border">
        <td>${faultCodeVO.date!""}</td>
        <td>${faultCodeVO.faultCode!""}</td>
    </tr>
    </#list>
</table>
<table class="half">
    <tr class="no-border"><td colspan="2">附2</td></tr>
    <tr class="no-border"><td colspan="2"><strong>违章信息</strong></td></tr>
    <tr class="border">
        <td>日期</td>
        <td>违章信息</td>
    </tr>
    <#list reportVO.illegalRecordVOList as illegalRecordVO>
    <tr class="border">
        <td>${illegalRecordVO.date!""}</td>
        <td>${illegalRecordVO.illegalRecord!""}</td>
    </tr>
    </#list>
</table>
</body>
</html>