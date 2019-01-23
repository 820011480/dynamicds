package com.mady.dynamicds.model;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
 
/**
 * user实体类
 * Created by pure on 2018-05-06.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private Date createTime;
}
