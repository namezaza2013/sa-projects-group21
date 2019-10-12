package com.cpe.backend.order.model;
import lombok.*;

@Data 
public class BodyOrder{
  private Long tablesId;
  private Long orderStatusId;
  private String desc;
  private Long[] menuId;
}