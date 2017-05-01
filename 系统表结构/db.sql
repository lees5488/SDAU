CREATE TABLE `event_report` (
  `event_no` varchar(50) NOT NULL COMMENT '事件编号',
  `event_name` varchar(255) DEFAULT NULL COMMENT '事件名称',
  `event_type` tinyint(4) NOT NULL COMMENT '事件类型',
  `trans_status` tinyint(4) NOT NULL COMMENT '事务状态',
  `employee_no` varchar(50) NOT NULL COMMENT '上报人',
  `event_content` varchar(255) NOT NULL COMMENT '上报内容',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '制单时间',
  `create_user` int(11) NOT NULL,
  `update_user` int(11) NOT NULL,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`event_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='事件上报表';



CREATE TABLE `event_verify` (
  `verify_no` varchar(50) NOT NULL COMMENT '审核编号',
  `event_no` varchar(50) DEFAULT NULL COMMENT '事件编号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '制单时间',
  `create_user` int(11) NOT NULL,
  `update_user` int(11) NOT NULL,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`verify_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='事件审核表';


CREATE TABLE `event_distribution` (
  `distribution_no` varchar(50) NOT NULL COMMENT '分配编号',
  `event_no` varchar(50) DEFAULT NULL COMMENT '事件编号',
	 agency_no VARCHAR(50) NOT NULL COMMENT '处理机构',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '制单时间',
  `create_user` int(11) NOT NULL,
  `update_user` int(11) NOT NULL,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`distribution_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='事件分配表';


CREATE TABLE `event_consummation` (
  `consummation_no` varchar(50) NOT NULL COMMENT '完结编号',
  `event_no` varchar(50) DEFAULT NULL COMMENT '事件编号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '制单时间',
  `create_user` int(11) NOT NULL,
  `update_user` int(11) NOT NULL,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`consummation_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='事件完结表';

CREATE TABLE `event_feedback` (
  `feedback_no` varchar(50) NOT NULL COMMENT '反馈编号',
  `event_no` varchar(50) DEFAULT NULL COMMENT '事件编号',
	 employee_no VARCHAR(50) NOT NULL COMMENT '反馈人',
	 content VARCHAR(255) NOT NULL COMMENT '反馈内容',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '制单时间',
  `create_user` int(11) NOT NULL,
  `update_user` int(11) NOT NULL,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`feedback_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='事件反馈表';
