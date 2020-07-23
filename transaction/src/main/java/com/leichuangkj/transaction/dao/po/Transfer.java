package com.leichuangkj.transaction.dao.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transfer {
    private Integer id;

    private String username;

    private Integer transfer;
}
