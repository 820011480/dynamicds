1. sql的执行语句：
原语句：
select distinct <select_list> from <left_table> <join_type> join <right_table>  on <join condition>
where <where_condition> group by <group_condition> having <having_condition> order by <order_condition> limit <limit_condition> ;
解析后语句：
from <left_table> on <join_condition> <join_type> join <right_table> where <where_condition> group by <group_condition> having <having_condition> 
select distinct<select_list> order by <order_condition> limit <limit_condition>;

explain 分析语句：

id : 分三种情况  这是SELECT的查询序列号
①. id 相同 ，id 相同执行顺序从上到下。
②. id 不同 ，执行顺序是id越大越先执行。
③. id 相同又不同 ， （不同）执行顺序从大到小 ，（相同） 从上到下     

select_type :select_type就是select的类型，可以有以下几种
   simple ： 简单查询 没有复合语句的查询
   primary : 存在符合查询 表示最外层select查询。
   union ： 表示后面的查询

table :

type:

possible_key:

key:

keY_len:

ref:

rows:

Extra:





