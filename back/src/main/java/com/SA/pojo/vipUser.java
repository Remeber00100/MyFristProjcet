package com.SA.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;


import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class vipUser {
    private int id;
    private String account;
    private String password;
    private int vipLv;
    @JsonFormat(pattern="yyyy年MM月dd日 HH:mm:ss", timezone="GMT+8")
    private Date vipBeginDate;
    private float vipTime;


}
