package cn.broccoli.blog.po;

import java.util.Date;

public class Shuoshuo {
    private Integer shuoId;

    private Integer userId;

    private Date shuoTime;

    private String shuoIp;

    private String shuoshuo;

    private Byte typeId;

    public Integer getShuoId() {
        return shuoId;
    }

    public void setShuoId(Integer shuoId) {
        this.shuoId = shuoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getShuoTime() {
        return shuoTime;
    }

    public void setShuoTime(Date shuoTime) {
        this.shuoTime = shuoTime;
    }

    public String getShuoIp() {
        return shuoIp;
    }

    public void setShuoIp(String shuoIp) {
        this.shuoIp = shuoIp == null ? null : shuoIp.trim();
    }

    public String getShuoshuo() {
        return shuoshuo;
    }

    public void setShuoshuo(String shuoshuo) {
        this.shuoshuo = shuoshuo == null ? null : shuoshuo.trim();
    }

    public Byte getTypeId() {
        return typeId;
    }

    public void setTypeId(Byte typeId) {
        this.typeId = typeId;
    }
}