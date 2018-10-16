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
(2,'2018-10-03 13:56:51','用户编辑',NULL,0,3,'用户查看',1,'system:user:edit','/admin/user/edit*',2,'2018-10-03 16:26:42',1),
(3,'2018-10-03 13:56:51','用户编辑',NULL,0,3,'用户编辑',2,'system:user:edit','/admin/user/edit*',2,'2018-10-03 16:26:42',1),
(4,'2018-10-03 16:48:48','用户添加',NULL,0,3,'用户添加',3,'system:user:add','/admin/user/add',2,'2018-10-03 16:49:26',1),
(5,'2018-10-03 16:48:48','用户删除',NULL,0,3,'用户删除',4,'system:user:deleteBatch','/admin/user/deleteBatch',2,'2018-10-03 14:11:41',1),
(6,'2018-10-03 16:48:48','角色分配',NULL,0,3,'角色分配',5,'system:user:grant','/admin/user/grant/**',2,'2018-10-03 14:11:51',1),
(7,'2018-10-03 16:45:10','角色管理',NULL,0,2,'角色管理',1,'system:role:index','/admin/role/index',1,'2018-10-03 16:46:52',NULL),
(8,'2018-10-03 16:47:02','角色编辑',NULL,0,3,'角色编辑',1,'system:role:edit','/admin/role/edit*',2,'2018-10-03 10:24:06',7),
(9,'2018-10-03 16:47:23','角色添加',NULL,0,3,'角色添加',2,'system:role:add','/admin/role/add',2,'2018-10-03 16:49:16',7),
(10,'2018-10-03 16:47:23','角色删除',NULL,0,3,'角色删除',3,'system:role:deleteBatch','/admin/role/deleteBatch',2,'2018-10-03 14:12:03',7),
(11,'2018-10-03 16:47:23','资源分配',NULL,0,3,'资源分配',4,'system:role:grant','/admin/role/grant/**',2,'2018-10-03 14:12:11',7),
(12,'2018-10-03 11:21:12','资源管理',NULL,0,2,'资源管理',1,'system:resource:index','/admin/resource/index',1,'2018-10-03 11:21:42',NULL),
(13,'2018-10-03 11:21:52','资源编辑',NULL,0,3,'资源编辑',1,'system:resource:edit','/admin/resource/edit*',2,'2018-10-03 11:22:36',12),
(14,'2018-10-03 11:21:54','资源添加',NULL,0,3,'资源添加',2,'system:resource:add','/admin/resource/add',2,'2018-10-03 11:22:39',12),
(15,'2018-10-03 11:21:54','资源删除',NULL,0,3,'资源删除',3,'system:resource:deleteBatch','/admin/resource/deleteBatch',2,'2018-10-03 14:12:31',12);
(16,'2018-10-03 11:21:54','通知管理',NULL,0,2,'通知管理',1,'system:notice:index','/admin/notice/index',2,'2018-10-03 14:12:31',NULL);
(17,'2018-10-03 11:21:54','通知添加',NULL,0,3,'通知添加',1,'system:notice:add','/admin/notice/add',2,'2018-10-03 14:12:31',16);
(18,'2018-10-03 11:21:54','通知编辑',NULL,0,3,'通知编辑',2,'system:notice:edit','/admin/notice/edit*',2,'2018-10-03 14:12:31',16);
(19,'2018-10-03 11:21:54','通知删除',NULL,0,3,'通知删除',3,'system:notice:deleteBatch','/admin/notice/deleteBatch',2,'2018-10-03 14:12:31',16);
(20,'2018-10-03 11:21:54','登陆日志管理',NULL,0,2,'登录日志管理',1,'system:loginlog:index','/admin/loginlog/index',1,'2018-10-03 14:12:31',NULL);
(21,'2018-10-03 11:21:54','登陆日志删除',NULL,0,3,'登录日志修改',1,'system:loginlog:delete','/admin/loginlog/delete*',2,'2018-10-03 14:12:31',20);

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO t_user_role VALUES (1,1),(2,2);

-- --------------t--------------
-- Records of t_role_resource
-- ----------------------------
INSERT INTO t_role_resource VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(2,1),(2,2);
