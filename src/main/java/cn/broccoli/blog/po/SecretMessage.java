package cn.broccoli.blog.po;

import java.util.Date;

public class SecretMessage {
    private Integer secretId;

    private Integer sendId;

    private Integer receiveId;

    private String messageTopic;

    private String messageContent;

    private Date messageTime;

    public Integer getSecretId() {
        return secretId;
    }

    public void setSecretId(Integer secretId) {
        this.secretId = secretId;
    }

    public Integer getSendId() {
        return sendId;
    }

    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    public Integer getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
    }

    public String getMessageTopic() {
        return messageTopic;
    }

    public void setMessageTopic(String messageTopic) {
        this.messageTopic = messageTopic == null ? null : messageTopic.trim();
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }
}