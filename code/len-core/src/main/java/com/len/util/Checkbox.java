package com.len.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Checkbox {

  private String id;
  private String name;
  /**默认未选择*/
  private boolean check=false;

}
