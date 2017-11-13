import java.sql.Timestamp;

/**
 *
 * @author miracle
 */
public class ArchiveBean {
    private int id;
  private String  fileId;
  private String  parentFileId;
  private String  fileType;
  private String  fileOrigin;
  private String  transactionType;
  private String  isaNumber;
  private String  isaDate;
  private String  isaTime;
  private String  gsControlNumber;
  private String  senderId;
  private String  receiverId;
  private String  priKeyType;
  private String  priKeyValue;
  private String  secKeyType;
  private String  secKeyValue;
  private Timestamp  dateTimeReceived;
  private String  status;
  private String  direction;
  private String  fileName;
  private String  ackFileId;
  private String  orgFilePath;
  private String  preTransPath;
  private String  postTransPath;
  private String  reSubmitPath;
  private String  reTranslatePath;
  private String  errMessage;
  private String  stControlNumber;
  private String  ackStatus;
  private String  reprocessStatus;
  private String  flowFlag;
  private String  carrierStatus;
  private String stopNum;
  private String tmwSenderId;
  private String tmwReceiverId;
  private String reasonCode;
  private String transactionPurpose;
  
  





    public ArchiveBean() {
    }

    public ArchiveBean(int id, String fileId, String parentFileId, String fileType, String fileOrigin, String transactionType, String isaNumber, String isaDate, String isaTime, String gsControlNumber, String senderId, String receiverId, String priKeyType, String priKeyValue, String secKeyType, String secKeyValue, Timestamp dateTimeReceived, String status, String direction, String fileName, String ackFileId, String orgFilePath, String preTransPath, String postTransPath, String reSubmitPath, String reTranslatePath, String errMessage, String stControlNumber, String ackStatus, String reprocessStatus, String flowFlag, String carrierStatus, String stopNum, String tmwSenderId, String tmwReceiverId, String reasonCode, String transactionPurpose) {
        this.id = id;
        this.fileId = fileId;
        this.parentFileId = parentFileId;
        this.fileType = fileType;
        this.fileOrigin = fileOrigin;
        this.transactionType = transactionType;
        this.isaNumber = isaNumber;
        this.isaDate = isaDate;
        this.isaTime = isaTime;
        this.gsControlNumber = gsControlNumber;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.priKeyType = priKeyType;
        this.priKeyValue = priKeyValue;
        this.secKeyType = secKeyType;
        this.secKeyValue = secKeyValue;
        this.dateTimeReceived = dateTimeReceived;
        this.status = status;
        this.direction = direction;
        this.fileName = fileName;
        this.ackFileId = ackFileId;
        this.orgFilePath = orgFilePath;
        this.preTransPath = preTransPath;
        this.postTransPath = postTransPath;
        this.reSubmitPath = reSubmitPath;
        this.reTranslatePath = reTranslatePath;
        this.errMessage = errMessage;
        this.stControlNumber = stControlNumber;
        this.ackStatus = ackStatus;
        this.reprocessStatus = reprocessStatus;
        this.flowFlag = flowFlag;
        this.carrierStatus = carrierStatus;
        this.stopNum = stopNum;
        this.tmwSenderId = tmwSenderId;
        this.tmwReceiverId = tmwReceiverId;
        this.reasonCode = reasonCode;
        this.transactionPurpose = transactionPurpose;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getParentFileId() {
        return parentFileId;
    }

    public void setParentFileId(String parentFileId) {
        this.parentFileId = parentFileId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileOrigin() {
        return fileOrigin;
    }

    public void setFileOrigin(String fileOrigin) {
        this.fileOrigin = fileOrigin;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getIsaNumber() {
        return isaNumber;
    }

    public void setIsaNumber(String isaNumber) {
        this.isaNumber = isaNumber;
    }

    public String getIsaDate() {
        return isaDate;
    }

    public void setIsaDate(String isaDate) {
        this.isaDate = isaDate;
    }

    public String getIsaTime() {
        return isaTime;
    }

    public void setIsaTime(String isaTime) {
        this.isaTime = isaTime;
    }

    public String getGsControlNumber() {
        return gsControlNumber;
    }

    public void setGsControlNumber(String gsControlNumber) {
        this.gsControlNumber = gsControlNumber;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getPriKeyType() {
        return priKeyType;
    }

    public void setPriKeyType(String priKeyType) {
        this.priKeyType = priKeyType;
    }

    public String getPriKeyValue() {
        return priKeyValue;
    }

    public void setPriKeyValue(String priKeyValue) {
        this.priKeyValue = priKeyValue;
    }

    public String getSecKeyType() {
        return secKeyType;
    }

    public void setSecKeyType(String secKeyType) {
        this.secKeyType = secKeyType;
    }

    public String getSecKeyValue() {
        return secKeyValue;
    }

    public void setSecKeyValue(String secKeyValue) {
        this.secKeyValue = secKeyValue;
    }

    public Timestamp getDateTimeReceived() {
        return dateTimeReceived;
    }

    public void setDateTimeReceived(Timestamp dateTimeReceived) {
        this.dateTimeReceived = dateTimeReceived;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getAckFileId() {
        return ackFileId;
    }

    public void setAckFileId(String ackFileId) {
        this.ackFileId = ackFileId;
    }

    public String getOrgFilePath() {
        return orgFilePath;
    }

    public void setOrgFilePath(String orgFilePath) {
        this.orgFilePath = orgFilePath;
    }

    public String getPreTransPath() {
        return preTransPath;
    }

    public void setPreTransPath(String preTransPath) {
        this.preTransPath = preTransPath;
    }

    public String getPostTransPath() {
        return postTransPath;
    }

    public void setPostTransPath(String postTransPath) {
        this.postTransPath = postTransPath;
    }

    public String getReSubmitPath() {
        return reSubmitPath;
    }

    public void setReSubmitPath(String reSubmitPath) {
        this.reSubmitPath = reSubmitPath;
    }

    public String getReTranslatePath() {
        return reTranslatePath;
    }

    public void setReTranslatePath(String reTranslatePath) {
        this.reTranslatePath = reTranslatePath;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public String getStControlNumber() {
        return stControlNumber;
    }

    public void setStControlNumber(String stControlNumber) {
        this.stControlNumber = stControlNumber;
    }

    public String getAckStatus() {
        return ackStatus;
    }

    public void setAckStatus(String ackStatus) {
        this.ackStatus = ackStatus;
    }

    public String getReprocessStatus() {
        return reprocessStatus;
    }

    public void setReprocessStatus(String reprocessStatus) {
        this.reprocessStatus = reprocessStatus;
    }

    public String getFlowFlag() {
        return flowFlag;
    }

    public void setFlowFlag(String flowFlag) {
        this.flowFlag = flowFlag;
    }

    public String getCarrierStatus() {
        return carrierStatus;
    }

    public void setCarrierStatus(String carrierStatus) {
        this.carrierStatus = carrierStatus;
    }

    public String getStopNum() {
        return stopNum;
    }

    public void setStopNum(String stopNum) {
        this.stopNum = stopNum;
    }

    public String getTmwSenderId() {
        return tmwSenderId;
    }

    public void setTmwSenderId(String tmwSenderId) {
        this.tmwSenderId = tmwSenderId;
    }

    public String getTmwReceiverId() {
        return tmwReceiverId;
    }

    public void setTmwReceiverId(String tmwReceiverId) {
        this.tmwReceiverId = tmwReceiverId;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getTransactionPurpose() {
        return transactionPurpose;
    }

    public void setTransactionPurpose(String transactionPurpose) {
        this.transactionPurpose = transactionPurpose;
    }

    
}