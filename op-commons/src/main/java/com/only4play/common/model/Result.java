package com.only4play.common.model;

import java.util.Objects;

import com.only4play.common.constants.BaseEnum;
import com.only4play.common.constants.CodeEnum;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * @author gim
 **/
@Data
public final class Result<E> {

  @Setter(AccessLevel.PRIVATE)
  private Integer code;
  @Setter(AccessLevel.PRIVATE)
  private String msg;
  @Setter(AccessLevel.PRIVATE)
  private E result;

  private Result() {
  }

  public static <E> Result<E> success(E e) {
    Result<E> object = new Result<>();
    object.setCode(CodeEnum.Success.getCode());
    object.setMsg(CodeEnum.Success.getName());
    object.setResult(e);
    return object;
  }

  public static <E> Result<E> success(E t, String msg) {
    Result<E> obj = success(t);
    obj.setMsg(msg);
    return obj;
  }

  public static Result fail(BaseEnum codeEnum) {
    Result object = new Result();
    object.setMsg(codeEnum.getName());
    object.setCode(codeEnum.getCode());
    return object;
  }

  public static Result fail(String msg) {
    Result object = new Result();
    object.setMsg(msg);
    object.setCode(CodeEnum.Fail.getCode());
    return object;
  }

  public static <E> Result<E> fail(E e, String msg) {
    Result<E> object = new Result<>();
    object.setCode(CodeEnum.Fail.getCode());
    object.setMsg(msg);
    object.setResult(e);
    return object;
  }

  public static <E> Result<E> res(BaseEnum codeEnum, E e) {
    Result<E> object = new Result<>();
    object.setMsg(codeEnum.getName());
    object.setCode(codeEnum.getCode());
    object.setResult(e);
    return object;
  }


  public boolean isSuccess() {
    if (Objects.equals(CodeEnum.Success.getCode(), this.getCode())) {
      return true;
    } else {
      return false;
    }
  }

}
