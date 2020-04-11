CREATE DATABASE  IF NOT EXISTS `jdkblog` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `jdkblog`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 192.168.3.9    Database: jdkblog
-- ------------------------------------------------------
-- Server version	5.7.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `rp_user_pay_info_extend`
--

DROP TABLE IF EXISTS `rp_user_pay_info_extend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rp_user_pay_info_extend` (
  `id` varchar(50) NOT NULL,
  `rp_user_pay_info_id` varchar(50) NOT NULL,
  `pay_way_code` varchar(50) NOT NULL,
  `pay_way_name` varchar(100) NOT NULL,
  `type_code` varchar(50) NOT NULL,
  `type_desc` varchar(200) DEFAULT NULL,
  `content` varchar(1000) NOT NULL,
  `create_time` datetime NOT NULL,
  `edit_time` datetime DEFAULT NULL,
  `version` varchar(10) NOT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rp_user_pay_info_extend`
--

LOCK TABLES `rp_user_pay_info_extend` WRITE;
/*!40000 ALTER TABLE `rp_user_pay_info_extend` DISABLE KEYS */;
/*!40000 ALTER TABLE `rp_user_pay_info_extend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_attach`
--

DROP TABLE IF EXISTS `t_attach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_attach` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) NOT NULL DEFAULT '',
  `ftype` varchar(50) DEFAULT '',
  `fkey` varchar(100) NOT NULL DEFAULT '',
  `author_id` int(10) DEFAULT NULL,
  `created` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_attach`
--

LOCK TABLES `t_attach` WRITE;
/*!40000 ALTER TABLE `t_attach` DISABLE KEYS */;
INSERT INTO `t_attach` VALUES (7,'微信图片_20200226230147.jpg','image','/upload/2020/02/sc2ovdc4g6grhqb9i8g5kit7gf.jpg',1,1582729587),(8,'微信图片_20200226230159.jpg','image','/upload/2020/02/4hb0jasiamhubqt869p7rqu59i.jpg',1,1582729590),(9,'微信图片_20200226230220.jpg','image','/upload/2020/02/0f3l0s81v0ho1o9hm82auc12k9.jpg',1,1582729593),(10,'微信图片_20200226230225.jpg','image','/upload/2020/02/s95i9t2c2oih8omogbolucj5qn.jpg',1,1582729596),(11,'微信图片_20200226230229.jpg','image','/upload/2020/02/3rk2987v80jt0oj8huhq4bnjpi.jpg',1,1582729600),(12,'微信图片_20200226230237.jpg','image','/upload/2020/02/7ri8u21voegrrolfnobqbo67t5.jpg',1,1582729600),(13,'微信图片_20200226230232.jpg','image','/upload/2020/02/qnlvtpceiige2rkejnpe3p0rp4.jpg',1,1582729600),(14,'微信图片_20200226230255.jpg','image','/upload/2020/02/ogvsmrh738ht4plu1v1uh9ldv8.jpg',1,1582729605),(15,'微信图片_20200226230247.jpg','image','/upload/2020/02/2gdg3bj36qinvr75hacd24kmgm.jpg',1,1582729606),(16,'微信图片_20200226230243.jpg','image','/upload/2020/02/trgh3hhs08gkrrpstfhgjblejc.jpg',1,1582729606),(17,'微信图片_20200226230249.jpg','image','/upload/2020/02/rgl49k7bsagfuoujutsh3vcuij.jpg',1,1582729606),(18,'微信图片_20200226230257.jpg','image','/upload/2020/02/qm52ndc31uir2r5jr64cs66o0k.jpg',1,1582729611),(19,'微信图片_20200226230304.jpg','image','/upload/2020/02/rom20iv4uogvgqefnd76uaqor5.jpg',1,1582729611),(20,'微信图片_20200226230301.jpg','image','/upload/2020/02/24obttua0kjm8rkjfubcabuigl.jpg',1,1582729611),(21,'微信图片_20200226230322.jpg','image','/upload/2020/02/4p9jknhcdegeqq6pklaha6d9r7.jpg',1,1582729616),(22,'微信图片_20200226230449.png','image','/upload/2020/02/v3go28qkpugikq6g90ko4l05cj.png',1,1582729616),(23,'微信图片_20200226230413.jpg','image','/upload/2020/02/rseo7tjorihikpd0ebbof5bj2d.jpg',1,1582729616),(24,'微信图片_20200226230421.jpg','image','/upload/2020/02/2r1lel2iigg1nru4n49sbr5qgd.jpg',1,1582729616),(25,'微信图片_20200226230438.jpg','image','/upload/2020/02/2r6i3s2noegt8otd3p5l6na597.jpg',1,1582729617),(26,'微信图片_20200226230434.jpg','image','/upload/2020/02/uk7lu14g0sjpdotpcp4duqp67r.jpg',1,1582729617),(27,'微信图片_20200226230510.jpg','image','/upload/2020/02/s3j0t297i2je2puv6j3ne1u2tu.jpg',1,1582729623),(28,'微信图片_20200226230456.png','image','/upload/2020/02/pr3dm3k3euj1tri5kvfigdtrar.png',1,1582729624),(29,'微信图片_20200226230452.jpg','image','/upload/2020/02/7icbts44q8i7po625piuvc8neo.jpg',1,1582729624),(30,'微信图片_20200226230459.jpg','image','/upload/2020/02/s8kq26jf60gc1ptjhds8e4c0ln.jpg',1,1582729624),(31,'微信图片_20200227224708.jpg','image','/upload/2020/02/vpparhdk24ip6opjajsql79fjj.jpg',1,1582814844),(32,'微信图片_20200227225410.jpg','image','/upload/2020/02/uqsf0tc026jorrjl9hgdi5qh23.jpg',1,1582815261),(33,'微信图片_20200227225445.jpg','image','/upload/2020/02/ttgvhtc9m8hkorm7hgtdv8sn19.jpg',1,1582815293),(34,'微信图片_20200227225539.jpg','image','/upload/2020/02/1o1eg5lgsihu0o02o7d3af1m6g.jpg',1,1582815353);
/*!40000 ALTER TABLE `t_attach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_comments`
--

DROP TABLE IF EXISTS `t_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_comments` (
  `coid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cid` int(10) unsigned DEFAULT '0',
  `created` int(10) unsigned DEFAULT '0',
  `author` varchar(200) DEFAULT NULL,
  `author_id` int(10) unsigned DEFAULT '0',
  `owner_id` int(10) unsigned DEFAULT '0',
  `mail` varchar(200) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `ip` varchar(64) DEFAULT NULL,
  `agent` varchar(200) DEFAULT NULL,
  `content` text,
  `type` varchar(16) DEFAULT 'comment',
  `status` varchar(16) DEFAULT 'approved',
  `parent` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`coid`),
  KEY `cid` (`cid`),
  KEY `created` (`created`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_comments`
--

LOCK TABLES `t_comments` WRITE;
/*!40000 ALTER TABLE `t_comments` DISABLE KEYS */;
INSERT INTO `t_comments` VALUES (1,1,1582732184,'热心网友',0,1,'','','0:0:0:0:0:0:0:1',NULL,'test info','comment','approved',0);
/*!40000 ALTER TABLE `t_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_contents`
--

DROP TABLE IF EXISTS `t_contents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_contents` (
  `cid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `slug` varchar(200) DEFAULT NULL,
  `created` int(10) unsigned DEFAULT '0',
  `modified` int(10) unsigned DEFAULT '0',
  `content` text COMMENT '内容文字',
  `author_id` int(10) unsigned DEFAULT '0',
  `type` varchar(16) DEFAULT 'post',
  `status` varchar(16) DEFAULT 'publish',
  `tags` varchar(200) DEFAULT NULL,
  `categories` varchar(200) DEFAULT NULL,
  `thumbImg` varchar(512) DEFAULT NULL,
  `hits` int(10) unsigned DEFAULT '0',
  `comments_num` int(10) unsigned DEFAULT '0',
  `allow_comment` tinyint(1) DEFAULT '1',
  `allow_ping` tinyint(1) DEFAULT '1',
  `allow_feed` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`cid`),
  UNIQUE KEY `slug` (`slug`),
  KEY `created` (`created`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_contents`
--

LOCK TABLES `t_contents` WRITE;
/*!40000 ALTER TABLE `t_contents` DISABLE KEYS */;
INSERT INTO `t_contents` VALUES (1,'ThreadLocal专题(一) -----告诉你我为什么是个打工仔？','ThreadLocal-one',1582639775,1582816611,'![alt](/upload/2020/02/vpparhdk24ip6opjajsql79fjj.jpg)\r\n在上篇文章《读懂ThreadLocal》简单介绍了下有哪些角色，以及角色的定位，这篇文章将更加全面的介绍ThreadLocal为什么是个长工——苦逼的天生的打工仔。\r\n\r\nThreadLocal的源码有的人看过，也有的人没有看过，但是说到上篇文章的思考方式：面向对象的字段和方法的封装，更重要的是字段和方法的内部联系是什么？如何能更具体的去理解它？\r\n\r\nThreadLocal是个打工仔——长工\r\n如果线程Thread是个拥有财富的地主的话，那么Thread Local就是财富的搬运工，是的，它不生产财富，它不消费财富，也不会拥有财富，它只是地主的长工。这些长工在大家族里为这个家的5个兄弟服务着：分别管理者自己对应编号的仓库，只要哪个大兄弟想要仓库的粮食或其他值钱的东西，他都会任劳任怨的去这个大兄弟的库房中给他搬运出来。\r\n\r\n五个兄弟的各自10个库房——ThreadLocal.ThreadLocalMap\r\nThread线程对象就是通过ThreadLocal.ThreadLocalMap来管理它的数据仓库群的，也就是大兄弟的10个库房，而这个ThreadLocalMap是通过数组管理多个仓库Entry[] table，这个Entry就是一个数据仓库类，也就是说Thread通过ThreadLocalMap字段来引用着它名下的多个数据仓库，如下图:\r\n![alt](/upload/2020/02/uqsf0tc026jorrjl9hgdi5qh23.jpg)\r\n\r\n悲伤的ThreadLocal——打工仔每天的工作内容\r\n你们都知道我是个打工仔，对，我只是财富的搬运工，不管哪个大兄弟跟我说想要取出什么东西，我都会拿着对应编号的钥匙去这个大兄弟的仓库群中的对应编号的仓库给他搬出来，而且我还帮他搬东西到新的库房。我是怎么知道这个大兄弟的仓库集群的？请看下图的红色下划线内容。\r\n![alt](/upload/2020/02/ttgvhtc9m8hkorm7hgtdv8sn19.jpg)\r\n对的，大兄弟的仓库群就是这个map。\r\n下面是我搬进去的过程：\r\n![alt](/upload/2020/02/1o1eg5lgsihu0o02o7d3af1m6g.jpg)\r\n搬进去的时候，我也是同样方式得到大兄弟的仓库群的。\r\n\r\n看到这里你也应该明白我是个打工仔的原因了吧! 大兄弟Thread的数据存放在它的仓库中，而我只是在Thread需要的时候给他拿出来，添加新的数据时候我给他搬进去。我是个打工仔，但我不是孤独的一个人，我有10个好哥们，他们跟我一起进出5个大兄弟的仓库群工作，各自管理者对应编号的仓库，而且我们很努力的在改变命运。',1,'post','publish','Java','默认分类','',12,1,1,1,1),(3,'ThreadLocal专题（二）— 数据仓库机制','threadlocal-two',1582640635,1582821371,'![alt](/upload/2020/02/0f3l0s81v0ho1o9hm82auc12k9.jpg)\r\n思维一，构建Thread数据仓库机制\r\n今天介绍的角色是线程的数据仓库群和仓库管理员：\r\n1.数据仓库管理人员：ThreadLocalMap\r\n![alt](/upload/2020/02/s95i9t2c2oih8omogbolucj5qn.jpg)\r\n这个仓库管理员维护的属性：Entry数组 table，table数组的大小。\r\n仓库管理员的核心行为如图所示：\r\n![alt](/upload/2020/02/3rk2987v80jt0oj8huhq4bnjpi.jpg)\r\n图中反馈的信息可以知道：仓库管理员维护着仓库群table，而getEntry，set，remove方法表示对table的行为：仓库内物品的获取，物品的存放，物品的清除。\r\n\r\n2.数据仓库：Entry\r\n![alt](/upload/2020/02/7ri8u21voegrrolfnobqbo67t5.jpg)\r\n仓库管理员维护的数据仓库群table数组的元素类型就是Entry，这个类是个特殊的类，这里不做进一步的剖析，会在以后文章内单独提出来。\r\n数据仓库的角色Entry维护这一个属性value，没有其他行为方法，所以仓库内存放的物品只有一个，即value，是个object类型——可以放入java体系中的任何引用类型。\r\n因此，ThreadLocal的数据仓库可以放入任何类型的数据。\r\n\r\n线程的数据仓库机制\r\n线程维护这数据仓库的管理员角色，而且还有两个管理员threadLocals和inheritableThreadLocals\r\n\r\n这里我们只谈threadLocals这一个属性，我们上面已经分析，threadLocals是一个数据仓库群管理员，管理着仓库群tables，方法有：set，getEntry，remove等。字段threadLocals在线程类中的访问权限是默认修饰符，所以同一个包的类ThreadLocal可以访问。\r\n所以长工角色虽然是个打工的人，但是真正干事的还是仓库群管理员ThreadLocalMap，因为长工的搬运工作都是委托给管理人员来施行的，他只需要在仓库外面等待，ThreadLocalMap类的get方法在ThreadLocal的get方法中，如下图。\r\n![alt](/upload/2020/02/trgh3hhs08gkrrpstfhgjblejc.jpg)\r\n\r\n其他委托方式也和get类似，如下两个图。\r\n![alt](/upload/2020/02/2gdg3bj36qinvr75hacd24kmgm.jpg)\r\n![alt](/upload/2020/02/rgl49k7bsagfuoujutsh3vcuij.jpg)\r\n\r\n线程的数据仓库继承机制\r\nThread的继承机制，大家可能还没碰到过，但是在java体系中却十分重要，不过这里的继承机制不是java中的类继承。这里的继承是指父子线程的属性继承以及数据仓库群的继承。\r\n\r\n子线程Thread被创建时会调用init()方法，这个方法是在父线程中运行，其中一行代码\r\n![alt](/upload/2020/02/ogvsmrh738ht4plu1v1uh9ldv8.jpg)\r\n\r\n所以，parent是当前线程(父线程)的引用，所以父子线程的属性继承传递发生在init()方法内，下图是线程组，守护线程，线程优先级等属性的继承代码。\r\n![alt](/upload/2020/02/qm52ndc31uir2r5jr64cs66o0k.jpg)\r\n\r\n数据仓库的继承代码如下图，inheritableThreadLocals是用于数据仓库继承机制的属性，ThreadLocalMap的引用。\r\n![alt](/upload/2020/02/24obttua0kjm8rkjfubcabuigl.jpg)\r\n\r\n图中代码显示，如果父线程inheritableThreadLocals属性不为空，则会创建一个新的ThreadLocalMap对象给子线程对象，且管理的仓库群物品和父线程一样。这就是线程的继承机制。\r\n\r\n长工ThreadLocal的工作\r\n所有的线程都是公用一个ThreadLocal对象的，线程通过threadlocal来从线程内部数据仓库群中获取数据，不言而喻，几个线程调用同一个threadlocal返回的是不同数据，同样set存放进去的数据也是使用同一个threadlocal的set方法。还有数据的移除和初始化，如下所示：\r\n1.ThreadLocal.get：长工角色获取数据\r\n2.ThreadLocal:set：长工角色存放数据\r\n3.ThreadLocal:remove: 长工角色移除数据\r\n\r\n我们已经谈到，仓库的数据存放工作不是由长工角色Thread Local来完成的，而是委托给仓库群的管理员角色Thread LocalMap来执行的，分别对应ThreadLocalMap的方法，如下所示：\r\n1.ThreadLocalMap.getEntry(ThreadLocal<?>key):\r\n2.ThreadLocalMap.set(ThreadLocal<?>key,Object value):\r\n3.ThreadLocalMap.remove(ThreadLocal<?>key);\r\n也就是说ThreadLocal的三个方法get，set，remove都在方法体内调用了ThreadLocalMap的getEntry,set,remove方法，而这个ThreadLocalMap数据管理员角色对象是线程的字段，在ThreadLocal的三种方法中都需要去获取当前线程的ThreadLocalMap对象，代码如下所示：\r\n![alt](/upload/2020/02/rom20iv4uogvgqefnd76uaqor5.jpg)\r\n\r\n三个方法里面都有这段代码：先获取Thread LocalMap对象，即Thread Local将数据的搬运工作委托给了线程对象的属性ThreadLocalMap。\r\n\r\n对长工工作的小结：大兄弟角色线程将数据搬运工作委托给threadlocal长工角色，而长工找到属于大兄弟的数据仓库群管理员threadlocalmap，将搬运的工作委托给管理员。\r\n\r\ntable中仓库Entry的定位\r\n我们现在已经知道线程对象 的数据放入的是数据仓库table数组中，每个threadlocal对象获取和存放操作是处理table数组中的哪个位置的数据，位置是如何定位的，这个就要涉及到ThreadLocal的其他机制，例如：ThreadLocal对象唯一ID机制，ThreadLocal的get初始化值机制等等。\r\n\r\n上面段落提到数据的搬运工作最后是委托给了ThreadLocalMap这个对象，以get方法为例，底层是管理员角色的getEntry方法在工作，如下图所示：\r\n![alt](/upload/2020/02/4p9jknhcdegeqq6pklaha6d9r7.jpg)\r\n\r\nthreadLocalHashCode字段属性是ThreadLoca对象唯一ID机制中的ID，表示这个对象的唯一性质，而这个i值也就因为这个threadLocalHashCode的唯一性而具有唯一性。所以可以判断具有唯一性的Threadlocal对象能获得具有唯一性质的i，因此对应的table[i]也就唯一对应到ThreadLocal对象了。\r\n\r\n对仓库Entry定位的小结：因为ThreadLocal对象的具有唯一性，因此它指向的是线程对象中数据仓库群table中的其中一个数据仓库entry，哪个线程委托threadlocal对象，threadlocal就去哪个线程下的仓库群进行操作。这个小结能够解决对ThreadLocal体系模糊不清的疑问，为什么不同线程调用同一个threadlocal对象的相同方法会获取不一样的数据？为什么不同的线程使用一个threadlocal对象进行set，还能保存两种这样的数据？\r\n\r\nThreadLocal数据仓库机制，它不仅仅只涉及到ThreadLocal这一个角色类，它还与Thread角色类强关联一起：数据就是维护在Thread对象中的。而数据存放位置的定位key包括：具有唯一行的ThreadLocal对象+Thread对象。到这里就是我对于ThreadLocal数据仓库机制的分享，感谢阅读，希望能帮助到你，我是大白，我来自共图社，一个持续输出Java好文的平台。',1,'post','publish','Java,ThreadLocal','默认分类','',10,0,1,1,1),(5,'Jedis与lua脚本——lua脚本在redis中的使用','jedis-lua-1',1582824035,1583228838,'* <font size=4><a href=\"#1\">1 使用lua的几个好处</a></font>\r\n\r\n* <font size=4><a href=\"#2\">2 redis原生API Jedis执行lua脚本的两种API方法</a></font>\r\n\r\n* <font size=4><a href=\"#3\">3 lua分布式锁</a></font>\r\n\r\n* <font size=4><a href=\"#4\">4 lua高并发减库存</a></font>\r\n\r\n* <font size=4><a href=\"#5\">5 lua高并发限流器</a></font>\r\n\r\n<a name=\"1\"><font  size=4 face=\"黑体\">**1.使用lua的几个好处**</font></a>\r\n<br/>**原子操作**。redis会将整个脚本作为一个整体执行，中间不会被其他命令插入。因此在编写脚本的过程中无需担心会出现竞态条件，就不需要在本地使用繁琐的事务或者使用锁机制，任何能在事务机制下能完成的任务lua脚本也能做到。\r\n<br/>**重复使用**。lua脚本能存放到redis服务器，作为一个redis扩展命令而存在着，每次脚本的执行只需要传入脚本在redis服务器中的唯一id就能执行该脚本扩展的原子命令。\r\n<br/>**降低网络开销**。可以将多个命令通过脚本的形式一次发送，不用每个命令都逐个发送，减少网络延迟。\r\n<br/>**速度快**。\r\n<br/>**可以移植**。\r\n<br/>**源码小巧**。\r\n\r\n<a name=\"2\"><font  size=4 face=\"黑体\">**2.redis原生命令以及Jedis执行lua脚本的两种API方法**</font></a>\r\n<br/><br/>\r\n**redis原生命令**\r\n- eval ：执行lua脚本，需要传入lua脚本代码\r\n- evalsha ：执行lua脚本，需要传入lua脚本在redis内的编号\r\n- script load : 将lua脚本缓存到redis服务器，并返回该脚本在redis的编号\r\n\r\neval直接执行脚本示例如下\r\n```js\r\nEVAL script numkeys key [key ...] arg [arg ...]\r\n\r\n> eval \"return {KEYS[1],KEYS[2],ARGV[1],ARGV[2]}\" 2 key1 key2 first second\r\n1) \"key1\"\r\n2) \"key2\"\r\n3) \"first\"\r\n4) \"second\"\r\n```  \r\nlua脚本简单描述\r\neval 命令的参数 依次为：lua脚本 ，key的数量为2， 第一个key值，第二个key值，第一个其他参数，第二个其他参数。\r\n返回的是字符串数组。\r\n<br/><font color=#DC143C size=3 face=\"黑体\">注意：redis客户端与服务器交换的数据最终转换称字符串的形式进行发送和接收。</font><br/>\r\n\r\nscript load和evalsha\r\n每次执行eval命令都会将脚本传入到redis中，如果脚本执行频率很高的话，就会增加网络开销\r\n因此redis提供了缓存脚本的命令script load 再调用evalsha 执行脚本，每次执行evalsha命令都是传入脚本在redis服务器的hash值，减少了脚本传输的网络开销。两个命令的使用如下：\r\n\r\n```js\r\nSCRIPT LOAD SCRIPT\r\nEVALSHA sha numkeys key [key ...] arg [arg ...]\r\n\r\nredis> SCRIPT LOAD \"return \'hello world\'\"\r\n\"34343d4s34343434a5656544534434da343ad4454a\"\r\n\r\nredis> EVALSHA 34343d4s34343434a5656544534434da343ad4454a 0\r\n\"hello world\"\r\n```  \r\nSCRIPT LOAD命令的返回值要保存好，作为脚本id来查找缓存在redis里的脚本。\r\nEVALSHA 参数和eval参数结构一样，只是第一个参数不是脚本内容，而是脚本缓存在redis中的唯一id。\r\n\r\n**Jedis执行lua脚本的两种API方法**\r\n- eval（String luaStr ,Object[] keyParams , Object[] arvgs）\r\n- scriptLoad(String luaStr)\r\n- evalsha(String luaLoad ,Object[] keyParams , Object[] arvgs）\r\n\r\n**lua脚本实现同一个IP的访问限流**\r\n\r\n```js\r\n--在lua脚本内调用redis命令incr，实现第一个key参数的自增\r\n--如果key不存在则创建key并赋值为1，如果存在则自动增加1，返回最终的值赋给变量num\r\nlocal num=redis.call(\'incr\',KEYS[1])\r\n--判断变量num的值，如果为1 则设置这个key的过期时间为ARGV[1] ,并返回成功1\r\nif tonumber(num)==1 then \r\n  redis.call(\'pexpire\',KEYS[1],ARGV[1])\r\n  return 1\r\n--如果num的值大于第二个值参数，则返回失败0 ，小于的话就返回成功1\r\nelseif tonumber(num)>tonumber(ARGV[2]) then\r\n  return 0\r\nelse\r\n  return 1\r\nend\r\n```  \r\n\r\n<a href=\"https://github.com/wmsJackWang/JDKingRedisses/tree/master/redisses-jdking-luaLock\"><font color=#DC143C size=3 face=\"黑体\">jedis两种API使用方式Github源码demo</font></a><br/>\r\n\r\n<a name=\"3\"><font  size=4 face=\"黑体\">**3.lua分布式锁**</font></a><br/>\r\n对于分布式锁，可以理解为是两个不相关的进程之间的通信，业界有很多成熟的分布式锁工具。redis+lua实现轻量的分布式锁，使得不同进程之间相互协作，实现高并发的安全性。因为lua脚本的原子性和快速等特性，多个进程之间协助速度将会非常的快。\r\n分布式锁也具有锁的一些特性，每个进程都一定会有**获取锁，释放锁**这两个过程，有些不稳定的进程，还会出现成功获取锁后还没来得及释放锁就死亡了的问题，以及进程获取锁失败需要在固定时间内多次去尝试获取锁需求，这些都是**分布式锁面临的问题**。如下：\r\n- **获取锁的进程死亡**\r\n- **获取锁失败进程尝试多久**\r\n\r\nredis实现分布式锁，有很多可以实现锁的命令，我选的是setnx命令：redis中存在key则命令执行失败，否则key创建成功。\r\n\r\n**获取锁的进程死亡**\r\n\r\n如果只使用这个命令来实现分布式锁，则会出现上面描述的第一个问题，进程还未释放锁就死了，那么其他进程就永远无法成功获取锁，那为了避免这个问题，根据redis功能，可以给key设置过期时间，就算进程死了，过了时间锁就不存在了，那其他进程就能获取到锁了。\r\n\r\n**获取锁失败进程尝试多久**\r\n\r\n如果每次执行setnx命令失败，就算是获取锁失败的话，就会使得获取锁的成功率大大降低，为了避免这个问题，就需要在获取锁的逻辑中增加多次尝试的机制: 在规定的延迟范围内，定时的多次尝试执行setnx命令，如果还没能执行成功，则算是获取锁失败，这种处理能大大提高获取锁的成功率。\r\n\r\n博主开发的一个基于redis+lua脚本的轻量分布式锁 JackDKingLuaDistributedKey 就解决了这些问题，感兴趣的同学可以用于工作项目中，或作为学习参考的demo，<a href=\"https://github.com/wmsJackWang/JDKingRedisses/tree/master/redisses-jdking-luaLock\">**点击跳转到Github源码地址**。</a>\r\n\r\n**获取锁的lua脚本**\r\n\r\n```js\r\n--获取锁key和锁设置的过期时间expireTime \r\nlocal key = KEYS[1]\r\nlocal expireTime = ARGV[1]\r\n\r\n#这个value可以作为扩展的点，你可以保存获取锁的进程唯一标识。\r\nlocal value = ARGV[1] \r\n\r\n--使用redis的setnx命令加锁 \r\nlocal result = redis.call(\'setnx\',key,value)\r\n\r\nif result == 1 \r\nthen \r\n	-- 加锁成功\r\n	--expireResult==0的情况是为了支持Redis versions <2.1.3情形下，过期时间存在则不会设置，之后的版本则会覆盖过期时间\r\n	local res = redis.call(\'expire\',key,expireTime)\r\n	if res == 1\r\n	then\r\n		return 1\r\n	else\r\n		return 0\r\n	end\r\nelse\r\n	return 0\r\nend\r\n```  \r\n\r\n**获取分布式锁不仅仅只是执行lua脚本**\r\n\r\n<br/>\r\n<a name=\"4\"><font  size=4 face=\"黑体\">4.**lua高并发减库存**</font></a><br/>\r\n<a name=\"5\"><font  size=4 face=\"黑体\">5.**lua高并发限流器**</font></a><br/>* <font size=4><a href=\"#1\">1 使用lua的几个好处</a></font>\r\n\r\n* <font size=4><a href=\"#2\">2 redis原生API Jedis执行lua脚本的两种API方法</a></font>\r\n\r\n* <font size=4><a href=\"#3\">3 lua分布式锁</a></font>\r\n\r\n* <font size=4><a href=\"#4\">4 lua高并发减库存</a></font>\r\n\r\n* <font size=4><a href=\"#5\">5 lua高并发限流器</a></font>\r\n\r\n<a name=\"1\"><font  size=4 face=\"黑体\">**1.使用lua的几个好处**</font></a>\r\n<br/>**原子操作**。redis会将整个脚本作为一个整体执行，中间不会被其他命令插入。因此在编写脚本的过程中无需担心会出现竞态条件，就不需要在本地使用繁琐的事务或者使用锁机制，任何能在事务机制下能完成的任务lua脚本也能做到。\r\n<br/>**重复使用**。lua脚本能存放到redis服务器，作为一个redis扩展命令而存在着，每次脚本的执行只需要传入脚本在redis服务器中的唯一id就能执行该脚本扩展的原子命令。\r\n<br/>**降低网络开销**。可以将多个命令通过脚本的形式一次发送，不用每个命令都逐个发送，减少网络延迟。\r\n<br/>**速度快**。\r\n<br/>**可以移植**。\r\n<br/>**源码小巧**。\r\n\r\n<a name=\"2\"><font  size=4 face=\"黑体\">**2.redis原生命令以及Jedis执行lua脚本的两种API方法**</font></a>\r\n<br/><br/>\r\n**redis原生命令**\r\n- eval ：执行lua脚本，需要传入lua脚本代码\r\n- evalsha ：执行lua脚本，需要传入lua脚本在redis内的编号\r\n- script load : 将lua脚本缓存到redis服务器，并返回该脚本在redis的编号\r\n\r\neval直接执行脚本示例如下\r\n```js\r\nEVAL script numkeys key [key ...] arg [arg ...]\r\n\r\n> eval \"return {KEYS[1],KEYS[2],ARGV[1],ARGV[2]}\" 2 key1 key2 first second\r\n1) \"key1\"\r\n2) \"key2\"\r\n3) \"first\"\r\n4) \"second\"\r\n```  \r\nlua脚本简单描述\r\neval 命令的参数 依次为：lua脚本 ，key的数量为2， 第一个key值，第二个key值，第一个其他参数，第二个其他参数。\r\n返回的是字符串数组。\r\n<br/><font color=#DC143C size=3 face=\"黑体\">注意：redis客户端与服务器交换的数据最终转换称字符串的形式进行发送和接收。</font><br/>\r\n\r\nscript load和evalsha\r\n每次执行eval命令都会将脚本传入到redis中，如果脚本执行频率很高的话，就会增加网络开销\r\n因此redis提供了缓存脚本的命令script load 再调用evalsha 执行脚本，每次执行evalsha命令都是传入脚本在redis服务器的hash值，减少了脚本传输的网络开销。两个命令的使用如下：\r\n\r\n```js\r\nSCRIPT LOAD SCRIPT\r\nEVALSHA sha numkeys key [key ...] arg [arg ...]\r\n\r\nredis> SCRIPT LOAD \"return \'hello world\'\"\r\n\"34343d4s34343434a5656544534434da343ad4454a\"\r\n\r\nredis> EVALSHA 34343d4s34343434a5656544534434da343ad4454a 0\r\n\"hello world\"\r\n```  \r\nSCRIPT LOAD命令的返回值要保存好，作为脚本id来查找缓存在redis里的脚本。\r\nEVALSHA 参数和eval参数结构一样，只是第一个参数不是脚本内容，而是脚本缓存在redis中的唯一id。\r\n\r\n**Jedis执行lua脚本的两种API方法**\r\n- eval（String luaStr ,Object[] keyParams , Object[] arvgs）\r\n- scriptLoad(String luaStr)\r\n- evalsha(String luaLoad ,Object[] keyParams , Object[] arvgs）\r\n\r\n**lua脚本实现同一个IP的访问限流**\r\n\r\n```js\r\n--在lua脚本内调用redis命令incr，实现第一个key参数的自增\r\n--如果key不存在则创建key并赋值为1，如果存在则自动增加1，返回最终的值赋给变量num\r\nlocal num=redis.call(\'incr\',KEYS[1])\r\n--判断变量num的值，如果为1 则设置这个key的过期时间为ARGV[1] ,并返回成功1\r\nif tonumber(num)==1 then \r\n  redis.call(\'pexpire\',KEYS[1],ARGV[1])\r\n  return 1\r\n--如果num的值大于第二个值参数，则返回失败0 ，小于的话就返回成功1\r\nelseif tonumber(num)>tonumber(ARGV[2]) then\r\n  return 0\r\nelse\r\n  return 1\r\nend\r\n```  \r\n\r\n<a href=\"https://github.com/wmsJackWang/JDKingRedisses/tree/master/redisses-jdking-luaLock\"><font color=#DC143C size=3 face=\"黑体\">jedis两种API使用方式Github源码demo</font></a><br/>\r\n\r\n<a name=\"3\"><font  size=4 face=\"黑体\">**3.lua分布式锁**</font></a><br/>\r\n对于分布式锁，可以理解为是两个不相关的进程之间的通信，业界有很多成熟的分布式锁工具。redis+lua实现轻量的分布式锁，使得不同进程之间相互协作，实现高并发的安全性。因为lua脚本的原子性和快速等特性，多个进程之间协助速度将会非常的快。\r\n分布式锁也具有锁的一些特性，每个进程都一定会有**获取锁，释放锁**这两个过程，有些不稳定的进程，还会出现成功获取锁后还没来得及释放锁就死亡了的问题，以及进程获取锁失败需要在固定时间内多次去尝试获取锁需求，这些都是**分布式锁面临的问题**。如下：\r\n- **获取锁的进程死亡**\r\n- **获取锁失败进程尝试多久**\r\n\r\nredis实现分布式锁，有很多可以实现锁的命令，我选的是setnx命令：redis中存在key则命令执行失败，否则key创建成功。\r\n\r\n**获取锁的进程死亡**\r\n\r\n如果只使用这个命令来实现分布式锁，则会出现上面描述的第一个问题，进程还未释放锁就死了，那么其他进程就永远无法成功获取锁，那为了避免这个问题，根据redis功能，可以给key设置过期时间，就算进程死了，过了时间锁就不存在了，那其他进程就能获取到锁了。\r\n\r\n**获取锁失败进程尝试多久**\r\n\r\n如果每次执行setnx命令失败，就算是获取锁失败的话，就会使得获取锁的成功率大大降低，为了避免这个问题，就需要在获取锁的逻辑中增加多次尝试的机制: 在规定的延迟范围内，定时的多次尝试执行setnx命令，如果还没能执行成功，则算是获取锁失败，这种处理能大大提高获取锁的成功率。\r\n\r\n博主开发的一个基于redis+lua脚本的轻量分布式锁 JackDKingLuaDistributedKey 就解决了这些问题，感兴趣的同学可以用于工作项目中，或作为学习参考的demo，<a href=\"https://github.com/wmsJackWang/JDKingRedisses/tree/master/redisses-jdking-luaLock\">**点击跳转到Github源码地址**。</a>\r\n\r\n**获取锁的lua脚本**\r\n\r\n```js\r\n--获取锁key和锁设置的过期时间expireTime \r\nlocal key = KEYS[1]\r\nlocal expireTime = ARGV[1]\r\n\r\n#这个value可以作为扩展的点，你可以保存获取锁的进程唯一标识。\r\nlocal value = ARGV[1] \r\n\r\n--使用redis的setnx命令加锁 \r\nlocal result = redis.call(\'setnx\',key,value)\r\n\r\nif result == 1 \r\nthen \r\n	-- 加锁成功\r\n	--expireResult==0的情况是为了支持Redis versions <2.1.3情形下，过期时间存在则不会设置，之后的版本则会覆盖过期时间\r\n	local res = redis.call(\'expire\',key,expireTime)\r\n	if res == 1\r\n	then\r\n		return 1\r\n	else\r\n		return 0\r\n	end\r\nelse\r\n	return 0\r\nend\r\n```  \r\n\r\n**获取分布式锁不仅仅只是执行lua脚本**\r\n\r\n<br/>\r\n<a name=\"4\"><font  size=4 face=\"黑体\">4.**lua高并发减库存**</font></a><br/>\r\n<a name=\"5\"><font  size=4 face=\"黑体\">5.**lua高并发限流器**</font></a><br/>',1,'post','publish','Java,Lua,Redis,Jedis','Redis,Java','',45,0,1,1,1);
/*!40000 ALTER TABLE `t_contents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_logs`
--

DROP TABLE IF EXISTS `t_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_logs` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `action` varchar(100) DEFAULT NULL,
  `data` varchar(2000) DEFAULT NULL,
  `author_id` int(10) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `created` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_logs`
--

LOCK TABLES `t_logs` WRITE;
/*!40000 ALTER TABLE `t_logs` DISABLE KEYS */;
INSERT INTO `t_logs` VALUES (1,'登录后台',NULL,1,'0:0:0:0:0:0:0:1',1582639587),(2,'登录后台',NULL,1,'0:0:0:0:0:0:0:1',1582640315),(3,'登录后台',NULL,1,'127.0.0.1',1582647487),(4,'登录后台',NULL,1,'0:0:0:0:0:0:0:1',1582727716),(5,'删除文章','2',1,'0:0:0:0:0:0:0:1',1582727723),(6,'删除附件','/upload/2020/02/qin1dt1kpajg3qihelnvcpuevs.jpg',1,'0:0:0:0:0:0:0:1',1582729116),(7,'删除附件','/upload/2020/02/p2meq7d66miteqdvse3r99qoip.jpg',1,'0:0:0:0:0:0:0:1',1582729561),(8,'删除附件','/upload/2020/02/phu1d8mo3sj7nr5l5tuigtkse3.jpg',1,'0:0:0:0:0:0:0:1',1582729565),(9,'删除附件','/upload/2020/02/ruirt0tplshd0pv40h77ofiqvi.jpg',1,'0:0:0:0:0:0:0:1',1582729574),(10,'删除附件','/upload/2020/02/pjrgrlangsinhr9culvh1ii33n.jpg',1,'0:0:0:0:0:0:0:1',1582729578),(11,'删除附件','/upload/2020/02/ttf7at7u4uh4go5s5mn6oqj0gu.jpg',1,'0:0:0:0:0:0:0:1',1582729582),(12,'登录后台',NULL,1,'0:0:0:0:0:0:0:1',1582731974),(13,'修改个人信息','{\"uid\":1,\"email\":\"jackdking@foxmail.com\",\"screenName\":\"admin\"}',1,'0:0:0:0:0:0:0:1',1582732066),(14,'登录后台',NULL,1,'0:0:0:0:0:0:0:1',1582814663),(15,'登录后台',NULL,1,'0:0:0:0:0:0:0:1',1582816237),(16,'登录后台',NULL,1,'0:0:0:0:0:0:0:1',1582816669),(17,'登录后台',NULL,1,'0:0:0:0:0:0:0:1',1582818590),(18,'删除页面','4',1,'0:0:0:0:0:0:0:1',1582821198),(19,'登录后台',NULL,1,'0:0:0:0:0:0:0:1',1583074426),(20,'登录后台',NULL,1,'0:0:0:0:0:0:0:1',1583074470),(21,'登录后台',NULL,1,'0:0:0:0:0:0:0:1',1583078003),(22,'登录后台',NULL,1,'0:0:0:0:0:0:0:1',1583117307),(23,'登录后台',NULL,1,'0:0:0:0:0:0:0:1',1583117308),(24,'登录后台',NULL,1,'0:0:0:0:0:0:0:1',1583145712),(25,'登录后台',NULL,1,'0:0:0:0:0:0:0:1',1583148566),(26,'登录后台',NULL,1,'0:0:0:0:0:0:0:1',1583155714),(27,'登录后台',NULL,1,'0:0:0:0:0:0:0:1',1583159748),(28,'登录后台',NULL,1,'0:0:0:0:0:0:0:1',1583219191),(29,'登录后台',NULL,1,'0:0:0:0:0:0:0:1',1583220437),(30,'登录后台',NULL,1,'0:0:0:0:0:0:0:1',1583228810);
/*!40000 ALTER TABLE `t_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_metas`
--

DROP TABLE IF EXISTS `t_metas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_metas` (
  `mid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `slug` varchar(200) DEFAULT NULL,
  `type` varchar(32) NOT NULL DEFAULT '',
  `description` varchar(200) DEFAULT NULL,
  `sort` int(10) unsigned DEFAULT '0',
  `parent` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`mid`),
  KEY `slug` (`slug`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_metas`
--

LOCK TABLES `t_metas` WRITE;
/*!40000 ALTER TABLE `t_metas` DISABLE KEYS */;
INSERT INTO `t_metas` VALUES (1,'Java','Java','tag',NULL,0,0),(2,'默认分类','默认分类','category',NULL,0,0),(4,'ThreadLocal','ThreadLocal','tag',NULL,0,0),(5,'Java',NULL,'category',NULL,0,0),(6,'Redis',NULL,'category',NULL,0,0),(7,'问题及解决方案',NULL,'category',NULL,0,0),(8,'龙果支付',NULL,'category',NULL,0,0),(9,'Lua','Lua','tag',NULL,0,0),(10,'Redis','Redis','tag',NULL,0,0),(11,'Jedis','Jedis','tag',NULL,0,0);
/*!40000 ALTER TABLE `t_metas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_options`
--

DROP TABLE IF EXISTS `t_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_options` (
  `name` varchar(32) NOT NULL DEFAULT '',
  `value` varchar(1000) DEFAULT '',
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_options`
--

LOCK TABLES `t_options` WRITE;
/*!40000 ALTER TABLE `t_options` DISABLE KEYS */;
INSERT INTO `t_options` VALUES ('site_block_ips','123',NULL);
/*!40000 ALTER TABLE `t_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_relationships`
--

DROP TABLE IF EXISTS `t_relationships`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_relationships` (
  `cid` int(10) unsigned NOT NULL,
  `mid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`cid`,`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_relationships`
--

LOCK TABLES `t_relationships` WRITE;
/*!40000 ALTER TABLE `t_relationships` DISABLE KEYS */;
INSERT INTO `t_relationships` VALUES (1,1),(1,2),(3,1),(3,2),(3,4),(5,1),(5,5),(5,6),(5,9),(5,10),(5,11);
/*!40000 ALTER TABLE `t_relationships` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_users`
--

DROP TABLE IF EXISTS `t_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_users` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `home_url` varchar(200) DEFAULT NULL,
  `screen_name` varchar(32) DEFAULT NULL,
  `created` int(10) unsigned DEFAULT '0',
  `activated` int(10) unsigned DEFAULT '0',
  `logged` int(10) unsigned DEFAULT '0',
  `group_name` varchar(16) DEFAULT 'visitor',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `name` (`username`),
  UNIQUE KEY `mail` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_users`
--

LOCK TABLES `t_users` WRITE;
/*!40000 ALTER TABLE `t_users` DISABLE KEYS */;
INSERT INTO `t_users` VALUES (1,'admin','a66abb5684c45962d887564f08346e8d','jackdking@foxmail.com',NULL,'admin',1490756162,0,0,'visitor');
/*!40000 ALTER TABLE `t_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-04 11:27:04
