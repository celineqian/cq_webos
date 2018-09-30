insert into t_user (`id`,`create_date`,`delete_status`,`description`,`email`,`locked`,`nick_name`,`password`,`telephone`,`update_date`,`user_name`) values (1,'2017-07-16 15:41:50',0,'管理员','celine@gmail.com',0,'CQ','3931MUEQD1939MQMLM4AISPVNE','9909990','2017-07-17 15:41:50','celine');
insert into t_role (`id`,`create_date`,`description`,`name`,`role_key`,`status`,`update_date`) values(1,'2017-07-16 15:41:50','管理员','Admin','administrator',0,'2017-07-16 15:41:50');
insert into t_user_role(`user_id`,`role_id`) values (1,1);
insert into `t_resource`(`id`,`create_date`,`description`,`icon`,`is_hidden`,`level`,`name`,`sort`,`source_key`,`source_url`,`type`,`update_date`,`parent_id`) values (1,'2017-01-10 13:56:51','用户管理',NULL,0,2,'用户管理',1,'system:user:index','/admin/user/index',1,'2017-01-10 13:59:01',NULL),(2,'2017-01-10 13:56:51','用户编辑',NULL,0,3,'用户编辑',1,'system:user:edit','/admin/user/edit*',2,'2017-01-10 16:26:42',1),(3,'2017-01-11 16:48:48','用户添加',NULL,0,3,'用户添加',2,'system:user:add','/admin/user/add',2,'2017-01-11 16:49:26',1),(4,'2017-01-11 16:48:48','用户删除',NULL,0,3,'用户删除',3,'system:user:deleteBatch','/admin/user/deleteBatch',2,'2017-01-18 14:11:41',1),(5,'2017-01-11 16:48:48','角色分配',NULL,0,3,'角色分配',4,'system:user:grant','/admin/user/grant/**',2,'2017-01-18 14:11:51',1),(6,'2017-01-12 16:45:10','角色管理',NULL,0,2,'角色管理',2,'system:role:index','/admin/role/index',1,'2017-01-12 16:46:52',NULL),(7,'2017-01-12 16:47:02','角色编辑',NULL,0,3,'角色编辑',1,'system:role:edit','/admin/role/edit*',2,'2017-01-18 10:24:06',1),(8,'2017-01-12 16:47:23','角色添加',NULL,0,3,'角色添加',2,'system:role:add','/admin/role/add',2,'2017-01-12 16:49:16',6),(9,'2017-01-12 16:47:23','角色删除',NULL,0,3,'角色删除',3,'system:role:deleteBatch','/admin/role/deleteBatch',2,'2017-01-18 14:12:03',6),(10,'2017-01-12 16:47:23','资源分配',NULL,0,3,'资源分配',4,'system:role:grant','/admin/role/grant/**',2,'2017-01-18 14:12:11',6),(11,'2017-01-17 11:21:12','资源管理',NULL,0,2,'资源管理',3,'system:resource:index','/admin/resource/index',1,'2017-01-17 11:21:42',NULL),(12,'2017-01-17 11:21:52','资源编辑',NULL,0,3,'资源编辑',1,'system:resource:edit','/admin/resource/edit*',2,'2017-01-17 11:22:36',11),(13,'2017-01-17 11:21:54','资源添加',NULL,0,3,'资源添加',2,'system:resource:add','/admin/resource/add',2,'2017-01-17 11:22:39',11),(14,'2017-01-17 11:21:54','资源删除',NULL,0,3,'资源删除',3,'system:resource:deleteBatch','/admin/resource/deleteBatch',2,'2017-01-18 14:12:31',11);
insert into `t_role_resource`(`role_id`,`resource_id`) values (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14);



DROP DATABASE IF EXISTS cqweb;
CREATE DATABASE IF NOT EXISTS cqweb DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

USE cqweb;


#UPDATE
insert into t_user (`id`,`create_date`,`delete_status`,`description`,`email`,`locked`,`nick_name`,`password`,`telephone`,`update_date`,`user_name`) values (1,'2017-07-16 15:41:50',0,'管理员','celine@gmail.com',0,'CQ','3931MUEQD1939MQMLM4AISPVNE','9909990','2017-07-17 15:41:50','celine'),(2,'2017-07-16 15:41:50',0,'用户','user@gmail.com',0,'User','3931MUEQD1939MQMLM4AISPVNE','0000000','2017-07-17 15:41:50','celine');
insert into t_role (`id`,`create_date`,`description`,`name`,`role_key`,`status`,`update_date`) values (1,'2017-07-16 15:41:50','管理员','Admin','administrator',0,'2017-07-16 15:41:50'),(2,'2017-07-16 15:41:50','用户','User','user',0,'2017-07-16 15:41:50');
insert into t_user_role(`user_id`,`role_id`) values (1,1),(2,2);
insert into `t_role_resource`(`role_id`,`resource_id`) values (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(2,2);
