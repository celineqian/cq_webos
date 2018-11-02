DROP DATABASE IF EXISTS cqweb;
CREATE DATABASE IF NOT EXISTS cqweb DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

USE cqweb;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO sys_user VALUES
(1,'2018-11-01 10:30:50','管理员','celine@gmail.com','CQ','3931MUEQD1939MQMLM4AISPVNE',0,'9909990','2018-11-01 10:30:50','celine'),
(2,'2018-11-01 10:30:50','用户','user@gmail.com','User','3931MUEQD1939MQMLM4AISPVNE',0,'0000000','2018-11-01 10:30:50','user');


-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO sys_role VALUES
(1,'2018-11-01 10:30:50','管理员','Admin','administrator',0,'2018-11-01 10:30:50'),
(2,'2018-11-01 10:30:50','用户','User','user',0,'2018-11-01 10:30:50');

-- ----------------------------
-- Records of sys_resource
-- ----------------------------

INSERT INTO sys_resource VALUES
(1,'2018-11-01 13:56:51','系统管理',NULL,0,2,'系统管理',1,'system:system:index','/admin/system/index',1,'2018-10-03 13:59:01',NULL),

(2,'2018-10-03 13:56:51','用户管理',NULL,0,3,'用户管理',1,'system:user:index','/admin/user/index',1,'2018-10-03 13:59:01',NULL),
(3,'2018-10-03 13:56:51','用户编辑',NULL,0,4,'用户编辑',2,'system:user:edit','/admin/user/edit*',2,'2018-10-03 16:26:42',2),
(4,'2018-10-03 16:48:48','用户添加',NULL,0,4,'用户添加',3,'system:user:add','/admin/user/add',2,'2018-10-03 16:49:26',2),
(5,'2018-10-03 16:48:48','用户删除',NULL,0,4,'用户删除',4,'system:user:delete','/admin/user/delete',2,'2018-10-03 14:11:41',2),
(6,'2018-10-03 16:48:48','角色分配',NULL,0,4,'角色分配',5,'system:user:grant','/admin/user/grant/**',2,'2018-10-03 14:11:51',2),

(7,'2018-10-03 16:45:10','角色管理',NULL,0,3,'角色管理',1,'system:role:index','/admin/role/index',1,'2018-10-03 16:46:52',NULL),
(8,'2018-10-03 16:47:02','角色编辑',NULL,0,4,'角色编辑',1,'system:role:edit','/admin/role/edit*',2,'2018-10-03 10:24:06',7),
(9,'2018-10-03 16:47:23','角色添加',NULL,0,4,'角色添加',2,'system:role:add','/admin/role/add',2,'2018-10-03 16:49:16',7),
(10,'2018-10-03 16:47:23','角色删除',NULL,0,4,'角色删除',3,'system:role:delete','/admin/role/delete',2,'2018-10-03 14:12:03',7),
(11,'2018-10-03 16:47:23','资源分配',NULL,0,4,'资源分配',4,'system:role:grant','/admin/role/grant/**',2,'2018-10-03 14:12:11',7),

(12,'2018-10-03 11:21:12','资源管理',NULL,0,3,'资源管理',1,'system:resource:index','/admin/resource/index',1,'2018-10-03 11:21:42',NULL),
(13,'2018-10-03 11:21:52','资源编辑',NULL,0,4,'资源编辑',1,'system:resource:edit','/admin/resource/edit*',2,'2018-10-03 11:22:36',12),
(14,'2018-10-03 11:21:54','资源添加',NULL,0,4,'资源添加',2,'system:resource:add','/admin/resource/add',2,'2018-10-03 11:22:39',12),
(15,'2018-10-03 11:21:54','资源删除',NULL,0,4,'资源删除',3,'system:resource:delete','/admin/resource/delete',2,'2018-10-03 14:12:31',12),

(16,'2018-10-03 11:21:54','通知管理',NULL,0,3,'通知管理',1,'system:notice:index','/admin/notice/index',2,'2018-10-03 14:12:31',NULL),
(17,'2018-10-03 11:21:54','通知添加',NULL,0,4,'通知添加',1,'system:notice:add','/admin/notice/add',2,'2018-10-03 14:12:31',16),
(18,'2018-10-03 11:21:54','通知编辑',NULL,0,4,'通知编辑',2,'system:notice:edit','/admin/notice/edit*',2,'2018-10-03 14:12:31',16),
(19,'2018-10-03 11:21:54','通知删除',NULL,0,4,'通知删除',3,'system:notice:delete','/admin/notice/delete',2,'2018-10-03 14:12:31',16),

(20,'2018-10-03 11:21:54','登陆日志管理',NULL,0,3,'登录日志管理',1,'system:loginlog:index','/admin/loginlog/index',1,'2018-10-03 14:12:31',NULL),
(21,'2018-10-03 11:21:54','登陆日志删除',NULL,0,4,'登录日志删除',1,'system:loginlog:delete','/admin/loginlog/delete',2,'2018-10-03 14:12:31',20),

(22,'2018-10-03 11:21:54','业务日志管理',NULL,0,3,'业务日志管理',1,'system:log:index','/admin/log/index*',1,'2018-10-03 14:12:31',NULL),
(23,'2018-10-03 11:21:54','业务日志删除',NULL,0,4,'业务日志删除',1,'system:log:delete','/admin/log/delete',2,'2018-10-03 14:12:31',22),

(24,'2018-11-01 13:56:51','交通管理',NULL,0,2,'交通管理',1,'system:transport:index','/admin/transport/index',1,'2018-10-03 13:59:01',NULL),

(25,'2018-10-19 11:21:54','车辆管理',NULL,0,3,'车辆管理',1,'transport:vehicle:index','/transport/vehicle/index',1,'2018-10-19 14:12:31',NULL),
(26,'2018-10-19 11:21:54','车辆添加',NULL,0,4,'车辆添加',1,'transport:vehicle:add','/transport/vehicle/add',2,'2018-10-19 14:12:31',25),
(27,'2018-10-19 11:21:54','车辆编辑',NULL,0,4,'车辆编辑',2,'transport:vehicle:edit','/transport/vehicle/edit*',2,'2018-10-19 14:12:31',25),
(28,'2018-10-19 11:21:54','车辆删除',NULL,0,4,'车辆删除',3,'transport:vehicle:delete','/transport/vehicle/delete',2,'2018-10-19 14:12:31',25),

(29,'2018-10-20 11:21:54','司机管理',NULL,0,3,'司机管理',1,'transport:driver:index','/transport/driver/index',1,'2018-10-20 14:12:31',NULL),
(30,'2018-10-20 11:21:54','司机添加',NULL,0,4,'司机添加',1,'transport:driver:add','/transport/driver/add',2,'2018-10-20 14:12:31',29),
(31,'2018-10-20 11:21:54','司机编辑',NULL,0,4,'司机编辑',2,'transport:driver:edit','/transport/driver/edit*',2,'2018-10-20 14:12:31',29),
(32,'2018-10-20 11:21:54','司机删除',NULL,0,4,'司机删除',3,'transport:driver:delete','/transport/driver/delete',2,'2018-10-20 14:12:31',29),

(33,'2018-10-22 11:21:54','航班管理',NULL,0,3,'航班管理',1,'transport:flight:index','/transport/flight/index',1,'2018-10-22 14:12:31',NULL),
(34,'2018-10-22 11:21:54','航班添加',NULL,0,4,'航班添加',1,'transport:flight:add','/transport/flight/add',2,'2018-10-22 14:12:31',33),
(35,'2018-10-22 11:21:54','航班编辑',NULL,0,4,'航班编辑',2,'transport:flight:edit','/transport/flight/edit',2,'2018-10-22 14:12:31',33),
(36,'2018-10-22 11:21:54','航班删除',NULL,0,4,'航班删除',3,'transport:flight:delete','/transport/flight/delete',2,'2018-10-22 14:12:31',33),

(37,'2018-10-22 11:21:54','路线管理',NULL,0,3,'路线管理',1,'transport:route:index','/transport/route/index',1,'2018-10-22 14:12:31',NULL),
(38,'2018-10-22 11:21:54','路线添加',NULL,0,4,'路线添加',1,'transport:route:add','/transport/route/add',2,'2018-10-22 14:12:31',37),
(39,'2018-10-22 11:21:54','路线编辑',NULL,0,4,'路线编辑',2,'transport:route:edit','/transport/route/edit',2,'2018-10-22 14:12:31',37),
(40,'2018-10-22 11:21:54','路线删除',NULL,0,4,'路线删除',3,'transport:route:delete','/transport/route/delete',2,'2018-10-22 14:12:31',37),

(41,'2018-10-26 11:21:54','班次管理',NULL,0,3,'班次管理',1,'transport:shift:index','/transport/shift/index',1,'2018-10-26 17:12:31',NULL),
(42,'2018-10-26 11:21:54','班次添加',NULL,0,4,'班次添加',1,'transport:shift:add','/transport/shift/add',2,'2018-10-26 17:12:31',41),
(43,'2018-10-26 11:21:54','班次编辑',NULL,0,4,'班次编辑',2,'transport:shift:edit','/transport/shift/edit',2,'2018-10-26 17:12:31',41),
(44,'2018-10-26 11:21:54','班次删除',NULL,0,4,'班次删除',3,'transport:shift:delete','/transport/shift/delete',2,'2018-10-26 17:12:31',41),
(45,'2018-10-26 11:21:54','班次结算',NULL,0,4,'班次结算',4,'transport:shift:settle','/transport/shift/settle',2,'2018-10-26 17:12:31',41),

(46,'2018-10-27 11:21:54','乘客管理',NULL,0,3,'乘客管理',1,'transport:passenger:index','/transport/passenger/index',1,'2018-10-27 14:12:31',NULL),
(47,'2018-10-27 11:21:54','乘客添加',NULL,0,4,'乘客添加',1,'transport:passenger:add','/transport/passenger/add',2,'2018-10-27 14:12:31',46),
(48,'2018-10-27 11:21:54','乘客编辑',NULL,0,4,'乘客编辑',2,'transport:passenger:edit','/transport/passenger/edit',2,'2018-10-27 14:12:31',46),
(49,'2018-10-27 11:21:54','乘客删除',NULL,0,4,'乘客删除',3,'transport:passenger:delete','/transport/passenger/delete',2,'2018-10-27 14:12:31',46),

(50,'2018-10-29 11:21:54','公司管理',NULL,0,3,'公司管理',1,'transport:company:index','/transport/company/index',1,'2018-10-29 14:12:31',NULL),
(51,'2018-10-29 11:21:54','公司添加',NULL,0,4,'公司添加',1,'transport:company:add','/transport/company/add',2,'2018-10-29 14:12:31',50),
(52,'2018-10-29 11:21:54','公司编辑',NULL,0,4,'公司编辑',2,'transport:company:edit','/transport/company/edit',2,'2018-10-29 14:12:31',50),
(53,'2018-10-29 11:21:54','公司删除',NULL,0,4,'公司删除',3,'transport:company:delete','/transport/company/delete',2,'2018-10-29 14:12:31',50),

(54,'2018-11-02 11:21:54','保养记录管理',NULL,0,3,'保养记录管理',1,'transport:servicerecord:index','/transport/servicerecord/index',1,'2018-11-02 14:12:31',NULL),
(55,'2018-11-02 11:21:54','保养记录添加',NULL,0,4,'保养记录添加',1,'transport:servicerecord:add','/transport/servicerecord/add',2,'2018-11-02 14:12:31',54),
(56,'2018-11-02 11:21:54','保养记录编辑',NULL,0,4,'保养记录编辑',2,'transport:servicerecord:edit','/transport/servicerecord/edit',2,'2018-11-02 14:12:31',54),
(57,'2018-11-02 11:21:54','保养记录删除',NULL,0,4,'保养记录删除',3,'transport:servicerecord:delete','/transport/servicerecord/delete',2,'2018-11-02 14:12:31',54),



-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO sys_user_role VALUES (1,1),(2,2);

-- --------------t--------------
-- Records of sys_role_resource
-- ----------------------------
INSERT INTO sys_role_resource VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),
(1,17),(1,18),(1,19),(1,20),(1,21),(1,22),(1,23),(1,24),(1,25),(1,26),(1,27),(1,28),(1,29),(1,30),(1,31),(1,32),(1,33),(1,34),(1,35),(1,36),(1,37),(1,38),(1,39),(1,40),(1,41),
(1,42),(1,43),(1,44),(1,45),(1,46),(1,47),(1,48),(1,49),(1,50),(1,51),(1,52),(1,53),(2,1),(2,2);