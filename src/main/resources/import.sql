DROP DATABASE IF EXISTS cqweb;
CREATE DATABASE IF NOT EXISTS cqweb DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

USE cqweb;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO t_user VALUES
(1,'2018-10-03 15:41:50','管理员','celine@gmail.com','CQ','3931MUEQD1939MQMLM4AISPVNE',0,'9909990','2018-10-03 15:41:50','celine'),
(2,'2018-10-03 15:41:50','用户','user@gmail.com','User','3931MUEQD1939MQMLM4AISPVNE',0,'0000000','2018-10-03 15:41:50','user');


-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO t_role VALUES (1,'2018-10-03 15:41:50','管理员','Admin','administrator',0,'2018-10-03 15:41:50'),(2,'2018-10-03 15:41:50','用户','User','user',0,'2018-10-03 15:41:50');

-- ----------------------------
-- Records of t_resource
-- ----------------------------
INSERT INTO t_resource VALUES
(1,'2018-10-03 13:56:51','用户管理',NULL,0,2,'用户管理',1,'system:user:index','/admin/user/index',1,'2018-10-03 13:59:01',NULL),
(2,'2018-10-03 13:56:51','用户编辑',NULL,0,3,'用户编辑',2,'system:user:edit','/admin/user/edit*',2,'2018-10-03 16:26:42',1),
(3,'2018-10-03 16:48:48','用户添加',NULL,0,3,'用户添加',3,'system:user:add','/admin/user/add',2,'2018-10-03 16:49:26',1),
(4,'2018-10-03 16:48:48','用户删除',NULL,0,3,'用户删除',4,'system:user:delete','/admin/user/delete',2,'2018-10-03 14:11:41',1),
(5,'2018-10-03 16:48:48','角色分配',NULL,0,3,'角色分配',5,'system:user:grant','/admin/user/grant/**',2,'2018-10-03 14:11:51',1),

(6,'2018-10-03 16:45:10','角色管理',NULL,0,2,'角色管理',1,'system:role:index','/admin/role/index',1,'2018-10-03 16:46:52',NULL),
(7,'2018-10-03 16:47:02','角色编辑',NULL,0,3,'角色编辑',1,'system:role:edit','/admin/role/edit*',2,'2018-10-03 10:24:06',6),
(8,'2018-10-03 16:47:23','角色添加',NULL,0,3,'角色添加',2,'system:role:add','/admin/role/add',2,'2018-10-03 16:49:16',6),
(9,'2018-10-03 16:47:23','角色删除',NULL,0,3,'角色删除',3,'system:role:delete','/admin/role/delete',2,'2018-10-03 14:12:03',6),
(10,'2018-10-03 16:47:23','资源分配',NULL,0,3,'资源分配',4,'system:role:grant','/admin/role/grant/**',2,'2018-10-03 14:12:11',6),

(11,'2018-10-03 11:21:12','资源管理',NULL,0,2,'资源管理',1,'system:resource:index','/admin/resource/index',1,'2018-10-03 11:21:42',NULL),
(12,'2018-10-03 11:21:52','资源编辑',NULL,0,3,'资源编辑',1,'system:resource:edit','/admin/resource/edit*',2,'2018-10-03 11:22:36',11),
(13,'2018-10-03 11:21:54','资源添加',NULL,0,3,'资源添加',2,'system:resource:add','/admin/resource/add',2,'2018-10-03 11:22:39',11),
(14,'2018-10-03 11:21:54','资源删除',NULL,0,3,'资源删除',3,'system:resource:delete','/admin/resource/delete',2,'2018-10-03 14:12:31',11),

(15,'2018-10-03 11:21:54','通知管理',NULL,0,2,'通知管理',1,'system:notice:index','/admin/notice/index',2,'2018-10-03 14:12:31',NULL),
(16,'2018-10-03 11:21:54','通知添加',NULL,0,3,'通知添加',1,'system:notice:add','/admin/notice/add',2,'2018-10-03 14:12:31',15),
(17,'2018-10-03 11:21:54','通知编辑',NULL,0,3,'通知编辑',2,'system:notice:edit','/admin/notice/edit*',2,'2018-10-03 14:12:31',15),
(18,'2018-10-03 11:21:54','通知删除',NULL,0,3,'通知删除',3,'system:notice:delete','/admin/notice/delete',2,'2018-10-03 14:12:31',15),

(19,'2018-10-03 11:21:54','登陆日志管理',NULL,0,2,'登录日志管理',1,'system:loginlog:index','/admin/loginlog/index',1,'2018-10-03 14:12:31',NULL),
(20,'2018-10-03 11:21:54','登陆日志删除',NULL,0,3,'登录日志删除',1,'system:loginlog:delete','/admin/loginlog/delete',2,'2018-10-03 14:12:31',19),

(21,'2018-10-03 11:21:54','业务日志管理',NULL,0,2,'业务日志管理',1,'system:log:index','/admin/log/index*',1,'2018-10-03 14:12:31',NULL),
(22,'2018-10-03 11:21:54','业务日志删除',NULL,0,3,'业务日志删除',1,'system:log:delete','/admin/log/delete',2,'2018-10-03 14:12:31',21),

(23,'2018-10-19 11:21:54','车辆管理',NULL,0,2,'车辆管理',1,'transport:vehicle:index','/transport/vehicle/index',1,'2018-10-19 14:12:31',NULL),
(24,'2018-10-19 11:21:54','车辆添加',NULL,0,3,'车辆添加',1,'transport:vehicle:add','/transport/vehicle/add',2,'2018-10-19 14:12:31',23),
(25,'2018-10-19 11:21:54','车辆编辑',NULL,0,3,'车辆编辑',2,'transport:vehicle:edit','/transport/vehicle/edit*',2,'2018-10-19 14:12:31',23),
(26,'2018-10-19 11:21:54','车辆删除',NULL,0,3,'车辆删除',3,'transport:vehicle:delete','/transport/vehicle/delete',2,'2018-10-19 14:12:31',23),

(27,'2018-10-20 11:21:54','司机管理',NULL,0,2,'司机管理',1,'transport:driver:index','/transport/driver/index',1,'2018-10-20 14:12:31',NULL),
(28,'2018-10-20 11:21:54','司机添加',NULL,0,3,'司机添加',1,'transport:driver:add','/transport/driver/add',2,'2018-10-20 14:12:31',27),
(29,'2018-10-20 11:21:54','司机编辑',NULL,0,3,'司机编辑',2,'transport:driver:edit','/transport/driver/edit*',2,'2018-10-20 14:12:31',27),
(30,'2018-10-20 11:21:54','司机删除',NULL,0,3,'司机删除',3,'transport:driver:delete','/transport/driver/delete',2,'2018-10-20 14:12:31',27),

(31,'2018-10-22 11:21:54','航班管理',NULL,0,2,'航班管理',1,'transport:flight:index','/transport/flight/index',1,'2018-10-22 14:12:31',NULL),
(32,'2018-10-22 11:21:54','航班添加',NULL,0,3,'航班添加',1,'transport:flight:add','/transport/flight/add',2,'2018-10-22 14:12:31',31),
(33,'2018-10-22 11:21:54','航班编辑',NULL,0,3,'航班编辑',2,'transport:flight:edit','/transport/flight/edit',2,'2018-10-22 14:12:31',31),
(34,'2018-10-22 11:21:54','航班删除',NULL,0,3,'航班删除',3,'transport:flight:delete','/transport/flight/delete',2,'2018-10-22 14:12:31',31),

(35,'2018-10-22 11:21:54','路线管理',NULL,0,2,'路线管理',1,'transport:route:index','/transport/route/index',1,'2018-10-22 14:12:31',NULL),
(36,'2018-10-22 11:21:54','路线添加',NULL,0,3,'路线添加',1,'transport:route:add','/transport/route/add',2,'2018-10-22 14:12:31',35),
(37,'2018-10-22 11:21:54','路线编辑',NULL,0,3,'路线编辑',2,'transport:route:edit','/transport/route/edit',2,'2018-10-22 14:12:31',35),
(38,'2018-10-22 11:21:54','路线删除',NULL,0,3,'路线删除',3,'transport:route:delete','/transport/route/delete',2,'2018-10-22 14:12:31',35),

(39,'2018-10-26 11:21:54','班次管理',NULL,0,2,'班次管理',1,'transport:shift:index','/transport/shift/index',1,'2018-10-26 17:12:31',NULL),
(40,'2018-10-26 11:21:54','班次添加',NULL,0,3,'班次添加',1,'transport:shift:add','/transport/shift/add',2,'2018-10-26 17:12:31',39),
(41,'2018-10-26 11:21:54','班次编辑',NULL,0,3,'班次编辑',2,'transport:shift:edit','/transport/shift/edit',2,'2018-10-26 17:12:31',39),
(42,'2018-10-26 11:21:54','班次删除',NULL,0,3,'班次删除',3,'transport:shift:delete','/transport/shift/delete',2,'2018-10-26 17:12:31',39),
(43,'2018-10-26 11:21:54','班次乘客',NULL,0,3,'班次乘客',4,'transport:shift:addPassenger','/transport/shift/addPassenger',2,'2018-10-26 17:12:31',39),
(44,'2018-10-26 11:21:54','班次结算',NULL,0,3,'班次结算',5,'transport:shift:settle','/transport/shift/settle',2,'2018-10-26 17:12:31',39);

(45,'2018-10-27 11:21:54','乘客管理',NULL,0,2,'乘客管理',1,'transport:Passenger:index','/transport/Passenger/index',1,'2018-10-27 14:12:31',NULL),
(46,'2018-10-27 11:21:54','乘客添加',NULL,0,3,'乘客添加',1,'transport:Passenger:add','/transport/Passenger/add',2,'2018-10-27 14:12:31',45),
(47,'2018-10-27 11:21:54','乘客编辑',NULL,0,3,'乘客编辑',2,'transport:Passenger:edit','/transport/Passenger/edit',2,'2018-10-27 14:12:31',45),
(48,'2018-10-27 11:21:54','乘客删除',NULL,0,3,'乘客删除',3,'transport:Passenger:delete','/transport/Passenger/delete',2,'2018-10-27 14:12:31',45),


-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO t_user_role VALUES (1,1),(2,2);

-- --------------t--------------
-- Records of t_role_resource
-- ----------------------------
INSERT INTO t_role_resource VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),
(1,17),(1,18),(1,19),(1,20),(1,21),(1,22),(1,23),(1,24),(1,25),(1,26),(1,27),(1,28),(1,29),(1,30),(2,1),(2,2);