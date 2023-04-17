// ---Auto Generated by Only4Play ---
package com.only4play.flow.domain.chain.response;

import com.only4play.common.constants.ValidStatus;
import com.only4play.common.model.AbstractJpaResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.lang.String;

@Schema
public class ChainResponse extends AbstractJpaResponse {
  @Schema(
      title = "应用名称"
  )
  private String applicationName;

  @Schema(
      title = "链路id"
  )
  private String chainId;

  @Schema(
      title = "链路名称"
  )
  private String chainName;

  @Schema(
      title = "链路描述"
  )
  private String chainDesc;

  @Schema(
      title = "链路el数据"
  )
  private String elData;

  @Schema(
      title = "页面json"
  )
  private String frontJson;

  @Schema(
      title = "环境变量"
  )
  private String env;

  @Schema(
      title = "有效状态: 1-有效,0-无效"
  )
  private ValidStatus validStatus;

  public String getApplicationName() {
    return applicationName;
  }

  public void setApplicationName(String applicationName) {
    this.applicationName = applicationName;
  }

  public String getChainId() {
    return chainId;
  }

  public void setChainId(String chainId) {
    this.chainId = chainId;
  }

  public String getChainName() {
    return chainName;
  }

  public void setChainName(String chainName) {
    this.chainName = chainName;
  }

  public String getChainDesc() {
    return chainDesc;
  }

  public void setChainDesc(String chainDesc) {
    this.chainDesc = chainDesc;
  }

  public String getElData() {
    return elData;
  }

  public void setElData(String elData) {
    this.elData = elData;
  }

  public String getFrontJson() {
    return frontJson;
  }

  public void setFrontJson(String frontJson) {
    this.frontJson = frontJson;
  }

  public String getEnv() {
    return env;
  }

  public void setEnv(String env) {
    this.env = env;
  }

  public ValidStatus getValidStatus() {
    return validStatus;
  }

  public void setValidStatus(ValidStatus validStatus) {
    this.validStatus = validStatus;
  }
}
